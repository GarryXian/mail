package com.garry.mail.service.impl;

import com.garry.mail.dao.MailFileInfoDAO;
import com.garry.mail.model.*;
import com.garry.mail.service.*;
import com.garry.mail.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 附件文件实体类 Service 实现
 * <p>
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:55:09   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Service
public class MailFileInfoServiceImpl implements MailFileInfoService {

    private static final Logger logger = LoggerFactory.getLogger(MailFileInfoServiceImpl.class);

    @Resource
    private MailFileInfoDAO mailFileInfoDAO;
    @Resource
    private MailFileFolderPathService mailFileFolderPathService;
    @Resource
    private MailAddressInfoService mailAddressInfoService;
    @Resource
    private MailGroupInfoService mailGroupInfoService;
    @Resource
    private MailService mailService;
    @Value("${sender}")
    private String sender;

    /**
     * 构建邮箱地址与附件信息表
     *
     * @return
     */
    @Override
    public String buildAndSaveMailFileInfo() throws ParseException {
        // 创建批次号
        String batchNo = System.currentTimeMillis() + "";
        MailFileFolderPathPO fileFolderPathPO = mailFileFolderPathService.findFolder();

        File file = new File(fileFolderPathPO.getFolderPath());
        File[] files = file.listFiles();
        // 获取所有的邮箱群组
        List<MailGroupInfoPO> mailGroupInfoPOS = mailGroupInfoService.findAll();
        // 根据文件名字查找对应的邮箱群组信息
        for (File subFile : files) {
            Boolean flag = true;
            //去除文件后缀名
            final String fileName = FileUtil.getFileNameWithoutSuffix(subFile);
            // 根据文件名过滤邮箱群组
            List<MailAddressInfoPO> mailAddressInfoPOS = new ArrayList<>();
            for (MailGroupInfoPO mailGroupInfoPO : mailGroupInfoPOS) {
                if (fileName.contains(mailGroupInfoPO.getMailFileName())) {
                    // 文件对应的群组, 根据群组汇总发送记录
                    saveMailFileInfo(mailGroupInfoPO, subFile, batchNo);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                logger.info("文件: " + fileName + "找不到对应群组 ,无法发送,请确认");
            }
        }
        return batchNo;
    }

    /**
     * 汇总并发送邮件
     */
    @Override
    public Integer sendMail() {
        // 获取所有未发送邮件
        List<MailFileInfoPO> unSendList = mailFileInfoDAO.findUnSendMail();
        Integer count = 0;
        for (MailFileInfoPO mailFileInfoPO : unSendList) {
            try {
                File file = new File(mailFileInfoPO.getFilePath());
                MailBean mailBean = new MailBean();
                mailBean.setFile(file);
                mailBean.setSender(sender);
                mailBean.setRecipient(mailFileInfoPO.getAddress());
                mailService.sendSimpleMail(mailBean);
                mailFileInfoPO.setSendStatus("Y");
                mailFileInfoPO.setSendMsg("发送成功了");
                mailFileInfoPO.setSendDate(new Date());
                count++;
            } catch (Exception e) {
                mailFileInfoPO.setSendStatus("E");
                mailFileInfoPO.setSendMsg(e.getMessage());
            }
            mailFileInfoDAO.updateById(mailFileInfoPO);
        }
        return count;
    }

    private void saveMailFileInfo(MailGroupInfoPO mailGroupInfoPO, File file, String batchNo) {
        // 根据邮箱群组, 找对应的所有邮箱地址
        List<MailAddressInfoPO> mailAddressInfoPOS = mailAddressInfoService.findByGroupId(mailGroupInfoPO.getMailGroupId());
        if (CollectionUtils.isEmpty(mailAddressInfoPOS)) {
            logger.info("邮箱群组id:" + mailGroupInfoPO.getMailGroupId() + " 中邮箱地址为空, 请确认");
        }
        for (MailAddressInfoPO mailAddressInfoPO : mailAddressInfoPOS) {
            MailFileInfoPO mailFileInfoPO = new MailFileInfoPO();
            mailFileInfoPO.setGroupId(mailGroupInfoPO.getMailGroupId());
            mailFileInfoPO.setGroupName(mailGroupInfoPO.getMailGroupName());
            mailFileInfoPO.setAddress(mailAddressInfoPO.getAddress());
            mailFileInfoPO.setBatchNo(batchNo);
            mailFileInfoPO.setFileName(file.getName());
            mailFileInfoPO.setFilePath(file.getPath());
            mailFileInfoPO.setCreationDate(new Date());
            mailFileInfoPO.setSendStatus("N");
            mailFileInfoDAO.insert(mailFileInfoPO);
        }
    }
}
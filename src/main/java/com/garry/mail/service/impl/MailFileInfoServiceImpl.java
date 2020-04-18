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
import org.springframework.util.StringUtils;

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

    private static final String MAIL_ADDRESS = "MAIL_ADDRESS";

    /**
     * 构建邮箱地址与附件信息表
     * date ==> 邮件固定日期后缀, 固定为 yyyyMMdd , 用此符号找需要发送的邮件
     *
     * @return
     */
    @Override
    public String buildAndSaveMailFileInfo(String date) throws ParseException {
        // 创建批次号
        String batchNo = System.currentTimeMillis() + "";
        MailFileFolderPathPO fileFolderPathPO = mailFileFolderPathService.findFolder();
        // 1. 根据配置路径获取文件夹地址中的所有子文件夹
        File file = new File(fileFolderPathPO.getFolderPath());
        File[] files = file.listFiles();

        // 2. 遍历, 获取 mailAddress.txt 和 对应日期要发送的文件
        for (File mailFileFolder : files) {

            if (mailFileFolder.isFile()) {
                // 如果不是文件夹, 跳过
                continue;
            }
            // 2.1 一个邮件文件夹构建一个mailFileInfoPO
            MailFileInfoPO mailFileInfoPO = new MailFileInfoPO();
            mailFileInfoPO.setCreationDate(new Date());
            mailFileInfoPO.setSendStatus("N");
            mailFileInfoPO.setBatchNo(batchNo);
            // 遍历文件夹下需要发送的文件
            for (File mailFile : mailFileFolder.listFiles()) {
                if (mailFile.getName().contains(date)) {
                    // 找到需发送的文件
                    mailFileInfoPO.setFileName(mailFile.getName());
                    mailFileInfoPO.setFilePath(mailFile.getPath());
                }
                if (mailFile.getName().contains(MAIL_ADDRESS)) {
                    // 找到邮件地址配置文件, 需读取
                    String recipients = FileUtil.readFile(mailFile);
                    mailFileInfoPO.setAddress(recipients);
                }
            }
            if (!StringUtils.isEmpty(mailFileInfoPO.getFilePath())) {
                mailFileInfoDAO.insert(mailFileInfoPO);
            }else {
                logger.error("文件夹 {} 中无需要发送的文件",mailFileFolder.getName() );
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
                String[] recipients = mailFileInfoPO.getAddress().split(";");
                mailBean.setRecipients(recipients);
                mailService.sendSimpleMail(mailBean);
                mailFileInfoPO.setSendStatus("Y");
                mailFileInfoPO.setSendMsg("发送成功了");
                mailFileInfoPO.setSendDate(new Date());
                count++;
            } catch (Exception e) {
                logger.error("文件夹 {} 邮件发送失败, 请联系 大佬", mailFileInfoPO.getFileName());
                mailFileInfoPO.setSendStatus("E");
                mailFileInfoPO.setSendMsg(e.getMessage());
            }
            mailFileInfoDAO.updateById(mailFileInfoPO);
        }
        return count;
    }

}
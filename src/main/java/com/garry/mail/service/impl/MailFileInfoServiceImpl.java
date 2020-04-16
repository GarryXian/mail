package com.garry.mail.service.impl;

import com.garry.mail.dao.MailFileInfoDAO;
import com.garry.mail.model.MailAddressInfoPO;
import com.garry.mail.model.MailFileFolderPathPO;
import com.garry.mail.model.MailFileInfoPO;
import com.garry.mail.service.MailAddressInfoService;
import com.garry.mail.service.MailFileFolderPathService;
import com.garry.mail.service.MailFileInfoService;
import com.garry.mail.util.DateUtils;
import com.garry.mail.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    /**
     * 构建邮箱地址与附件信息表
     *
     * @return
     */
    @Override
    public String buildAndSaveMailFileInfo() throws ParseException {
        // 创建批次号
        String batchNo = DateUtils.dateFormat(new Date(), "yyyyMMdd");
        MailFileFolderPathPO fileFolderPathPO = mailFileFolderPathService.findFolder();

        File file = new File(fileFolderPathPO.getFolderPath());
        File[] files = file.listFiles();
        // 查找所有邮箱地址配置信息
        List<MailAddressInfoPO> allMailAddressInfo = mailAddressInfoService.findAll();
        // 根据文件名字查找对应的邮箱地址
        for (File subFile : files) {
            //去除文件后缀名
            final String fileName = FileUtil.getFileNameWithoutSuffix(subFile);
            // 根据文件名过滤邮箱地址
            List<MailAddressInfoPO> mailAddressInfoPOS = new ArrayList<>();
            for (MailAddressInfoPO mailAddressInfoPO : allMailAddressInfo) {
                if (fileName.contains(mailAddressInfoPO.getFileName())){
                    mailAddressInfoPOS.add(mailAddressInfoPO);
                }
            }
            saveMailFileInfo(mailAddressInfoPOS,subFile, batchNo);
        }
        return batchNo;
    }

    private void saveMailFileInfo(List<MailAddressInfoPO> addressInfoPOS, File file, String batchNo){
        for (MailAddressInfoPO addressInfoPO : addressInfoPOS) {
            MailFileInfoPO mailFileInfoPO = new MailFileInfoPO();
            mailFileInfoPO.setBatchNo(batchNo);
            mailFileInfoPO.setFileName(file.getName());
            mailFileInfoPO.setFilePath(file.getPath());
            mailFileInfoPO.setCreationDate(new Date());
//            mailFileInfoPO.setSendDate(null);
//            mailFileInfoPO.setSendMsg(null);
            mailFileInfoDAO.insert(mailFileInfoPO);
        }

    }
}
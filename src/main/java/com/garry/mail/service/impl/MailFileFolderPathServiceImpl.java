package com.garry.mail.service.impl;

import com.garry.mail.dao.MailFileFolderPathDAO;
import com.garry.mail.service.MailFileFolderPathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 附件文件夹实体类 Service 实现
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:46   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Service
public class MailFileFolderPathServiceImpl implements MailFileFolderPathService {

    private static final Logger logger = LoggerFactory.getLogger(MailFileFolderPathServiceImpl.class);

    @Resource
    private MailFileFolderPathDAO mailFileFolderPathDAO;

}
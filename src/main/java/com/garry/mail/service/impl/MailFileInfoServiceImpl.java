package com.garry.mail.service.impl;

import com.garry.mail.dao.MailFileInfoDAO;
import com.garry.mail.service.MailFileInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 附件文件实体类 Service 实现
 *
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

}
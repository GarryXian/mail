package com.garry.mail.service.impl;

import com.garry.mail.dao.MailAddressInfoDAO;
import com.garry.mail.service.MailAddressInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 邮箱地址信息 Service 实现
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Service
public class MailAddressInfoServiceImpl implements MailAddressInfoService {

    private static final Logger logger = LoggerFactory.getLogger(MailAddressInfoServiceImpl.class);

    @Resource
    private MailAddressInfoDAO mailAddressInfoDAO;

}
package com.garry.mail.service;

import com.garry.mail.model.MailAddressInfoPO;

import java.util.List;

/**
 * 邮箱地址信息 Service 接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
public interface MailAddressInfoService {

    List<MailAddressInfoPO> findAll();

}

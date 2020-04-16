package com.garry.mail.service;

import com.garry.mail.model.MailGroupInfoPO;

import java.util.List;
import java.util.Map;

/**
 * 邮箱群组 Service 接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-16 20:47:36   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
public interface MailGroupInfoService {

	List<MailGroupInfoPO> findAll();
}

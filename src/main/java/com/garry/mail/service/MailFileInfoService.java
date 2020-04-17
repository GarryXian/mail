package com.garry.mail.service;

import com.garry.mail.model.MailFileInfoPO;

import java.text.ParseException;

/**
 * 附件文件实体类 Service 接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:55:09   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
public interface MailFileInfoService {

    /**
     * 汇总并发送邮件
     * @return
     */
    Integer sendMail();

    /**
     * 构建邮箱地址与附件信息表
     * @return
     */
    String buildAndSaveMailFileInfo(String date) throws ParseException;
}

package com.garry.mail.service;

import com.garry.mail.model.MailBean;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 9:38
 */
public interface MailService {

    void sendSimpleMail(MailBean mailBean);
}

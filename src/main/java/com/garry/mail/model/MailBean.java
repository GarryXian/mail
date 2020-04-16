package com.garry.mail.model;

import lombok.Data;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 9:37
 */
@Data
public class MailBean {

    private String recipient;

    private String subject;

    private String content;

    private String MAIL_SENDER;
}

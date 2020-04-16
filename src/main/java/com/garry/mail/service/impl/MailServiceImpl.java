package com.garry.mail.service.impl;

import com.garry.mail.model.MailBean;
import com.garry.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 9:34
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(MailBean mailBean) {
        try {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setFrom(mailBean.getMAIL_SENDER());
            mailMessage.setTo(mailBean.getRecipient());
            mailMessage.setSubject(mailBean.getSubject());
            mailMessage.setText(mailBean.getContent());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
        }
    }
}

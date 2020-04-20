package com.garry.mail.service.impl;

import com.garry.mail.model.MailBean;
import com.garry.mail.service.MailService;
import com.garry.mail.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;

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
    public void sendSimpleMail(MailBean mailBean) throws Exception {
        try {
            File file = mailBean.getFile();
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.attachFile(file);
            multipart.addBodyPart(messageBodyPart);
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setFrom(mailBean.getSender());
            InternetAddress[] addresses = new InternetAddress[mailBean.getRecipients().length];
            for (int i = 0; i < mailBean.getRecipients().length; i++) {
                addresses[i] = new InternetAddress(mailBean.getRecipients()[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.addRecipients(Message.RecipientType.CC, mailBean.getSender());
            message.setSubject(FileUtil.getFileNameWithoutSuffix(file));
            message.setContent(multipart);
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("邮件发送失败{}", e.getMessage());
            throw new Exception("邮件发送失败" + e.getMessage());
        }
    }
}

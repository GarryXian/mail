package com.garry.mail.controller;


import com.garry.mail.model.MailBean;
import com.garry.mail.service.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 9:56
 */
@RestController
@RequestMapping("/test")
public class MailTestController {

    @Resource
    private MailService mailService;


    @GetMapping("/send")
    public void testMail() {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient("18676391882@163.com");
        mailBean.setSubject("就这就这就这就这就这?");
        mailBean.setContent("就这就这就这就这就这?");
        mailBean.setMAIL_SENDER("garry_xian92@163.com");
        mailService.sendSimpleMail(mailBean);
    }
}

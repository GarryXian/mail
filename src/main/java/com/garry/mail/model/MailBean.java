package com.garry.mail.model;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.util.List;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 9:37
 */
@Data
public class MailBean {

    private String recipient;

    private String[] recipients;

    private String subject;

    private String content;

    private String sender;

    private File file;
}

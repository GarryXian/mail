package com.garry.mail.service;

import com.garry.mail.model.MailFileFolderPathPO;

/**
 * 附件文件夹实体类 Service 接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:46   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
public interface MailFileFolderPathService {

    /**
     * 查找当前的附件文件夹地址
     * @return
     */
    MailFileFolderPathPO findFolder();


}

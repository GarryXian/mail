package com.garry.mail.util;

import java.io.File;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 15:53
 */
public class FileUtil {

    //获取不带后缀名的文件名
    public static String getFileNameWithoutSuffix(File file){
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
}

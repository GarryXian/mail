package com.garry.mail.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author 冼家荣 xianjr1 xianjr1@meicloud.com
 * @Date 2020/4/16 15:53
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    //获取不带后缀名的文件名
    public static String getFileNameWithoutSuffix(File file){
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    //获取不带后缀名的文件名
    public static String readFile(File file){

        StringBuilder result = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(new FileReader(file))){
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
        }catch(Exception e){
            logger.error("读取文件{} 失败", file.getName());
        }
        return result.toString();
    }

}

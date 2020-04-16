package com.garry.mail.dao;

import com.garry.mail.model.MailFileInfoPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 附件文件实体类 MyBatis Mapper Dao接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:55:09   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Mapper
public interface MailFileInfoDAO  {

	List<MailFileInfoPO> query(Map<String, Object> param);



}

package com.garry.mail.dao;

import com.garry.mail.model.MailAddressInfoPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 邮箱地址信息 MyBatis Mapper Dao接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Mapper
public interface MailAddressInfoDAO{

	List<MailAddressInfoPO> query(Map<String, Object> param);

}

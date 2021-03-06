package com.garry.mail.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garry.mail.model.MailAddressInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 邮箱地址信息 MyBatis Mapper Dao接口
 * <p>
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Mapper
public interface MailAddressInfoDAO extends BaseMapper<MailAddressInfoPO> {

    List<MailAddressInfoPO> findByGroupId(@Param("groupId") Long groupId);

    List<MailAddressInfoPO> findAll();
}

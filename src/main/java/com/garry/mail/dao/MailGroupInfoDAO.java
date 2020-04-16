package com.garry.mail.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.garry.mail.model.MailGroupInfoPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 邮箱群组 MyBatis Mapper Dao接口
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-16 20:47:36   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Mapper
public interface MailGroupInfoDAO extends BaseMapper<MailGroupInfoPO> {

	List<MailGroupInfoPO> query(Map<String, Object> param);

	List<MailGroupInfoPO> pageQuery(Page<MailGroupInfoPO> page, Map<String, Object> param);


}

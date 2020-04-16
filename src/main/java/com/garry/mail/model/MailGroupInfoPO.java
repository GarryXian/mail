package com.garry.mail.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 邮箱群组 实体类
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-16 20:47:36   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@ApiModel(value = "MailGroupInfoPO", description = "邮箱群组 实体类")
@TableName(value = "mail_group_info")
@Getter
@Setter
@ToString
public class MailGroupInfoPO {

	private static final long serialVersionUID = 1L;

	/**邮箱群组id*/
	@ApiModelProperty(value = "邮箱群组id")
	@TableId(value = "mail_group_id", type = IdType.ID_WORKER)
	private Long mailGroupId;

	/**邮箱群组名称*/
	@ApiModelProperty(value = "邮箱群组名称")
	@TableField("mail_group_name")
	private String mailGroupName;

	/**邮箱群组对应附件名字*/
	@ApiModelProperty(value = "邮箱群组对应附件名字")
	@TableField("mail_file_name")
	private String mailFileName;


}

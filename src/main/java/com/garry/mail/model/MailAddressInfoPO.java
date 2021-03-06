package com.garry.mail.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 邮箱地址信息 实体类
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@ApiModel(value = "MailAddressInfoPO", description = "邮箱地址信息 实体类")
@TableName(value = "mail_address_info")
@Getter
@Setter
@ToString
public class MailAddressInfoPO  {

	private static final long serialVersionUID = 1L;


	/**邮箱地址id*/
	@ApiModelProperty(value = "邮箱地址id")
	@TableId(value = "address_id", type = IdType.ID_WORKER)
	private Long addressId;

	/**邮箱地址id*/
	@ApiModelProperty(value = "邮箱地址id")
	@TableId(value = "address")
	private String address;


	/**邮箱群组id*/
	@ApiModelProperty(value = "邮箱群组id")
	@TableId(value = "group_id")
	private Long groupId;

	/**创建时间*/
	@ApiModelProperty(value = "创建时间")
	@TableField("creation_date")
	private java.util.Date creationDate;

}

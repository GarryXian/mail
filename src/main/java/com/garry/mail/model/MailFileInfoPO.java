package com.garry.mail.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 附件文件实体类 实体类
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:55:09   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@ApiModel(value = "MailFileInfoPO", description = "附件文件实体类 实体类")
@Getter
@Setter
@ToString
public class MailFileInfoPO  {

	private static final long serialVersionUID = 1L;

	/**附件id*/
	@ApiModelProperty(value = "附件id")
	@TableId(value = "file_id",type = IdType.ID_WORKER)
	private Long fileId;

	/**邮箱地址id*/
	@ApiModelProperty(value = "邮箱地址id")
	@TableField(value = "address_id")
	private Long addressId;

	/**发送批次号*/
	@ApiModelProperty(value = "发送批次号")
	@TableField(value = "batch_no")
	private String batchNo;

	/**附件名称*/
	@ApiModelProperty(value = "附件名称")
	@TableField(value = "file_name")
	private String fileName;

	/**附件绝对路径*/
	@ApiModelProperty(value = "附件绝对路径")
	@TableField(value = "file_path")
	private String filePath;

	/**创建日期*/
	@ApiModelProperty(value = "创建日期")
	@TableField(value = "creation_date")
	private java.util.Date creationDate;

	/**发送时间*/
	@ApiModelProperty(value = "发送时间")
	@TableField(value = "send_date")
	private java.util.Date sendDate;

	/**发送回执*/
	@ApiModelProperty(value = "发送回执")
	@TableField(value = "send_msg")
	private String sendMsg;
}

package com.garry.mail.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 附件文件夹实体类 实体类
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:46   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@ApiModel(value = "MailFileFolderPathPO", description = "附件文件夹实体类 实体类")
@TableName(value = "mail_file_folder_path")
@Getter
@Setter
@ToString
public class MailFileFolderPathPO  {

	private static final long serialVersionUID = 1L;


	/**路径id*/
	@ApiModelProperty(value = "路径id")
	@TableId(value = "folder_path_id", type = IdType.ID_WORKER)
	private Long folderPathId;

	/**文件夹绝对路径*/
	@ApiModelProperty(value = "文件夹绝对路径")
	@TableField("folder_path")
	private String folderPath;

	/**创建日期*/
	@ApiModelProperty(value = "创建日期")
	@TableField("creation_date")
	private java.util.Date creationDate;

}

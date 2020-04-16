package com.garry.mail.model;

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
@Getter
@Setter
@ToString
public class MailFileFolderPathPO  {

	private static final long serialVersionUID = 1L;

	/**路径id*/
	@ApiModelProperty(value = "路径id")
	private Long folderPathId;

	/**文件夹绝对路径*/
	@ApiModelProperty(value = "文件夹绝对路径")
	private String folderPath;

	/**创建日期*/
	@ApiModelProperty(value = "创建日期")
	private java.util.Date creationDate;

}

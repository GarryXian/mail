package com.garry.mail.controller;

import com.garry.mail.service.MailFileInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 附件文件实体类 Controller 控制器
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:55:09   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Api(tags = {"附件文件实体类控制器"})
@RestController
@RequestMapping("/mailFileInfo")
public class MailFileInfoController {

	@Resource
	private MailFileInfoService mailFileInfoService;




}

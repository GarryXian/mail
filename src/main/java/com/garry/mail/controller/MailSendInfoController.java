package com.garry.mail.controller;

import com.garry.mail.dto.ResponseResult;
import com.garry.mail.service.MailFileInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮箱地址信息 Controller 控制器
 *
 * <pre>
 * -----------------------History----------------------
 * DATE        AUTHOR        VERSION        DESCRIPTION
 * 2020-04-15 22:54:24   CodeGenerator      V1.0.0      新建
 * </pre>
 *
 * @author create by CodeGenerator
 */
@Api(tags = {"邮箱地址信息控制器"})
@RestController
@RequestMapping("/mailService")
public class MailSendInfoController {

	@Resource
	private MailFileInfoService mailFileInfoService;

	@GetMapping("/send")
	public ResponseResult<String> send() {
		try {
			Integer result = mailFileInfoService.sendMail();
			return ResponseResult.createSuccessResult(
					String.format("发送成功, 发送 %s 封邮件", result));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.createFailResult("构建失败",null );
		}
	}



}

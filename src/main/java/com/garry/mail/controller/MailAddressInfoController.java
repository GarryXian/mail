package com.garry.mail.controller;

import com.garry.mail.service.MailAddressInfoService;
import io.swagger.annotations.Api;
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
@RequestMapping("/mailAddressInfo")
public class MailAddressInfoController {

	@Resource
	private MailAddressInfoService mailAddressInfoService;





}

package com.garry.mail.controller;

import com.garry.mail.dto.ResponseResult;
import com.garry.mail.model.MailBean;
import com.garry.mail.model.MailFileInfoPO;
import com.garry.mail.service.MailFileInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;

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

	@GetMapping("/buildMailFileInfo/{date}")
	public ResponseResult<String> buildAndSaveMailFileInfo(@PathVariable String date) {
		try {
			String result =	mailFileInfoService.buildAndSaveMailFileInfo(date);
			return ResponseResult.createSuccessResult(
                    String.format("构建成功,批次号 %s, 请留意检查!!", result));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.createFailResult("构建失败",null );
		}
	}


}

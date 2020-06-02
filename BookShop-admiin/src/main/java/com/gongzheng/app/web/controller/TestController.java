package com.gongzheng.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年3月26日 上午1:00:51
 * @Description: 
*/
@Controller
@RequestMapping("/test")
public class TestController {
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		System.out.println("测试无需sprig security 身份认证！");
		return "测试无需sprig security 身份认证！";
	}

}

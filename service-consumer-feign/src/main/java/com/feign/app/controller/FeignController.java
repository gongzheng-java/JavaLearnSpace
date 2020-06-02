package com.feign.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feign.app.service.FeignService;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月21日 下午4:07:38
 * @Description: 
*/
@RestController
@RequestMapping("/feign")
public class FeignController {
	
	@Autowired
	private FeignService feignService;
	
	@RequestMapping("/getUserInfo")
	public List<String> getUserList(){
		System.out.println("使用feign调用producer服务。。。。。");
		return feignService.getUserList();
	}
	

}

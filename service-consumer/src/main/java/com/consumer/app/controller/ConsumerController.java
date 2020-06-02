package com.consumer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumer.app.service.ConsumerService;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月14日 下午2:12:22
 * @Description: 
*/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@RequestMapping("/getUserInfo")
	public List<String> getUserList(){
		
		return consumerService.getUserList();
	}
	
	@RequestMapping("/zuulTest")
	public String zuulTest() {
		System.out.println("测试zuul路由网关。");
		return "This is Service-consumer project!";
	}

}

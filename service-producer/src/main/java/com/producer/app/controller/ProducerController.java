 package com.producer.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月13日 下午10:47:17
 * @Description: 
*/
@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	//获取.yml中的端口号
	@Value("${server.port}")
	private String serverProt;
	
	//发布后直接浏览器测 http://localhost:8762/getUserList 访问
	@RequestMapping("/getUserList")
	public List<String> getUserList() {
		List<String> listUser = new ArrayList<String>();
		listUser.add("zhangsan");
		listUser.add("lisi");
		listUser.add("yushengjun");
		listUser.add("serverProt:"+serverProt);
		System.out.println("servcie-producer："+serverProt+" 服务被调用..............");
		return listUser;
	}

	
	@RequestMapping("/zuulTest")
	public String zuulTest() {
		System.out.println("测试zuul路由网关。");
		return "This is Service-producer project! serverProt:"+serverProt;
	}

}

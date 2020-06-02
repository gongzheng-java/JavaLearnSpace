package com.dubbo.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dubbo.api.UserService;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月10日 上午11:02:05
 * @Description:
 */
@ResponseBody
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(String name) {
		String welcome = userService.sayHi(name);
		return welcome;
	}
}

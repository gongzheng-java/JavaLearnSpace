package com.dubbo.provider;

import com.dubbo.api.UserService;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月9日 下午6:07:05
 * @Description:
 */
public class UserServiceImpl implements UserService {

	public String sayHi(String name) {
		System.out.println("您好，" + name);
		return "看到" + name;
	}

}

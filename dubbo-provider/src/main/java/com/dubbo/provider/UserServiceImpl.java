package com.dubbo.provider;

import com.dubbo.api.UserService;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��9�� ����6:07:05
 * @Description:
 */
public class UserServiceImpl implements UserService {

	public String sayHi(String name) {
		System.out.println("���ã�" + name);
		return "����" + name;
	}

}

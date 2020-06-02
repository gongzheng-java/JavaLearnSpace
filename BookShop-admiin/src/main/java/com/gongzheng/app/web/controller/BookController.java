package com.gongzheng.app.web.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gongzheng.app.domain.Book;
import com.gongzheng.app.service.BookService;

import io.swagger.annotations.*;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年3月9日   下午10:01:12 
 * @Description:
 */
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@ResponseBody
	@RequestMapping("/getBook")
	public Book getBook() {

		Book book = new Book();
		book = bookService.findById(14);
		String name = book.getCategory().getName();
		System.out.println(name);
		System.out.println("service:" + book);
		return book;
	}

	/**
	 * 方法异常测试
	 * 1、测试500错误 访问该地址会跳转到500.html页面
	 * 2、调用此方法注意拦截器的postHandle方法是否执行
	 * 3.集成swagger时，若不指定求情方式，则会生成多个相同的接口
	 * 4.@ApiOperation("测试接口1") 是swagger注解，作用于方法，用于描述页面接口作用，告诉使用者接口的实现的功能，如：“根据ID查询订单”。
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation("测试500异常错误")
	public String test() {
		System.out.println("13123");
		throw new RuntimeException("测试500错误 访问该地址会跳转到500.html页面");
		// return "张三";
	}

	/**
	 * 方法正常执行
	 *1、调用此方法注意拦截器的postHandle方法是否执行
	 */
	@ResponseBody
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	@ApiOperation("测试接口test1")
	public String test1() {

		// 获取spring security登陆信息(该部分代码可以写在任何地方)
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("获取的authentication对象信息:" + authentication);
		if (authentication != null) {
			System.out.println("当前认证的用户信息：" + authentication.getPrincipal());
		}

		System.out.println("13123");

		return "张三";
	}

	/**
	 * 测试swagger页面展示方法及参数
	 * 展示普通参数时swagger页面注释
	 * 
	 * @ApiParam("姓名") swagger注解，作用于参数
	 */
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	@ApiOperation("测试swagger普通参数")
	public String test2(
			@ApiParam("姓名") @RequestParam(value = "name", required = false, defaultValue = "张三丰") String name,
			@ApiParam("年龄") @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);

		return "您好！" + name;
	}

	/**
	 * 测试swagger页面展示方法及参数
	 * 展示对象参数时swagger页面参数注释
	 */
	@ResponseBody
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	@ApiOperation("测试swagger对象参数")
	public String test3(Book book) {
		System.out.println("13123");

		return "张三";
	}
}

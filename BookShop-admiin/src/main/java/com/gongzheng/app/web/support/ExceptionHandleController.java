package com.gongzheng.app.web.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
  *静态资源处理  异常捕获 
 * @Author: gongZheng
 * @Date:   2020年3月10日   上午12:55:59 
 * @Description: 
 *     1.在resources/error文件中创建了异常跳转页面，若是前后端分离项目，那么后台不需要自己做跳转页面，
 *     而是给前端返回异常的json，由前端根据返回的状态，自己确定跳转的页面；
 *     2.创建此类后，再次访问http://localhost:8020/admin/book/test 不在跳转到500.html页面，而是现实json信息
 * 
 */
@RestControllerAdvice
public class ExceptionHandleController {
	
 
   /**
    * 1.该方法可以编写多个，@ExceptionHandler注解后可以是自己编写的异常类
    * 2.虽然捕获异常，正常返回异常信息，但是处理异常过程中没有错误，因此返回给前端的status状态码依旧是200(成功)
    *   所以需要添加注解@ResponseStatus，之后状态码会变成500
    * @param exception
    * @return
    */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus//该注解可以控制返回状态码
	public Map<String, Object> handleException(RuntimeException exception){
		Map<String, Object> result=new HashMap<>();
		result.put("flag", "fail");
		result.put("errMsg", exception.getMessage());
		return result;
	}

}

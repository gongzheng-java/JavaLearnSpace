package com.gongzheng.app.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
  * 拦截器：可在方法执行前后执行一些公共操作
  * 此处实现 记录方法调用时间
 * @Autho:  gongZheng
 * @Time:   2020年3月10日 下午4:15:29
 * @Description: 1.HandlerInterceptor接口是spring框架提供的，实现改接口并重写接口的三个抽象方法
 *               2.若想拦截器生效，还需要创建配置类，并在该类中添加拦截器配置(参见WebConfig类)
 *               3.拦截器作用：登录拦截、或是权限校验、或是防重复提交、或是根据业务像12306去校验购票时间
*/
@Component
public class TimeInterceptor implements HandlerInterceptor {
	
	/**
	  * 调用前执行
	  * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
	 * @param request
	 * @param response
	 * @param handler 处理请求的方法
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 开始执行。。。。。");
		//打印请求的类和方法
		//在请求资源找不到的情况下会出现转换错误，因此加判断
		if (handler instanceof HandlerMethod) {
			String className=((HandlerMethod)handler).getBean().getClass().getName();
			String methodName=((HandlerMethod)handler).getMethod().getName();
			System.out.println("此次URL求情的类名："+className);
			System.out.println("此次URL求情的方法名："+methodName);
		}
		
		request.setAttribute("startTime", new Date().getTime());
		
         //如果返回false 那么方法不会被调用
		return true;
	}
	
	/**
	  * 调用成功返回，不成功则不执行
	  * 在业务处理器处理请求执行完成后，生成视图之前执行。
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView 保存返回视图数据，前后端分离的项目则无值
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			 ModelAndView modelAndView) throws Exception {
		
		System.out.println("\n postHandle 开始执行。。。。。");
		long time=new Date().getTime()-(Long)request.getAttribute("startTime");
		System.out.println(" postHandle 耗时： "+time+" ms");
	}


	/**
	 * 调用处理完成后执行，不管是否调用成功都会执行
	 * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			 Exception ex) throws Exception {
		
		System.out.println("\n afterCompletion 开始执行。。。。。");
		//如果异常被ExceptionHandleController类捕获，此处是null值
		System.out.println("异常信息："+ex);
	}
}

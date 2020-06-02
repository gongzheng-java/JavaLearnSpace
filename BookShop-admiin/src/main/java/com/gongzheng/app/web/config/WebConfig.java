package com.gongzheng.app.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gongzheng.app.web.interceptor.TimeInterceptor;


/**
 * 配置类
 * 配置拦截器和过滤器
 * @Autho:  gongZheng
 * @Time:   2020年3月10日 下午8:30:37
 * @Description: 1.通过打印信息可以发现该类在容器启动时执行一次，后面直接执行拦截器或过滤器内容
 *  2.以下WebMvcConfigurer 比较常用的重写接口
  *         解决跨域问题 
 *    public void addCorsMappings(CorsRegistry registry) ;
  *        添加拦截器
 *    void addInterceptors(InterceptorRegistry registry);
  *        这里配置视图解析器
 *    void configureViewResolvers(ViewResolverRegistry registry);
  *        配置内容裁决的一些选项
 *    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
  *       视图跳转控制器
 *   void addViewControllers(ViewControllerRegistry registry);
  *      静态资源处理 
 *   void addResourceHandlers(ResourceHandlerRegistry registry);
  *      默认静态资源处理器 
 *   void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
*/
@SuppressWarnings("deprecation")
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private TimeInterceptor timeInterceptor;

	/**
	 * 注册拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("<<<<<<<<<<<<<<<<<<<执行拦截器>>>>>>>>>>>>>>>>>>>>>");
		
		registry.addInterceptor(timeInterceptor);
		
	}
	
	/**
	 *过滤器
	 *在老项目中过滤器是在web.xml文件中配置，但是springboot中没有该文件，所以实现过滤器的方式如下
	 * @return
	 */
	@Bean
	public FilterRegistrationBean characterEncodingFilterRegister() {
		System.out.println("<<<<<<<<<<<<<<<<<<<执行过滤器>>>>>>>>>>>>>>>>>>>>>");
		
		//FilterRegistrationBean类来提供过滤器这样的功能
		FilterRegistrationBean registratrion=new FilterRegistrationBean();
		
		//创建过滤器，指定其作用。验证过滤器是否起作用，可以在过滤器类里面打断点
		CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8");
		filter.setForceEncoding(true);//是否强制编码，此处是true
		
		/**
		  * 注册过滤器(将上面准备好过滤器注册进去，此处也可以添加自定义过滤器)
		  * 当你有多个拦截器的时候，可以再添加registratrion.setOrder(**)进行设置
		 */
		registratrion.setFilter(filter);
		
		//设置过滤规则（过滤指定的url）
		/**
		 * 方式一：创建集合保存过滤规则，然后将集合添加到setUrlPatterns()中
		 */
		List<String> urls=new ArrayList<String>();
		urls.add("/*");
		urls.add(".html");
		urls.add("/folder_name/*");
		urls.add("/index.html");
		registratrion.setUrlPatterns(urls);
		
		/**
		 * 方式二：依次添加
		 */
		  //过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件，注意这里*前有“/”
		registratrion.addUrlPatterns("/*");
		  //过滤指定的类型文件资源, 当前应用程序根目录下的所有html文件，注意：*.html前没有“/”,否则错误
		registratrion.addUrlPatterns(".html");
		  //过滤指定的目录下的所有文件,当前应用程序根目录下的folder_name子目录（可以是多级子目录）下所有文件
		registratrion.addUrlPatterns("/folder_name/*");
		  //过滤指定文件
		registratrion.addUrlPatterns("/index.html");

		 
		
		return registratrion;
	}
}

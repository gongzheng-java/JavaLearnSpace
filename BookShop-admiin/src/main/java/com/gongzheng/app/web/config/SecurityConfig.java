package com.gongzheng.app.web.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

/**
 * sping Security 配置类
 * @Autho:  gongZheng
 * @Time:   2020年3月26日 上午12:41:46
 * @Description: sping Security是安全框架，用于控制权限,此处是配置类，用于控制spring security的一些行为
*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http//.httpBasic()//弹框登陆 类似于html的alert();
		.formLogin()//表单登陆界面
		.and()
		.authorizeRequests()
		.antMatchers("/test").permitAll()//指定 /test 的请求无需拦截(controller包中的TestController类)
		//.antMatchers(HttpMethod.GET).permitAll()//指定get请求任何人都可以访问，无需验证
		.anyRequest().authenticated();//表示除上上述配置的求情外，其他的求情都需要身份认证才能访问
		

	}
}

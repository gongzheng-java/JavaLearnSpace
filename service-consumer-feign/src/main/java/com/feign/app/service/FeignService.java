package com.feign.app.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月21日 下午3:58:48
 * @Description:  
 *    1.注意这是个接口，service-consumer项目中是类
 *    2.类注解value值是生产者的微服务注册名
*/
@FeignClient(value="service-producer")
public interface FeignService {
	
	/**
	 * 底层是发送一个http求情，访问对应的微服务的接口地址
	 * 此处相当于http://service-producer//producer/getUserList
	 * @return
	 */
	@RequestMapping("/producer/getUserList")
	public List<String> getUserList();
	
	

}

package com.consumer.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月14日 下午2:12:05
 * @Description: 
*/
@Service
public class ConsumerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 使用rest调用
	 * 还有一种方法是Feign调用，参照feign项目
	 * @return
	 */
	public List<String> getUserList(){
		//调用生产者
		System.out.println("service-consumer 开始调用微服务--->");
		return restTemplate.getForObject("http://service-producer/producer/getUserList",List.class);
	}

}

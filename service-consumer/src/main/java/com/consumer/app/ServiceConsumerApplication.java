package com.consumer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

	/**
	 * 如果没有这部分代码，启动时会报错，提示无法加载到service类中的RestTemplate模板
	 * @Bean 表示记载注入RestTemplate这个模板类
	 * @LoadBalanced 注解表明这个restRemplate开启负载均衡的功能
	 *        需要注意的是该部分是谁调用就集成到哪里，而不是被调用方
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

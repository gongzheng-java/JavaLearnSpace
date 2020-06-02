package test.eureka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 注册中心
 * @Autho:  gongZheng
 * @Time:   2020年4月13日 下午6:27:13
 * @Description: 注意 注册中心使用eureka的@EnableEurekaServer注解，其余的项目都是使用@EnableEurekaClient注解
*/
@EnableEurekaServer //标注在注册中心项目主类上
@SpringBootApplication
public class 	EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

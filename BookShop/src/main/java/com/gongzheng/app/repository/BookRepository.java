package com.gongzheng.app.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gongzheng.app.domain.Book;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年3月3日   下午11:05:55 
 * @Description:
 */
public interface BookRepository extends JpaRepository<Book,Long>,JpaSpecificationExecutor<Book>{
	
	//多对一中配置的抓取策略是无效的，所以需要配置次注解，表示关联查询多对一中的一方对象，可以减少sql语句的产生，减少查询次数
	//1.如果有使用@Query注解编写了sql语句，则不需要次注解
	//2、如果编写多个此类方法时，就需要每个加这个注解,因此可以优化
	@EntityGraph(attributePaths= {"category","authors"})//可写多个关联对象,名称是Book类中的属性名，不是对象类名
	Book findByName(String name);
	
	Book findById(long id);

}

package com.gongzheng.app.domain;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *多对多 图书--作者 中间关系表
 * @Author: gongZheng
 * @Date:   2020年2月29日   下午11:04:43 
 * @Description:
 */
@Entity
@Table(name="bookauthor")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class BookAuthor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;
	
	//多对一  ：多对一关联关系一般由有外键的一方来维护，即多的一方维护，注意查看Book实体类中的注解和注释
	//fetch 抓取策略  及时查询或缓存查询，默认及时查询，一般设置成lazy 缓存查询
	@ManyToOne(fetch=FetchType.LAZY)
	private Book book;
	
	//多对一  ：多对一关联关系一般由有外键的一方来维护，即多的一方维护，注意查看Author实体类中的注解和注释
	//fetch 抓取策略  及时查询或缓存查询，默认及时查询，一般设置成lazy 缓存查询
	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;

}

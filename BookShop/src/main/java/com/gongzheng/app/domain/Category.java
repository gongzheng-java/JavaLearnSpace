package com.gongzheng.app.domain;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gongzheng.app.domain.pojo.Common;

/**
 *  图书门类
 * @Author: gongZheng
 * @Date:   2020年2月29日   下午5:46:12 
 * @Description: 当实体类名、属性名和数据库表名、字段名一致时，就无需用注解指定映射的表名，字段名(不区分大小写)
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	// 当不写注解的时候，默认添加 @Basic 注解(但必须保证和数据表字段名一致)
	private String name;

	// 该注解无需和数据库表字段映射
	@Transient
	private String xxx;

	// 嵌入公共类对象
	@Embedded
	private Common common;
	
	//一对多 
	// mappedBy="Category" 表示当前一对多关系由多的一方管理维护，category 表示 是 Book实体类中的对象
	@OneToMany(mappedBy="category")
	private List<Book> books;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
	}

	
}

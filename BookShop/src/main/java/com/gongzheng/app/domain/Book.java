package com.gongzheng.app.domain;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gongzheng.app.domain.pojo.Common;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年2月29日   下午10:23:27 
 * @Description:
 */
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Book {

	/**  */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@ApiModelProperty("图书名称")
	private String name;

	// 嵌入公共类对象
	@Embedded
	private Common common;

	// 多对一 ：多对一关联关系一般由有外键的一方来维护，即多的一方维护，注意查看Category实体类中的注解和注释
	// fetch 抓取策略 及时查询或缓存查询，默认及时查询，一般设置成lazy 缓存查询
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	// 一对多 （根据书获取作者信息）
	// mappedBy="book" 表示当前一对多关系由多的一方管理维护，book 表示 是 BookAuthor实体类中的对象
	@OneToMany(mappedBy = "book",fetch=FetchType.LAZY)
	private List<BookAuthor> authors;
	
	/**
	 * 乐观锁
	 */
	@Version
	private int version;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<BookAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(List<BookAuthor> authors) {
		this.authors = authors;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", common=" + common + ", category=" + category + ", authors="
				+ authors + "]";
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	

}

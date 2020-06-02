package com.gongzheng.app.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gongzheng.app.domain.pojo.Common;

/**
 *图书作者类
 * @Author: gongZheng
 * @Date:   2020年2月29日   下午6:16:41 
 * @Description:
 */
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Author{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	private String name;

	private int age;

	private int gender;

	private Date birthday;

	//国籍
	private String nationality;

	// 嵌入公共类对象
	@Embedded
	private Common common;

	// 一对多 (根据作者获取书信息)
	// mappedBy="author" 表示当前一对多关系由多的一方管理维护，author 表示 是 BookAuthor实体类中的对象
	@OneToMany(mappedBy = "author")
	@OrderBy("book.name ACS")//获取书信息时，按照书名升序排序
	private List<BookAuthor> books;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
	}

	public List<BookAuthor> getBooks() {
		return books;
	}

	public void setBooks(List<BookAuthor> books) {
		this.books = books;
	}



	
}

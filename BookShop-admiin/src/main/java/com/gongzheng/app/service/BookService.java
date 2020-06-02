package com.gongzheng.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzheng.app.domain.Book;
import com.gongzheng.app.repository.BookRepository;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月11日 下午8:39:18
 * @Description: 
*/
@Service(value="BookService")
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Book findById(long id) {
	Book book=	bookRepository.getOne(id);
	System.out.println(book.toString());
	return book;
	}
}

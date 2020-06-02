package com.gongzheng.app.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;

import com.gongzheng.app.BaseTest;
import com.gongzheng.app.domain.Book;
import com.gongzheng.app.domain.pojo.Common;

/**
 * 图书测试类
 * @Author: gongZheng
 * @Date:   2020年3月3日   下午10:58:46 
 * @Description:
 */
public class BookRepositoryTest extends BaseTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void getBook() {
		System.out.println(bookRepository.getOne((long) 10));
	}

	@Test
	public void saveTest() {

		Book book = new Book();
		book.setName("时间简史");
		Common common = new Common();
		common.setDel_flag(0);
		book.setCommon(common);
		bookRepository.save(book);

		System.out.println("保存成功！");
	}

	/**
	 * 查询 
	 * 需要注意根据实体类中抓起策略fetch的取值不同，而导致生成sql的不同，
	 * 也要注意取查询结果对象的属性值不同，生成的sql也不一样
	 */
	@Test
	public void FindAllTest() {

		// List<Book> bList = bookRepository.findAll();
		Book book = null;

		/**
		 * 多对一中@ManyToOne 注解配置 fetch = FetchType.LAZY是无效的，还是产生两条sql语句
		 * 所以需要在BookRepository中findByName方法配置注解，这样执行book.getCategory().getName()就只要一条sql
		 */
		book = bookRepository.findByName("时间简史");

		// book = bookRepository.getOne(14L);

		System.out.println(book.getCategory().getName());

	}

	/**
	 * 动态查询
	 * 
	 * 注意：若想使用下面方式实现动态查询，那么BookRepository接口还需要继承 JpaSpecificationExecutor
	 */
	@Test
	public void DynamicQueryTest() {
		// 参数对象
		Book book = new Book();
		book.setName("红楼梦");

		Specification<Book> spec = new Specification<Book>() {

			/**
			 * root是对实体对象的封装
			 */
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				// 添加条件 第一个参数是属性名 第二个是属性值,一般放参数名，如果参数名有值，则查询，没有则不查询
				Predicate p1 = cb.equal(root.get("category").get("name"), "名著");
				Predicate p2 = cb.equal(root.get("name"), book.getName());
				Predicate p3 = cb.equal(root.get("common").get("del_flag"), 1);

				// 原条件拼装 没有创建 predicates 对象
				/*
				 * Predicate p=cb.and(p1,p2,p3); return p;
				 */
				// 组装条件
				predicates.add(p1); // 开发时可以直接写predicates.add(cb.equal(root.get("name"),
									// book.getName()));
				predicates.add(p2);
				predicates.add(p3);
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}

		};

		List<Book> books = bookRepository.findAll(spec);
		System.out.println(books.get(0).toString());

	}

	/**
	 * 测试乐观锁
	 * 实现：book实体类增加int字段 和 @Version 注解
	 * 注意查看生产的sql，和数据库version字段值变化
	 */
	@Test
	public void versionTest() {
		Book book = null;
		book=bookRepository.findById(14);
		//book=bookRepository.getOne(10L);
       System.out.println(book);
		book.setName("红楼梦");
		
		//此处直接使用save()方法不起作用
		bookRepository.saveAndFlush(book);
		
		System.out.println("修改成功！");
	}

	@Test
	public void test() {
		
		System.out.println("\n修改成功！");
	}
}

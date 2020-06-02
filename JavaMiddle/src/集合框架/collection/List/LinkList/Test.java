package 集合框架.collection.List.LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年7月23日   下午10:34:05 
 * @Description:
 */
public class Test {

	@org.junit.Test
	public void test() {
		
		MyLinkedList mList=new MyLinkedList();
		mList.add("111");
		mList.add("112");
		mList.add("113");
		mList.add("114");
		mList.add("115");
		mList.add("116");
		mList.add("117");
		mList.add("118");
		mList.add("119");
		mList.add("111");
		mList.add("112");
		mList.add("113");
		mList.add("114");
		mList.add("115");
		mList.add("116");
		mList.add("117");
		mList.add("118");
		mList.add("119");
		System.out.println("元素个数："+mList.size());
		System.out.println(mList.get(9));
		System.out.println(mList.get(7));
		
	}

}

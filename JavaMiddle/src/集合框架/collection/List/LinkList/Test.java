package ���Ͽ��.collection.List.LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��7��23��   ����10:34:05 
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
		System.out.println("Ԫ�ظ�����"+mList.size());
		System.out.println(mList.get(9));
		System.out.println(mList.get(7));
		
	}

}

package ���Ͽ��.collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��5��27�� ����8:07:13
 * @Description:
 */
public class Test extends Thread {
	public static void main(String[] args) throws InterruptedException {
	

		
			MyList mList = new MyList();
		
		System.out.println("���ϴ�С��" + mList.size());
		System.out.println("�����Ƿ�Ϊ�գ�" + mList.isEmpty());
		System.out.println("�������Ƿ����ĳԪ�أ�" + mList.contains(13));
		System.out.println("��ȡָ���±�ļ���Ԫ�أ�" + mList.get(0));
		System.out.println("ָ����Ԫ���ڼ����е��±꣺" + mList.indexOf(13));
		sleep(1000);

		mList.add(13);
		mList.add("111");
		mList.add(15);
		mList.add("000");

		System.out.println("���ϴ�С��" + mList.size());
		System.out.println("�����Ƿ�Ϊ�գ�" + mList.isEmpty());
		System.out.println("�������Ƿ����ĳԪ�أ�" + mList.contains(13));
		System.out.println("ָ����Ԫ���ڼ����е��±꣺" + mList.indexOf(13));
		System.out.println("��ȡָ���±�ļ���Ԫ�أ�" + mList.get(3));

		
		System.out.println("++++++++++++++++++++++++++++++++++");
		List list = new ArrayList<>();
		list.add(123);
		list.add(123);
		list.add("����");
		list.add("����");
		list.add(12.3);
		list.add(3, "zhangsan ");
		//System.out.println(list.set(2, "����"));
		System.out.println("list �Ĵ�С��" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove("����");
		// list.remove("����");
		System.out.println("ɾ��");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

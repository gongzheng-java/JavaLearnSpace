package 集合框架.collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年5月27日 下午8:07:13
 * @Description:
 */
public class Test extends Thread {
	public static void main(String[] args) throws InterruptedException {
	

		
			MyList mList = new MyList();
		
		System.out.println("集合大小：" + mList.size());
		System.out.println("集合是否为空：" + mList.isEmpty());
		System.out.println("集合中是否包含某元素：" + mList.contains(13));
		System.out.println("获取指定下标的集合元素：" + mList.get(0));
		System.out.println("指定的元素在集合中的下标：" + mList.indexOf(13));
		sleep(1000);

		mList.add(13);
		mList.add("111");
		mList.add(15);
		mList.add("000");

		System.out.println("集合大小：" + mList.size());
		System.out.println("集合是否为空：" + mList.isEmpty());
		System.out.println("集合中是否包含某元素：" + mList.contains(13));
		System.out.println("指定的元素在集合中的下标：" + mList.indexOf(13));
		System.out.println("获取指定下标的集合元素：" + mList.get(3));

		
		System.out.println("++++++++++++++++++++++++++++++++++");
		List list = new ArrayList<>();
		list.add(123);
		list.add(123);
		list.add("李四");
		list.add("李四");
		list.add(12.3);
		list.add(3, "zhangsan ");
		//System.out.println(list.set(2, "王五"));
		System.out.println("list 的大小：" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove("李四");
		// list.remove("李四");
		System.out.println("删除");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

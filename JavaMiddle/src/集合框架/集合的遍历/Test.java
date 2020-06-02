package 集合框架.集合的遍历;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年7月25日 下午10:59:21
 * @Description:
 */
public class Test {

	/**
	 * list集合的三种遍历
	 */
	@org.junit.Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("中国银行");
		list.add("建设银行");
		list.add("广发银行");
		list.add("工商银行");
		list.add("农业银行");
		list.add("华夏银行");
		list.add("浦发银行");

		System.out.println("方式一：普通的for循环遍历list");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("size:"+list.size());
			//list.remove(2);
			System.out.println(list.get(i));
		}
		
		
		System.out.println("");
		System.out.println("方式二：for增强遍历list");
		for (String string : list) {
			System.out.println(string);
		}
          
		System.out.println();
		System.out.println("方式三：迭代器");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * 遍历set集合 只有这一种遍历方法
	 */
	@org.junit.Test
	public void test1() {
		Set<String> set = new HashSet<>();
		set.add("中国银行");
		set.add("建设银行");
		set.add("广发银行");
		set.add("工商银行");
		set.add("农业银行");
		set.add("华夏银行");
		set.add("浦发银行");
		//for增强循环
		System.out.println("for增强循环：");
		for(String string:set){
			System.out.println(string);
		}

		String string = null;
		// for增强循环，迭代器
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			string = (String) iterator.next();
			System.out.println(string);
		}

		// while循环
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			string = (String) iterator.next();
			System.out.println(string);
		}
	}

	/**
	 * 遍历map集合
	 */
	@org.junit.Test
	public void test2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "中国银行");
		map.put("2", "建设银行");
		map.put("3", "浦发银行");
		map.put("4", "杭州银行");
		map.put("5", "工商银行");
		map.put("6", "广发银行");
		map.put("7", "农业银行");
		map.put("8", "华夏银行");

		System.out.println("map遍历的方式一：");
		for (String key : map.keySet()) {
			System.out.println("key : " + key + " value : " + map.get(key));
		}
		// 只遍历value值
		for (String value : map.values()) {
			System.out.println(value);
		}

		// 通过Map.Entry(String,String)
		// 获取，然后使用entry.getKey()获取到键，通过entry.getValue()获取到值
		System.out.println("map遍历的方式二：");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("键 key ：" + entry.getKey() + " 值value ：" + entry.getValue());
		}

		// 方式三，其实的方式二的复杂写法
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("键key ：" + entry.getKey() + " value ：" + entry.getValue());
		}
		System.out.println("====================================");
	}
	
	
	

}

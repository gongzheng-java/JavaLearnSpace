package guava编程.实用功能;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 查看每个老师教授的课程 Multimap key-value key可以重复
 * 
 * @Author: gongZheng
 * @Date: 2019年8月29日 下午9:44:56
 * @Description:
 */
public class MultimapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("语文", "张老师");
		map.put("数学", "李老师");
		map.put("生物", "张老师");
		map.put("物理", "李老师");
		map.put("化学", "王老师");
		map.put("音乐", "王老师");
		map.put("美术", "王老师");
		map.put("英语", "张老师");

		Multimap<String, String> multimap = ArrayListMultimap.create();

		//multimap的key可以重复，所以将map的value值当key值，保存在multimap中
		//这样的话，遍历后multimap中保存是多个相同的key值，对应不同的value值
		for (String key : map.keySet()) {
			multimap.put(map.get(key), key);
		}

		for (String string : multimap.keySet()) {
			//根据key取value值，因为多有相同的key，所以可以取出key值相同的value，返回一个value的集合
			//这个集合就是同一个老师，所教授的不同的课程
			Collection<String> collection = multimap.get(string);
			System.out.println(string + "--->" + collection.toString());
		}

	}

}

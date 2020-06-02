package 集合框架.Map.optimize;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年7月22日   下午10:46:51 
 * @Description:
 */
public class Test {
	


	public static void main(String[] args) {

		MyMap2 map2=new MyMap2();
		map2.put("1", "张三");
		map2.put("2", "李四");
		map2.put("3", "王五");
		map2.put("1", "拿破仑");
		System.out.println(map2.size());
		System.out.println(map2.get("1"));
		
		Map<String, String> map=new HashMap<>();
		map.put("1", "张三");
		map.put("2", "李四");
		map.put("3", "王五");
		map.put("1", "拿破仑");
		System.out.println(map.size());
	}
}

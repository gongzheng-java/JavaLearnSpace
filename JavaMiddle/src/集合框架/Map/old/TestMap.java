package 集合框架.Map.old;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的基本用法
 * @Author: gongZheng
 * @Date:   2019年6月5日   下午10:51:56 
 * @Description:
 */
public class TestMap {
	public static void main(String[] args) {
		Map<String, Object> map= new HashMap<>();
		map.put("1", "zhansgan");
		System.out.println(map.get("1").hashCode());
	}
	
}

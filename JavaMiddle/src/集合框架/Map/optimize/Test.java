package ���Ͽ��.Map.optimize;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��7��22��   ����10:46:51 
 * @Description:
 */
public class Test {
	


	public static void main(String[] args) {

		MyMap2 map2=new MyMap2();
		map2.put("1", "����");
		map2.put("2", "����");
		map2.put("3", "����");
		map2.put("1", "������");
		System.out.println(map2.size());
		System.out.println(map2.get("1"));
		
		Map<String, String> map=new HashMap<>();
		map.put("1", "����");
		map.put("2", "����");
		map.put("3", "����");
		map.put("1", "������");
		System.out.println(map.size());
	}
}

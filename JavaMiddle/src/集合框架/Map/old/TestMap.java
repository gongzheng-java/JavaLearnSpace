package ���Ͽ��.Map.old;

import java.util.HashMap;
import java.util.Map;

/**
 * ����map�Ļ����÷�
 * @Author: gongZheng
 * @Date:   2019��6��5��   ����10:51:56 
 * @Description:
 */
public class TestMap {
	public static void main(String[] args) {
		Map<String, Object> map= new HashMap<>();
		map.put("1", "zhansgan");
		System.out.println(map.get("1").hashCode());
	}
	
}

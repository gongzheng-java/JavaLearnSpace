package guava编程.实用功能;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *HashMap key唯一 value可以重复
 *BiMap 双向map  key和value都不能重复
 * @Author: gongZheng
 * @Date: 2019年8月29日 下午10:42:16
 * @Description:
 * 应用：比如根据用户找邮箱，根据邮箱找用户
 */
public class BiMapDemo {
	public static void main(String[] args) {
		//如果key重复，会覆盖原来的值；如果value重复会直接报错
         BiMap<String, String> biMap=HashBiMap.create();
         biMap.put("a", "110");
         biMap.put("a", "111");
         biMap.put("c", "112");
         biMap.put("d", "113");
         biMap.put("e", "114");
         System.out.println("a的值："+biMap.get("a"));//值是111，覆盖原来的100
         System.out.println("bimap大小："+biMap.size());//大小是4
         System.out.println("根据value找key值："+biMap.inverse().get("111"));//inverse()是反转的意思
	     System.out.println("多次反转："+biMap.inverse().inverse().get("a"));
	}
	
}

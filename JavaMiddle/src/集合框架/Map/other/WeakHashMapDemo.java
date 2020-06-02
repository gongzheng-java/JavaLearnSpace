package ���Ͽ��.Map.other;

import java.util.WeakHashMap;

/**
 *WeakHasMap ��Ϊ�����ͣ�gc���к����������
 * @Author: gongZheng
 * @Date:   2019��8��28��   ����8:33:45 
 * @Description:
 */
public class WeakHashMapDemo {
public static void main(String[] args) {
	WeakHashMap<String, String> wHashMap=new WeakHashMap<String,String>();
	//ǰ�����ǳ����ض��󣬲��ᱻ����
	wHashMap.put("a","zhansgan");
	wHashMap.put("b","lisi");
	//������ gc���лᱻ����
	wHashMap.put(new String("c"),"wangwu");
	wHashMap.put(new String("d"),"zhaoliu");
	
	//֪ͨ��������
	System.gc();
	System.runFinalization();
	System.out.println(wHashMap.get("a"));
	System.out.println(wHashMap.get("c"));
	System.out.println("������"+wHashMap.size());
	
	
	
	
	
}
}

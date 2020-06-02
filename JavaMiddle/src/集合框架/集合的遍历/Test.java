package ���Ͽ��.���ϵı���;

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
 * @Date: 2019��7��25�� ����10:59:21
 * @Description:
 */
public class Test {

	/**
	 * list���ϵ����ֱ���
	 */
	@org.junit.Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("�й�����");
		list.add("��������");
		list.add("�㷢����");
		list.add("��������");
		list.add("ũҵ����");
		list.add("��������");
		list.add("�ַ�����");

		System.out.println("��ʽһ����ͨ��forѭ������list");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("size:"+list.size());
			//list.remove(2);
			System.out.println(list.get(i));
		}
		
		
		System.out.println("");
		System.out.println("��ʽ����for��ǿ����list");
		for (String string : list) {
			System.out.println(string);
		}
          
		System.out.println();
		System.out.println("��ʽ����������");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * ����set���� ֻ����һ�ֱ�������
	 */
	@org.junit.Test
	public void test1() {
		Set<String> set = new HashSet<>();
		set.add("�й�����");
		set.add("��������");
		set.add("�㷢����");
		set.add("��������");
		set.add("ũҵ����");
		set.add("��������");
		set.add("�ַ�����");
		//for��ǿѭ��
		System.out.println("for��ǿѭ����");
		for(String string:set){
			System.out.println(string);
		}

		String string = null;
		// for��ǿѭ����������
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			string = (String) iterator.next();
			System.out.println(string);
		}

		// whileѭ��
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			string = (String) iterator.next();
			System.out.println(string);
		}
	}

	/**
	 * ����map����
	 */
	@org.junit.Test
	public void test2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "�й�����");
		map.put("2", "��������");
		map.put("3", "�ַ�����");
		map.put("4", "��������");
		map.put("5", "��������");
		map.put("6", "�㷢����");
		map.put("7", "ũҵ����");
		map.put("8", "��������");

		System.out.println("map�����ķ�ʽһ��");
		for (String key : map.keySet()) {
			System.out.println("key : " + key + " value : " + map.get(key));
		}
		// ֻ����valueֵ
		for (String value : map.values()) {
			System.out.println(value);
		}

		// ͨ��Map.Entry(String,String)
		// ��ȡ��Ȼ��ʹ��entry.getKey()��ȡ������ͨ��entry.getValue()��ȡ��ֵ
		System.out.println("map�����ķ�ʽ����");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("�� key ��" + entry.getKey() + " ֵvalue ��" + entry.getValue());
		}

		// ��ʽ������ʵ�ķ�ʽ���ĸ���д��
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("��key ��" + entry.getKey() + " value ��" + entry.getValue());
		}
		System.out.println("====================================");
	}
	
	
	

}

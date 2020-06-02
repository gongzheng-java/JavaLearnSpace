package ���Ͽ��.collection.Set;

import java.util.HashMap;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��7��24��   ����10:29:47 
 * @Description:set �ײ��ʵ����hashMap������hashmap��key�������ݣ�
 * ����map��keyֵ�����ظ������ʵ����set�����ֵ���ǲ��ظ���
 */
public class MySet {
	//transient�ؼ��� ��ĳЩ�����εĳ�Ա���Ա����������л�
	private transient HashMap map;
	
	private static final Object PRESENT = new Object();
	
	public MySet(){
		map=new HashMap<>();
	}
	
	/**
	 * ���ϸ���
	 * @return
	 */
	public int size(){
		return map.size();
	}
	/**
	 * ���Ԫ��
	 * @param obj
	 * @return �ɹ�����true
	 */
	public boolean add(Object obj){
		//map ���Ԫ�سɹ��Ļ�������null
		return map.put(obj, PRESENT)==null;
	}

	/**
	 * set�Ƿ�Ϊ��
	 * @return
	 */
	 public boolean isEmpty() {
	        return map.isEmpty();
	    }
	 /**
	  * �ж��Ƿ���ڸ�Ԫ��
	  * @param o
	  * @return
	  */
	 public boolean contains(Object o) {
	        return map.containsKey(o);
	    }
	 
	 /**
	  * �Ƴ�
	  * @param obj
	  * @return
	  */
	 public boolean remove(Object obj){
		 //map��remove �������ص���valueֵ
		return map.remove(obj)==PRESENT;
	 }
	
}

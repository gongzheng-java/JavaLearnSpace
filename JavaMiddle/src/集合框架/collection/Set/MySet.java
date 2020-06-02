package 集合框架.collection.Set;

import java.util.HashMap;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年7月24日   下午10:29:47 
 * @Description:set 底层的实现是hashMap，利用hashmap的key保存数据，
 * 由于map的key值不能重复，因此实现了set保存的值都是不重复的
 */
public class MySet {
	//transient关键字 让某些被修饰的成员属性变量不被序列化
	private transient HashMap map;
	
	private static final Object PRESENT = new Object();
	
	public MySet(){
		map=new HashMap<>();
	}
	
	/**
	 * 集合个数
	 * @return
	 */
	public int size(){
		return map.size();
	}
	/**
	 * 添加元素
	 * @param obj
	 * @return 成功返回true
	 */
	public boolean add(Object obj){
		//map 添加元素成功的话返回是null
		return map.put(obj, PRESENT)==null;
	}

	/**
	 * set是否为空
	 * @return
	 */
	 public boolean isEmpty() {
	        return map.isEmpty();
	    }
	 /**
	  * 判断是否存在该元素
	  * @param o
	  * @return
	  */
	 public boolean contains(Object o) {
	        return map.containsKey(o);
	    }
	 
	 /**
	  * 移除
	  * @param obj
	  * @return
	  */
	 public boolean remove(Object obj){
		 //map的remove 方法返回的是value值
		return map.remove(obj)==PRESENT;
	 }
	
}

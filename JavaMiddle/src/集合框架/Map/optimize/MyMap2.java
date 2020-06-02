package 集合框架.Map.optimize;

import java.util.LinkedList;

/**
 * map升级
 * 
 * @Author: gongZheng
 * @Date: 2019年7月22日 下午10:12:29
 * @Description: 1.提高查询效率   
 * 2. map的底层实现是数组+链表
 * 3.
 * 
 */
public class MyMap2 {
	private LinkedList[] a = new LinkedList[999];

	private int size;
	
	/**
	 * 获取hash值
	 * @param key
	 * @return
	 * 优化：hash值有可能出现负数，所以处理如下
	 */
	private int getHashValue(Object key){
		int i = key.hashCode();
		i=i<0?-i:i;
		return i%a.length;
	}

	/**
	 * 添加值
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		Entry2 e = new Entry2(key, value);
		// 采用hashcode取余有个弊端是，计算出的值会出现重复
		//采用数组+链表的好处是，如果i值出现重复，key值不重复，依旧可以将值添加到map中
		int i=getHashValue(key);

		if (a[i] == null) {// 当不存在该对象时，不存在重复的key
			LinkedList<Object> list = new LinkedList<>();
			list.add(e);
			a[i] = list;
			size++;
		} else {// 当已经存在链表对象时，判断是否已经存在key，如果存在则覆盖value
			LinkedList<Entry2> list = a[i];
			for (int j = 0; j < list.size(); j++) {
				Entry2 entry2 = list.get(j);
				if (key.equals(entry2.key)) {
					entry2.value = value;
					return;
				}
			}
			size++;
			list.add(e);
		}

	}

	/**
	 * 根据key获取value值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		int i=getHashValue(key);
		LinkedList<Entry2> list = a[i];
		if (list != null) {
			for (int j = 0; j < list.size(); j++) {
				Entry2 entry2 = list.get(j);
				if (key.equals(entry2.key)) {
					return entry2.value;
				}
			}
		}
		return null;

	}

	public int size() {
		return size;
	}

}

package 集合框架.Map.old;

/**
 * 模拟自定义实现Map功能
 * 
 * @Author: gongZheng
 * @Date: 2019年6月5日 下午11:49:48
 * @Description: 缺点是采用了遍历的方式获取集合中的元素，效率很低
 */
public class MyMap {

  private Entry[] entries = new Entry[999];

	int size;

	/**
	 * 添加元素
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		//如果出现重复键，则覆盖原来是值
		for (int i = 0; i < size; i++) {
			if (entries[i].key.equals(key)) {
				entries[i].value=value;
				return;
			}
		}
		entries[size++] = entry;
	}

	/**
	 * 根据key获取对象
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		for (int i = 0; i < size; i++) {
			if (entries[i].key.equals(key)) {
				return entries[i].value;
			}
		}
		return null;
	}

	/**
	 * 根据key判断元素是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++) {
			if (entries[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据value判断元素是否存在
	 * 
	 * @param value
	 * @return
	 */
	public boolean containsValue(Object value) {
		for (int i = 0; i < size; i++) {
			if (entries[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	public void putAll(MyMap map){
		for (int i = 0; i < map.size; i++) {
			
		
		}
	}

}

package ���Ͽ��.Map.old;

/**
 * ģ���Զ���ʵ��Map����
 * 
 * @Author: gongZheng
 * @Date: 2019��6��5�� ����11:49:48
 * @Description: ȱ���ǲ����˱����ķ�ʽ��ȡ�����е�Ԫ�أ�Ч�ʺܵ�
 */
public class MyMap {

  private Entry[] entries = new Entry[999];

	int size;

	/**
	 * ���Ԫ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		//��������ظ������򸲸�ԭ����ֵ
		for (int i = 0; i < size; i++) {
			if (entries[i].key.equals(key)) {
				entries[i].value=value;
				return;
			}
		}
		entries[size++] = entry;
	}

	/**
	 * ����key��ȡ����
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
	 * ����key�ж�Ԫ���Ƿ����
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
	 * ����value�ж�Ԫ���Ƿ����
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

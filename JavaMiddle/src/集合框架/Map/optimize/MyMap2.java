package ���Ͽ��.Map.optimize;

import java.util.LinkedList;

/**
 * map����
 * 
 * @Author: gongZheng
 * @Date: 2019��7��22�� ����10:12:29
 * @Description: 1.��߲�ѯЧ��   
 * 2. map�ĵײ�ʵ��������+����
 * 3.
 * 
 */
public class MyMap2 {
	private LinkedList[] a = new LinkedList[999];

	private int size;
	
	/**
	 * ��ȡhashֵ
	 * @param key
	 * @return
	 * �Ż���hashֵ�п��ܳ��ָ��������Դ�������
	 */
	private int getHashValue(Object key){
		int i = key.hashCode();
		i=i<0?-i:i;
		return i%a.length;
	}

	/**
	 * ���ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		Entry2 e = new Entry2(key, value);
		// ����hashcodeȡ���и��׶��ǣ��������ֵ������ظ�
		//��������+����ĺô��ǣ����iֵ�����ظ���keyֵ���ظ������ɿ��Խ�ֵ��ӵ�map��
		int i=getHashValue(key);

		if (a[i] == null) {// �������ڸö���ʱ���������ظ���key
			LinkedList<Object> list = new LinkedList<>();
			list.add(e);
			a[i] = list;
			size++;
		} else {// ���Ѿ������������ʱ���ж��Ƿ��Ѿ�����key����������򸲸�value
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
	 * ����key��ȡvalueֵ
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

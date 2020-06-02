package ���Ͽ��.collection.List.ArrayList;

/**
 * �ο�arraylistԴ����дlist��
 * 
 * @Author: gongZheng
 * @Date: 2019��5��27�� ����7:08:19
 * @Description: �ײ�ʵ��������
 */
public class MyList {

	// transient���εĳ�Ա���Ա����������л�
	transient Object[] elementData;

	// list ��С(ע����ָ����Ԫ�صĸ�����������object���鳤��)
	private int size;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	public MyList() {
		this(2);
	}

	public MyList(int initialCapacity) {
		if (initialCapacity > 0) {
			elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			elementData = EMPTY_ELEMENTDATA;
		} else {
			try {
				throw new Exception("���ϳ��ȱ������0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ���Ԫ��
	 * 
	 * @param obj
	 * @return
	 */
	public boolean add(Object obj) {
		// ��������
		if (size + 1 >= elementData.length) {
			Object[] newObj = new Object[size * 2 + 1];
			for (int i = 0; i < elementData.length; i++) {
				newObj[i] = elementData[i];
			}
			elementData = newObj;
		}
		elementData[size] = obj;
		size++;
		return true;
	}

	/**
	 * �򼯺���ָ��λ�ò���Ԫ��
	 * 
	 * @param index
	 * @param obj
	 * @return
	 */
	public void add(int index, Object obj) {
		checkIndex(index);
		// ����(��ָ��λ�����ʱ���϶��ǳ������ϴ�С�ģ�����ֱ������)
		Object[] newObj = new Object[size * 2 + 1];
		for (int i = 0; i < elementData.length; i++) {
			newObj[i] = elementData[i];
		}
		elementData = newObj;
		
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}

	/**
	 * �����±��ȡԪ��
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	/**
	 * �ж��±��Ƿ�Խ��
	 */
	private void checkIndex(int index) {
		if (index >= size || index < 0) {
			try {
				throw new Exception("�����±�Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ȡ����Ԫ�ظ���
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * �жϼ����Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * �ж�ָ����Ԫ���Ƿ�����ڼ�����
	 * 
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * ����ָ��Ԫ���ڼ����е�λ��
	 * 
	 * @param o
	 * @return �Ҳ�������-1
	 */
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elementData[i].equals(o))
					return i;
			}
		}
		return -1;
	}

	/**
	 * ��ռ�������
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	/**
	 * ɾ��ָ��λ�õ�Ԫ��
	 * 
	 * @param index
	 * @return ���ر�ɾ���Ķ���
	 */
	public Object remove(int index) {
		checkIndex(index);
		// ��ȡ��ɾ����Ԫ��
		Object oldObj = elementData[index];
		// ɾ��ĳ��Ԫ�غ���Ҫ�������Ԫ����ǰŲ�����˴�������ҪŲ���ĸ���
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		// �����һ��Ԫ����Ϊnull,ͬʱ��Ԫ�صĸ�������һ��
		elementData[--size] = null;
		return oldObj;
	}

	/**
	 * ɾ��ָ������Ԫ��
	 * 
	 * @param obj
	 * @return
	 */
	public boolean remove(Object obj) {
		if (obj == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) {
					remove(i);
					return true;
				}
			}

		} else {
			for (int i = 0; i < size; i++) {
				if (obj.equals(elementData[i])) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ��������ָ��λ������Ԫ�أ����ú���滻��ԭ��λ�õ�Ԫ��
	 * ��add(index,object)��ͬ���ǣ��÷������滻��ָ���±�λ��Ԫ�ص�ֵ������λ�õ�Ԫ�ز���Ų��λ��
	 * ��add(index,object)���Ԫ�غ󣬻ᵼ������Ԫ��λ���ƶ�
	 * 
	 * @param index
	 * @param obj
	 * @return ���ر��滻��Ԫ��
	 */
	public Object set(int index, Object obj) {
		checkIndex(index);
		Object oldObj = elementData[index];
		elementData[index] = obj;
		return oldObj;
	}

}

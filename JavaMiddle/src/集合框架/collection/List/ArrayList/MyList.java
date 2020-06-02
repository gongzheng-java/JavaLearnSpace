package 集合框架.collection.List.ArrayList;

/**
 * 参考arraylist源码手写list类
 * 
 * @Author: gongZheng
 * @Date: 2019年5月27日 下午7:08:19
 * @Description: 底层实现是数组
 */
public class MyList {

	// transient修饰的成员属性变量不被序列化
	transient Object[] elementData;

	// list 大小(注意是指包含元素的个数，并不是object数组长度)
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
				throw new Exception("集合长度必须大于0");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 添加元素
	 * 
	 * @param obj
	 * @return
	 */
	public boolean add(Object obj) {
		// 数组扩容
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
	 * 向集合中指定位置插入元素
	 * 
	 * @param index
	 * @param obj
	 * @return
	 */
	public void add(int index, Object obj) {
		checkIndex(index);
		// 扩容(在指定位置添加时，肯定是超出集合大小的，所以直接扩容)
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
	 * 根据下标获取元素
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	/**
	 * 判断下标是否越界
	 */
	private void checkIndex(int index) {
		if (index >= size || index < 0) {
			try {
				throw new Exception("集合下标越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取几个元素个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断几个是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 判断指定的元素是否存在于集合中
	 * 
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * 查找指定元素在集合中的位置
	 * 
	 * @param o
	 * @return 找不到返回-1
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
	 * 清空集合内容
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	/**
	 * 删除指定位置的元素
	 * 
	 * @param index
	 * @return 返回被删除的对象
	 */
	public Object remove(int index) {
		checkIndex(index);
		// 获取被删除的元素
		Object oldObj = elementData[index];
		// 删除某个元素后，需要将后面的元素向前挪动，此处计算需要挪动的个数
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		// 将最后一个元素设为null,同时将元素的个数减少一个
		elementData[--size] = null;
		return oldObj;
	}

	/**
	 * 删除指定对象元素
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
	 * 给集合中指定位置设置元素，设置后会替换掉原来位置的元素
	 * 和add(index,object)不同的是，该方法是替换掉指定下标位置元素的值，其余位置的元素不会挪动位置
	 * 而add(index,object)添加元素后，会导致其他元素位置移动
	 * 
	 * @param index
	 * @param obj
	 * @return 返回被替换的元素
	 */
	public Object set(int index, Object obj) {
		checkIndex(index);
		Object oldObj = elementData[index];
		elementData[index] = obj;
		return oldObj;
	}

}

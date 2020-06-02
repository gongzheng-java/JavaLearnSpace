package Collection.customize;

/**
 * 模拟编写jdk中的 ArrayList类
 * 
 * @Author: gongZheng
 * @Date: 2019年3月17日 下午7:12:46
 * @Description:
 */
public class MyArrayList {

	private Object[] value;

	private int size;

	/**
	 * 定义集合初始大小 （设置集合默认大小）
	 */
	public MyArrayList() {
		this(2);// 调用另一个构造器
	}

	/**
	 * 指定集合大小
	 * 
	 * @param count
	 */
	public MyArrayList(int size) {
		if (size <= 0) {
			try {
				throw new Exception("集合大小不能小于等于0");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		value = new Object[size];
	}

	/**
	 * 返回集合大小
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * 添加集合元素
	 * 
	 * @param obj
	 */
	public void add(Object obj) {
		this.value[size] = obj;
		size++;
		// 数组扩容
		if (size >= value.length) {
			int newSize = value.length * 2 + 2;
			Object[] newObj = new Object[newSize];
			for (int i = 0; i < value.length; i++) {
				newObj[i] = value[i];
			}
			value = newObj;
		}
	}

	/**
	 * 取出集合元素
	 * 
	 * @param indexOf
	 * @return
	 */
	public Object get(int indexOf) {
		indexOfCheck(indexOf);
		return value[indexOf];
	}

	/**
	 * 数组越界处理
	 * 
	 * @param indexOf
	 */
	private void indexOfCheck(int indexOf) {
		if (indexOf < 0 || indexOf >= size) {
			try {
				throw new Exception("集合元素越界!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断集合是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 判断集合中是否包含某元素
	 * 
	 * @param obj
	 * @return
	 */
	public int indexOf(Object obj) {
		if (obj == null) {
			return -1;
		}
		for (int i = 0; i < value.length; i++) {
			if (obj.equals(value[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 元素替换
	 * 
	 * @param index
	 *            替换位置的索引
	 * @param obj
	 *            需要替换的元素
	 */
	public void set(int index, Object obj) {

	}

}

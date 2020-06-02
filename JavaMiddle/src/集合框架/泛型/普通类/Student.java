package 集合框架.泛型.普通类;

/**
 * 没有使用泛型
 * 
 * @Author: gongZheng
 * @Date: 2019年8月5日 下午8:26:24
 * @Description: 当没有使用泛型的时候，student中的属性可以保存任何类型的数据，丢失了自己实际类型
 * 在取值的时候需要对object属性值转换，效率低，容易产生错误
 */
public class Student {

	private Object obj1;
	private Object obj2;

	public Student(Object obj1, Object obj2) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	/**
	 * @return the obj1
	 */
	public Object getObj1() {
		return obj1;
	}

	/**
	 * @param obj1
	 *            the obj1 to set
	 */
	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}

	/**
	 * @return the obj2
	 */
	public Object getObj2() {
		return obj2;
	}

	/**
	 * @param obj2
	 *            the obj2 to set
	 */
	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}

}

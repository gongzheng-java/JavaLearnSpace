package 集合框架.泛型.普通类;

/**
 * 使用泛型
 * 
 * @Author: gongZheng
 * @Date: 2019年8月5日 下午8:37:20
 * @Description: 泛型常见字母： 
 *  T    type表示类型
 *  K V  分别代表键值对key value 
 *  E    代表 element 元素 
 *  ？       表示不确定类型
 *  
 *  注意：泛型不能使用静态修饰
 */
public class Student2<T1, T2> {
	
	 //private static T1 tt; 错误 不能使用静态
	private T1 t1;
	private T2 t2;

	public Student2(T1 t1, T2 t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}

	
	public T1 getT1() {
		return t1;
	}

	
	public void setT1(T1 t1) {
		this.t1 = t1;
	}


	public T2 getT2() {
		return t2;
	}

	
	public void setT2(T2 t2) {
		this.t2 = t2;
	}
	
	

}

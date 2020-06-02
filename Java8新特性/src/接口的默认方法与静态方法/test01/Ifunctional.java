package 接口的默认方法与静态方法.test01;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年4月21日 下午8:52:22
 * @Description:
 */
public interface Ifunctional {

	// 常规方法 实现类必须重写
	void method(String name);

	// 接口默认的方法  java8 新特性 该方法默认public修饰且只能使用public修饰
	//子类可以重写覆盖接口的默认方法，也可以不覆盖
	default void defaultMethod() {
		System.out.println("这是接口的默认方法。。。。");
	}
	
	default String defaultMethod2(String name){
		return "您好，"+name;
	}
	// 新特性（注意：在java8 之前接口中的不能有static修饰的方法）
	// 接口的静态方法必须给出方法体，即必须有自己的默认实现
	//注意：接口的static方法不能被子类重写
	static void staticMethod() {
		System.out.println("这是接口的静态static方法01，默认实现。。。。。。");
	}

	static void staticMethod2() {
		System.out.println("这是接口的静态static方法02，默认实现。。。。。。");
	}
}

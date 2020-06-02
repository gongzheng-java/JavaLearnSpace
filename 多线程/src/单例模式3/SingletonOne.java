package 单例模式3;

/**
 * 懒汉式 1 不推荐
 * 
 * @Author: gongZheng
 * @Date: 2017年11月16日 下午4:45:50
 * @Description: 该模式线程不安全，当多个线程同时操作时，会出现实例出多个类对象
 */
public class SingletonOne {
	// 注意此处不能使用find修饰，find修饰的变量是不可改变的
	private static SingletonOne SingletonOne = null;

	private SingletonOne() {
	}

	public static SingletonOne getSingletonOne() {
		/**
		 * 线程不安全的原因分析：当两个线程A、B同时访问此类时，A线程在此处判断类对象为空后出现阻塞，没有执行后面的实例化类对象
		 * 而此时B线程也在访问此类，在if判断处该类对象依旧是null，进入if代码块实例化了类对象，
		 * 而后A线程“苏醒”后继续执行，也实例化了类对象，这样就该类对象就会实例化两次
		 */
		if (SingletonOne == null) {
			SingletonOne = new SingletonOne();
		}
		return SingletonOne;
	}

}

package 线程的常用方法.线程的优先级方法;

/**
 * 线程优先级
 * 
 * @Author: gongZheng
 * @Date: 2017年11月29日 下午7:02:12
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {

		JoinDemo jDemo = new JoinDemo();

		Thread thread = new Thread(jDemo, "线程01");
		Thread thread2 = new Thread(jDemo, "线程02");

		thread.start();
		// 线程的优先级只有1~10 ，通常使用常量表示，默认优先级是5。
		// 线程优先级表示线程抢夺CPU资源的频率，优先级高表示越能抢夺CPU执行权
		thread.setPriority(Thread.MAX_PRIORITY); // 级别 10
		// thread.setPriority(Thread.NORM_PRIORITY);// 级别 5 线程的默认优先级
		thread2.start();
		thread2.setPriority(Thread.MIN_PRIORITY); // 级别 1

		for (int i = 0; i <= 100; i++) {

			System.out.println("主线程：" + Thread.currentThread().toString() + "==>" + i);
		}
	}

}

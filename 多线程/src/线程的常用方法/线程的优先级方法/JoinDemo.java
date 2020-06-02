package 线程的常用方法.线程的优先级方法;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月29日 下午6:36:57
 * @Description:
 */
public class JoinDemo implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i <= 100; i++) {
			/*
			 * 线程的toString()方法 返回该线程的字符串表示形式，包括线程名称、优先级和线程组。 线程的级别默认是5
			 * 谁启动线程，该线程就属于哪个组，所以此处的线程组值都是main
			 */
			System.out.println(Thread.currentThread().toString() + "-------》" + i);
		}
	}

}

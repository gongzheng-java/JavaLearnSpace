package 线程的常用方法.join方法;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月29日 下午6:36:57
 * @Description:
 */
public class JoinDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-------》" + i);
		}
	}

}

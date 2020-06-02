package 多线程.同步并发;

import static org.hamcrest.CoreMatchers.theInstance;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年12月1日   下午3:07:48 
 * @Description:
 */
public class Demo01 implements Runnable {

	private static int num = 100;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}

	}

	public synchronized void test() {
		if (num <= 0) {
			flag = false;
			return;// 此处没有跳出，还会继续运行下面代码，依旧会出现0 负数情况
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到票--->" + num--);

	}

}

package 售票的例子02;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午1:19:10
 * @Description:
 */
public class Ticket implements Runnable {

	/**
	 * 不建议定义静态，生命周期太长，不好控制，这样以来继承thread类实现多线程的弊端就体现了
	 */
	// private static int num = 100;

	private int num = 200;

	@Override
	public void run() {
		while (num > 0) {
			show();
		}
	}

	public synchronized void show() {
		if (num > 0) {
			try {
				Thread.sleep(2);// 模拟卡顿，会出现负数结果
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "\t余票：" + num--);
		}
	}

}

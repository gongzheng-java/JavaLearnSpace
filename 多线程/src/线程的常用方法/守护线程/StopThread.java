package 线程的常用方法.守护线程;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月28日 下午6:34:21
 * @Description: 如何停止一个线程？ 
 *              原来的stop()停止线程的方法已经过时，不推荐使用，因此停止线程只有一种方法，那就是线程结束。
 *              开启多线程后，代码一般都是循环执行的，只要控制循环就可以使run()方法结束，从而结束线程。
 */
public class StopThread implements Runnable {

	private boolean flag = true;// 创建标识符，标识线程是否结束运行

	@Override
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("线程" + Thread.currentThread().getName() + "发生异常，改变标识符，结束当前线程！！！");
				flag = false;// main测试类中，使用了Thread类的interrupt()方法强制清除wait()状态的线程，故此处通过捕获异常来改变标识符的值
			}
			System.out.println(Thread.currentThread().getName() + "-.--...----..>");
		}

	}

	public void changeFlag() {
		flag = false;
	}

}

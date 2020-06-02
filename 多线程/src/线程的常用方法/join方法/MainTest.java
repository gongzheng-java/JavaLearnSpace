package 线程的常用方法.join方法;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月29日 下午7:02:12
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) throws InterruptedException {

		JoinDemo jDemo = new JoinDemo();

		Thread thread = new Thread(jDemo, "线程1");
		Thread thread2 = new Thread(jDemo, "线程2");

		thread.start();
		/*
		 * join() 等待该线程终止 注意该方法主要是针对主线程
		 * 
		 * 开始执行的时候，cpu执行权在主线手里，线程没有使用join()方法的时候，三个线程将相互抢夺cpu执行权；当某个线程调用该方法时，
		 * 那么主线程就会暂停执行，等到该线程执行完后，主线程才参与执行。
		 * 使用场景：当多个线程在执行的时候，可以临时加入某个线程，该线程先运算完再继续运行其他线程。 注意通过调换join方法的位置来观察运行结果。
		 */
		 thread.join();//此处调用时，首先会执行完线程1，然后线程2和主线程抢资源
		thread2.start();
		//thread.join();// 此处调用时，会优先执行完线程1和线程2，主线程不会参与抢夺资源；等线程1执行完后，线程2和主线程抢夺资源
		for (int i = 0; i <= 10; i++) {
			System.out.println("主线程：" + Thread.currentThread().getName() + "==>" + i);
		}
	}

}

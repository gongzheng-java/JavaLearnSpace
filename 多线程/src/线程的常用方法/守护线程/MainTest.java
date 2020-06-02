package 线程的常用方法.守护线程;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月28日 下午6:37:28
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {
		StopThread stopThread = new StopThread();

		Thread thread = new Thread(stopThread);
		Thread thread2 = new Thread(stopThread);

		/*setDaemon()方法将线程标记为守护线程或用户线程，该方法必须在启动线程前调用，参数为true时有效。
		 * 效果：在“停止线程”示例中，我们发现通过改变线程循环标识符或调用interrupt()方法可以使线程停止运行；若不然当主线程执行完后，另外的线程会出现无限循环运行或者出现锁死冻结状态
		 *      而无法停止。现在，在此处调用setDaemon()方法，将线程设置为守护线程，并去掉之前使线程停止的相关代码，运行后，依旧可以实现停止线程的效果。
		 * 解释：该方法相当将对应的线程设置为后台线程，通常我们看到的都是前台线程，当我们将某个线程标记成后台线程后，其开启和运行都没什么变化，一起和前台线程抢夺cpu资源，唯一就是结束有区别
		 *      当所有的前台线程都结束后，后台线程也会自动结束（后台线程依赖前台线程，前台线程结束后，后台存在就没什么意思，就像守护前台线程一样）。
		 *      此处将thread thread2都设置成后台线程后（如果只设置其中的一个，线程将不会结束，两个线程都将处于wait状态），前台线程只有主线程，
		 *      所以当主线程执行完后，所有的线程都结束运行。
		 */
		//thread.setDaemon(true);
		thread2.setDaemon(true);
		thread.start();
		thread2.start();

		int num = 0;
		while (true) {
			System.out.println("进入主线程循环：" + num);
			if (num++ == 60) {
				/*
				 * 1.此处如果不调用方法，不改变标识值，当num值达到60后，跳出循环，主线程会继续运行thread和thread2线程，
				 * 两个线程又是无线循环的，所以会出现线程无法停止的现象
				 * 而且代码的执行速度很快，会在一瞬间执行完并跳出主线程的循环，接着无限执行另外两个线程，来不及看到主线程的输出语句，
				 * 因此会让人感觉到主线程的循环没有执行，
				 * cpu的执行权一直被上面两个线程占据执行的假象。(发生上述情况的前提是，run()方法没有使用同步锁，单纯的run()方法
				 * )。可以通过调用changeFlag()来改变这以现象， 让线程停止
				 */

				/*
				 * 2.如果调用changeFlag()方法，run()方法使用同步锁后，再调用wait()
				 * 方法模拟线程卡顿阻塞而导致的冻结状态，会出现单纯的执行主线现象，直到主线程执行完毕，
				 * 而另外两个线程一直处于Wait()状态，多线程也一直处于运行状态，不会结束
				 */
				// stopThread.changeFlag();

				// 为了解决上面第二种出现的状况(注意此时就不需要再调用上面改变标识符状态的changeFlag()方法了)，下面可以通过调用interrupt()来强制清除线程所处的冻结(阻塞)状态,
				// 让线程恢复到运行状态中来，但是这样做会导致线程异常，刚好可以通过 catch块捕获异常，在catch块中改变
				// 标识符值，从而来结束当前线程
				// (这样就不需要通过调用changeFlag()方法来改变标识符状态了)
				//thread.interrupt();
				//thread2.interrupt();
				System.out.println("线程停止！！");
				break;
			}
			System.out.println("主线程：" + Thread.currentThread().getName());
		}
		System.err.println("Over!!!");

	}

}

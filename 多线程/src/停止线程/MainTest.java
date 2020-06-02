package 停止线程;

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
				thread.interrupt();
				thread2.interrupt();
				System.out.println("线程停止！！");
				break;
			}
			System.out.println("主线程：" + Thread.currentThread().getName());
		}
		System.err.println("Over!!!");

	}

}

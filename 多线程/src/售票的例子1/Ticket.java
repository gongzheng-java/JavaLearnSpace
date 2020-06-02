package 售票的例子1;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月7日 下午7:36:16
 * @Description: 票数100张，多个窗口同时售票 实现线程的方法：
 *            1. 继承thread的类，重写run()方法
 *               缺陷：java的单根继承，一旦继承了线程类就不能继承其他的类，这样大大限制了类的拓展性，不推荐使用
 *            2.实现runnable接口， 重写Runnable接口中的run()方法， 通过Thread类创建线程对象，
 *               将Runnable接口的实现类作为参数，传递给Thread类的构造函数
 *               调用Thread类的start()方法开启线程，会执行Runnable的实现类中run()方法
 * 
 *               切记多线程的条件：1.必须的两个或以上线程 2.使用的是相同的线程锁
 * 
 */
public class Ticket implements Runnable { /*
										 * /extends Thread {
										 * 
										 * 
										 * /**
										 * 1.继承thread类时，如果此处没有使用静态，会出现每一个线程都会卖出100张票
										 * ，实际票数大于100， 不符合实际情况
										 * 所以此处使用静态变量，让多个线程共享一个变量
										 * 。缺点是，静态变量生命周期比较长，不好控制，会长时间占用内存
										 * 以此，引出下面实现多线程的第二个方法，实现Runnable接口
										 * 2.实现Runnable接口时，可以不使用静态变量
										 */
	// private static int ticket = 100;
	private int ticket = 1000;
	Object object = new Object();

	@Override
	public void run() {
		// this.getName() 是获取当前线程的名称
		// 标准写法是Thread.currentThread().getName()或currentThread().getName()
		// 当给线程命名时，会获取所命名的名称，如果没有，则会获取线程的默认名称

		while (ticket > 0) {
			show();
			// synchronized (object) {
			// //同步，解决多线程安全问题，此处参数的任意对象；将线程共享部分的代码放到synchronized中
			// 同步代码使用的锁是参数对象
			// }

		}

	}

	// 将原来的同步代码，变成同步函数 同步函数使用的锁的this 如果同步函数被静态static修饰后就不是this，而是:当前类名.class
	public synchronized void show() {
		if (ticket > 0) {
			// 当连续输出“当前线程名称：”字样时，说明执行某一个线程时并不是完全执行完整个代码块，而是执行一部分后，就去执行另一个线程，然后再不定是时间里再回来执行该线程
			// System.out.println("当前线程名称："+Thread.currentThread().getName());
			try {
				Thread.sleep(10);// 模拟程序卡顿，暴露出该多线程的安全问题，测试结果会出现0和-1，需要使用synchronized同步来解决
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":当前余票--->" + ticket--);
		}
	}

}

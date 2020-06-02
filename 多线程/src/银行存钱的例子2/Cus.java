package 银行存钱的例子2;

/**
 * 用户类
 * 
 * @Author: gongZheng
 * @Date: 2017年11月14日 下午6:05:35
 * @Description: 具有存钱的方法 多个用户同时存钱
 */
public class Cus implements Runnable {

	Bank bank = new Bank();

	// 使用循环，模拟一个用户存钱多次
	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			bank.addMoney(100);
		}

	}

	public static void main(String[] args) {
		Cus cus = new Cus();
		// 创建多个线程对象，模式多个用户存钱
		Thread thread0 = new Thread(cus, "用户0");
		Thread thread1 = new Thread(cus, "用户1");
		Thread thread2 = new Thread(cus, "用户2");
		Thread thread3 = new Thread(cus, "用户3");

		// start()方法用于开始一个线程，实际运行的是run()方法的代码
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

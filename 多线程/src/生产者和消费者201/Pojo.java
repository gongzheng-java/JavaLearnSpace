package 生产者和消费者201;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月25日 下午3:39:04
 * @Description:
 */
public class Pojo {

	private String name;
	private int count = 1;
	private boolean flag = false;

	// 赋值
	public synchronized void set(String name) {
		// 此处使用while，而不是用if是为了防止执行相同操作的另一个线程,从wait()苏醒过来获取cpu执行权时，没有经过标识判断而直接执行生产者操作，
		// 从而导致连续执行两次生产者操作。运行时将此处改成if判断，同时将notifyAll()改成notify()，对比效果。
		while (flag) {
			// if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "--->" + count++;
		System.out.println(Thread.currentThread().getName() + "生产者:" + this.name);
		flag = true;
		// this.notify();
		this.notifyAll();// 上面判断改成了while，如果此处不使用notifyAll()方法唤醒所有处于wait()中的线程，那么会出现线程锁死的线程，即所有的线程都处于wait()状态
	}

	// 输出
	public synchronized void out() {
		// 此处使用while 的道理同上
		while (!flag) {
			// if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "*******消费者*********" + this.name);
		flag = false;
		// this.notify();
		this.notifyAll();// 原理同上
	}
}

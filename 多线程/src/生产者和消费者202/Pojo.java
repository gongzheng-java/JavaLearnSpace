package 生产者和消费者202;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年11月25日   下午3:39:04 
 * @Description:
 */
public class Pojo {
	
	private String name;
	private int count=1;
	private boolean flag=false;
	
	//jdk API原话：Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。
	//JDK1.5之后，Lock代替了synchronized；Condition代替了object监视器，即synchronized锁对象（关于不同状态的synchronized所对应的锁对象问题，参考示例“售票的例子”）
	private final Lock lock= new ReentrantLock();
	private final Condition condition_Pro=lock.newCondition();//生产者
	private final Condition condition_Con=lock.newCondition();//消费中
	
	//赋值  使用JDK1.5新特性后，不需要在方法上加synchronized修饰
	public  void set(String name) throws InterruptedException{
		lock.lock();//获取锁
		try {
			while (flag) {
				condition_Pro.await();//生产者线程等待
			}
			this.name=name+"--->"+count++;
			System.out.println(Thread.currentThread().getName()+"生产者:"+this.name);
			flag=true;
			//this.notify();
			condition_Con.signal();//唤醒对方（消费者）线程
		} finally  {
			lock.unlock();//释放锁资源
		}
		
	}

	//输出
	public  void out() throws InterruptedException{
		lock.lock();//获取锁对象
		try {
			while (!flag) {
				condition_Con.await();
			}
			System.out.println(Thread.currentThread().getName()+"*******消费者*********"+this.name);
			flag=false;
			condition_Pro.signal();//唤醒对方（生产者）线程
		} finally {
			lock.unlock();//释放所资源
		}
		
	}
	
	
}

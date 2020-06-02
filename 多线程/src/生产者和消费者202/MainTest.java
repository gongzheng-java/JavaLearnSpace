package 生产者和消费者202;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年11月25日   下午4:13:23 
 * @Description:
 */
public class MainTest {

	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		
		Produce produce = new Produce(pojo);
		Consumer consumer = new Consumer(pojo);
		
		Thread thread2 = new Thread(produce);
		Thread thread1 = new Thread(consumer);
		Thread thread4 = new Thread(produce);
		Thread thread3 = new Thread(consumer);
		Thread thread5 = new Thread(produce);
		Thread thread6 = new Thread(consumer);
		
		//当只有两个线程的（输入和输出各一个的时候），输入和输出的正常的结果，当多个线程的时候就会出现问题
		thread2.start();
		thread1.start();
		
		//如果不做处理，当出现多个线程的时候，会出现连续打印多个生产者信息或者多个消费者信息，即对象生产一个却被消费了多次
		thread4.start();
		thread3.start();
		thread5.start();
		thread6.start();
		

	}

}

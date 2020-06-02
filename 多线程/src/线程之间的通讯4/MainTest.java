package 线程之间的通讯4;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年11月16日   下午7:43:00 
 * @Description:
 */
public class MainTest {

	public static void main(String[] args) {
		
		Entity entity=new Entity();
		//两个类带参构造函数都以共同的Entity对象作为参数，是为了保证两个线程使用相同的锁对象
		Input input=new Input(entity);
		Output output=new Output(entity);
		
		Thread thread=new Thread(input);
		Thread thread2=new Thread(output);
		Thread thread1=new Thread(input);
		Thread thread3=new Thread(output);
		
		thread2.start();
		thread.start();
		//thread1.start();
		//thread3.start();
		
		/*
		 * 总结说明：运行此类会看到正确的输出结果，但是如果有多个线程，如上所示，两个赋值线程和两个输出线程的话，那么会出现不是交替输出的效果。
		 *       如果想看到理想效果，参照下一个示例，消费者和生产者
		 * 
		 */

	}

}

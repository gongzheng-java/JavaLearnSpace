package queue详细分析;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *测试方法
 * @Author: gongZheng
 * @Date:   2019年9月25日   下午2:12:18 
 * @Description:
 */
public class TestBasket {

	private static final Basket basket= new Basket();
	
	public static void test(){
		//创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
		 ExecutorService service=Executors.newCachedThreadPool();
		  Producer producer=new Producer(basket);
		  Consumer consumer=new Consumer(basket);
		  service.submit(producer);
		  service.submit(consumer);
		  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  service.shutdownNow();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	
	  

	  

	
}

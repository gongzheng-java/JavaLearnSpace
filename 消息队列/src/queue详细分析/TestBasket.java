package queue��ϸ����;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *���Է���
 * @Author: gongZheng
 * @Date:   2019��9��25��   ����2:12:18 
 * @Description:
 */
public class TestBasket {

	private static final Basket basket= new Basket();
	
	public static void test(){
		//����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��߳�
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

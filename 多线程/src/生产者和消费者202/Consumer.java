package 生产者和消费者202;

/**
 *消费者
 * @Author: gongZheng
 * @Date:   2017年11月25日   下午4:11:49 
 * @Description:
 */
public class Consumer implements Runnable {
	
	private Pojo pojo;

	public Consumer(Pojo pojo) {
		super();
		this.pojo = pojo;
	}

	private int num=10000;
	@Override
	public void run() {
		while (true) {
			try {
				pojo.out();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num--;
		}
		
	}
	


}

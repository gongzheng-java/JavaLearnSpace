package queue详细分析;

/**
 *消费者
 * @Author: gongZheng
 * @Date:   2019年9月25日   下午2:30:44 
 * @Description:
 */
public class Consumer implements Runnable {

	private Basket basket;

	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// 消费苹果
				System.out.println("消费者准备消费苹果：" + System.currentTimeMillis());
				basket.consume();
				System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
				System.out.println("消费完后有苹果：" + basket.getAppleNumber() + "个");
				// 休眠1000ms
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

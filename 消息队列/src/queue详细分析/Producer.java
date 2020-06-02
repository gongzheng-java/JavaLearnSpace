package queue详细分析;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年9月25日   下午2:26:14 
 * @Description:
 */
public class Producer implements Runnable {

	private Basket basket;

	public Producer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// 生产苹果
				System.out.println("生产者准备生产苹果：" + System.currentTimeMillis());
				basket.produce();
				System.out.println("生产者生产苹果完毕：" + System.currentTimeMillis());
				System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");
				// 休眠300ms
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

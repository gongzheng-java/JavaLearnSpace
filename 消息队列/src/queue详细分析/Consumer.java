package queue��ϸ����;

/**
 *������
 * @Author: gongZheng
 * @Date:   2019��9��25��   ����2:30:44 
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
				// ����ƻ��
				System.out.println("������׼������ƻ����" + System.currentTimeMillis());
				basket.consume();
				System.out.println("����������ƻ����ϣ�" + System.currentTimeMillis());
				System.out.println("���������ƻ����" + basket.getAppleNumber() + "��");
				// ����1000ms
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

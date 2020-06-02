package queue��ϸ����;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��9��25��   ����2:26:14 
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
				// ����ƻ��
				System.out.println("������׼������ƻ����" + System.currentTimeMillis());
				basket.produce();
				System.out.println("����������ƻ����ϣ�" + System.currentTimeMillis());
				System.out.println("���������ƻ����" + basket.getAppleNumber() + "��");
				// ����300ms
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

package ���д�Ǯ������03;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����5:22:04
 * @Description:
 */
public class Cus implements Runnable {

	private Bank b = new Bank();

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			b.add(100);
		}

	}

}

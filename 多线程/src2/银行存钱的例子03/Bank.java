package ���д�Ǯ������03;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����5:19:39
 * @Description:
 */
public class Bank {
	private int sum;

	public synchronized void add(int num) {
		sum = sum + num;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "  ��ǰ���sun��" + sum);
	}
}

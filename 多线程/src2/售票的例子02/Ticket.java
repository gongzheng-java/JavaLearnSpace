package ��Ʊ������02;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����1:19:10
 * @Description:
 */
public class Ticket implements Runnable {

	/**
	 * �����鶨�徲̬����������̫�������ÿ��ƣ����������̳�thread��ʵ�ֶ��̵߳ı׶˾�������
	 */
	// private static int num = 100;

	private int num = 200;

	@Override
	public void run() {
		while (num > 0) {
			show();
		}
	}

	public synchronized void show() {
		if (num > 0) {
			try {
				Thread.sleep(2);// ģ�⿨�٣�����ָ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "\t��Ʊ��" + num--);
		}
	}

}

package ���д�Ǯ������2;

/**
 * �û���
 * 
 * @Author: gongZheng
 * @Date: 2017��11��14�� ����6:05:35
 * @Description: ���д�Ǯ�ķ��� ����û�ͬʱ��Ǯ
 */
public class Cus implements Runnable {

	Bank bank = new Bank();

	// ʹ��ѭ����ģ��һ���û���Ǯ���
	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			bank.addMoney(100);
		}

	}

	public static void main(String[] args) {
		Cus cus = new Cus();
		// ��������̶߳���ģʽ����û���Ǯ
		Thread thread0 = new Thread(cus, "�û�0");
		Thread thread1 = new Thread(cus, "�û�1");
		Thread thread2 = new Thread(cus, "�û�2");
		Thread thread3 = new Thread(cus, "�û�3");

		// start()�������ڿ�ʼһ���̣߳�ʵ�����е���run()�����Ĵ���
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

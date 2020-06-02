package ��Ʊ������1;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��7�� ����7:36:16
 * @Description: Ʊ��100�ţ��������ͬʱ��Ʊ ʵ���̵߳ķ�����
 *            1. �̳�thread���࣬��дrun()����
 *               ȱ�ݣ�java�ĵ����̳У�һ���̳����߳���Ͳ��ܼ̳��������࣬������������������չ�ԣ����Ƽ�ʹ��
 *            2.ʵ��runnable�ӿڣ� ��дRunnable�ӿ��е�run()������ ͨ��Thread�ഴ���̶߳���
 *               ��Runnable�ӿڵ�ʵ������Ϊ���������ݸ�Thread��Ĺ��캯��
 *               ����Thread���start()���������̣߳���ִ��Runnable��ʵ������run()����
 * 
 *               �мǶ��̵߳�������1.����������������߳� 2.ʹ�õ�����ͬ���߳���
 * 
 */
public class Ticket implements Runnable { /*
										 * /extends Thread {
										 * 
										 * 
										 * /**
										 * 1.�̳�thread��ʱ������˴�û��ʹ�þ�̬�������ÿһ���̶߳�������100��Ʊ
										 * ��ʵ��Ʊ������100�� ������ʵ�����
										 * ���Դ˴�ʹ�þ�̬�������ö���̹߳���һ������
										 * ��ȱ���ǣ���̬�����������ڱȽϳ������ÿ��ƣ��᳤ʱ��ռ���ڴ�
										 * �Դˣ���������ʵ�ֶ��̵߳ĵڶ���������ʵ��Runnable�ӿ�
										 * 2.ʵ��Runnable�ӿ�ʱ�����Բ�ʹ�þ�̬����
										 */
	// private static int ticket = 100;
	private int ticket = 1000;
	Object object = new Object();

	@Override
	public void run() {
		// this.getName() �ǻ�ȡ��ǰ�̵߳�����
		// ��׼д����Thread.currentThread().getName()��currentThread().getName()
		// �����߳�����ʱ�����ȡ�����������ƣ����û�У�����ȡ�̵߳�Ĭ������

		while (ticket > 0) {
			show();
			// synchronized (object) {
			// //ͬ����������̰߳�ȫ���⣬�˴�������������󣻽��̹߳����ֵĴ���ŵ�synchronized��
			// ͬ������ʹ�õ����ǲ�������
			// }

		}

	}

	// ��ԭ����ͬ�����룬���ͬ������ ͬ������ʹ�õ�����this ���ͬ����������̬static���κ�Ͳ���this������:��ǰ����.class
	public synchronized void show() {
		if (ticket > 0) {
			// �������������ǰ�߳����ƣ�������ʱ��˵��ִ��ĳһ���߳�ʱ��������ȫִ������������飬����ִ��һ���ֺ󣬾�ȥִ����һ���̣߳�Ȼ���ٲ�����ʱ�����ٻ���ִ�и��߳�
			// System.out.println("��ǰ�߳����ƣ�"+Thread.currentThread().getName());
			try {
				Thread.sleep(10);// ģ����򿨶٣���¶���ö��̵߳İ�ȫ���⣬���Խ�������0��-1����Ҫʹ��synchronizedͬ�������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":��ǰ��Ʊ--->" + ticket--);
		}
	}

}

package ���߳�.ͬ������;

import static org.hamcrest.CoreMatchers.theInstance;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��12��1��   ����3:07:48 
 * @Description:
 */
public class Demo01 implements Runnable {

	private static int num = 100;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}

	}

	public synchronized void test() {
		if (num <= 0) {
			flag = false;
			return;// �˴�û�������������������������룬���ɻ����0 �������
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����Ʊ--->" + num--);

	}

}

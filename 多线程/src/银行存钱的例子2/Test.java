package ���д�Ǯ������2;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��27�� ����5:15:28
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		// ���̵߳����־���main
		System.out.println("��ȡ���߳����ƣ�" + Thread.currentThread().getName());
		Cus cus = new Cus();

		Thread t1 = new Thread(cus);
		Thread t2 = new Thread(cus);
		// Thread t3 = new Thread(cus, "�û�03");

		t1.start();
		t2.start();
		// t3.start();

	}

}

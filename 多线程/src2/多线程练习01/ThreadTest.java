package ���߳���ϰ01;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����10:23:12
 * @Description:
 */
public class ThreadTest {

	public static void main(String[] args) {
		Test t1 = new Test();
		// t1.setName("11");// �ֶ����߳�ȡ��
		Test t2 = new Test("�߳�2");

		t1.start();
		t2.start();

		for (int i = 0; i < 90; i++) {
			System.out.println("�������̡߳���������" + i);
		}

	}

}

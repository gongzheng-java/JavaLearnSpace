package �̵߳ĳ��÷���.�̵߳����ȼ�����;

/**
 * �߳����ȼ�
 * 
 * @Author: gongZheng
 * @Date: 2017��11��29�� ����7:02:12
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {

		JoinDemo jDemo = new JoinDemo();

		Thread thread = new Thread(jDemo, "�߳�01");
		Thread thread2 = new Thread(jDemo, "�߳�02");

		thread.start();
		// �̵߳����ȼ�ֻ��1~10 ��ͨ��ʹ�ó�����ʾ��Ĭ�����ȼ���5��
		// �߳����ȼ���ʾ�߳�����CPU��Դ��Ƶ�ʣ����ȼ��߱�ʾԽ������CPUִ��Ȩ
		thread.setPriority(Thread.MAX_PRIORITY); // ���� 10
		// thread.setPriority(Thread.NORM_PRIORITY);// ���� 5 �̵߳�Ĭ�����ȼ�
		thread2.start();
		thread2.setPriority(Thread.MIN_PRIORITY); // ���� 1

		for (int i = 0; i <= 100; i++) {

			System.out.println("���̣߳�" + Thread.currentThread().toString() + "==>" + i);
		}
	}

}

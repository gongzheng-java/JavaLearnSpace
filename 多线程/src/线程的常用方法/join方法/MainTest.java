package �̵߳ĳ��÷���.join����;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��29�� ����7:02:12
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) throws InterruptedException {

		JoinDemo jDemo = new JoinDemo();

		Thread thread = new Thread(jDemo, "�߳�1");
		Thread thread2 = new Thread(jDemo, "�߳�2");

		thread.start();
		/*
		 * join() �ȴ����߳���ֹ ע��÷�����Ҫ��������߳�
		 * 
		 * ��ʼִ�е�ʱ��cpuִ��Ȩ����������߳�û��ʹ��join()������ʱ�������߳̽��໥����cpuִ��Ȩ����ĳ���̵߳��ø÷���ʱ��
		 * ��ô���߳̾ͻ���ִͣ�У��ȵ����߳�ִ��������̲߳Ų���ִ�С�
		 * ʹ�ó�����������߳���ִ�е�ʱ�򣬿�����ʱ����ĳ���̣߳����߳����������ټ������������̡߳� ע��ͨ������join������λ�����۲����н����
		 */
		 thread.join();//�˴�����ʱ�����Ȼ�ִ�����߳�1��Ȼ���߳�2�����߳�����Դ
		thread2.start();
		//thread.join();// �˴�����ʱ��������ִ�����߳�1���߳�2�����̲߳������������Դ�����߳�1ִ������߳�2�����߳�������Դ
		for (int i = 0; i <= 10; i++) {
			System.out.println("���̣߳�" + Thread.currentThread().getName() + "==>" + i);
		}
	}

}

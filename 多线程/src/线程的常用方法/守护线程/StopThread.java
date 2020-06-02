package �̵߳ĳ��÷���.�ػ��߳�;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��28�� ����6:34:21
 * @Description: ���ֹͣһ���̣߳� 
 *              ԭ����stop()ֹͣ�̵߳ķ����Ѿ���ʱ�����Ƽ�ʹ�ã����ֹͣ�߳�ֻ��һ�ַ������Ǿ����߳̽�����
 *              �������̺߳󣬴���һ�㶼��ѭ��ִ�еģ�ֻҪ����ѭ���Ϳ���ʹrun()�����������Ӷ������̡߳�
 */
public class StopThread implements Runnable {

	private boolean flag = true;// ������ʶ������ʶ�߳��Ƿ��������

	@Override
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("�߳�" + Thread.currentThread().getName() + "�����쳣���ı��ʶ����������ǰ�̣߳�����");
				flag = false;// main�������У�ʹ����Thread���interrupt()����ǿ�����wait()״̬���̣߳��ʴ˴�ͨ�������쳣���ı��ʶ����ֵ
			}
			System.out.println(Thread.currentThread().getName() + "-.--...----..>");
		}

	}

	public void changeFlag() {
		flag = false;
	}

}

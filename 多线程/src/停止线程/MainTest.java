package ֹͣ�߳�;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��28�� ����6:37:28
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {
		StopThread stopThread = new StopThread();

		Thread thread = new Thread(stopThread);
		Thread thread2 = new Thread(stopThread);

		thread.start();
		thread2.start();

		int num = 0;
		while (true) {
			System.out.println("�������߳�ѭ����" + num);
			if (num++ == 60) {
				/*
				 * 1.�˴���������÷��������ı��ʶֵ����numֵ�ﵽ60������ѭ�������̻߳��������thread��thread2�̣߳�
				 * �����߳���������ѭ���ģ����Ի�����߳��޷�ֹͣ������
				 * ���Ҵ����ִ���ٶȺܿ죬����һ˲��ִ���겢�������̵߳�ѭ������������ִ�����������̣߳��������������̵߳������䣬
				 * ��˻����˸о������̵߳�ѭ��û��ִ�У�
				 * cpu��ִ��Ȩһֱ�����������߳�ռ��ִ�еļ���(�������������ǰ���ǣ�run()����û��ʹ��ͬ������������run()����
				 * )������ͨ������changeFlag()���ı��������� ���߳�ֹͣ
				 */

				/*
				 * 2.�������changeFlag()������run()����ʹ��ͬ�������ٵ���wait()
				 * ����ģ���߳̿������������µĶ���״̬������ֵ�����ִ����������ֱ�����߳�ִ����ϣ�
				 * �����������߳�һֱ����Wait()״̬�����߳�Ҳһֱ��������״̬���������
				 */
				// stopThread.changeFlag();

				// Ϊ�˽������ڶ��ֳ��ֵ�״��(ע���ʱ�Ͳ���Ҫ�ٵ�������ı��ʶ��״̬��changeFlag()������)���������ͨ������interrupt()��ǿ������߳������Ķ���(����)״̬,
				// ���ָ̻߳�������״̬�����������������ᵼ���߳��쳣���պÿ���ͨ�� catch�鲶���쳣����catch���иı�
				// ��ʶ��ֵ���Ӷ���������ǰ�߳�
				// (�����Ͳ���Ҫͨ������changeFlag()�������ı��ʶ��״̬��)
				thread.interrupt();
				thread2.interrupt();
				System.out.println("�߳�ֹͣ����");
				break;
			}
			System.out.println("���̣߳�" + Thread.currentThread().getName());
		}
		System.err.println("Over!!!");

	}

}

package �̵߳ĳ��÷���.�̵߳����ȼ�����;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��29�� ����6:36:57
 * @Description:
 */
public class JoinDemo implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i <= 100; i++) {
			/*
			 * �̵߳�toString()���� ���ظ��̵߳��ַ�����ʾ��ʽ�������߳����ơ����ȼ����߳��顣 �̵߳ļ���Ĭ����5
			 * ˭�����̣߳����߳̾������ĸ��飬���Դ˴����߳���ֵ����main
			 */
			System.out.println(Thread.currentThread().toString() + "-------��" + i);
		}
	}

}

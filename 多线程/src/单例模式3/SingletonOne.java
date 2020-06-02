package ����ģʽ3;

/**
 * ����ʽ 1 ���Ƽ�
 * 
 * @Author: gongZheng
 * @Date: 2017��11��16�� ����4:45:50
 * @Description: ��ģʽ�̲߳���ȫ��������߳�ͬʱ����ʱ�������ʵ������������
 */
public class SingletonOne {
	// ע��˴�����ʹ��find���Σ�find���εı����ǲ��ɸı��
	private static SingletonOne SingletonOne = null;

	private SingletonOne() {
	}

	public static SingletonOne getSingletonOne() {
		/**
		 * �̲߳���ȫ��ԭ��������������߳�A��Bͬʱ���ʴ���ʱ��A�߳��ڴ˴��ж������Ϊ�պ����������û��ִ�к����ʵ���������
		 * ����ʱB�߳�Ҳ�ڷ��ʴ��࣬��if�жϴ��������������null������if�����ʵ�����������
		 * ����A�̡߳����ѡ������ִ�У�Ҳʵ����������������͸������ͻ�ʵ��������
		 */
		if (SingletonOne == null) {
			SingletonOne = new SingletonOne();
		}
		return SingletonOne;
	}

}

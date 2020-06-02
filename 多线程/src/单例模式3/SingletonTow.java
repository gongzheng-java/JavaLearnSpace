package ����ģʽ3;

/**
 * ����ʽ 2  ���Ƽ�
 * @Author: gongZheng
 * @Date:   2017��11��16��   ����4:59:04 
 * @Description:�̰߳�ȫ ����ÿ���ж�ͬ��������������
 */
public class SingletonTow {
	 //ע��˴�����ʹ��find���Σ�find���εı����ǲ��ɸı��
	private static SingletonTow singletonTow = null;
	
	private SingletonTow(){}
	
	/**
	 * ����ͬ���� ���÷������ͬ���������Ա�֤�̰߳�ȫ
	 * ���ǲ�ͬ���߳�ÿ�η��ʵ�ʱ�򶼻��ж�ͬ�������������� ���Ƽ�ʹ��
	 * @return
	 */
	public  static synchronized SingletonTow getSingletonTow(){
		
		if (singletonTow == null) {
			singletonTow = new SingletonTow();
		}
		
		return singletonTow;
	}

}

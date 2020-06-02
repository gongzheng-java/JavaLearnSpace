package ����ģʽ3;

/**
 *����ʽ 3 �Ƽ�
 * @Author: gongZheng
 * @Date:   2017��11��16��   ����5:13:58 
 * @Description: ������ģʽ�иõ�����������
 */
public class SingletonThree {
	
	private static SingletonThree singletonThree;
	
	private SingletonThree(){}
	
	
	public static SingletonThree getSingletonThree(){
		/**
		 * Ϊ�˱���ÿһ�ζ�Ҫ�ж�ͬ�������������ܣ���ִ��ͬ����֮ǰ�ж�������Ƿ���null������ֻ�е�һ�μ����������ж�ͬ����
		 * �����Ͳ������ж�ͬ�������ȱ�֤���̰߳�ȫ������߳�������
		 */
		if (singletonThree == null) {
			synchronized (SingletonThree.class) {
				if (singletonThree == null) {
					singletonThree = new SingletonThree();
				}
			}
		}
		return singletonThree;
	}
	

}

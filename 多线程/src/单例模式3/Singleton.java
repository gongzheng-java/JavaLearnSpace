package ����ģʽ3;

/**
 *����ʽ 
 * @Author: gongZheng
 * @Date:   2017��11��16��   ����4:08:43 
 * @Description:  �տ�ʼ������ʱ�ͳ�ʼ������Ķ��󣬹ʲ������̰߳�ȫ����
 *                ����ʽ���ഴ����ͬʱ��ʵ����һ����̬�������������֮��᲻��ʹ���������������ռ��һ�����ڴ棬
 *                ������Ӧ�ģ��ڵ�һ�ε���ʱ�ٶ�Ҳ����죬��Ϊ����Դ�Ѿ���ʼ����ɡ�
 */
public class Singleton {
	//ʹ��final����ʹ������Ͻ�
	private static final Singleton singleton = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getSingletion(){
		return singleton;
	}

}

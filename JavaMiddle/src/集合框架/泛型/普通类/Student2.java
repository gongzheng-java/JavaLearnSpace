package ���Ͽ��.����.��ͨ��;

/**
 * ʹ�÷���
 * 
 * @Author: gongZheng
 * @Date: 2019��8��5�� ����8:37:20
 * @Description: ���ͳ�����ĸ�� 
 *  T    type��ʾ����
 *  K V  �ֱ�����ֵ��key value 
 *  E    ���� element Ԫ�� 
 *  ��       ��ʾ��ȷ������
 *  
 *  ע�⣺���Ͳ���ʹ�þ�̬����
 */
public class Student2<T1, T2> {
	
	 //private static T1 tt; ���� ����ʹ�þ�̬
	private T1 t1;
	private T2 t2;

	public Student2(T1 t1, T2 t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}

	
	public T1 getT1() {
		return t1;
	}

	
	public void setT1(T1 t1) {
		this.t1 = t1;
	}


	public T2 getT2() {
		return t2;
	}

	
	public void setT2(T2 t2) {
		this.t2 = t2;
	}
	
	

}

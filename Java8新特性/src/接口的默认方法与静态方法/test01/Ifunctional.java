package �ӿڵ�Ĭ�Ϸ����뾲̬����.test01;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��4��21�� ����8:52:22
 * @Description:
 */
public interface Ifunctional {

	// ���淽�� ʵ���������д
	void method(String name);

	// �ӿ�Ĭ�ϵķ���  java8 ������ �÷���Ĭ��public������ֻ��ʹ��public����
	//���������д���ǽӿڵ�Ĭ�Ϸ�����Ҳ���Բ�����
	default void defaultMethod() {
		System.out.println("���ǽӿڵ�Ĭ�Ϸ�����������");
	}
	
	default String defaultMethod2(String name){
		return "���ã�"+name;
	}
	// �����ԣ�ע�⣺��java8 ֮ǰ�ӿ��еĲ�����static���εķ�����
	// �ӿڵľ�̬����������������壬���������Լ���Ĭ��ʵ��
	//ע�⣺�ӿڵ�static�������ܱ�������д
	static void staticMethod() {
		System.out.println("���ǽӿڵľ�̬static����01��Ĭ��ʵ�֡�����������");
	}

	static void staticMethod2() {
		System.out.println("���ǽӿڵľ�̬static����02��Ĭ��ʵ�֡�����������");
	}
}

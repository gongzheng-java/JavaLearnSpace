package �ӿڵ�Ĭ�Ϸ����뾲̬����.test01;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��21��   ����9:08:28 
 * @Description:
 */
public class IfunctionalImpl implements Ifunctional {

	//�˴�����ʵ�ֽӿڵĳ��淽�� ����֮ǰ��java7һ����
	@Override
	public void method(String name) {
		System.out.println(name+" ����ʵ������ʵ�ֽӿڵķ���������������");
		
	}
	
	
	//��д�ӿڵ�Ĭ�Ϸ���
	@Override
	public void defaultMethod(){
		System.out.println("������д���ǽӿڵ�Ĭ�Ϸ���������������");
	}
	
	
	
	
	

}

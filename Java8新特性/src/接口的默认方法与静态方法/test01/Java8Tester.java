package �ӿڵ�Ĭ�Ϸ����뾲̬����.test01;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��22��   ����2:17:16 
 * @Description:
 */
public class Java8Tester {
	//����
		public static void main(String[] args) {
			
			IfunctionalImpl ifunctionalImpl = new IfunctionalImpl();
			ifunctionalImpl.method("000");
			
			//ͨ��ʵ����Ķ�����Ե��ýӿڵ�Ĭ�Ϸ���,���ǲ��ܵ��ýӿڵľ�̬����
			ifunctionalImpl.defaultMethod();
			String hello = ifunctionalImpl.defaultMethod2("����");
			System.out.println(hello);
			
		    //ȥ���ӿ��еĳ��淽���󣬿���ʹ�ø÷�ʽֱ�ӵ��ýӿڵ�Ĭ�Ϸ���
			/*Ifunctional ifunctional = new Ifunctional(){};
			ifunctional.defaultMethod();*/
			
			
			
			//�ӿڵľ�̬����ֻ���ýӿڵ������ã���ʽ���ӿ���.�ӿڵľ�̬������
			Ifunctional.staticMethod();
			Ifunctional.staticMethod2();
			
			
		}
}

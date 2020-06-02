package Lambda��ķ����ʽ.ʾ��2;


/**
 *
 * @Author: gongZheng
 * @Date: 2018��4��21�� ����10:49:23
 * @Description:  ��lambda���ʽ���������
 *   lambdaֻ�����ں���ʽ�ӿ�
 */
public class Java8Tester {

	// �÷����������Զ��壬����Ҫ�ͽӿ���һ��
	private int operateImpl(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String args[]) {
		
		

		Java8Tester tester = new Java8Tester();

		// ��������
		MathOperation addition = (int a, int b) -> a + b;
		/*
		 * ��Lambda���ʽ�����(�������)�� 
		 * 1�����Ƚ� MathOperation addition = (int a, int b) -> a +b;���ʽ������impl�� ͨ��"implements"ʵ�ֽӿں��MathOperation�еķ����ľ���ʵ��ȥ����
		 * 2��Lambda���ʽ�������͵ģ���=���ŵ���߾��Ǳ��ʽ�����ͣ�Lambda���ʽ������ʵ�����Ƕ�Ӧ�ӿڵ����͡�
		 *    ������ int num=2һ����int�൱��lambda���ʽ�����ͣ�num���Ǳ��ʽ������
		 *    �˴�lambda���ʽ��������addition��������MathOperation�ӿ� 
		 * 3��(int a, int b) -> a +b;�������ڲ���ļ�д���൱���Ƕ� MathOperation �ӿ��� operation(int a, int b);�ľ���ʵ�֣����£�
		 *    int operation(int a, int b){
		 *        return a+b��  
		 *    }
		 * 4��Ȼ��lambda���ʽ addition �������������뵽 operateImpl(int a, int b, MathOperation mathOperation) �����У��μ�����ĵ���
		 * 5. ��� operateImpl()�����ڲ�ͨ����Ӧ�Ľӿڶ���addition���ǽӿڶ���ȥ���ýӿ��еķ�����
		 *    �÷�����lambda���ʽadditionʵ�֣�������a b ��ִ�� a+b��Ȼ�󷵻ء�
		 */

		// ������������
		MathOperation subtraction = (a, b) -> a - b;

		// �������еķ�����䣬Ҳ����д�ɣ�
		// MathOperation multiplication = (int a, int b) -> a * b;
		MathOperation multiplication = (int a, int b) -> {return a * b;};
			
		

		// û�д����ż��������
		MathOperation division = (int a, int b) -> a / b;

		// Lambda ����Ѻ�����Ϊһ�������Ĳ�����������Ϊ�������ݽ������У�,
		// �����tester.operate(10, 5, addition) ���ǽ�addition��������operate()��������
		System.out.println("10 + 5 = " + tester.operateImpl(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operateImpl(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operateImpl(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operateImpl(10, 5, division));

		
		// �������ţ�ͨ��һ����������Ҫ���ţ�Ҳ����Ҫ�������ͣ���Ϊ���������⽫message���ָĳ� (String message)
		GreetingService greetService1 = (String message) -> System.out.println("Hello " + message);
		      greetService1.sayMessage("Runoob");//GreetingService greetService1 = new GreetingServiceImpl()���൱���ⲿ�ֱ�������
		      
		/*
		 * ��lambda���ʽ��������⣺
		 * GreetingService greetService1 = message -> System.out.println("Hello " + message);����ȷ����˼·����
		 * 
		 * GreetingServiceImpl �� GreetingService�ӿ� ��ʵ���� ͨ������ʵ��һ���ӿڵķ��������������ģ�
		 * 
		 *  GreetingService greetService1 = new GreetingServiceImpl(){
		 *  
			                                          @Override
			                                          public void sayMessage(String message) { 
				                                          System.out.println("Hello " + message);
			                                          }
		                                         };
		 ���� new GreetingServiceImpl()����Ĳ���ʹ�������ڲ���ķ�ʽ�������ˣ���(String message) -> System.out.println("Hello " + message);�����
		  
		  ע�⣺(String message) -> System.out.println("Hello " + message) �е�(String message) �Ǻͷ�����sayMessage�Ĳ�������(String message)��Ӧ
		      ͨ����д��  message -> System.out.println("Hello " + message)
		  
		  ���� ʹ��lambda���ʽ�Ľӿ� ��ֻ����һ�������������߿���lambda���ʽʱ���ܿ������뵽�ӿ��е��Ǹ������ˡ�
		 * */
		
		
		
		// ������
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
		greetService2.sayMessage("Google");
		
	}

}

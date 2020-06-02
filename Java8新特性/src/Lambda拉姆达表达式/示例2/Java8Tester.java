package Lambda拉姆达表达式.示例2;


/**
 *
 * @Author: gongZheng
 * @Date: 2018年4月21日 下午10:49:23
 * @Description:  对lambda表达式的深入理解
 *   lambda只能用于函数式接口
 */
public class Java8Tester {

	// 该方法名可以自定义，不需要和接口中一致
	private int operateImpl(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String args[]) {
		
		

		Java8Tester tester = new Java8Tester();

		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;
		/*
		 * 对Lambda表达式的理解(自我理解)： 
		 * 1、首先将 MathOperation addition = (int a, int b) -> a +b;表达式当做是impl类 通过"implements"实现接口后对MathOperation中的方法的具体实现去看待
		 * 2、Lambda表达式是有类型的，“=”号的左边就是表达式的类型，Lambda表达式的类型实际上是对应接口的类型。
		 *    类似于 int num=2一样，int相当于lambda表达式的类型，num就是表达式的名字
		 *    此处lambda表达式的名称是addition，类型是MathOperation接口 
		 * 3、(int a, int b) -> a +b;是匿名内部类的简写，相当于是对 MathOperation 接口中 operation(int a, int b);的具体实现，如下：
		 *    int operation(int a, int b){
		 *        return a+b；  
		 *    }
		 * 4、然后将lambda表达式 addition 当做参数，传入到 operateImpl(int a, int b, MathOperation mathOperation) 方法中，参见下面的调用
		 * 5. 最后 operateImpl()方法内部通过对应的接口对象（addition就是接口对象）去调用接口中的方法，
		 *    该方法被lambda表达式addition实现，参数是a b ，执行 a+b，然后返回。
		 */

		// 不用类型声明
		MathOperation subtraction = (a, b) -> a - b;

		// 大括号中的返回语句，也可以写成：
		// MathOperation multiplication = (int a, int b) -> a * b;
		MathOperation multiplication = (int a, int b) -> {return a * b;};
			
		

		// 没有大括号及返回语句
		MathOperation division = (int a, int b) -> a / b;

		// Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）,
		// 下面的tester.operate(10, 5, addition) 就是将addition函数当做operate()方法参数
		System.out.println("10 + 5 = " + tester.operateImpl(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operateImpl(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operateImpl(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operateImpl(10, 5, division));

		
		// 不用括号（通常一个参数不需要括号，也不需要数据类型），为了下面的理解将message部分改成 (String message)
		GreetingService greetService1 = (String message) -> System.out.println("Hello " + message);
		      greetService1.sayMessage("Runoob");//GreetingService greetService1 = new GreetingServiceImpl()；相当于这部分被隐藏了
		      
		/*
		 * 对lambda表达式的深入理解：
		 * GreetingService greetService1 = message -> System.out.println("Hello " + message);的正确代码思路如下
		 * 
		 * GreetingServiceImpl 是 GreetingService接口 的实现类 通常我们实现一个接口的方法是下面这样的：
		 * 
		 *  GreetingService greetService1 = new GreetingServiceImpl(){
		 *  
			                                          @Override
			                                          public void sayMessage(String message) { 
				                                          System.out.println("Hello " + message);
			                                          }
		                                         };
		 上面 new GreetingServiceImpl()后面的部分使用匿名内部类的方式给隐藏了，用(String message) -> System.out.println("Hello " + message);替代了
		  
		  注意：(String message) -> System.out.println("Hello " + message) 中的(String message) 是和方法名sayMessage的参数部分(String message)对应
		      通常简写是  message -> System.out.println("Hello " + message)
		  
		  所以 使用lambda表达式的接口 中只能是一个方法，开发者看到lambda表达式时就能快速联想到接口中的那个函数了。
		 * */
		
		
		
		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
		greetService2.sayMessage("Google");
		
	}

}

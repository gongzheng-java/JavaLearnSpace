package Lambda拉姆达表达式.示例2;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月21日   下午10:49:59 
 * @Description:
 *  1、使用Lambda表达式，必须要求接口中有且仅有一个方法 ，这样的接口才可以隐式转换为Lambda表达式，于是产生了“函数接口”这个概念。
 *  2、如果接口中有两个或以上方法，那么在使用Lambda表达式的地方就会出现编译错误，但是该接口不会出现编译错误(会让开发者摸不着头脑)，这样以来函数式接口非常脆弱
 *     为了克服这种代码层面的脆弱性，并显式说明某个接口是函数式接口，就需要在接口上加上 注解@FunctionalInterface，这样以来一旦开发者在该接口中添加了其他方法
 *     那么该接口就会出现编译错误现象。
 *     测试效果是：如果接口中有多个方法，那么使用了lambda表达式的地方会出现编译错误，而接口中不会（接口相当于普通接口，自然就不会出错了）；
 *               一旦加入@FunctionalInterface注解，则标明该接口是函数接口，java8就会限制该接口中只能有一个方法(此时该接口就是特殊接口了)，
 *               如果接口中有一个以上的方法的话，该接口就会出现编译错误。
 *              
 *  3.Lambda表达式的理解，以及表达式和该接口中方法的关系，请参考测试类Java8Tester.java。
 *  4.默认方法和静态方法不会破坏函数式接口的定义，即可以如下定义默认方法和静态方法
 *  5、lambda只能用于函数式接口
 */
@FunctionalInterface
public interface MathOperation {
	
	/*因为该接口中只有一个函数，所以我们看到 addition = (int a, int b) -> a + b 表达式时就能立马想到与下面的方法对应起来(毕竟没有多余的)，
	 * (int a, int b)就是 operation方法 的参数(int a, int b)部分，a+b就是operation(int a, int b)方法的具体实现
	 * 假设该方法中有多个函数，那么我们看到lambda表达式时脑海中会出现多个函数的样子，将无法和对应的方法匹配上去
	 * */
	int operation(int a, int b);
	
	//void add(String a,String b); 使用了@FunctionalInterface注解，所以不能定义该方法
	
	default void defaultMethod(){
		System.out.println("这是接口的默认方法，不会破坏函数式接口定义。");
	}
	
	static void staticMethod(){
		System.out.println("这是接口的静态方法，也不会破坏函数式接口定义");
	}
	
	
}

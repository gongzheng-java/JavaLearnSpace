package 接口的默认方法与静态方法.test01;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月22日   下午2:17:16 
 * @Description:
 */
public class Java8Tester {
	//测试
		public static void main(String[] args) {
			
			IfunctionalImpl ifunctionalImpl = new IfunctionalImpl();
			ifunctionalImpl.method("000");
			
			//通过实现类的对象可以调用接口的默认方法,但是不能调用接口的静态方法
			ifunctionalImpl.defaultMethod();
			String hello = ifunctionalImpl.defaultMethod2("张三");
			System.out.println(hello);
			
		    //去掉接口中的常规方法后，可以使用该方式直接调用接口的默认方法
			/*Ifunctional ifunctional = new Ifunctional(){};
			ifunctional.defaultMethod();*/
			
			
			
			//接口的静态方法只能用接口的名调用，格式：接口名.接口的静态方法名
			Ifunctional.staticMethod();
			Ifunctional.staticMethod2();
			
			
		}
}

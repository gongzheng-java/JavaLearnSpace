package 接口的默认方法与静态方法.test01;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月21日   下午9:08:28 
 * @Description:
 */
public class IfunctionalImpl implements Ifunctional {

	//此处必须实现接口的常规方法 ，和之前的java7一样的
	@Override
	public void method(String name) {
		System.out.println(name+" 这是实现类中实现接口的方法。。。。。。");
		
	}
	
	
	//重写接口的默认方法
	@Override
	public void defaultMethod(){
		System.out.println("子类重写覆盖接口的默认方法、、、、、、");
	}
	
	
	
	
	

}

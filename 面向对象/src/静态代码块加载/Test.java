package 静态代码块加载;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年12月18日   下午1:05:22 
 * @Description:
 */
public class Test {
	public Test(){
		System.out.println("33333333333333");
	}
	static{
		System.out.println("00000000000000");
	}
	{
		System.out.println("11111111111111111111");
		
	}

	
	public static void main(String[] args) {
		Test test =new Test();
	}
	
	
}

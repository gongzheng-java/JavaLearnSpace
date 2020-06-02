package 集合框架.泛型.方法;

/**
 *泛型方法
 * @Author: gongZheng
 * @Date:   2019年8月5日   下午9:23:42 
 * @Description:
 * 泛型方法只能访问对象信息，不能修改信息
 * 因为泛型数据类型的不确定的，无法准确操作对象
 */
public class MethodTest {
	
	public <T> void test(T a){
		System.out.println(a);
	}

}

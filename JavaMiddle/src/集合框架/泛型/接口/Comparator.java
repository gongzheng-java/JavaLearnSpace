package 集合框架.泛型.接口;

/**
 *泛型接口 
 * @Author: gongZheng
 * @Date:   2019年8月5日   下午9:13:36 
 * @Description:
 *  因为接口中变量默认  public static final修饰 ，
 *  所以泛型字母只能使用在方法中，不能使用在全局常量中
 *  
 *  接口中的方法默认是 public abstract修饰
 */
public interface Comparator<T> {
    
	// public T t1; 错误 默认有static修饰
	
	void findById(T t);
}

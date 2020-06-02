package 单例模式3;

/**
 *饿汉式 
 * @Author: gongZheng
 * @Date:   2017年11月16日   下午4:08:43 
 * @Description:  刚开始加载类时就初始化该类的对象，故不存在线程安全问题
 *                饿汉式在类创建的同时就实例化一个静态对象出来，不管之后会不会使用这个单例，都会占据一定的内存，
 *                但是相应的，在第一次调用时速度也会更快，因为其资源已经初始化完成。
 */
public class Singleton {
	//使用final修饰使代码更严谨
	private static final Singleton singleton = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getSingletion(){
		return singleton;
	}

}

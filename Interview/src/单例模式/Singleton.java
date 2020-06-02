package 单例模式;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月6日 下午3:46:44
 * @Description: 
*/
public class Singleton {
	
	private Singleton() {
		
	}

	private static final Singleton SINGLETON= new Singleton();
	
	public static Singleton getSingleton() {
		return SINGLETON;
	}
}

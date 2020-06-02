package 单例模式3;

/**
 *懒汉式 3 推荐
 * @Author: gongZheng
 * @Date:   2017年11月16日   下午5:13:58 
 * @Description: 在懒汉模式中该单例方法最优
 */
public class SingletonThree {
	
	private static SingletonThree singletonThree;
	
	private SingletonThree(){}
	
	
	public static SingletonThree getSingletonThree(){
		/**
		 * 为了避免每一次都要判断同步锁而消耗性能，在执行同步锁之前判断类对象是否是null，这样只有第一次加载类对象会判断同步锁
		 * 后续就不会再判断同步锁，既保证了线程安全，又提高程序性能
		 */
		if (singletonThree == null) {
			synchronized (SingletonThree.class) {
				if (singletonThree == null) {
					singletonThree = new SingletonThree();
				}
			}
		}
		return singletonThree;
	}
	

}

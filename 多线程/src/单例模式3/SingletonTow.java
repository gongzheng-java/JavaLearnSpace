package 单例模式3;

/**
 * 懒汉式 2  不推荐
 * @Author: gongZheng
 * @Date:   2017年11月16日   下午4:59:04 
 * @Description:线程安全 但是每次判断同步锁会消耗性能
 */
public class SingletonTow {
	 //注意此处不能使用find修饰，find修饰的变量是不可改变的
	private static SingletonTow singletonTow = null;
	
	private SingletonTow(){}
	
	/**
	 * 加上同步锁 将该方法变成同步函数可以保证线程安全
	 * 但是不同的线程每次访问的时候都会判断同步锁会消耗性能 不推荐使用
	 * @return
	 */
	public  static synchronized SingletonTow getSingletonTow(){
		
		if (singletonTow == null) {
			singletonTow = new SingletonTow();
		}
		
		return singletonTow;
	}

}

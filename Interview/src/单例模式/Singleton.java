package ����ģʽ;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020��4��6�� ����3:46:44
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

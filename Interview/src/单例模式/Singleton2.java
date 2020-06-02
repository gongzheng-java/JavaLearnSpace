package ����ģʽ;



/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020��4��6�� ����3:48:35
 * @Description: 
*/
public class Singleton2 {
	
	private Singleton2() {}
	
	private static Singleton2 singleton2=null;
	

	private static Singleton2 getSingleton2() {
		if (singleton2==null) {
			synchronized(Singleton2.class) {
				if (singleton2==null) {
					singleton2=new Singleton2();
				}
			}
		}
		return singleton2;
	}

}

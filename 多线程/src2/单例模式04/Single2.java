package 单例模式04;

/**
 * 懒汉式
 * 
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午9:27:49
 * @Description:
 */
public class Single2 {
	private static Single2 s = null;

	private Single2() {

	}

	public static Single2 getInstance() {
		if (s == null) {
			synchronized (Single2.class) {
				if (s == null) {
					s = new Single2();
				}
			}
		}
		return s;
	}
}

package 单例模式04;

/**
 * 饿汉式
 * 
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午9:25:05
 * @Description:
 */
public class Single1 {

	private static final Single1 s = new Single1();

	private Single1() {

	}

	public static Single1 getInsttance() {
		return s;
	}

}

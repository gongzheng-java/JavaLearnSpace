package �����ߺ�������06;

/**
 * ����ʽ
 * 
 * @Author: gongZheng
 * @Date: 2019��2��14�� ����2:23:53
 * @Description:
 */
public class Single {

	/*
	 * private static final Single s = new Single();
	 * 
	 * private Single() { }
	 * 
	 * public static Single getIntance() { return s; }
	 */

	private Single() {
	}

	private static Single s = null;

	public static Single getInstance() {

		if (s == null) {
			synchronized (Single.class) {
				if (s == null) {
					s = new Single();
				}
			}
		}

		return s;
	}

}

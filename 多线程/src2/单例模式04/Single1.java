package ����ģʽ04;

/**
 * ����ʽ
 * 
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����9:25:05
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

package catch���ִ��˳��;

import java.io.IOException;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��23�� ����10:09:05
 * @Description:���� IOException��ΧС��Exception������IOException����д��Exception���棬
 *                 ��������޷�ͨ��
 */
public class Test {
	public void doSomething() throws IOException {
		System.out.println("do somthing");
	}

	public static void main(String[] args) {
		Test etct = new Test();
		try {
			etct.doSomething();
		} catch (IOException e) {

		} catch (Exception e) {

		}
	}
}

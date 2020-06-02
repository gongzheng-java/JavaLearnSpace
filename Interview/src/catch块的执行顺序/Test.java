package catch块的执行顺序;

import java.io.IOException;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月23日 下午10:09:05
 * @Description:结论 IOException范围小于Exception，所以IOException不能写在Exception后面，
 *                 否则编译无法通过
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

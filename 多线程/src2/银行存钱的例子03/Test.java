
package 银行存钱的例子03;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午5:23:32
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		Cus cus = new Cus();

		Thread t1 = new Thread(cus);
		Thread t2 = new Thread(cus);
		Thread t3 = new Thread(cus);

		t1.start();
		t2.start();
		t3.start();

	}

}

package 银行存钱的例子03;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午5:19:39
 * @Description:
 */
public class Bank {
	private int sum;

	public synchronized void add(int num) {
		sum = sum + num;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "  当前存款sun：" + sum);
	}
}

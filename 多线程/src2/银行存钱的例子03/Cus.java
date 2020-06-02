package 银行存钱的例子03;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午5:22:04
 * @Description:
 */
public class Cus implements Runnable {

	private Bank b = new Bank();

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			b.add(100);
		}

	}

}

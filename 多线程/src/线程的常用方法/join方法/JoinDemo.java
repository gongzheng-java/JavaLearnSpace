package �̵߳ĳ��÷���.join����;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��29�� ����6:36:57
 * @Description:
 */
public class JoinDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-------��" + i);
		}
	}

}

package �����ߺ�������201;

/**
 * ������
 * 
 * @Author: gongZheng
 * @Date: 2017��11��25�� ����4:11:49
 * @Description:
 */
public class Consumer implements Runnable {

	private Pojo pojo;

	public Consumer(Pojo pojo) {
		super();
		this.pojo = pojo;
	}

	private int num = 100;

	@Override
	public void run() {
		while (true) {
			pojo.out();
			num--;
		}

	}

}

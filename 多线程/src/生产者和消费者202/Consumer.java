package �����ߺ�������202;

/**
 *������
 * @Author: gongZheng
 * @Date:   2017��11��25��   ����4:11:49 
 * @Description:
 */
public class Consumer implements Runnable {
	
	private Pojo pojo;

	public Consumer(Pojo pojo) {
		super();
		this.pojo = pojo;
	}

	private int num=10000;
	@Override
	public void run() {
		while (true) {
			try {
				pojo.out();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num--;
		}
		
	}
	


}

package �����ߺ�������202;

/**
 *������
 * @Author: gongZheng
 * @Date:   2017��11��25��   ����4:07:00 
 * @Description:
 */
public class Produce implements Runnable {
	
	private Pojo pojo;

	public Produce(Pojo pojo) {
		super();
		this.pojo = pojo;
	}

	private int num=10000;

	@Override
	public void run() {
		while (true) {
			try {
				pojo.set("Tiffany & Co");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			num--;
		}
		
	}

}

package �̼߳�ͨѶ05;

/**
 * ��ֵ����
 * 
 * @Author: gongZheng
 * @Date: 2019��2��14�� ����10:25:40
 * @Description:
 */
public class Input implements Runnable {

	private Entity e;

	public Input(Entity entity) {
		this.e = entity;
	}

	@Override
	public void run() {
		int num = 0;
		while (true) {
			synchronized (e) {
				if (e.flag) {
					try {
						e.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("�����߸�ֵ��");
				if (num == 0) {
					e.name = "zhangsan";
					e.sex = "man";
				} else if (num == 1) {
					e.name = "����";
					e.sex = "Ů";
				}
				num = (num + 1) % 2;
				e.flag = true;
				e.notify();

			}

		}
	}

}

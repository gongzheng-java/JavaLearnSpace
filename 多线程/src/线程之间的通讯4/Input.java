package �߳�֮���ͨѶ4;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��16�� ����7:32:03
 * @Description:
 */
public class Input implements Runnable {

	private Entity e;

	public Input(Entity e) {
		super();
		this.e = e;
	}

	int num = 0;//�ñ�ʶ�����ڽ��渳ֵ��Ů�����߳̽������������޹�

	@Override
	public void run() {
		for (int i = 0; i <=5000; i++) {
			//����ĵȴ��ͻ��ѱ�����ͬһ����������������̱߳���
			synchronized (e) {
				if (e.flag) {
					try {
						e.wait();//ע�⣺����˴�ֱ��ʹ��wait()�������쳣��ӦΪ�߳�������ͬ��Ҫ��֤��ͬ�������󣬲���Ч��
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if (num == 0) {
					e.setName("����");
					e.setSex("��");
				} else {
					e.setName("����");
					e.setSex("Ů");
				}
				System.out.println("��ֵ����....");
				num = (num + 1) % 2;
				e.flag=true;
				e.notify();//�����߳�
				
			}
			
		}

	}

}

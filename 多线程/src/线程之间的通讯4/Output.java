package �߳�֮���ͨѶ4;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��16�� ����7:32:16
 * @Description:
 */
public class Output implements Runnable {
	private Entity e;

	public Output(Entity e) {
		// super();
		this.e = e;
	}

	int num=0;
	@Override
	public void run() {
		for (int i = 0; i <=5000; i++) {
			
			//����ĵȴ��ͻ��ѱ�����ͬһ����������������̱߳���
			synchronized (e) {
				if (!e.flag) {
					try {
						e.wait();//ע�⣺����˴�ֱ��ʹ��wait()�������쳣��ӦΪ�߳�������ͬ��Ҫ��֤��ͬ�������󣬲���Ч��
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("ȡֵ�����"+e.getName() + "---------------->" + e.getSex()+(num++));
				e.flag=false;
				e.notify();
				
			}
		}

	}

}

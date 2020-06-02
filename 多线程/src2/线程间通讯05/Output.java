package 线程间通讯05;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月14日 上午10:31:26
 * @Description:
 */
public class Output implements Runnable {
	private Entity e;

	public Output(Entity e) {
		super();
		this.e = e;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (e) {
				if (!e.flag) {
					try {
						e.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("消费者取值：" + e.name + "----->>" + e.sex);
				e.flag = false;
				e.notify();
			}

		}
	}

}

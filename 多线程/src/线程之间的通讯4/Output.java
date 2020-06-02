package 线程之间的通讯4;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月16日 下午7:32:16
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
			
			//下面的等待和唤醒必须是同一个锁对象，则否会出现线程报错
			synchronized (e) {
				if (!e.flag) {
					try {
						e.wait();//注意：如果此处直接使用wait()将出现异常，应为线程锁对象不同，要保证相同的锁对象，才有效果
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("取值输出："+e.getName() + "---------------->" + e.getSex()+(num++));
				e.flag=false;
				e.notify();
				
			}
		}

	}

}

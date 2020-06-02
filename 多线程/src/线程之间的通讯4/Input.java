package 线程之间的通讯4;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月16日 下午7:32:03
 * @Description:
 */
public class Input implements Runnable {

	private Entity e;

	public Input(Entity e) {
		super();
		this.e = e;
	}

	int num = 0;//该标识符用于交替赋值男女，与线程交替输入和输出无关

	@Override
	public void run() {
		for (int i = 0; i <=5000; i++) {
			//下面的等待和唤醒必须是同一个锁对象，则否会出现线程报错
			synchronized (e) {
				if (e.flag) {
					try {
						e.wait();//注意：如果此处直接使用wait()将出现异常，应为线程锁对象不同，要保证相同的锁对象，才有效果
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				if (num == 0) {
					e.setName("张三");
					e.setSex("男");
				} else {
					e.setName("丽丽");
					e.setSex("女");
				}
				System.out.println("赋值输入....");
				num = (num + 1) % 2;
				e.flag=true;
				e.notify();//唤醒线程
				
			}
			
		}

	}

}

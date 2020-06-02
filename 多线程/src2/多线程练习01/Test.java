package 多线程练习01;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 上午10:14:08
 * @Description:
 */
public class Test extends Thread {

	private String name;

	public Test() {
		super();
	}

	public Test(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 60; i++) {
			// 获取线程名称的标准写法，还有一种写法 this.getName()
			System.out.println(Thread.currentThread().getName() + "...." + name + " run......." + i);
		}
	}

}

package ���߳���ϰ01;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����10:14:08
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
			// ��ȡ�߳����Ƶı�׼д��������һ��д�� this.getName()
			System.out.println(Thread.currentThread().getName() + "...." + name + " run......." + i);
		}
	}

}

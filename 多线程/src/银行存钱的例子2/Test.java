package 银行存钱的例子2;

/**
 *
 * @Author: gongZheng
 * @Date: 2017年11月27日 下午5:15:28
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		// 主线程的名字就是main
		System.out.println("获取主线程名称：" + Thread.currentThread().getName());
		Cus cus = new Cus();

		Thread t1 = new Thread(cus);
		Thread t2 = new Thread(cus);
		// Thread t3 = new Thread(cus, "用户03");

		t1.start();
		t2.start();
		// t3.start();

	}

}

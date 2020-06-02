package 多线程练习01;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 上午10:23:12
 * @Description:
 */
public class ThreadTest {

	public static void main(String[] args) {
		Test t1 = new Test();
		// t1.setName("11");// 手动给线程取名
		Test t2 = new Test("线程2");

		t1.start();
		t2.start();

		for (int i = 0; i < 90; i++) {
			System.out.println("这是主线程。。。。。" + i);
		}

	}

}

package 多线程.同步并发;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年12月1日   下午3:12:15 
 * @Description:
 */
public class TestMain {

	public static void main(String[] args) {
		Demo01 d=new Demo01();
		
		Thread t1=new Thread(d,"张三");
		Thread t2=new Thread(d,"李四");
		Thread t3=new Thread(d,"王五");

		t1.start();
		t2.start();
		t3.start();
	}

}

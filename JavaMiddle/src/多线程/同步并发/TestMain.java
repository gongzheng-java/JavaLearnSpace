package ���߳�.ͬ������;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��12��1��   ����3:12:15 
 * @Description:
 */
public class TestMain {

	public static void main(String[] args) {
		Demo01 d=new Demo01();
		
		Thread t1=new Thread(d,"����");
		Thread t2=new Thread(d,"����");
		Thread t3=new Thread(d,"����");

		t1.start();
		t2.start();
		t3.start();
	}

}

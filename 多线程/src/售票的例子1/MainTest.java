package 售票的例子1;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年11月7日   下午8:12:38 
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {
		
		//1.测试实现多线程的第一种方法，继承thread类
		/*Ticket ticket = new Ticket();
		Ticket ticket2 = new Ticket();
		Ticket ticket3 = new Ticket();
		ticket.start();
		ticket2.start();
		ticket3.start();*/
		
		//2.测试实现多线程的第二种方法，实现runnable接口
		Ticket ticket=new Ticket();
		
		Thread t0=new Thread(ticket);//自定义线程名称
		Thread t1=new Thread(ticket,"线程1");
		Thread t2=new Thread(ticket,"线程2");
		Thread t3=new Thread(ticket,"线程3");
		Thread t4=new Thread(ticket,"线程4");
		Thread t5=new Thread(ticket,"线程5");
		Thread t6=new Thread(ticket,"线程6");
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

}

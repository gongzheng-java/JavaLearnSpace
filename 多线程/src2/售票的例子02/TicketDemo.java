package 售票的例子02;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月13日 下午1:05:43
 * @Description:
 */
public class TicketDemo {

	public static void main(String[] args) {
		/*
		 * Ticket t1 = new Ticket(); Ticket t2 = new Ticket(); Ticket t3 = new
		 * Ticket(); Ticket t4 = new Ticket(); new Thread(t1).start(); new
		 * Thread(t2).start(); new Thread(t3).start(); new Thread(t4).start();
		 */
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket, "线程1");
		Thread t2 = new Thread(ticket, "线程2");
		Thread t3 = new Thread(ticket, "线程3");
		Thread t4 = new Thread(ticket, "线程4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

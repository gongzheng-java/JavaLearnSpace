package ��Ʊ������02;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��13�� ����1:05:43
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
		Thread t1 = new Thread(ticket, "�߳�1");
		Thread t2 = new Thread(ticket, "�߳�2");
		Thread t3 = new Thread(ticket, "�߳�3");
		Thread t4 = new Thread(ticket, "�߳�4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

package ��Ʊ������1;

/**
 *
 * @Author: gongZheng
 * @Date:   2017��11��7��   ����8:12:38 
 * @Description:
 */
public class MainTest {
	public static void main(String[] args) {
		
		//1.����ʵ�ֶ��̵߳ĵ�һ�ַ������̳�thread��
		/*Ticket ticket = new Ticket();
		Ticket ticket2 = new Ticket();
		Ticket ticket3 = new Ticket();
		ticket.start();
		ticket2.start();
		ticket3.start();*/
		
		//2.����ʵ�ֶ��̵߳ĵڶ��ַ�����ʵ��runnable�ӿ�
		Ticket ticket=new Ticket();
		
		Thread t0=new Thread(ticket);//�Զ����߳�����
		Thread t1=new Thread(ticket,"�߳�1");
		Thread t2=new Thread(ticket,"�߳�2");
		Thread t3=new Thread(ticket,"�߳�3");
		Thread t4=new Thread(ticket,"�߳�4");
		Thread t5=new Thread(ticket,"�߳�5");
		Thread t6=new Thread(ticket,"�߳�6");
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

}

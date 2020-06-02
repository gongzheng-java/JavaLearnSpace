package UDP����;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�
 * @Author: gongZheng
 * @Date:   2018��2��2��   ����4:34:56 
 * @Description:
 */
public class Rece implements Runnable {
	
	private DatagramSocket ds;
	
	public  Rece() {}
	
	public  Rece(DatagramSocket ds) { 
	   this.ds = ds;	
    }

	@Override
	public void run() {
		
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dPacket = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dPacket);
			String ip =	dPacket.getAddress().getHostAddress();
			String data =new String(dPacket.getData(), 0, dPacket.getLength());
			System.out.println(ip+"  :  "+data);
			} catch (IOException e) {
				System.out.println("��������ʧ�ܣ���");
				e.printStackTrace();
			}
		}
		
	}

}

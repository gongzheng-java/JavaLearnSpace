package UDP����;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��2��2��   ����4:35:29 
 * @Description:
 */
public class UDPChat {
	public static void main(String[] args) throws SocketException {
		//DatagramSocket dSocket = new DatagramSocket();
		//DatagramSocket dSocket2 = new DatagramSocket(10001);
		
		
		Send send = new Send(new DatagramSocket());//���Ͷ�
	    Rece rece = new Rece(new DatagramSocket(10001));//���ն�(����ָ���˿ں�)
		
		//ͬʱ���������߳�
		new Thread(send).start();
		new Thread(rece).start();
		
	}

}

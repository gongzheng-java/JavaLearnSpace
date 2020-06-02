package UDP聊天;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年2月2日   下午4:35:29 
 * @Description:
 */
public class UDPChat {
	public static void main(String[] args) throws SocketException {
		//DatagramSocket dSocket = new DatagramSocket();
		//DatagramSocket dSocket2 = new DatagramSocket(10001);
		
		
		Send send = new Send(new DatagramSocket());//发送端
	    Rece rece = new Rece(new DatagramSocket(10001));//接收端(必须指定端口号)
		
		//同时开启两个线程
		new Thread(send).start();
		new Thread(rece).start();
		
	}

}

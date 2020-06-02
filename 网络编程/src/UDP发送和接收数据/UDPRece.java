package UDP发送和接收数据;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * UDP 接收端
 * @Author: gongZheng
 * @Date:   2018年2月2日   上午10:07:39 
 * @Description: 用于接收UDP协议传输的数据和处理
 * 
 * 
 */
public class UDPRece {
	public static void main(String[] args) throws IOException {
		
		//创建UDP服务 socket对象 并指定监听端口号，用于接收数据
		DatagramSocket ds = new DatagramSocket(10000);
		while (true) {
		//指定接收数据的byte长度
		byte[] buf = new byte[1024];
		
		//用来接收长度为 length 的数据包  注意：DatagramPacket类构造函数的参数个数不一样，意义也不一样
		DatagramPacket dp= new DatagramPacket(buf, buf.length);
		
		//接收数据，将获取的数据封装到数据包中
		ds.receive(dp);//阻塞式方法，没有收到消息，处于等待状态  该进程不会结束
		
		//InetAddress iAddress = dp.getAddress();
		//System.out.println("获取IP 地址："+iAddress.getHostName()+"   "+iAddress.getHostAddress()+"   ");
		
		//System.out.println("获取端口号:"+dp.getPort());
		
		String date = new String(dp.getData(), 0, dp.getLength());
		System.out.println("获取发送的内容："+date);
		
		}
	}

}

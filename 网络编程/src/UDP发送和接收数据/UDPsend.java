package UDP发送和接收数据;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 发送端
 * @Author: gongZheng
 * @Date:   2018年2月1日   下午5:19:02 
 * @Description: UDP面向无连接，没有接收端，发送的数据会丢失
 *         
 */
public class UDPsend {
	public static void main(String[] args) throws IOException {
		//1.创建UDP服务 socket对象(相当于邮局，发送数据媒介)   创建数据报套接字并将其绑定到本地主机上的指定端口。
		//DatagramSocket ds=new DatagramSocket(8080);//可以不指定端口号
		
			
		
		//2.需要发送的数据(相当于具体要发送的物品)
//		String str="您好，这就是要发送的信息";
//		byte[] buf = str.getBytes();//将数据转换成字节
//		InetAddress address = InetAddress.getByName("192.168.10.147");//指定发送的地址，此处设置为本机地址
		
		//2.创建数据报包 对象（相当于将需要发送的物品封装成包裹发送）
		// 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。  注意：该类构造的函数参数个数不同，作用不一样
//		DatagramPacket dp= new DatagramPacket(buf, buf.length, address, 10000);
//		
//		ds.send(dp);//发送
//		ds.close();//关闭
		//注意：一定要处理异常(处理或抛出)，因为端口号等的参数可能会出错
		
		
		/* 采用键盘录入方式发送消息  可以连续发送多条消息，直到注入“再见”二字停止发送*/
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line=null;
		
		while ((line = reader.readLine()) != null) {
			
			byte[] bs = line.getBytes();
			DatagramPacket dPacket = new DatagramPacket(bs, bs.length, InetAddress.getByName("192.168.43.248"), 10000);
			ds.send(dPacket);
			
			//终止发送
			if ("再见".equals(line)) {
				break;
			}
		}
		ds.close();
		
	}

}

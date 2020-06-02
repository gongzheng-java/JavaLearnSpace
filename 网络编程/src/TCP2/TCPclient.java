package TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  客户端
 * @Author: gongZheng
 * @Date:   2018年2月5日   下午7:05:07 
 * @Description:
 * 1.建立scoket服务，指定主机和端口
 * 2.获取socket中的输出流，将数据写入流中，通过网络发送给服务端
 * 3.获取socket中的输入流，将服务器反馈的数据获取到，并打印输出
 * 4.关闭客户端资源
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.10.147", 10004);
		//发送消息给服务端
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("这条消息是发送给服务端的".getBytes());
		
		
		//3.获取socket中的输入流 用于读取服务器反馈的数据
		InputStream iReader = socket.getInputStream();
		byte[] b = new byte[1024];//创建缓冲区
		int len = iReader.read(b);//将读取的数据放入缓冲区中        阻塞式方法
		System.out.println(new String(b, 0,len));
		
		socket.close();
		
		
		//注意代码中的阻塞式方法:
		//1.首先启动服务端，服务端运行到阻塞式方法accept()处，等待客户端消息
		//2.启动客户端，在给服务端发完消息后，客户端运行到阻塞式方法read()处，等待服务端的消息
		//3.服务端接收到客户端消息后，打印输出，然后反馈给客户端消息  关闭服务
		//4.客户端接收到服务端消息，打印输出，关闭服务
		
		/* */
		
	}

}

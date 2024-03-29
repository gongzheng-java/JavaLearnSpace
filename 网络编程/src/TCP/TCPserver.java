package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务端
 * 
 * @Author: gongZheng
 * @Date: 2018年2月5日 下午3:12:47
 * @Description: 1.建立服务端socket服务 ServerSocket，并监听一个端口 2.获取连接过来的客户端对象
 *               通过ServerSocket的accept()方法 ，侦听并接受到此套接字的连接。阻塞式方法，会等待客户端连接
 *               3.如果客户端发过来数据，服务端将使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端已启动！！！");
		// 创建服务端对象，并监听端口
		ServerSocket serverSocket = new ServerSocket(10008);
		
		// 获取连接过来的客户端对象 accept()阻塞式方法
		Socket socket = serverSocket.accept();
		
		// 获取客户端ip地址
		String ip = socket.getInetAddress().getHostAddress();
		String name = socket.getInetAddress().getHostName();
		
		// 获取客户端发过来的数据，使用客户端对象的读取流来读取数据
		InputStream inputStream = socket.getInputStream();
		
		// 循环接收客户端消息
		while (true) {
			// 创建缓冲区
			byte[] buf = new byte[1024];
			// 将数据读取到缓冲区中
			int len = inputStream.read(buf); //阻塞式方法
			System.out.println(ip + "\t" + name + "  发来消息：" + new String(buf, 0, len));
			if (new String(buf).equals("拜拜")) {
				break;
			}
		}
		
		socket.close();
		serverSocket.close();
	}

}

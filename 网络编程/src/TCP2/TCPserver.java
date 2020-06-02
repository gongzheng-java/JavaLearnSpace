package TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 
 * @Author: gongZheng
 * @Date: 2018年2月5日 下午7:16:51
 * @Description:
 * 
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		// 创建socket 服务 ServerSocket服务
		ServerSocket serverSocket = new ServerSocket(10004);
		Socket socket = serverSocket.accept();// 获取客户端socket对象 阻塞式方法

		InputStream inputStream = socket.getInputStream();// 获取客户端的输入流对象
		byte[] b = new byte[1024];// 创建缓冲区
		int len = inputStream.read(b);// 将数据读取到缓冲中
		// 获取客户端的ip信息
		String ip = socket.getInetAddress().getHostAddress();
		String name = socket.getInetAddress().getHostName();
		System.out.print("收到IP：" + ip + "   用户：" + name + "     消息：");
		System.out.println(new String(b, 0, len));

		// 反馈给客户端信息
		OutputStream outputStream = socket.getOutputStream();// 获取客户端的输出流
		outputStream.write("这是反馈给客户端的消息".getBytes());
		socket.close();
		serverSocket.close();

	}

}

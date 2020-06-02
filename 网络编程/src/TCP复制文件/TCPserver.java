package TCP复制文件;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 
 * @Author: gongZheng
 * @Date: 2018年2月7日 下午12:01:34
 * @Description:
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		// 创建serverScoket对象，并监听端口
		ServerSocket serverSocket = new ServerSocket(10007);

		// 获取客户端socket对象 阻塞式方法
		Socket socket = serverSocket.accept();
		// 获取客户端信息
		String IP = socket.getInetAddress().getHostAddress();
		String name = socket.getInetAddress().getHostName();
		System.out.println("来自 " + IP + "  的用户  " + name + "  的连接");

		// 读取客户端信息
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// 创建写入对象 将读取的数据写入到文件中
		PrintWriter out = new PrintWriter(new FileWriter("D:\\112.txt"), true);

		// 循环读取客服端socket中的信息，并写入到文件中
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("读取的信息是："+line);
			out.println(line);
		}
          
		// 返回给客户端信息
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
		pWriter.println("文件接收成功，注意查看。");

		// 关闭资源
		bufferedReader.close();
		socket.close();
		serverSocket.close();

	}

}

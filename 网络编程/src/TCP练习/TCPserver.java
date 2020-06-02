package TCP练习;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *服务端
 * @Author: gongZheng
 * @Date:   2018年2月6日   下午2:40:04 
 * @Description:
 * 1.创建serverScoket服务 
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//创建serversocket服务，并监听端口
		ServerSocket serverSocket = new ServerSocket(10002);
	
		// 获取客户端socket对象 阻塞式方法
		Socket socket = serverSocket.accept();
		//获取客户端信息
		String IP=socket.getInetAddress().getHostAddress();
		String name=socket.getInetAddress().getHostName();
		System.out.println("来自 "+IP+"  的用户  "+name+"  的连接");
		
		//获取客户端的字节输入流对象，并封装成字符输入流对象  用于读取客户端信息
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//方法一：获取客户端的字节输出流输入流对象，并封装成字符输出流对象  用于给客户端反馈信息
		/*BufferedWriter bufferedWriter = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		
		//方法二：true 表示是否刷新缓存区
		PrintWriter pWriter = new  PrintWriter(socket.getOutputStream(),true);
		
		String line = null;
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("收到客户端信息："+line);
			String str=line.toUpperCase();//将读取的字符串转大写
			
			//对应方法一：
//			bufferedWriter.write(str); //写入，反馈给客户端
//			bufferedWriter.newLine();//此处是加入换行符，如果没有该行代码，客户端将收不到反馈信息
//			bufferedWriter.flush();//刷新缓存区
			
			//对应方法二：
			pWriter.println(str);
		}
		
		socket.close();
		serverSocket.close();
		
		
	}

}

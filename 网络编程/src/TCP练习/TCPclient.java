package TCP练习;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.ws.handler.MessageContext.Scope;

/**
 *客户端
 * @Author: gongZheng
 * @Date:   2018年2月6日   下午2:39:55 
 * @Description:
 * 1.建立服务
 * 2.获取键盘录入
 * 3.将数据发送给服务端
 * 4.获取服务端返回给客户端的数据
 * 5.关闭资源
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建socket服务，指定 IP 地址的指定端口号
		Socket socket = new Socket("192.168.10.147", 10002);
		
		//读取键盘数据的流对象(数据源  操作键盘流)
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//方法1：定义输出目的地(网络设备，输出流)，将数写入socket输出流，发给服务端  (操作socket的流)
		/*BufferedWriter bufferedWriter = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		//方法2： 创建输出流PrintWriter对象，获取socket输出流
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
		

		
		/*循环将数据写出去和读取*/
		//一定socket读取流，读取服务端返回的数据  (操作socket的流)
		BufferedReader bReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=null;//用于存储键盘录入的信息
		while ((line=bufferedReader.readLine()) != null) { //此处readLine()方法读取的是键盘录入信息
			if (line.equals("exit")) {
				break;
			}
			
			/*对应方法1*/
//			bufferedWriter.write(line);//将数据写出去，发送给服务端
//			bufferedWriter.newLine();//此处是加入换行符，如果没有该行代码，服务端将收不到信息
//			bufferedWriter.flush();
			
			
			/*对应方法二*/
			pWriter.println(line);
			
			String str = bReader.readLine();//读取服务端返回的数据
			System.out.println("获取服务端返回的数据："+str);
		}
		
		//关闭资源
		bufferedReader.close();//关闭键盘录入
		socket.close();//关闭socket
		
		
		
	}

}

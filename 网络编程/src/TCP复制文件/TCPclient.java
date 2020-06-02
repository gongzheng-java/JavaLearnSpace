package TCP复制文件;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *客户端
 * @Author: gongZheng
 * @Date:   2018年2月7日   下午12:01:23 
 * @Description:将客户端文件发送给服务端，服务端收到文件后将文件保存起来
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建socket服务 指定主机并绑定端口
		Socket socket = new Socket("192.168.10.147", 10007);
		
		//读取文件
		File file = new File("D:\\110.txt");
		if (file.exists()) { //判断文件是否存在
			if (file.isFile()) { //判断文件是否是文件
				
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				//创建写入对象，将读取的数据写入到socket中发送到服务端
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				
				String line = null;
				//循环将数据写入socket，发送出去
				while ((line = bufferedReader.readLine()) != null) {
					printWriter.println(line);
				}
				
				//关闭客户端输出流，相当于给流中加入一个结束标记 -1 ，否则服务端循环读取部分无法结束，
				//一直处于阻塞等待状态，从而导致客户端和服务端都处于等待状态
				socket.shutdownOutput();
				
				
				//此处只需接收服务端返回的，接收成功字样就可以，所以不需要循环读取
				BufferedReader bReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String message = bReader.readLine();//阻塞式方法
				System.out.println("服务端返回消息是："+message);
				
				//关闭资源
				bufferedReader.close();
				socket.close();
				
			}else {
				System.out.println("该文件不是一个标准文件(可能是文件夹目录等等)。");
			}
		}else {
			System.err.println("不存在该文件！！！");
		}
		
	}

}

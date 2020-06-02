package TCP上传图片;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *客户端
 * @Author: gongZheng
 * @Date:   2018年2月7日   下午4:43:46 
 * @Description:
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//创建服务
		Socket socket = new Socket("192.168.10.146", 10009);
		
		//读取数据
		FileInputStream fInputStream = new FileInputStream("D:\\test2.jpg");
		//获取socket输出流
		OutputStream outputStream = socket.getOutputStream();
		
		byte[] b = new byte[1024];//创建字节缓冲区
		int num = 0;
		//循环将图片数据流读取到字节缓冲区中，再将通过socket输出流将缓冲区的数据写出去
		while ((num = fInputStream.read(b)) != -1) {
			//outputStream.write(b, 0, num);
			outputStream.write(b);
		}
		
		/*关闭客户端输出流，相当于给流中加入一个结束标记 -1 ，否则服务端循环读取部分无法结束，
		一直处于阻塞等待状态，从而导致客户端和服务端都处于等待状态*/
		socket.shutdownOutput();
		
		//获取服务端反馈的信息
		InputStream inputStream = socket.getInputStream();
		byte[] b1 =new byte[1024];
		int len = inputStream.read(b1);
		System.out.println("len："+len);
		System.out.println(new String(b1, 0, len));
		System.out.println(new String(b1));
		
		
		fInputStream.close();
		socket.close();
		
	}

}

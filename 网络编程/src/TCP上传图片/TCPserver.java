package TCP上传图片;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *服务端
 * @Author: gongZheng
 * @Date:   2018年2月7日   下午4:43:55 
 * @Description:
 *  这个服务端有个局限性，当A客户端连接后，被服务端获取到对应的socket，服务端执行具体的操作流程；
 *   而此时B客户端连接时，只能处于等待状态。
 *   因为服务端还没有处理完A客户端的请求，还有混循环回来执行下次accept方法，所以暂时获取不到B客户端对象。
 *   
 *   那么为了让更多的客户端同时并发访问服务端，服务端需要将每个客户端封装到一个单独的线程中，这样，就可以实现并发访问。
 *   参见示例“客户端并发上传图片”
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//创建服务
		ServerSocket serverSocket = new ServerSocket(10009);
		//获取客户端socket
		Socket socket = serverSocket.accept();
		//获取客户端的输入流，读取客户端socket流中的信息
		InputStream inputStream = socket.getInputStream();
		//创建文件输出流对象
		FileOutputStream fOutputStream = new FileOutputStream("D:\\test6.jpg");
		
		byte[] buff = new byte[1024];
		int num = 0;
		//循环将数据写入文件中
		while ((num = inputStream.read(buff)) != -1) {
			fOutputStream.write(buff, 0, num);
		}
		
		//给客户端反馈消息
		OutputStream outputStream = socket.getOutputStream();
		byte[] bs = "上传成功，注意查看".getBytes();
		outputStream.write(bs);
		System.out.println("字节长度："+bs.length);
		
		fOutputStream.close();
		socket.close();
		serverSocket.close();
	}

}

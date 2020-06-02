package TCP上传图片.客户端并发上传图片;

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
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//创建服务
		ServerSocket serverSocket = new ServerSocket(10009);
		
		//循环获取客户端，并创建线程
		while (true) {
			//获取客户端socket
			Socket socket = serverSocket.accept();
			new Thread(new PicThread(socket)).start();
			
//			PicThread picThread = new PicThread(socket);
//			Thread thread = new Thread(picThread);
//			thread.start();
		}
		
		//此时服务端不需要关闭
		//serverSocket.close();
	}

}

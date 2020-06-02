package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP 客户端
 * @Author: gongZheng
 * @Date:   2018年2月5日   上午11:27:52 
 * @Description:  TCP是面向连接 如果服务端没有开启的话就开启客户端，会出现连接报错现象
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("启动客户端");
			//创建socket服务，并指定连接的主机和端口
			Socket socket = new Socket("192.168.10.147", 10008);
			
			//读取键盘数据的流对象(数据源  操作键盘流),接收键盘录入的数据
			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(System.in));
			//获取socket的输出流对象，将数据发送到服务端
			OutputStream outputStream = socket.getOutputStream();
			
			String line = null;
			while ((line = bufferedReader.readLine()) != null ) {
				outputStream.write(line.getBytes());
				outputStream.flush();
			}
			
			socket.close();
		
	}

}

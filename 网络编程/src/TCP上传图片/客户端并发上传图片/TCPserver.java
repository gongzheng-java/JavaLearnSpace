package TCP�ϴ�ͼƬ.�ͻ��˲����ϴ�ͼƬ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *�����
 * @Author: gongZheng
 * @Date:   2018��2��7��   ����4:43:55 
 * @Description:
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//��������
		ServerSocket serverSocket = new ServerSocket(10009);
		
		//ѭ����ȡ�ͻ��ˣ��������߳�
		while (true) {
			//��ȡ�ͻ���socket
			Socket socket = serverSocket.accept();
			new Thread(new PicThread(socket)).start();
			
//			PicThread picThread = new PicThread(socket);
//			Thread thread = new Thread(picThread);
//			thread.start();
		}
		
		//��ʱ����˲���Ҫ�ر�
		//serverSocket.close();
	}

}

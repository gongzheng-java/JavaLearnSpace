package TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 * 
 * @Author: gongZheng
 * @Date: 2018��2��5�� ����7:16:51
 * @Description:
 * 
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		// ����socket ���� ServerSocket����
		ServerSocket serverSocket = new ServerSocket(10004);
		Socket socket = serverSocket.accept();// ��ȡ�ͻ���socket���� ����ʽ����

		InputStream inputStream = socket.getInputStream();// ��ȡ�ͻ��˵�����������
		byte[] b = new byte[1024];// ����������
		int len = inputStream.read(b);// �����ݶ�ȡ��������
		// ��ȡ�ͻ��˵�ip��Ϣ
		String ip = socket.getInetAddress().getHostAddress();
		String name = socket.getInetAddress().getHostName();
		System.out.print("�յ�IP��" + ip + "   �û���" + name + "     ��Ϣ��");
		System.out.println(new String(b, 0, len));

		// �������ͻ�����Ϣ
		OutputStream outputStream = socket.getOutputStream();// ��ȡ�ͻ��˵������
		outputStream.write("���Ƿ������ͻ��˵���Ϣ".getBytes());
		socket.close();
		serverSocket.close();

	}

}

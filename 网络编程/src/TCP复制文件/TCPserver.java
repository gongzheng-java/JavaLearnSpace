package TCP�����ļ�;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 * 
 * @Author: gongZheng
 * @Date: 2018��2��7�� ����12:01:34
 * @Description:
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		// ����serverScoket���󣬲������˿�
		ServerSocket serverSocket = new ServerSocket(10007);

		// ��ȡ�ͻ���socket���� ����ʽ����
		Socket socket = serverSocket.accept();
		// ��ȡ�ͻ�����Ϣ
		String IP = socket.getInetAddress().getHostAddress();
		String name = socket.getInetAddress().getHostName();
		System.out.println("���� " + IP + "  ���û�  " + name + "  ������");

		// ��ȡ�ͻ�����Ϣ
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// ����д����� ����ȡ������д�뵽�ļ���
		PrintWriter out = new PrintWriter(new FileWriter("D:\\112.txt"), true);

		// ѭ����ȡ�ͷ���socket�е���Ϣ����д�뵽�ļ���
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("��ȡ����Ϣ�ǣ�"+line);
			out.println(line);
		}
          
		// ���ظ��ͻ�����Ϣ
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
		pWriter.println("�ļ����ճɹ���ע��鿴��");

		// �ر���Դ
		bufferedReader.close();
		socket.close();
		serverSocket.close();

	}

}

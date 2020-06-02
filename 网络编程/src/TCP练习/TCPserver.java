package TCP��ϰ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *�����
 * @Author: gongZheng
 * @Date:   2018��2��6��   ����2:40:04 
 * @Description:
 * 1.����serverScoket���� 
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//����serversocket���񣬲������˿�
		ServerSocket serverSocket = new ServerSocket(10002);
	
		// ��ȡ�ͻ���socket���� ����ʽ����
		Socket socket = serverSocket.accept();
		//��ȡ�ͻ�����Ϣ
		String IP=socket.getInetAddress().getHostAddress();
		String name=socket.getInetAddress().getHostName();
		System.out.println("���� "+IP+"  ���û�  "+name+"  ������");
		
		//��ȡ�ͻ��˵��ֽ����������󣬲���װ���ַ�����������  ���ڶ�ȡ�ͻ�����Ϣ
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//����һ����ȡ�ͻ��˵��ֽ���������������󣬲���װ���ַ����������  ���ڸ��ͻ��˷�����Ϣ
		/*BufferedWriter bufferedWriter = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		
		//��������true ��ʾ�Ƿ�ˢ�»�����
		PrintWriter pWriter = new  PrintWriter(socket.getOutputStream(),true);
		
		String line = null;
		
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("�յ��ͻ�����Ϣ��"+line);
			String str=line.toUpperCase();//����ȡ���ַ���ת��д
			
			//��Ӧ����һ��
//			bufferedWriter.write(str); //д�룬�������ͻ���
//			bufferedWriter.newLine();//�˴��Ǽ��뻻�з������û�и��д��룬�ͻ��˽��ղ���������Ϣ
//			bufferedWriter.flush();//ˢ�»�����
			
			//��Ӧ��������
			pWriter.println(str);
		}
		
		socket.close();
		serverSocket.close();
		
		
	}

}

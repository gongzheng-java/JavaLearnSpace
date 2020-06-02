package TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *  �ͻ���
 * @Author: gongZheng
 * @Date:   2018��2��5��   ����7:05:07 
 * @Description:
 * 1.����scoket����ָ�������Ͷ˿�
 * 2.��ȡsocket�е��������������д�����У�ͨ�����緢�͸������
 * 3.��ȡsocket�е��������������������������ݻ�ȡ��������ӡ���
 * 4.�رտͻ�����Դ
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.10.147", 10004);
		//������Ϣ�������
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("������Ϣ�Ƿ��͸�����˵�".getBytes());
		
		
		//3.��ȡsocket�е������� ���ڶ�ȡ����������������
		InputStream iReader = socket.getInputStream();
		byte[] b = new byte[1024];//����������
		int len = iReader.read(b);//����ȡ�����ݷ��뻺������        ����ʽ����
		System.out.println(new String(b, 0,len));
		
		socket.close();
		
		
		//ע������е�����ʽ����:
		//1.������������ˣ���������е�����ʽ����accept()�����ȴ��ͻ�����Ϣ
		//2.�����ͻ��ˣ��ڸ�����˷�����Ϣ�󣬿ͻ������е�����ʽ����read()�����ȴ�����˵���Ϣ
		//3.����˽��յ��ͻ�����Ϣ�󣬴�ӡ�����Ȼ�������ͻ�����Ϣ  �رշ���
		//4.�ͻ��˽��յ��������Ϣ����ӡ������رշ���
		
		/* */
		
	}

}

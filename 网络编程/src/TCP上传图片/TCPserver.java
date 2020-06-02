package TCP�ϴ�ͼƬ;

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
 *  ���������и������ԣ���A�ͻ������Ӻ󣬱�����˻�ȡ����Ӧ��socket�������ִ�о���Ĳ������̣�
 *   ����ʱB�ͻ�������ʱ��ֻ�ܴ��ڵȴ�״̬��
 *   ��Ϊ����˻�û�д�����A�ͻ��˵����󣬻��л�ѭ������ִ���´�accept������������ʱ��ȡ����B�ͻ��˶���
 *   
 *   ��ôΪ���ø���Ŀͻ���ͬʱ�������ʷ���ˣ��������Ҫ��ÿ���ͻ��˷�װ��һ���������߳��У��������Ϳ���ʵ�ֲ������ʡ�
 *   �μ�ʾ�����ͻ��˲����ϴ�ͼƬ��
 */
public class TCPserver {
	public static void main(String[] args) throws IOException {
		//��������
		ServerSocket serverSocket = new ServerSocket(10009);
		//��ȡ�ͻ���socket
		Socket socket = serverSocket.accept();
		//��ȡ�ͻ��˵�����������ȡ�ͻ���socket���е���Ϣ
		InputStream inputStream = socket.getInputStream();
		//�����ļ����������
		FileOutputStream fOutputStream = new FileOutputStream("D:\\test6.jpg");
		
		byte[] buff = new byte[1024];
		int num = 0;
		//ѭ��������д���ļ���
		while ((num = inputStream.read(buff)) != -1) {
			fOutputStream.write(buff, 0, num);
		}
		
		//���ͻ��˷�����Ϣ
		OutputStream outputStream = socket.getOutputStream();
		byte[] bs = "�ϴ��ɹ���ע��鿴".getBytes();
		outputStream.write(bs);
		System.out.println("�ֽڳ��ȣ�"+bs.length);
		
		fOutputStream.close();
		socket.close();
		serverSocket.close();
	}

}

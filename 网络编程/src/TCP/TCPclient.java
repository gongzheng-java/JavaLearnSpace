package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP �ͻ���
 * @Author: gongZheng
 * @Date:   2018��2��5��   ����11:27:52 
 * @Description:  TCP���������� ��������û�п����Ļ��Ϳ����ͻ��ˣ���������ӱ�������
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("�����ͻ���");
			//����socket���񣬲�ָ�����ӵ������Ͷ˿�
			Socket socket = new Socket("192.168.10.147", 10008);
			
			//��ȡ�������ݵ�������(����Դ  ����������),���ռ���¼�������
			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(System.in));
			//��ȡsocket����������󣬽����ݷ��͵������
			OutputStream outputStream = socket.getOutputStream();
			
			String line = null;
			while ((line = bufferedReader.readLine()) != null ) {
				outputStream.write(line.getBytes());
				outputStream.flush();
			}
			
			socket.close();
		
	}

}

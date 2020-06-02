package TCP�����ļ�;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *�ͻ���
 * @Author: gongZheng
 * @Date:   2018��2��7��   ����12:01:23 
 * @Description:���ͻ����ļ����͸�����ˣ�������յ��ļ����ļ���������
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//����socket���� ָ���������󶨶˿�
		Socket socket = new Socket("192.168.10.147", 10007);
		
		//��ȡ�ļ�
		File file = new File("D:\\110.txt");
		if (file.exists()) { //�ж��ļ��Ƿ����
			if (file.isFile()) { //�ж��ļ��Ƿ����ļ�
				
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				//����д����󣬽���ȡ������д�뵽socket�з��͵������
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				
				String line = null;
				//ѭ��������д��socket�����ͳ�ȥ
				while ((line = bufferedReader.readLine()) != null) {
					printWriter.println(line);
				}
				
				//�رտͻ�����������൱�ڸ����м���һ��������� -1 ����������ѭ����ȡ�����޷�������
				//һֱ���������ȴ�״̬���Ӷ����¿ͻ��˺ͷ���˶����ڵȴ�״̬
				socket.shutdownOutput();
				
				
				//�˴�ֻ����շ���˷��صģ����ճɹ������Ϳ��ԣ����Բ���Ҫѭ����ȡ
				BufferedReader bReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String message = bReader.readLine();//����ʽ����
				System.out.println("����˷�����Ϣ�ǣ�"+message);
				
				//�ر���Դ
				bufferedReader.close();
				socket.close();
				
			}else {
				System.out.println("���ļ�����һ����׼�ļ�(�������ļ���Ŀ¼�ȵ�)��");
			}
		}else {
			System.err.println("�����ڸ��ļ�������");
		}
		
	}

}

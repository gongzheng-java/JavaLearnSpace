package TCP��ϰ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.ws.handler.MessageContext.Scope;

/**
 *�ͻ���
 * @Author: gongZheng
 * @Date:   2018��2��6��   ����2:39:55 
 * @Description:
 * 1.��������
 * 2.��ȡ����¼��
 * 3.�����ݷ��͸������
 * 4.��ȡ����˷��ظ��ͻ��˵�����
 * 5.�ر���Դ
 */
public class TCPclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//����socket����ָ�� IP ��ַ��ָ���˿ں�
		Socket socket = new Socket("192.168.10.147", 10002);
		
		//��ȡ�������ݵ�������(����Դ  ����������)
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//����1���������Ŀ�ĵ�(�����豸�������)������д��socket����������������  (����socket����)
		/*BufferedWriter bufferedWriter = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		//����2�� ���������PrintWriter���󣬻�ȡsocket�����
		PrintWriter pWriter = new PrintWriter(socket.getOutputStream(), true);
		

		
		/*ѭ��������д��ȥ�Ͷ�ȡ*/
		//һ��socket��ȡ������ȡ����˷��ص�����  (����socket����)
		BufferedReader bReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=null;//���ڴ洢����¼�����Ϣ
		while ((line=bufferedReader.readLine()) != null) { //�˴�readLine()������ȡ���Ǽ���¼����Ϣ
			if (line.equals("exit")) {
				break;
			}
			
			/*��Ӧ����1*/
//			bufferedWriter.write(line);//������д��ȥ�����͸������
//			bufferedWriter.newLine();//�˴��Ǽ��뻻�з������û�и��д��룬����˽��ղ�����Ϣ
//			bufferedWriter.flush();
			
			
			/*��Ӧ������*/
			pWriter.println(line);
			
			String str = bReader.readLine();//��ȡ����˷��ص�����
			System.out.println("��ȡ����˷��ص����ݣ�"+str);
		}
		
		//�ر���Դ
		bufferedReader.close();//�رռ���¼��
		socket.close();//�ر�socket
		
		
		
	}

}

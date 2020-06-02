package UDP���ͺͽ�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP ���Ͷ�
 * @Author: gongZheng
 * @Date:   2018��2��1��   ����5:19:02 
 * @Description: UDP���������ӣ�û�н��նˣ����͵����ݻᶪʧ
 *         
 */
public class UDPsend {
	public static void main(String[] args) throws IOException {
		//1.����UDP���� socket����(�൱���ʾ֣���������ý��)   �������ݱ��׽��ֲ�����󶨵����������ϵ�ָ���˿ڡ�
		//DatagramSocket ds=new DatagramSocket(8080);//���Բ�ָ���˿ں�
		
			
		
		//2.��Ҫ���͵�����(�൱�ھ���Ҫ���͵���Ʒ)
//		String str="���ã������Ҫ���͵���Ϣ";
//		byte[] buf = str.getBytes();//������ת�����ֽ�
//		InetAddress address = InetAddress.getByName("192.168.10.147");//ָ�����͵ĵ�ַ���˴�����Ϊ������ַ
		
		//2.�������ݱ��� �����൱�ڽ���Ҫ���͵���Ʒ��װ�ɰ������ͣ�
		// �������ݱ���������������Ϊ length �İ����͵�ָ�������ϵ�ָ���˿ںš�  ע�⣺���๹��ĺ�������������ͬ�����ò�һ��
//		DatagramPacket dp= new DatagramPacket(buf, buf.length, address, 10000);
//		
//		ds.send(dp);//����
//		ds.close();//�ر�
		//ע�⣺һ��Ҫ�����쳣(������׳�)����Ϊ�˿ںŵȵĲ������ܻ����
		
		
		/* ���ü���¼�뷽ʽ������Ϣ  �����������Ͷ�����Ϣ��ֱ��ע�롰�ټ�������ֹͣ����*/
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line=null;
		
		while ((line = reader.readLine()) != null) {
			
			byte[] bs = line.getBytes();
			DatagramPacket dPacket = new DatagramPacket(bs, bs.length, InetAddress.getByName("192.168.43.248"), 10000);
			ds.send(dPacket);
			
			//��ֹ����
			if ("�ټ�".equals(line)) {
				break;
			}
		}
		ds.close();
		
	}

}

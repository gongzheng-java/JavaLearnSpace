package UDP���ͺͽ�������;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * UDP ���ն�
 * @Author: gongZheng
 * @Date:   2018��2��2��   ����10:07:39 
 * @Description: ���ڽ���UDPЭ�鴫������ݺʹ���
 * 
 * 
 */
public class UDPRece {
	public static void main(String[] args) throws IOException {
		
		//����UDP���� socket���� ��ָ�������˿ںţ����ڽ�������
		DatagramSocket ds = new DatagramSocket(10000);
		while (true) {
		//ָ���������ݵ�byte����
		byte[] buf = new byte[1024];
		
		//�������ճ���Ϊ length �����ݰ�  ע�⣺DatagramPacket�๹�캯���Ĳ���������һ��������Ҳ��һ��
		DatagramPacket dp= new DatagramPacket(buf, buf.length);
		
		//�������ݣ�����ȡ�����ݷ�װ�����ݰ���
		ds.receive(dp);//����ʽ������û���յ���Ϣ�����ڵȴ�״̬  �ý��̲������
		
		//InetAddress iAddress = dp.getAddress();
		//System.out.println("��ȡIP ��ַ��"+iAddress.getHostName()+"   "+iAddress.getHostAddress()+"   ");
		
		//System.out.println("��ȡ�˿ں�:"+dp.getPort());
		
		String date = new String(dp.getData(), 0, dp.getLength());
		System.out.println("��ȡ���͵����ݣ�"+date);
		
		}
	}

}

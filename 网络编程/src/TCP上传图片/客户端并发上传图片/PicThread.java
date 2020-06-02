package TCP�ϴ�ͼƬ.�ͻ��˲����ϴ�ͼƬ;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ������߳���
 * @Author: gongZheng
 * @Date:   2018��2��8��   ����4:54:58 
 * @Description:
 *  ��ȷÿ���ͻ���Ҫ�ڷ���˵Ĵ��룬���ô������run()������
 */
public class PicThread implements Runnable {
	private Socket socket;

	
	public PicThread() {
		
	}
	
	public PicThread(Socket socket) {
		System.out.println("�����̣߳���");
		this.socket = socket;
	}

	
	@Override
	public void run() {
		/*������ǣ����ڷ�ֹ�ļ����ظ��������¸�������
		 * �˴�֮���Բ����˱������Ϊ���������Ϊ�˱�֤ÿ̨��ͬ�������ͻ��˲���ʱ���ļ������Ǵ��¿�ʼ�����
		 * ������˵������һ̨�����ͻ���ִ��һ�κ󣬵ڶ�̨�����ͻ��˵��ļ�����������һ̨������*/
		int count = 0;
		
		String IP= socket.getInetAddress().getHostAddress();
	    String name=socket.getInetAddress().getHostName();
		try {
			System.out.println("���� " + IP + "  ���û�  " + name + "  ������");
			//��ȡ�ͻ��˵�����������ȡ�ͻ���socket���е���Ϣ
			InputStream inputStream = socket.getInputStream();
			
			
			//�����ļ���������󣨴����ļ����ظ������µ��ļ��������⣩
			File file = new File("D:\\test("+count+").jpg");
			while (file.exists()) { //�ж�������ļ����Ƿ���ڣ�������������������µ��ļ���
				 file = new File("D:\\test("+(count++)+").jpg");
			}
			
			FileOutputStream fOutputStream = new FileOutputStream(file);
			
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
		} catch (Exception e) {
			System.out.println(IP +"   ͼƬ����ʧ�ܣ�����������");
			e.printStackTrace();
		}
		
		
	}
	

}

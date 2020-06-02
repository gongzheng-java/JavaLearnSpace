package TCP�ϴ�ͼƬ.�ͻ��˲����ϴ�ͼƬ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * 
 * @Author: gongZheng
 * @Date: 2018��2��7�� ����4:43:46
 * @Description: ��ԭ���Ļ����ϣ�ʹ�ö��̲߳�������ͼƬ
 */
public class TCPclient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		String[] args1 = new String[1];

		args1[0] = "D:\\test.jpg";

		aa(args1);

	}

	public static void aa(String[] args) throws IOException {
		// �ж��Ƿ����ļ�
		if (args.length != 1) {
			System.out.println("��ѡ��һ��ͼƬ�ļ���");
			return;
		}

		File file = new File(args[0]);

		// �ж��ļ��Ƿ���ڣ��ж��Ƿ����ļ�
		if (!(file.exists() && file.isFile())) {
			System.out.println("�ļ������ڻ��Ǳ�׼�ļ�");
			return;
		}

		// �ж�ͼƬ��ʽ �����.jpg��ʽ
		if (!file.getName().endsWith(".jpg")) {
			System.out.println("ͼƬ��ʽ����ȷ��������JPG��");
			return;
		}

		// ����ͼƬ��С ���ܴ���5M
		if (file.length() > 1024 * 1024 * 5) {
			System.out.println("�Բ���ͼƬ����(���ܴ���5M)��");
		}

		// ��������
		Socket socket = new Socket("192.168.10.146", 10009);

		// ��ȡ����
		// FileInputStream fInputStream = new FileInputStream("D:\\test2.jpg");
		FileInputStream fInputStream = new FileInputStream(file);

		// ��ȡsocket�����
		OutputStream outputStream = socket.getOutputStream();

		byte[] b = new byte[1024];// �����ֽڻ�����
		int num = 0;
		// ѭ����ͼƬ��������ȡ���ֽڻ������У��ٽ�ͨ��socket�������������������д��ȥ
		while ((num = fInputStream.read(b)) != -1) {
			// outputStream.write(b, 0, num);
			outputStream.write(b);
		}

		/*
		 * �رտͻ�����������൱�ڸ����м���һ��������� -1 ����������ѭ����ȡ�����޷�������
		 * һֱ���������ȴ�״̬���Ӷ����¿ͻ��˺ͷ���˶����ڵȴ�״̬
		 */
		socket.shutdownOutput();

		// ��ȡ����˷�������Ϣ
		InputStream inputStream = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len = inputStream.read(b1);
		System.out.println("len��" + len);
		System.out.println(new String(b1, 0, len));
		System.out.println(new String(b1));

		fInputStream.close();
		socket.close();
	}

}

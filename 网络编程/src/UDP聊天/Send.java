package UDP����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ���Ͷ�
 * 
 * @Author: gongZheng
 * @Date: 2018��2��2�� ����4:33:16
 * @Description:
 */
public class Send implements Runnable {

	private DatagramSocket ds;

	public Send() {
	}

	public Send(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;

		try {
			while ((str = bReader.readLine()) != null) {
				byte[] bs = str.getBytes();
				DatagramPacket dPacket = new DatagramPacket(bs, bs.length, InetAddress.getByName("192.168.1.101"),
						10001);
				ds.send(dPacket);
				if (str.equals("�ݰ�")) {
					break;
				}
			}
			ds.close();
		} catch (IOException e) {
			System.out.println("����ʧ��!!!!!!!!!!");
			e.printStackTrace();
		}
	}

}

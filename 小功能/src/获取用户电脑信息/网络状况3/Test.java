package ��ȡ�û�������Ϣ.����״��3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import ��ȡ�û�������Ϣ.����״��2.IntentAvailableUtil;

/**
 *
 * @Author: gongZheng
 * @Date:   2020��5��21��   ����5:23:15 
 * @Description:
 */
public class Test {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new URL("http://baidu.com");
			try {
				InputStream in = url.openStream();
				in.close();
				System.out.println("��������������");
			} catch (IOException e) {
				System.out.println("��������ʧ�ܣ�");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

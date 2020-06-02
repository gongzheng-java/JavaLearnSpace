package ������.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.common.base.StandardSystemProperty;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��10��14��   ����8:01:44 
 * @Description:
 */
public class Test {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iAddress=InetAddress.getLocalHost();
		
	
		System.out.println("IP:"+iAddress.getHostAddress());
		System.out.println("�������ƣ�"+iAddress.getHostName());
		System.out.println("�������ƣ�"+iAddress.getCanonicalHostName());
		
		System.out.println();
		iAddress=iAddress.getByName("localhost");
		System.out.println("IP:"+iAddress.getHostAddress());
		System.out.println("�������ƣ�"+iAddress.getHostName());
		System.out.println("�������ƣ�"+iAddress.getCanonicalHostName());
		
		
		//����
		System.out.println();
		InetAddress iAddress2=InetAddress.getByName("www.google.com");
		System.out.println("IP:"+iAddress2.getHostAddress());
		System.out.println("�������ƣ�"+iAddress2.getHostName());
		System.out.println("�������ƣ�"+iAddress2.getCanonicalHostName());
		
		
	}

}

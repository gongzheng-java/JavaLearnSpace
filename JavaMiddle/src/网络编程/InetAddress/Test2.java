package ������.InetAddress;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��10��14��   ����8:08:54 
 * @Description:
 */
public class Test2 {
	public static void main(String[] args) {
		InetSocketAddress address=new InetSocketAddress(9898);
		System.out.println(address.getHostName());
		System.out.println(address.getHostString());
		
		
		System.out.println();
		InetSocketAddress address2=new InetSocketAddress("127.0.0.1",9090);
		System.out.println(address2.getHostName());
		System.out.println(address2.getHostString());
		System.out.println(address2.getPort());
		InetAddress iAddress=address2.getAddress();
		System.out.println("IP:"+iAddress.getHostAddress());
		System.out.println("�������ƣ�"+iAddress.getHostName());
		System.out.println("�������ƣ�"+iAddress.getCanonicalHostName());
		
	}

}

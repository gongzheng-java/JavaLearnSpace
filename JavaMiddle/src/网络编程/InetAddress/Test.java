package 网络编程.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.common.base.StandardSystemProperty;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年10月14日   下午8:01:44 
 * @Description:
 */
public class Test {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iAddress=InetAddress.getLocalHost();
		
	
		System.out.println("IP:"+iAddress.getHostAddress());
		System.out.println("主机名称："+iAddress.getHostName());
		System.out.println("主机名称："+iAddress.getCanonicalHostName());
		
		System.out.println();
		iAddress=iAddress.getByName("localhost");
		System.out.println("IP:"+iAddress.getHostAddress());
		System.out.println("主机名称："+iAddress.getHostName());
		System.out.println("主机名称："+iAddress.getCanonicalHostName());
		
		
		//解析
		System.out.println();
		InetAddress iAddress2=InetAddress.getByName("www.google.com");
		System.out.println("IP:"+iAddress2.getHostAddress());
		System.out.println("主机名称："+iAddress2.getHostName());
		System.out.println("主机名称："+iAddress2.getCanonicalHostName());
		
		
	}

}

package IP地址;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试获取IP相关信息
 * 
 * @Author: gongZheng
 * @Date: 2018年2月1日 下午3:17:08
 * @Description: 由于本地IP地址会变化，而后面的示例使用的都是本地IP地址，所以
 *               首先运行该类，查看本地IP地址，再查看后面的示例中所写的IP地址是否和此处获取的一致，如果不一致，需要修改 否则运行示例没效果
 */
public class IPdemo {
	public static void main(String[] args) throws UnknownHostException {

		// 返回本地主机对象
		InetAddress iAddress = InetAddress.getLocalHost();

		System.out.println("获取本地主机信息(名称/地址)：" + iAddress.toString());
		System.out.println("获取本地主机名称：" + iAddress.getHostName());
		System.out.println("获取本地主机地址：" + iAddress.getHostAddress());
		System.out.println("获取此 IP 地址的完全限定域名" + iAddress.getCanonicalHostName());
		System.out.println();

		// 在给定主机名的情况下确定主机的 IP 地址 www.taobao.com/115.238.23.253
		InetAddress iAddress2 = InetAddress.getByName("www.baidu.com");
		System.out.println("获取所需主机信息(名称/地址)：" + iAddress2);

	}

}

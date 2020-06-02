package 获取用户电脑信息;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.management.OperatingSystemMXBean;

import 获取用户电脑信息.网络状况1.NetState;
import 获取用户电脑信息.网络状况2.IntentAvailableUtil;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年5月19日   下午2:18:31 
 * @Description:
 */
public class Test {

	public static void main(String[] args) throws UnknownHostException {
		// 用户ip、计算机配置、网络情况、浏览器类型及版本信息等

		// 获取当前用户IP
		InetAddress iAddress = InetAddress.getLocalHost();
		System.out.println("获取本地主机名称：" + iAddress.getHostName());
		System.out.println("获取本地主机地址：" + iAddress.getHostAddress());

		// 计算机配置内存
		OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		long size = osmb.getTotalPhysicalMemorySize();
		// 得出的内存大小是以B作单位的，从B --> KB --> MB --> GB 每次要除以1024
		size = size / (1024*1024*1024)+1;
		System.out.println("计算机内存:  " + size+" G");
		
		//网络状况
		System.out.println(NetState.isConnect()+"\n");
		System.out.println(IntentAvailableUtil.connState("http://baidu.com"));
		
		

	}

	
}

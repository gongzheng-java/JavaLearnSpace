package ��ȡ�û�������Ϣ;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.management.OperatingSystemMXBean;

import ��ȡ�û�������Ϣ.����״��1.NetState;
import ��ȡ�û�������Ϣ.����״��2.IntentAvailableUtil;

/**
 *
 * @Author: gongZheng
 * @Date:   2020��5��19��   ����2:18:31 
 * @Description:
 */
public class Test {

	public static void main(String[] args) throws UnknownHostException {
		// �û�ip����������á������������������ͼ��汾��Ϣ��

		// ��ȡ��ǰ�û�IP
		InetAddress iAddress = InetAddress.getLocalHost();
		System.out.println("��ȡ�����������ƣ�" + iAddress.getHostName());
		System.out.println("��ȡ����������ַ��" + iAddress.getHostAddress());

		// ����������ڴ�
		OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		long size = osmb.getTotalPhysicalMemorySize();
		// �ó����ڴ��С����B����λ�ģ���B --> KB --> MB --> GB ÿ��Ҫ����1024
		size = size / (1024*1024*1024)+1;
		System.out.println("������ڴ�:  " + size+" G");
		
		//����״��
		System.out.println(NetState.isConnect()+"\n");
		System.out.println(IntentAvailableUtil.connState("http://baidu.com"));
		
		

	}

	
}

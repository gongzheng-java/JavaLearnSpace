package IP��ַ;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ���Ի�ȡIP�����Ϣ
 * 
 * @Author: gongZheng
 * @Date: 2018��2��1�� ����3:17:08
 * @Description: ���ڱ���IP��ַ��仯���������ʾ��ʹ�õĶ��Ǳ���IP��ַ������
 *               �������и��࣬�鿴����IP��ַ���ٲ鿴�����ʾ������д��IP��ַ�Ƿ�ʹ˴���ȡ��һ�£������һ�£���Ҫ�޸� ��������ʾ��ûЧ��
 */
public class IPdemo {
	public static void main(String[] args) throws UnknownHostException {

		// ���ر�����������
		InetAddress iAddress = InetAddress.getLocalHost();

		System.out.println("��ȡ����������Ϣ(����/��ַ)��" + iAddress.toString());
		System.out.println("��ȡ�����������ƣ�" + iAddress.getHostName());
		System.out.println("��ȡ����������ַ��" + iAddress.getHostAddress());
		System.out.println("��ȡ�� IP ��ַ����ȫ�޶�����" + iAddress.getCanonicalHostName());
		System.out.println();

		// �ڸ����������������ȷ�������� IP ��ַ www.taobao.com/115.238.23.253
		InetAddress iAddress2 = InetAddress.getByName("www.baidu.com");
		System.out.println("��ȡ����������Ϣ(����/��ַ)��" + iAddress2);

	}

}

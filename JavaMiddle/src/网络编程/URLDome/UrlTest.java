package ������.URLDome;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * @Author: gongZheng
 * @Date:   2019��10��14��   ����9:10:53 
 * @Description:
 *   url��ͳһ��Դ��λ�������ɣ�Э�� + ����(����) + �˿ں� + ��Դ
 */
public class UrlTest {
public static void main(String[] args) throws MalformedURLException {
	//����·������  #aa ����ê��
	URL url=new URL("https://www.baidu.com:9696/index/index.jsp#aa?user=admin");
	System.out.println("Э�飺"+url.getProtocol());
	System.out.println("����(����)��"+url.getHost());
	System.out.println("�˿ںţ�"+url.getPort());
	System.out.println("��Դ��ַ��"+url.getPath());
	System.out.println("ê�㣺"+url.getRef());
	//ע�⣺��������ê���ʱ�򣬴˴���ȡ����null��������ê��getRef()�����У����������û��ê�㣬�����������ȡ
	System.out.println("������"+url.getQuery());
	
	System.out.println();
	//���·��
	URL url2=new URL("https://www.baidu.com/login/");
	url2=new URL(url2, "long.jsp");
	System.out.println(url2);
	
	
}
}

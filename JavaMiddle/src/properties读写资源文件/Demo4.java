package properties��д��Դ�ļ�;

import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��������·����ȡ�����ļ��������о���ʹ�ø÷�ʽ��
 * һ�������java�ļ���binĿ¼��
 * ͨ����Window->Show View->Navigator�����Բ鿴
 * @Author: gongZheng
 * @Date:   2019��8��27��   ����9:54:23 
 * @Description:
 * ���ַ�ʽ����Ϊ���ύ���ͻ�����java�������ֽ����ļ�������Դ����
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		Properties properties=new Properties();
		//������·��  / ��ʾ binĿ¼
		//properties.load(Demo4.class.getResourceAsStream("/db.properties"));
		
		//��ʽ�� ʹ�����������ȡ·��  ���ַ���·������Ҫ /
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		System.out.println(properties.getProperty("driver"));
	     System.out.println(properties.getProperty("password","scott"));
	     System.out.println(properties.getProperty("url"));
	}

}

package properties��д��Դ�ļ�;

import java.sql.Connection;
import java.util.Properties;

/**
 * properties�Ĵ洢�Ͷ�ȡ
 * @Author: gongZheng
 * @Date:   2019��8��27��   ����8:31:40 
 * @Description:
 */
public class Demo01 {
	public static void main(String[] args) {
		Properties properties=new Properties();
        //�洢
		properties.setProperty("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.setProperty("url", "jdbc:sqlserver://localhost:1433;database=CEJB");
		properties.setProperty("user", "sa");
		properties.setProperty("password", "123456");
		
		//��ȡ
		Object a=properties.get("url");
		String b=properties.getProperty("url");//���û�ж�ȡ��ֵ���򷵻�null 
		//����������ʱ�����û�и���key��ȡ��ֵ���򷵻صڶ���������ΪĬ��ֵ
		String c=properties.getProperty("aa", "���û�ж�ȡ��key��Ӧ��ֵ�����ȡ���Ĭ��ֵ");
	
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		
	
	}

}

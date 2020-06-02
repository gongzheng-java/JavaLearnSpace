package properties��д��Դ�ļ�;

import static org.hamcrest.CoreMatchers.endsWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * properties ������ļ�(�������ļ�)
 * @Author: gongZheng
 * @Date:   2019��8��27��   ����8:55:23 
 * @Description:
 * 1.������ļ����ݺͺ�׺û�й�ϵ
 * 2.�������.properties  �� .xml�ļ�
 */
public class Demo2 {
	public static void main(String[] args) throws IOException   {
		Properties properties=new Properties();
        //�洢
		properties.setProperty("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.setProperty("url", "jdbc:sqlserver://localhost:1433;database=CEJB");
		properties.setProperty("user", "sa");
		properties.setProperty("password", "123456");
		
		//���.properties�ļ�
		File file=new File("D:/Test/db.properties");
		FileOutputStream fStream=new FileOutputStream(file);
		properties.store(fStream, "db����");
		//��� .xml�ļ�
		File file2=new File("D:/Test/db1.xml");
		FileOutputStream fStream2=new FileOutputStream(file2);
		properties.storeToXML(fStream2, "db1����");
		properties.storeToXML(fStream2, "db2����","utf-8");
		
		//ʹ�����·�� �洢����ǰ��Ŀ��
		File file3=new File("src/db.properties");
		FileOutputStream fStream3=new FileOutputStream(file3);
		properties.store(fStream3, "db1����");
		
	}

}

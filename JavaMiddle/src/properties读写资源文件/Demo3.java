package properties��д��Դ�ļ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties��ȡ�����ļ�
 * @Author: gongZheng
 * @Date:   2019��8��27��   ����9:44:27 
 * @Description:
 */
public class Demo3 {
public static void main(String[] args) throws IOException {
	Properties properties=new Properties();
	//��ȡ����·��
	// File file=new File("D:/Test/db.properties");
	 //��ȡ���·��
	 File file=new File("src/db.properties");
	 FileInputStream fStream=new FileInputStream(file);
     properties.load(fStream);
     System.out.println(properties.getProperty("driver"));
     System.out.println(properties.getProperty("password","scott"));
  
     
}
}

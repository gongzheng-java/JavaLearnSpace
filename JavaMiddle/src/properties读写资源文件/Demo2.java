package properties读写资源文件;

import static org.hamcrest.CoreMatchers.endsWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * properties 输出到文件(即配置文件)
 * @Author: gongZheng
 * @Date:   2019年8月27日   下午8:55:23 
 * @Description:
 * 1.输出的文件内容和后缀没有关系
 * 2.可以输出.properties  和 .xml文件
 */
public class Demo2 {
	public static void main(String[] args) throws IOException   {
		Properties properties=new Properties();
        //存储
		properties.setProperty("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.setProperty("url", "jdbc:sqlserver://localhost:1433;database=CEJB");
		properties.setProperty("user", "sa");
		properties.setProperty("password", "123456");
		
		//输出.properties文件
		File file=new File("D:/Test/db.properties");
		FileOutputStream fStream=new FileOutputStream(file);
		properties.store(fStream, "db配置");
		//输出 .xml文件
		File file2=new File("D:/Test/db1.xml");
		FileOutputStream fStream2=new FileOutputStream(file2);
		properties.storeToXML(fStream2, "db1配置");
		properties.storeToXML(fStream2, "db2配置","utf-8");
		
		//使用相对路径 存储到当前项目中
		File file3=new File("src/db.properties");
		FileOutputStream fStream3=new FileOutputStream(file3);
		properties.store(fStream3, "db1配置");
		
	}

}

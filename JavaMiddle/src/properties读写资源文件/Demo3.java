package properties读写资源文件;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties读取配置文件
 * @Author: gongZheng
 * @Date:   2019年8月27日   下午9:44:27 
 * @Description:
 */
public class Demo3 {
public static void main(String[] args) throws IOException {
	Properties properties=new Properties();
	//读取绝对路径
	// File file=new File("D:/Test/db.properties");
	 //读取相对路径
	 File file=new File("src/db.properties");
	 FileInputStream fStream=new FileInputStream(file);
     properties.load(fStream);
     System.out.println(properties.getProperty("driver"));
     System.out.println(properties.getProperty("password","scott"));
  
     
}
}

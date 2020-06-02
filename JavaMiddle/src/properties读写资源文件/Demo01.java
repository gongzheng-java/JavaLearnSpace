package properties读写资源文件;

import java.sql.Connection;
import java.util.Properties;

/**
 * properties的存储和读取
 * @Author: gongZheng
 * @Date:   2019年8月27日   下午8:31:40 
 * @Description:
 */
public class Demo01 {
	public static void main(String[] args) {
		Properties properties=new Properties();
        //存储
		properties.setProperty("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.setProperty("url", "jdbc:sqlserver://localhost:1433;database=CEJB");
		properties.setProperty("user", "sa");
		properties.setProperty("password", "123456");
		
		//读取
		Object a=properties.get("url");
		String b=properties.getProperty("url");//如果没有读取到值，则返回null 
		//两个参数的时候，如果没有根据key读取到值，则返回第二个参数作为默认值
		String c=properties.getProperty("aa", "如果没有读取到key对应的值，则读取这个默认值");
	
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		
	
	}

}

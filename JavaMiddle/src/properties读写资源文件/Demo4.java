package properties读写资源文件;

import java.io.IOException;
import java.util.Properties;

/**
 * 使用类的相对路径读取配置文件（工作中经常使用该方式）
 * 一般编译后的java文件在bin目录下
 * 通过“Window->Show View->Navigator”可以查看
 * @Author: gongZheng
 * @Date:   2019年8月27日   下午9:54:23 
 * @Description:
 * 此种方式的因为，提交给客户的是java编译后的字节码文件，不是源代码
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		Properties properties=new Properties();
		//类的相对路径  / 表示 bin目录
		//properties.load(Demo4.class.getResourceAsStream("/db.properties"));
		
		//方式二 使用类加载器获取路径  此种方法路径不需要 /
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		System.out.println(properties.getProperty("driver"));
	     System.out.println(properties.getProperty("password","scott"));
	     System.out.println(properties.getProperty("url"));
	}

}

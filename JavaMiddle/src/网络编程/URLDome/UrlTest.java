package 网络编程.URLDome;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL
 * @Author: gongZheng
 * @Date:   2019年10月14日   下午9:10:53 
 * @Description:
 *   url是统一资源定位符，构成：协议 + 域名(主机) + 端口号 + 资源
 */
public class UrlTest {
public static void main(String[] args) throws MalformedURLException {
	//绝对路径构建  #aa 链接锚点
	URL url=new URL("https://www.baidu.com:9696/index/index.jsp#aa?user=admin");
	System.out.println("协议："+url.getProtocol());
	System.out.println("域名(主机)："+url.getHost());
	System.out.println("端口号："+url.getPort());
	System.out.println("资源地址："+url.getPath());
	System.out.println("锚点："+url.getRef());
	//注意：当链接有锚点的时候，此处获取的是null，参数在锚点getRef()方法中；如果链接中没有锚点，则可以正常获取
	System.out.println("参数："+url.getQuery());
	
	System.out.println();
	//相对路径
	URL url2=new URL("https://www.baidu.com/login/");
	url2=new URL(url2, "long.jsp");
	System.out.println(url2);
	
	
}
}

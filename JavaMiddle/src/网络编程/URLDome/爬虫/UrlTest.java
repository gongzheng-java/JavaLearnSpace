package 网络编程.URLDome.爬虫;

import static org.hamcrest.CoreMatchers.is;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年10月15日   下午10:01:41 
 * @Description:
 */
public class UrlTest {
	public static void main(String[] args) throws IOException {
		URL url=new URL("https://www.baidu.com");
		
		//获取资源网络流
		/*InputStream iStream=url.openStream();
		byte[] flush=new byte[1024];
		int len=0;
		while (-1!=(len=iStream.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
		iStream.close();*/
		
		BufferedReader br=
				new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		
		String msg=null;
		
		while ((msg=br.readLine())!=null) {
			bw.append(msg);
			bw.newLine();
			System.out.println(msg);
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

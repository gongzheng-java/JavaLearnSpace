package 获取用户电脑信息.网络状况3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import 获取用户电脑信息.网络状况2.IntentAvailableUtil;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年5月21日   下午5:23:15 
 * @Description:
 */
public class Test {

	public static void main(String[] args) {

		URL url = null;
		try {
			url = new URL("http://baidu.com");
			try {
				InputStream in = url.openStream();
				in.close();
				System.out.println("网络连接正常！");
			} catch (IOException e) {
				System.out.println("网络连接失败！");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}

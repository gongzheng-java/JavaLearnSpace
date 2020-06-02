package 获取用户电脑信息.网络状况2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

public class IntentAvailableUtil {
	
	public static void main(String[] args) {  
        URL url = null;  
        try {  
            url = new URL("http://baidu.com");  
            IntentAvailableUtil.connState("IntentAvailableUtil");
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
	
	/**记录连接次数**/
	private static int count = 0;
	/**URL**/
	private static URL urlStr = null;
	/**连接响应码**/
	private static int stateCode = 0;
	/**记录网络断开时间**/
	private static String closeTime = null;
	/**HttpURLCOnnection对象**/
	private static HttpURLConnection connection = null;

	/***
	* 功能描述：检测当前的网络是否断开或当前地址是否可连接
	*  如果网络没有断开，最多连接网络5次，如果5次连接不成功说明该地址不存在或
	*   视为无效地址。
	* @param url
	*/
	public synchronized static boolean connState(String url) {
		while (count < 5) {
			try {
				urlStr = new URL(url);
				connection = (HttpURLConnection) urlStr.openConnection();
				stateCode = connection.getResponseCode();
				if (stateCode == 200) {
					return true;
				}
			} catch (Exception e) {
				if (closeTime == null) {
					DateFormat df = DateFormat.getDateTimeInstance();
					closeTime = df.format(new Date());
					System.out.println("网络连接已断开,请检查网络连接设备");
					System.out.println("断开时间:" + closeTime);
					System.out.println("程序开始每10秒检查一次");
				}
				try {
					System.out.println("开始第" + ++count + "次检查网络连接状态");
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
				}
			}

		}

		return false;

	}
}

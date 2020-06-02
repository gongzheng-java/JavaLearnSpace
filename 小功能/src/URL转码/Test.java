package URL转码;

import java.net.URI;
import java.net.URLEncoder;

import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年5月8日   下午6:27:09 
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		//http://localhost:8080/cesiumData/photo//牛从甲线/±500kV牛从甲线2494#极1小号侧外串绝缘子挂板单帽.JPG
		// http://localhost:8080/cesiumData/photo/%E7%89%9B%E4%BB%8E%E7%94%B2%E7%BA%BF/%C2%B1500kV%E7%89%9B%E4%BB%8E%E7%94%B2%E7%BA%BF2494%23%E6%9E%811%E5%B0%8F%E5%8F%B7%E4%BE%A7%E5%A4%96%E4%B8%B2%E7%BB%9D%E7%BC%98%E5%AD%90%E6%8C%82%E6%9D%BF%E5%8D%95%E5%B8%BD.JPG
		// /photo/%E7%89%9B%E4%BB%8E%E7%94%B2%E7%BA%BF/%C2%B1500kV%E7%89%9B%E4%BB%8E%E7%94%B2%E7%BA%BF2494%23%E6%9E%811%E5%B0%8F%E5%8F%B7%E4%BE%A7%E5%A4%96%E4%B8%B2%E7%BB%9D%E7%BC%98%E5%AD%90%E6%8C%82%E6%9D%BF%E5%8D%95%E5%B8%BD.JPG
		// photo/牛从甲线/±500kV牛从甲线2494#极1小号侧外串绝缘子挂板单帽.JPG
		String str = "photo/牛从甲线/±500kV牛从甲线2494#极1小号侧外串绝缘子挂板单帽.JPG";
		String urlCode = URLEncoder.encode(str);
		urlCode=urlCode.replace("%2F", "/");
		
		System.out.println(urlCode);
	}

}

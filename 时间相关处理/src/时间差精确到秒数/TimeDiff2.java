package 时间差精确到秒数;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年1月14日   下午11:37:20 
 * @Description:
 */
public class TimeDiff2 {
	/**
	     * 
	     * @param firstLoginTime 最小的时间
	     * @param nowTime传递最大的时间
	     * @return
	     
	 * @throws java.text.ParseException */

	public static JSONObject getDistanceTime(String firstLoginTime, String nowTime){
		JSONObject dataMap = new JSONObject();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1;
		
			try {
				d1 = df.parse(nowTime);
				Date d2 = df.parse(firstLoginTime);// 用户初次登录时间
				long diff = d1.getTime() - d2.getTime();//// 当前的时间减去我初次登陆的时间如果大于等于2小时
				long seconds = diff / (1000); // 共计秒数
				long days = diff / (1000 * 60 * 60 * 24);
				long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
				long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
				dataMap.put("hours", hours);
				dataMap.put("minutes", minutes);
				dataMap.put("seconds", seconds);
				dataMap.put("days", days);
				return dataMap;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		
		return dataMap;

	}
	
	public static void main(String[] args) throws java.text.ParseException {
		String aa = "2019-03-03 12:30:00";
		String bb = "2019-03-03 12:32:00";
		JSONObject json = getDistanceTime(aa, bb);
		String sec = json.getString("seconds");
	}

}

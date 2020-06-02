package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年7月4日 下午3:00:18
 * @Description:
 */
public class Test1 {

	/*
	 * public static void main(String[] args) { LocalDateTime localDateTime =
	 * LocalDateTime.now(); DateTimeFormatter dateTimeFormatter =
	 * DateTimeFormatter.ofPattern("yyyyMMdd"); StringBuffer preReportCode = new
	 * StringBuffer("xx").append(localDateTime.format(dateTimeFormatter));
	 * System.out.println(preReportCode); }
	 */

	@org.junit.Test
	public void test() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		StringBuffer preReportCode = new StringBuffer("xx").append(localDateTime.format(dateTimeFormatter));
		System.out.println(preReportCode);
	}

	@org.junit.Test
	public void test2() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String time = "2018-04";
		Date date;
		try {
			date = dateFormat.parse(time);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void test3() {
		long timeStamp = 1546272000000l;// 直接是时间戳
		// long timeStamp = System.currentTimeMillis(); //
		// 获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 这个是你要转成后的时间的格式
		String sd = sdf.format(new Date(timeStamp)); // 时间戳转换成时间
		System.out.println(sd);// 打印出你要的时间

		Long num = null;
		num = 9L;
		System.out.println(num);
	}

	@org.junit.Test
	public void test4() {
		Map<String, Object> map = new HashMap<>();
		Long[] ids = { 1L, 2L, 3L };
		map.put("ids", ids);
		String strs = map.get("ids").toString();
		List<String> lstStrId = Arrays.asList(strs.contains(",") ? strs.split(",") : new String[] { strs });

		List<Long> lstId = new ArrayList<>();
		for (String strId : lstStrId) {
			Long value = Long.parseLong(strId);
			if (!lstId.contains(value)) {
				lstId.add(value);
			}
		}

		for (Long long1 : lstId) {
			System.out.println(long1);
		}

	}

	@org.junit.Test
	public void test5() throws ParseException {
		
		String dateStr1 = "2019-01-14 18:03:23";
		String dateStr2 = "2019-01-14 18:06:56"; 
		SimpleDateFormat sfFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

		long date1 = sfFormat.parse(dateStr1).getTime();
		long date2 = sfFormat.parse(dateStr2).getTime();
		System.out.println(date1);
		System.out.println(date2);
		
		long num=date2-date1;
		long a =num/(1000);
		System.out.println("相差："+a);
		
		
		System.out.println(getLookTime(num));
        
	}
	
	private String getLookTime(long time) {  // time为秒
		  // 小时
		  long  hour =  time / (60 * 60); 
		  // 分钟
	      long  min =   (time / 60) - (hour * 60);  
	      // 秒
	      long  sec =   time  - (hour * 60 * 60) - (min * 60);
	      
	      String result = hour + "时"+min+"分"+sec+"秒";
	      return result;
		}

	
	public static long getMinute(LocalDateTime inDate, LocalDateTime nowDate) {
		Duration duration = java.time.Duration.between(inDate, nowDate);
		
		System.out.println("时间差:" + duration.getSeconds());
		long hour = duration.getSeconds() / ChronoUnit.HOURS.getDuration().getSeconds();
		long minute = (duration.getSeconds() - ChronoUnit.HOURS.getDuration().getSeconds() * hour) / ChronoUnit.MINUTES.getDuration().getSeconds();
		long second = (duration.getSeconds() - ChronoUnit.HOURS.getDuration().getSeconds() * hour) - minute * ChronoUnit.MINUTES.getDuration().getSeconds();
		
		System.out.println("时间:" + hour + ":" + minute + ":" + second);
		return second;
		}


}

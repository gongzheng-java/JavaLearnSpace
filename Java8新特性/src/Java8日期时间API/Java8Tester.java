package Java8日期时间API;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年4月22日 下午8:30:27
 * @Description:
 */
public class Java8Tester {
	public static void main(String[] args) {

		Date day = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(df.format(day));

		// java8之前获取当前时间
		/*
		 * System.out.println(new Date().toLocaleString());
		 * 
		 * System.out.println(
		 * "=================================================="); // 获取当日时间
		 * LocalDateTime currentime = LocalDateTime.now(); int num
		 * =currentime.getYear(); System.out.println("当前时间：" + currentime);
		 * System.out.println("年、月、日："+currentime.toLocalDate());
		 * System.out.println("时、分、秒："+currentime.toLocalTime());
		 * System.out.println("年："+currentime.getYear());
		 * System.out.println("月(英文)："+currentime.getMonth());
		 * System.out.println("月(数字)："+currentime.getMonthValue());
		 * System.out.println("日："+currentime.getDayOfMonth());
		 * System.out.println("时："+currentime.getHour());
		 * System.out.println("分："+currentime.getMinute());
		 * System.out.println("秒："+currentime.getSecond());
		 * System.out.println("当前周几（英文）"+currentime.getDayOfWeek());
		 * System.out.println(
		 * "========================================================================="
		 * );
		 */
		// 返回1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六 RiverJobService.java:265
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDate = s.format(cal.getTime()); // 当前日期
		System.out.println("Calendar当前时间：" + curDate);
		System.out.println("Calendar当前周几(数字)：" + (cal.get(Calendar.DAY_OF_WEEK) - 1));// 周日是1，周六是7
		System.out.println("Calendar当前月份(数字)：" + (cal.get(Calendar.MONTH) + 1));// 月份是0~11
		System.out.println("Calendar当前日期数：" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar当前年份：" + cal.get(Calendar.YEAR));
		System.out.println("Calendar上一年份：" + (cal.get(Calendar.YEAR) - 1));
		System.out.println("当前月份最后一天：" + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		// 设置当前时间为当月最后一天
		cal.set(cal.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String curDate1 = s.format(cal.getTime()); // 当前日期
		System.out.println("Calendar当前时间：" + curDate1);
		System.out.println("设置Calendar后当前周几(数字)：" + (cal.get(Calendar.DAY_OF_WEEK) - 1));
		System.out.println("当前小时数(24小时制)：" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("当前小时数(12小时制)：" + cal.get(Calendar.HOUR));

		cal.set(cal.DAY_OF_MONTH, 1);

		// 设置时间为当天12点钟
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		System.out.println("设置后的时间：" + s.format(cal.getTime()));

		System.out.println("-----------");
		cal.add(Calendar.HOUR_OF_DAY, 0);
		System.out.println("当前时间的之前或之后小时数(24小时制)：" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("-----------");
		int month = cal.get(Calendar.MONTH) + 1;
		Long monthLong = (long) month;
		System.out.println("当前月份 or (转Long类型)：" + month + " / " + monthLong);
		String[] months = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
		Calendar rightNow = Calendar.getInstance();
		System.out.println(months[rightNow.get(Calendar.MONTH)]);

	}

}

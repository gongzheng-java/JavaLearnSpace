package 时间相关处理;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年8月23日 下午4:02:46
 * @Description:
 */
public class TestDate {

	@Test
	void te() {
		System.out.println("123");
	}

	private static Calendar cal = Calendar.getInstance();

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	// 设置当前时间是周日，获取当前周一的时间
	@Test
	void test() throws ParseException {
		// 设置指定某个周日时间为当前时间
		String dateStr = "2018-08-26 00:00:00";
		Date date = sdf.parse(dateStr);
		cal.setTime(date);
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;// 月份 0~11
		// 设置周一时间
		cal.add(Calendar.DATE, -6);

		System.out.println("周一时间是：" + sdf.format(cal.getTime()));
		System.out.println("当前年份：" + year);
		System.out.println("当前月份：" + month);
		System.out.println("当前周一的时间：" + cal.get(cal.DAY_OF_WEEK));// 周日是1，周六是7
		System.out.println("当前周是这个月的第几周：" + cal.get(cal.DAY_OF_WEEK_IN_MONTH));

	}

	/**
	 * 根据指定时间，获取指定时间周一和周日的时间
	 */
	@Test
	void test1() {
		// 参数
		Date date = new Date();

		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(cal.getTime());
		System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		System.out.println("所在周星期日的日期：" + imptimeEnd);
	}

	/**
	 * 计算两个时间差
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test
	void test2() throws InterruptedException, ParseException {
		Date startTime = sdf.parse("2018-09-28 22:42:06");
		Date endTime = sdf.parse("2018-09-28 23:01:46");

		long time = endTime.getTime() - startTime.getTime();
		System.out.println("时差：" + time);
		System.out.println("时差（秒）：" + time / 1000);
		double time1 = time / (1000 * 60);
		double time2 = time / (1000 * 60);
		System.out.println("时差（分钟）：" + time1 + " <> " + time2);
		double time3 = time / (1000 * 60 * 60 * 1.0);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("时差（小时）：" + time3);
		System.out.println("时差（小时 四舍五入）：" + df.format(time3));

	}

	/**
	 * 设置时间
	 */
	@Test
	void test3() {
		Long[] ids = { 1L, 2L, 3L, 4L, 5L };
		System.out.println(ids.toString());
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 9);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date m9 = c.getTime();
		System.out.println(sdf.format(m9));

		c.set(Calendar.HOUR_OF_DAY, 18);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date m6 = c.getTime();
		System.out.println(sdf.format(m6));
	}

	@Test
	void test4() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = "2018-09-01";
		Date date2 = sdf.parse(date);
		System.out.println(sdf.format(date2));

		int result = Integer.parseInt("09");
		System.out.println(result);
		StringBuffer prefix = new StringBuffer();
		System.out.println("1>>" + prefix.toString());
		for (int i = 0; i < 12; i++) {
			Random r = new Random();
			int a = r.nextInt(3) + 1;
			System.out.println(a);
		}
	}

}

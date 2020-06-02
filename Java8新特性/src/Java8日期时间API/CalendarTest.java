package Java8日期时间API;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年6月14日 上午11:06:16
 * @Description:
 */
public class CalendarTest {

	// 排水养护设施统计报表
	@Test
	public void test() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		Date endTime = dateFormat.parse("2019-07-01 00:00:00");// 定时任务时间
		cal.setTime(endTime);
		cal.add(Calendar.DAY_OF_MONTH, -1);// 设置时间为上月月底
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		System.out.println(dateFormat.format(cal.getTime()));

	}

	// double类型数据精确度
	@Test
	public void test1() {
		DecimalFormat df = new DecimalFormat("#0.00");

		double d1 = 3.23556d;
		double d2 = 0.0;
		double d3 = 2.0;

		System.out.println(df.format(d1));
		System.out.println(df.format(d2));
		System.out.println(df.format(d3));
	}

	// 当前时间是周几
	@Test
	public void test2() {
		Calendar cal = Calendar.getInstance();
		System.out.println("当前年份：" + cal.get(Calendar.YEAR));
		System.out.println("当前月份：" + cal.get(Calendar.MONTH));// 月份是0~11，对应1~12月份
		System.out.println("当前日期数：" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("当前周几：" + cal.get(Calendar.DAY_OF_WEEK));// 周日是1，周六是7
		System.out.println("当前小时数：" + cal.get(Calendar.HOUR_OF_DAY));

		String aString = "404ce4a13e794555aa976b1c556e1732";
		System.out.println("字符串长度：" + aString.length());
	}

	@Test
	public void test3() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endTime = dateFormat.parse("2019-01-01 02:00:00");// 定时任务时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(endTime);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String time = dateFormat.format(cal.getTime());
		System.out.println("当前时间是：" + time);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("当前月份：" + month);

	}

	@Test
	public void test4() throws ParseException {
		List<Long> reportTypeList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L);
		for (Long long1 : reportTypeList) {
			System.out.println(long1);
		}

	}

	// 合并两个map
	@Test
	public void test5() throws ParseException {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "张三");
		map.put("2", "李四");

		Map<String, Object> map2 = new HashMap<>();
		map2.put("3", "张三");
		map2.put("4", "李思思");
		map2.put("2", "覆盖李四");

		map.putAll(map2);

		for (String str : map.keySet()) {
			System.out.println("key:" + str);
			System.out.println("value:" + map.get(str));
			System.out.println();
		}

	}

}

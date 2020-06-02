package Java8日期时间API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年5月31日 上午10:40:14
 * @Description:
 */
public class DateTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		// 原时间
		Date startDate = s.parse("2018-04-01");
		Date entDate = s.parse("2018-04-30");
		// 需要复制的年份和月份
		Long newYearId = 2019L;
		Long newMonthId = 2L;

		Calendar cal = Calendar.getInstance();
		cal.setTime(entDate);// 设置结束时间
		// 判断结束时间的天数是否是当前月最后一天
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);// 当前设置时间月份的最后一天
		int day = cal.get(Calendar.DATE);// 当前设置时间的天数
		// 保存周期起点时间
		cal.setTime(startDate);// 设置起点时间
		cal.set(Calendar.YEAR, newYearId.intValue());// 修改起点时间年份
		cal.set(Calendar.MONTH, (newMonthId.intValue() - 1));// 修改起点月份
		System.out.println("复制后周期的起点时间：" + s.format(cal.getTime()));
		// newRiverPlanPeriod.setWorkStartTime(cal.getTime());
		if (lastDay == day) {
			// 获取修改后月份的最后一天
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DATE, lastDay);
		} else {
			cal.set(Calendar.DATE, day);
		}
		System.out.println("复制后周期的终点时间：" + s.format(cal.getTime()));

	}

}

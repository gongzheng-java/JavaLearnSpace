package 时间差精确到秒数;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.Interval;
import org.joda.time.Period;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 *
 * @Author: gongZheng
 * @Date:   2020年1月14日   下午11:17:53 
 * @Description:
 */
public class TimeDiff {
	public static void main(String[] args) {
		TimeDiff dutil = new TimeDiff();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

		Date date1;
		try {
			date1 = simpleDateFormat.parse("14/01/2020 11:30:10");
			Date date2 = simpleDateFormat.parse("15/01/2020 11:35:55");
			dutil.diff(date1, date2);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

	}

	private void diff(Date date1, Date date2) throws java.text.ParseException {

		Interval interval = new Interval(date1.getTime(), date2.getTime());
		Period period = interval.toPeriod();

		String timeStr = period.getHours() + ":" + period.getMinutes() + ":" + period.getSeconds();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		
		Date date = simpleDateFormat.parse(timeStr);
		String timeDiffStr =simpleDateFormat.format(date);
		
		System.out.println(timeDiffStr);

//		System.out.printf("%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", period.getYears(),
//				period.getMonths(), period.getDays(), period.getHours(), period.getMinutes(), period.getSeconds());

	}
	
	/**
	 * 获取两个时间差 精确到时分秒
	 * 缺陷 当时差超过一天时，不能按照小时计算，比如 时差25小时5分3秒 会计算成 1天1时5分3秒
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String getDiffTime(Date date1, Date date2) {
		
		return "";
	}

}

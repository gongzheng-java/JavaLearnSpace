package ����֮����������;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��10��18�� ����4:20:26
 * @Description:
 */
public class IntervalTime {

	public static void main(String[] args) {
		String dateStr = "2018-10-1 1:21:28";
		String dateStr2 = "2018-10-18 1:21:28";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2 = format.parse(dateStr2);
			Date date = format.parse(dateStr);

			System.out.println("�������ڵĲ�ࣺ" + differentDays(date, date2));
			System.out.println("�������ڵĲ�ࣺ" + differentDaysByMillisecond(date, date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * date2��date1�������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // ͬһ��
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // ����
				{
					timeDistance += 366;
				} else // ��������
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // ��ͬ��
		{
			System.out.println("�ж�day2 - day1 : " + (day2 - day1));
			return day2 - day1;
		}
	}

	/**
	 * ͨ��ʱ����������ж�����ʱ��ļ��
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDaysByMillisecond(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

}

package 可视化日历;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 可视化日历
 * 
 * @Author: gongZheng
 * @Date: 2019年5月14日 下午8:25:00
 * @Description:
 */
public class VisualCalendar {
	public static void main(String[] args) {
		// 指定一个时间，后期改为手动输入
		Scanner input = new Scanner(System.in);
		//input.hasNextInt();
		// System.out.print("请输入日期(格式 yyyy-MM-dd)：");
		String dateStr = "2019-5-13";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		
		try {
			date = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			date=new Date();
			cal.setTime(date);
			// 获取当前月份最大天数
			int maxDay = cal.getActualMaximum(cal.DATE);// 或者是cal.getActualMaximum(cal.DAY_OF_MONTH);
			// 设置当前月份第一天
			cal.set(cal.DAY_OF_MONTH, 1);
			// 获取月份第一天是周几
			int weekDay = cal.get(cal.DAY_OF_WEEK) - 1;// 周日是1，周六是7
			System.out.println("当前月份天数：" + maxDay);
			System.out.println("当前月份第一天是周几：" + weekDay);

			System.out.println("一\t二\t三\t四\t五\t六\t日");
			for (int i = 0; i < weekDay - 1; i++) {
				System.out.print("\t");
			}
			// 获取当前日期数
			cal.setTime(new Date());// 设置当前日期
			int nowDay = cal.get(cal.DAY_OF_MONTH);
			for (int i = 1; i <= maxDay; i++) {
				// 判断是否是当前日期，如果是则标出
				if (nowDay == i)
					System.out.print("[" + i + "]" + "\t");
				else
					System.out.print(i + "\t");

				if ((i + (weekDay - 1)) % 7 == 0) {
					System.out.println();
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}

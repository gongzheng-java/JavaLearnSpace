package ���ӻ�����;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ���ӻ�����
 * 
 * @Author: gongZheng
 * @Date: 2019��5��14�� ����8:25:00
 * @Description:
 */
public class VisualCalendar {
	public static void main(String[] args) {
		// ָ��һ��ʱ�䣬���ڸ�Ϊ�ֶ�����
		Scanner input = new Scanner(System.in);
		//input.hasNextInt();
		// System.out.print("����������(��ʽ yyyy-MM-dd)��");
		String dateStr = "2019-5-13";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		
		try {
			date = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			date=new Date();
			cal.setTime(date);
			// ��ȡ��ǰ�·��������
			int maxDay = cal.getActualMaximum(cal.DATE);// ������cal.getActualMaximum(cal.DAY_OF_MONTH);
			// ���õ�ǰ�·ݵ�һ��
			cal.set(cal.DAY_OF_MONTH, 1);
			// ��ȡ�·ݵ�һ�����ܼ�
			int weekDay = cal.get(cal.DAY_OF_WEEK) - 1;// ������1��������7
			System.out.println("��ǰ�·�������" + maxDay);
			System.out.println("��ǰ�·ݵ�һ�����ܼ���" + weekDay);

			System.out.println("һ\t��\t��\t��\t��\t��\t��");
			for (int i = 0; i < weekDay - 1; i++) {
				System.out.print("\t");
			}
			// ��ȡ��ǰ������
			cal.setTime(new Date());// ���õ�ǰ����
			int nowDay = cal.get(cal.DAY_OF_MONTH);
			for (int i = 1; i <= maxDay; i++) {
				// �ж��Ƿ��ǵ�ǰ���ڣ����������
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

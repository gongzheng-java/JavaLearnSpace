package Java8����ʱ��API;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��4��22�� ����8:30:27
 * @Description:
 */
public class Java8Tester {
	public static void main(String[] args) {

		Date day = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(df.format(day));

		// java8֮ǰ��ȡ��ǰʱ��
		/*
		 * System.out.println(new Date().toLocaleString());
		 * 
		 * System.out.println(
		 * "=================================================="); // ��ȡ����ʱ��
		 * LocalDateTime currentime = LocalDateTime.now(); int num
		 * =currentime.getYear(); System.out.println("��ǰʱ�䣺" + currentime);
		 * System.out.println("�ꡢ�¡��գ�"+currentime.toLocalDate());
		 * System.out.println("ʱ���֡��룺"+currentime.toLocalTime());
		 * System.out.println("�꣺"+currentime.getYear());
		 * System.out.println("��(Ӣ��)��"+currentime.getMonth());
		 * System.out.println("��(����)��"+currentime.getMonthValue());
		 * System.out.println("�գ�"+currentime.getDayOfMonth());
		 * System.out.println("ʱ��"+currentime.getHour());
		 * System.out.println("�֣�"+currentime.getMinute());
		 * System.out.println("�룺"+currentime.getSecond());
		 * System.out.println("��ǰ�ܼ���Ӣ�ģ�"+currentime.getDayOfWeek());
		 * System.out.println(
		 * "========================================================================="
		 * );
		 */
		// ����1�������ա�2������һ��3�����ڶ���4����������5�������ġ�6�������塢7�������� RiverJobService.java:265
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDate = s.format(cal.getTime()); // ��ǰ����
		System.out.println("Calendar��ǰʱ�䣺" + curDate);
		System.out.println("Calendar��ǰ�ܼ�(����)��" + (cal.get(Calendar.DAY_OF_WEEK) - 1));// ������1��������7
		System.out.println("Calendar��ǰ�·�(����)��" + (cal.get(Calendar.MONTH) + 1));// �·���0~11
		System.out.println("Calendar��ǰ��������" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar��ǰ��ݣ�" + cal.get(Calendar.YEAR));
		System.out.println("Calendar��һ��ݣ�" + (cal.get(Calendar.YEAR) - 1));
		System.out.println("��ǰ�·����һ�죺" + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		// ���õ�ǰʱ��Ϊ�������һ��
		cal.set(cal.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String curDate1 = s.format(cal.getTime()); // ��ǰ����
		System.out.println("Calendar��ǰʱ�䣺" + curDate1);
		System.out.println("����Calendar��ǰ�ܼ�(����)��" + (cal.get(Calendar.DAY_OF_WEEK) - 1));
		System.out.println("��ǰСʱ��(24Сʱ��)��" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("��ǰСʱ��(12Сʱ��)��" + cal.get(Calendar.HOUR));

		cal.set(cal.DAY_OF_MONTH, 1);

		// ����ʱ��Ϊ����12����
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		System.out.println("���ú��ʱ�䣺" + s.format(cal.getTime()));

		System.out.println("-----------");
		cal.add(Calendar.HOUR_OF_DAY, 0);
		System.out.println("��ǰʱ���֮ǰ��֮��Сʱ��(24Сʱ��)��" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("-----------");
		int month = cal.get(Calendar.MONTH) + 1;
		Long monthLong = (long) month;
		System.out.println("��ǰ�·� or (תLong����)��" + month + " / " + monthLong);
		String[] months = { "һ��", "����", "����", "����", "����", "����", "����", "����", "����", "ʮ��", "ʮһ��", "ʮ����" };
		Calendar rightNow = Calendar.getInstance();
		System.out.println(months[rightNow.get(Calendar.MONTH)]);

	}

}

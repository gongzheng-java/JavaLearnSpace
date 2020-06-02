package ʱ����ش���;

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
 * @Date: 2018��8��23�� ����4:02:46
 * @Description:
 */
public class TestDate {

	@Test
	void te() {
		System.out.println("123");
	}

	private static Calendar cal = Calendar.getInstance();

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ

	// ���õ�ǰʱ�������գ���ȡ��ǰ��һ��ʱ��
	@Test
	void test() throws ParseException {
		// ����ָ��ĳ������ʱ��Ϊ��ǰʱ��
		String dateStr = "2018-08-26 00:00:00";
		Date date = sdf.parse(dateStr);
		cal.setTime(date);
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH) + 1;// �·� 0~11
		// ������һʱ��
		cal.add(Calendar.DATE, -6);

		System.out.println("��һʱ���ǣ�" + sdf.format(cal.getTime()));
		System.out.println("��ǰ��ݣ�" + year);
		System.out.println("��ǰ�·ݣ�" + month);
		System.out.println("��ǰ��һ��ʱ�䣺" + cal.get(cal.DAY_OF_WEEK));// ������1��������7
		System.out.println("��ǰ��������µĵڼ��ܣ�" + cal.get(cal.DAY_OF_WEEK_IN_MONTH));

	}

	/**
	 * ����ָ��ʱ�䣬��ȡָ��ʱ����һ�����յ�ʱ��
	 */
	@Test
	void test1() {
		// ����
		Date date = new Date();

		cal.setTime(date);
		// �ж�Ҫ����������Ƿ������գ���������һ����������ģ����������⣬���㵽��һ��ȥ��
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// ��õ�ǰ������һ�����ڵĵڼ���
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		System.out.println("Ҫ��������Ϊ:" + sdf.format(cal.getTime())); // ���Ҫ��������
		// ����һ�����ڵĵ�һ�죬���й���ϰ��һ�����ڵĵ�һ��������һ
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// ��õ�ǰ������һ�����ڵĵڼ���
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// ���������Ĺ��򣬸���ǰ���ڼ�ȥ���ڼ���һ�����ڵ�һ��Ĳ�ֵ
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(cal.getTime());
		System.out.println("����������һ�����ڣ�" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(cal.getTime());
		System.out.println("�����������յ����ڣ�" + imptimeEnd);
	}

	/**
	 * ��������ʱ���
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test
	void test2() throws InterruptedException, ParseException {
		Date startTime = sdf.parse("2018-09-28 22:42:06");
		Date endTime = sdf.parse("2018-09-28 23:01:46");

		long time = endTime.getTime() - startTime.getTime();
		System.out.println("ʱ�" + time);
		System.out.println("ʱ��룩��" + time / 1000);
		double time1 = time / (1000 * 60);
		double time2 = time / (1000 * 60);
		System.out.println("ʱ����ӣ���" + time1 + " <> " + time2);
		double time3 = time / (1000 * 60 * 60 * 1.0);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("ʱ�Сʱ����" + time3);
		System.out.println("ʱ�Сʱ �������룩��" + df.format(time3));

	}

	/**
	 * ����ʱ��
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

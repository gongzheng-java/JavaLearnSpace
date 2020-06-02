package Java8����ʱ��API;

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
 * @Date: 2018��6��14�� ����11:06:16
 * @Description:
 */
public class CalendarTest {

	// ��ˮ������ʩͳ�Ʊ���
	@Test
	public void test() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		Date endTime = dateFormat.parse("2019-07-01 00:00:00");// ��ʱ����ʱ��
		cal.setTime(endTime);
		cal.add(Calendar.DAY_OF_MONTH, -1);// ����ʱ��Ϊ�����µ�
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		System.out.println(dateFormat.format(cal.getTime()));

	}

	// double�������ݾ�ȷ��
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

	// ��ǰʱ�����ܼ�
	@Test
	public void test2() {
		Calendar cal = Calendar.getInstance();
		System.out.println("��ǰ��ݣ�" + cal.get(Calendar.YEAR));
		System.out.println("��ǰ�·ݣ�" + cal.get(Calendar.MONTH));// �·���0~11����Ӧ1~12�·�
		System.out.println("��ǰ��������" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("��ǰ�ܼ���" + cal.get(Calendar.DAY_OF_WEEK));// ������1��������7
		System.out.println("��ǰСʱ����" + cal.get(Calendar.HOUR_OF_DAY));

		String aString = "404ce4a13e794555aa976b1c556e1732";
		System.out.println("�ַ������ȣ�" + aString.length());
	}

	@Test
	public void test3() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date endTime = dateFormat.parse("2019-01-01 02:00:00");// ��ʱ����ʱ��
		Calendar cal = Calendar.getInstance();
		cal.setTime(endTime);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String time = dateFormat.format(cal.getTime());
		System.out.println("��ǰʱ���ǣ�" + time);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("��ǰ�·ݣ�" + month);

	}

	@Test
	public void test4() throws ParseException {
		List<Long> reportTypeList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L);
		for (Long long1 : reportTypeList) {
			System.out.println(long1);
		}

	}

	// �ϲ�����map
	@Test
	public void test5() throws ParseException {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "����");
		map.put("2", "����");

		Map<String, Object> map2 = new HashMap<>();
		map2.put("3", "����");
		map2.put("4", "��˼˼");
		map2.put("2", "��������");

		map.putAll(map2);

		for (String str : map.keySet()) {
			System.out.println("key:" + str);
			System.out.println("value:" + map.get(str));
			System.out.println();
		}

	}

}

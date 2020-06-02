package Java8����ʱ��API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��5��31�� ����10:40:14
 * @Description:
 */
public class DateTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		// ԭʱ��
		Date startDate = s.parse("2018-04-01");
		Date entDate = s.parse("2018-04-30");
		// ��Ҫ���Ƶ���ݺ��·�
		Long newYearId = 2019L;
		Long newMonthId = 2L;

		Calendar cal = Calendar.getInstance();
		cal.setTime(entDate);// ���ý���ʱ��
		// �жϽ���ʱ��������Ƿ��ǵ�ǰ�����һ��
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);// ��ǰ����ʱ���·ݵ����һ��
		int day = cal.get(Calendar.DATE);// ��ǰ����ʱ�������
		// �����������ʱ��
		cal.setTime(startDate);// �������ʱ��
		cal.set(Calendar.YEAR, newYearId.intValue());// �޸����ʱ�����
		cal.set(Calendar.MONTH, (newMonthId.intValue() - 1));// �޸�����·�
		System.out.println("���ƺ����ڵ����ʱ�䣺" + s.format(cal.getTime()));
		// newRiverPlanPeriod.setWorkStartTime(cal.getTime());
		if (lastDay == day) {
			// ��ȡ�޸ĺ��·ݵ����һ��
			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DATE, lastDay);
		} else {
			cal.set(Calendar.DATE, day);
		}
		System.out.println("���ƺ����ڵ��յ�ʱ�䣺" + s.format(cal.getTime()));

	}

}

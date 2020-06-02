package test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月12日 下午10:39:04
 * @Description:
 */
public class Name {
	private static Calendar cal = Calendar.getInstance();

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	@Test
	public void test() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		StringBuffer preReportCode = new StringBuffer("xx").append(localDateTime.format(dateTimeFormatter));
		System.out.println(preReportCode);

	}
	
	/**
	 * 获取文件名
	 */
	@Test
	public void test2() {
		String filePath="C:/Users/custser/export/excel/留言201909122196.xls";
		int lastIndex = filePath.lastIndexOf("/");
		System.out.println(lastIndex);
        String string= filePath.substring(lastIndex+1);
        System.out.println(string);

	}
	
	

}

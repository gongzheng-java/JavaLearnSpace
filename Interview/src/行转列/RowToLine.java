package 行转列;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 百度复制
 * 
 * @Author: gongZheng
 * @Date: 2019年2月21日 下午8:37:19
 * @Description:
 */
public class RowToLine {
	public static void main(String[] args)
			throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// 你提供的对象列表，需要转换的原数据
		/*
		 * List<StudentGrand> StudentGrandList = new ArrayList<>();
		 * getStudentGrandList(StudentGrandList);
		 */
		List<StudentGrand> StudentGrandList = getStudentGrandList();
		// 实现行转列的算法
		List<List<String>> convertedTable = convert(StudentGrandList);
		// 打印转换后的集合，查看结果
		print(convertedTable);
		// 剩下的可以根据实际需求，将转换好的集合传给前端、或随意处理
	}

	private static List<List<String>> convert(List<StudentGrand> StudentGrandList)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {

		// getDeclaredFields():
		// 获取类中所有的属性(public、protected、default、private)，但不包括继承的属性，返回 Field
		// 对象的一个数组
		Field[] declaredFields = StudentGrand.class.getDeclaredFields();

		List<List<String>> convertedTable = new ArrayList<List<String>>();

		// 多少个属性表示多少行，遍历行
		for (Field field : declaredFields) {
			System.out.println(field.getName());
			field.setAccessible(true);// 设置为true表示在用反射时访问私有变量
			ArrayList<String> rowLine = new ArrayList<String>();
			// 每一行的第一列对应StudentGrand字段名
			// 所以新table的第一列要设置为字段名
			rowLine.add(field.getName());
			// list<T>多少个StudentGrand实体类表示有多少列，遍历列
			for (int i = 0; i < StudentGrandList.size(); i++) {

				// 新table从第二列开始，某一列的某个值对应旧table第一列的某个字段

				StudentGrand StudentGrand = StudentGrandList.get(i);
				// grand为int会报错  field的get(Objectobj)返回指定对象obj上此 Field表示的字段的值
				String val = (String) field.get(StudentGrand);

				// System.out.println(val);
				rowLine.add(val);
			}

			convertedTable.add(rowLine);
		}
		return convertedTable;
	}

	// 测试用数据，实际应该从数据库查询，传过来的
	private static List<StudentGrand> getStudentGrandList() {
		List<StudentGrand> list = new ArrayList<StudentGrand>();
		list.add(new StudentGrand("001", "toni", "语文", "98"));
		list.add(new StudentGrand("001", "toni", "数学", "98"));
		list.add(new StudentGrand("001", "toni", "外语", "98"));
		list.add(new StudentGrand("001", "toni", "体育", "98"));
		list.add(new StudentGrand("006", "amy", "语文", "98"));
		list.add(new StudentGrand("006", "amy", "数学", "98"));
		list.add(new StudentGrand("006", "amy", "外语", "98"));
		list.add(new StudentGrand("006", "amy", "体育", "98"));
		list.add(new StudentGrand("003", "安东尼", "语文", "98"));
		list.add(new StudentGrand("003", "安东尼", "数学", "98"));
		list.add(new StudentGrand("003", "安东尼", "外语", "98"));
		list.add(new StudentGrand("003", "安东尼", "体育", "98"));
		return list;
	}

	// 打印查看结果
	private static void print(List<List<String>> convertedTable) {
		// String json = JSONArray.formObject(convertedTable).toString();
		for (List<String> list : convertedTable) {
			for (String string : list) {
				System.out.print(string + "  ");
			}
			System.out.println();
		}
	}

}

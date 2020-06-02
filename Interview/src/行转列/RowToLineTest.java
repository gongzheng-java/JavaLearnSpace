package 行转列;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月22日 上午10:06:41
 * @Description:
 */
public class RowToLineTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// 初始化数据
		List<StudentGrand> stuList = getData();
		// 转换
		List<List<String>> resultList = rowLineConver(stuList);
		// 输出
		print(resultList);

	}

	public static void print(List<List<String>> resultList) {
		for (List<String> list : resultList) {
			for (String str : list) {
				System.out.print(str + "   ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> rowLineConver(List<StudentGrand> list)
			throws IllegalArgumentException, IllegalAccessException {
		List<List<String>> resultList = new ArrayList<>();
		// 通过反射获取累中所有的属性
		Class c = StudentGrand.class;
		// 获取类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段
		Field[] fields = c.getDeclaredFields();

		for (Field field : fields) {
			List<String> str = new ArrayList<>();
			// 获取属性名，放在第一个位置
			str.add(field.getName());
			// 打开私有访问
			field.setAccessible(true);
			// 遍历获取每个属性所对应的的值
			for (int i = 0; i < list.size(); i++) {
				StudentGrand sGrand = list.get(i);
				str.add((String) field.get(sGrand));
			}

			resultList.add(str);
		}

		return resultList;

	}

	public static List<StudentGrand> getData() {
		List<StudentGrand> list = new ArrayList<StudentGrand>();
		list.add(new StudentGrand("001", "张三", "语文", "10"));
		list.add(new StudentGrand("001", "张三", "数学", "10"));
		list.add(new StudentGrand("001", "张三", "英语", "10"));

		list.add(new StudentGrand("002", "李四", "语文", "20"));
		list.add(new StudentGrand("002", "李四", "数学", "20"));
		list.add(new StudentGrand("002", "李四", "英语", "20"));

		list.add(new StudentGrand("003", "王五", "语文", "30"));
		list.add(new StudentGrand("003", "王五", "数学", "30"));
		list.add(new StudentGrand("003", "王五", "英语", "30"));
		return list;
	}

}

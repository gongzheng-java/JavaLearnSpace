package ��ת��;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��22�� ����10:06:41
 * @Description:
 */
public class RowToLineTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// ��ʼ������
		List<StudentGrand> stuList = getData();
		// ת��
		List<List<String>> resultList = rowLineConver(stuList);
		// ���
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
		// ͨ�������ȡ�������е�����
		Class c = StudentGrand.class;
		// ��ȡ���ӿ��������������ֶΡ�����������������Ĭ�ϣ��������ʺ�˽���ֶΣ����������̳е��ֶ�
		Field[] fields = c.getDeclaredFields();

		for (Field field : fields) {
			List<String> str = new ArrayList<>();
			// ��ȡ�����������ڵ�һ��λ��
			str.add(field.getName());
			// ��˽�з���
			field.setAccessible(true);
			// ������ȡÿ����������Ӧ�ĵ�ֵ
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
		list.add(new StudentGrand("001", "����", "����", "10"));
		list.add(new StudentGrand("001", "����", "��ѧ", "10"));
		list.add(new StudentGrand("001", "����", "Ӣ��", "10"));

		list.add(new StudentGrand("002", "����", "����", "20"));
		list.add(new StudentGrand("002", "����", "��ѧ", "20"));
		list.add(new StudentGrand("002", "����", "Ӣ��", "20"));

		list.add(new StudentGrand("003", "����", "����", "30"));
		list.add(new StudentGrand("003", "����", "��ѧ", "30"));
		list.add(new StudentGrand("003", "����", "Ӣ��", "30"));
		return list;
	}

}

package ��ת��;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * �ٶȸ���
 * 
 * @Author: gongZheng
 * @Date: 2019��2��21�� ����8:37:19
 * @Description:
 */
public class RowToLine {
	public static void main(String[] args)
			throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// ���ṩ�Ķ����б���Ҫת����ԭ����
		/*
		 * List<StudentGrand> StudentGrandList = new ArrayList<>();
		 * getStudentGrandList(StudentGrandList);
		 */
		List<StudentGrand> StudentGrandList = getStudentGrandList();
		// ʵ����ת�е��㷨
		List<List<String>> convertedTable = convert(StudentGrandList);
		// ��ӡת����ļ��ϣ��鿴���
		print(convertedTable);
		// ʣ�µĿ��Ը���ʵ�����󣬽�ת���õļ��ϴ���ǰ�ˡ������⴦��
	}

	private static List<List<String>> convert(List<StudentGrand> StudentGrandList)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {

		// getDeclaredFields():
		// ��ȡ�������е�����(public��protected��default��private)�����������̳е����ԣ����� Field
		// �����һ������
		Field[] declaredFields = StudentGrand.class.getDeclaredFields();

		List<List<String>> convertedTable = new ArrayList<List<String>>();

		// ���ٸ����Ա�ʾ�����У�������
		for (Field field : declaredFields) {
			System.out.println(field.getName());
			field.setAccessible(true);// ����Ϊtrue��ʾ���÷���ʱ����˽�б���
			ArrayList<String> rowLine = new ArrayList<String>();
			// ÿһ�еĵ�һ�ж�ӦStudentGrand�ֶ���
			// ������table�ĵ�һ��Ҫ����Ϊ�ֶ���
			rowLine.add(field.getName());
			// list<T>���ٸ�StudentGrandʵ�����ʾ�ж����У�������
			for (int i = 0; i < StudentGrandList.size(); i++) {

				// ��table�ӵڶ��п�ʼ��ĳһ�е�ĳ��ֵ��Ӧ��table��һ�е�ĳ���ֶ�

				StudentGrand StudentGrand = StudentGrandList.get(i);
				// grandΪint�ᱨ��  field��get(Objectobj)����ָ������obj�ϴ� Field��ʾ���ֶε�ֵ
				String val = (String) field.get(StudentGrand);

				// System.out.println(val);
				rowLine.add(val);
			}

			convertedTable.add(rowLine);
		}
		return convertedTable;
	}

	// ���������ݣ�ʵ��Ӧ�ô����ݿ��ѯ����������
	private static List<StudentGrand> getStudentGrandList() {
		List<StudentGrand> list = new ArrayList<StudentGrand>();
		list.add(new StudentGrand("001", "toni", "����", "98"));
		list.add(new StudentGrand("001", "toni", "��ѧ", "98"));
		list.add(new StudentGrand("001", "toni", "����", "98"));
		list.add(new StudentGrand("001", "toni", "����", "98"));
		list.add(new StudentGrand("006", "amy", "����", "98"));
		list.add(new StudentGrand("006", "amy", "��ѧ", "98"));
		list.add(new StudentGrand("006", "amy", "����", "98"));
		list.add(new StudentGrand("006", "amy", "����", "98"));
		list.add(new StudentGrand("003", "������", "����", "98"));
		list.add(new StudentGrand("003", "������", "��ѧ", "98"));
		list.add(new StudentGrand("003", "������", "����", "98"));
		list.add(new StudentGrand("003", "������", "����", "98"));
		return list;
	}

	// ��ӡ�鿴���
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

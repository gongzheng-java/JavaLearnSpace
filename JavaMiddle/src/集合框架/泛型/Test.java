package ���Ͽ��.����;

import ���Ͽ��.����.����.MethodTest;
import ���Ͽ��.����.��ͨ��.Student;
import ���Ͽ��.����.��ͨ��.Student2;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��8��5�� ����7:41:52
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
    //û�з��Ϳ��Դ���κ�ֵ��ȡֵʱ��Ҫת��
	Student s1=new Student(12, "12.3");
	//ʹ�÷��ͣ�ָ���������͸�ֵ������������ǿת
	Student2<String, Integer> s2=new Student2<String, Integer>("����", 89);
	Student2<String, String> s3=new Student2<String, String>("����", "����");
	
	MethodTest method= new MethodTest();
	method.test("����");
	
	}

}

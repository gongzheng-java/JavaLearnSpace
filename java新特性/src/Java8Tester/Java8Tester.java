package Java8Tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ʹ��java7 �� java8 �Լ�������
 * @Author: gongZheng
 * @Date: 2018��4��21�� ����5:41:05
 * @Description:
 */
public class Java8Tester {
	
	
	   
	public static void main(String[] args) {
		

		List<String> names1 = new ArrayList<String>();
		names1.add("a ");
		names1.add("e ");
		names1.add("b ");
		names1.add("d ");
		names1.add("c ");

		List<String> names2 = new ArrayList<String>();
		names2.add("C ");
		names2.add("D ");
		names2.add("A ");
		names2.add("E ");
		names2.add("B ");
		
		Java8Tester tester = new Java8Tester();
		System.out.println("ʹ��java7  �﷨��");
		tester.sortUsingJava7(names1);
		System.out.println(names1);
		
		System.out.println("java8�﷨��");
		tester.sortUsingJava8(names2);
		System.out.println(names2);
		
		
	}
	
	// ʹ�� java 7 ����
	   private void sortUsingJava7(List<String> names){   
	      Collections.sort(names, new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	         }
	      });
	   }
	   
	   //ʹ��java8����
	   private void sortUsingJava8(List<String> list){
		   Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
	   }
	   

}

package Java8Tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 使用java7 和 java8 对集合排序
 * @Author: gongZheng
 * @Date: 2018年4月21日 下午5:41:05
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
		System.out.println("使用java7  语法：");
		tester.sortUsingJava7(names1);
		System.out.println(names1);
		
		System.out.println("java8语法：");
		tester.sortUsingJava8(names2);
		System.out.println(names2);
		
		
	}
	
	// 使用 java 7 排序
	   private void sortUsingJava7(List<String> names){   
	      Collections.sort(names, new Comparator<String>() {
	         @Override
	         public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	         }
	      });
	   }
	   
	   //使用java8排序
	   private void sortUsingJava8(List<String> list){
		   Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
	   }
	   

}

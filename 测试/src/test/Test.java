package test;

import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��26�� ����10:43:37
 * @Description:
 */
public class Test {
	public static void main(String[] args) {

		/*Set<String> stSet = new HashSet<>();
		stSet.add("11");
		stSet.add("12");
        System.out.println(stSet.add("12"));
		for (String string : stSet) {
			System.out.println(string);
		}*/
		
		try {
			System.out.println("try it ~");
			throwSomething();
			System.out.println("after throw ~");
		} finally {
			System.out.println("finallly you get it ~");
		}
		
		
	}

	public static void throwSomething(){
		Error error=new Error("����ʱ�쳣");
		throw new RuntimeErrorException(error);
	}
}

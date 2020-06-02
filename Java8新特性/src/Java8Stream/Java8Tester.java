package Java8Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月22日   下午5:22:25 
 * @Description:
 */
public class Java8Tester {

	@Test
	public void test() {
		
		List<String> list = Arrays.asList("1one", "two", "three", "4four");
		
		//假设需要从一个字符串列表中选出以数字开头的字符串并输出，Java 7之前需要这样写：
		for (String string : list) {
			if (Character.isDigit(string.charAt(0))) { //Character.isDigit() 是判断是都是0~9的数字，返回Boolean值
				System.out.println(string);
			}
		}
		
		
		//Java 8就可以这样写：
		list.stream()// 1.得到容器的Steam
		    .filter(str -> Character.isDigit(str.charAt(0)))// 2.选出以数字开头的字符串
		    .forEach(str -> System.out.println(str));// 3.输出字符串
		
		
	}
	
	@Test
	public void test2() {
		//假设需要从一个字符串列表中，选出所有不以数字开头的字符串，将其转换成大写形式，并把结果放到新的集合当中
		List<String> list = Arrays.asList("1one", "two", "three", "4four");
		Set<String> newlist=list.stream()
				            .filter(str->!Character.isDigit(str.charAt(0)))
				            .map(String::toUpperCase)
				            .collect(Collectors.toSet());
		
		
	}

}

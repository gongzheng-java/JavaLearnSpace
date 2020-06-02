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
 * @Date:   2018��4��22��   ����5:22:25 
 * @Description:
 */
public class Java8Tester {

	@Test
	public void test() {
		
		List<String> list = Arrays.asList("1one", "two", "three", "4four");
		
		//������Ҫ��һ���ַ����б���ѡ�������ֿ�ͷ���ַ����������Java 7֮ǰ��Ҫ����д��
		for (String string : list) {
			if (Character.isDigit(string.charAt(0))) { //Character.isDigit() ���ж��Ƕ���0~9�����֣�����Booleanֵ
				System.out.println(string);
			}
		}
		
		
		//Java 8�Ϳ�������д��
		list.stream()// 1.�õ�������Steam
		    .filter(str -> Character.isDigit(str.charAt(0)))// 2.ѡ�������ֿ�ͷ���ַ���
		    .forEach(str -> System.out.println(str));// 3.����ַ���
		
		
	}
	
	@Test
	public void test2() {
		//������Ҫ��һ���ַ����б��У�ѡ�����в������ֿ�ͷ���ַ���������ת���ɴ�д��ʽ�����ѽ���ŵ��µļ��ϵ���
		List<String> list = Arrays.asList("1one", "two", "three", "4four");
		Set<String> newlist=list.stream()
				            .filter(str->!Character.isDigit(str.charAt(0)))
				            .map(String::toUpperCase)
				            .collect(Collectors.toSet());
		
		
	}

}

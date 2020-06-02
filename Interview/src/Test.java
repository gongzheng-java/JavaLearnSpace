import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.plaf.multi.MultiButtonUI;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月6日 下午12:43:28
 * @Description: 
*/
public class Test {

	
	@org.junit.Test
	public void test() {
		String str="kaqidxdxosxsoalddlax";
		char[] charStr=str.toCharArray();
		TreeMap<Character, Integer> treeMap=new TreeMap<>();
		for (char c : charStr) {
		Integer value=	treeMap.get(c);
		if(value==null) {
			treeMap.put(c, 1);
		}else {
			value++;
			treeMap.put(c, value);
		}
			//输出
		for (char d : treeMap.keySet()) {
			System.out.println(d+"--->"+treeMap.get(d));
		}
		}
	}
	
	@org.junit.Test
	public void test1() {
		char xiaoxie='a';
		char A='A';
		System.out.println((int)xiaoxie);
		System.out.println((int)A);
		
		for (int i = 0; i < 26; i++) {
			System.out.println(xiaoxie+"---"+A);
			xiaoxie++;
			A++;
		}
	}
	
	@org.junit.Test
	public void test2() {
	
	}

}

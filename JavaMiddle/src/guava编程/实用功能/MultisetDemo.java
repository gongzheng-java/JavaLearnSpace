package guava编程.实用功能;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 使用 Multiset 统计单词出现的次数
 * 
 * @Author: gongZheng
 * @Date: 2019年8月29日 下午9:43:22
 * @Description:
 */
public class MultisetDemo {
	public static void main(String[] args) {
		String str = "Studies serve for delight for ornament and for ability Their chief use for delight";
		String[] strs = str.split(" ");
		Multiset<String> multiset = HashMultiset.create();
		for (String strTemp : strs) {
			multiset.add(strTemp);
		}

		// 获取所有单词的set,set没有重复值，相当于获取了map方式中的所有的key
		Set<String> set = multiset.elementSet();
		for (String word : set) {
			System.out.println(word + "---->" + multiset.count(word)+"次");
		}
	}

}

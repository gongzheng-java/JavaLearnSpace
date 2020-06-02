package guava���.ʵ�ù���;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * ʹ�� Multiset ͳ�Ƶ��ʳ��ֵĴ���
 * 
 * @Author: gongZheng
 * @Date: 2019��8��29�� ����9:43:22
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

		// ��ȡ���е��ʵ�set,setû���ظ�ֵ���൱�ڻ�ȡ��map��ʽ�е����е�key
		Set<String> set = multiset.elementSet();
		for (String word : set) {
			System.out.println(word + "---->" + multiset.count(word)+"��");
		}
	}

}

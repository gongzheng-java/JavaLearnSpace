package 统计字母出现的次数;

import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月20日 下午9:20:10
 * @Description: 1：首先它是一个字符串,但是要对每个字符进行分析它出现的次数,那么肯定是要进行循环遍历,要进行遍历一般要么是集合,要么是数组,
 *               而在这里变成数组比较好,
 * 
 *               2:变成数组后,我们可以用一个map集合存储字符和出现的次数也就是说key是Character,value是Integer,
 *               然后在遍历的时候拿key获取value值进行判断如果value是null,就表示集合中没有这字符次数就是1,
 *               如果不为null就代表集合中有这字符,出现次数就是++，然后再存储到集合中
 * 
 *               3：做完上述操作后就遍历集合,但是用什么集合比较好呢,我们发现它要求输出的结果是a,b,c这种按字典顺序,
 *               map集合有此功能的可以用TreeMap
 * 
 */
public class MapDemo {
	public static void main(String[] args) {
		String str = "aababcabcdabcde";
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		char[] chs = str.toCharArray();
		for (Character ch : chs) {
			Integer value = map.get(ch);
			if (value == null) {
				map.put(ch, 1);
			} else {
				value++;
				map.put(ch, value);
			}
		}

		Set<Character> set = map.keySet();
		StringBuilder sb = new StringBuilder();
		for (Character s : set) {
			Integer value = map.get(s);
			sb.append(s).append("(").append(value).append(")");
		}

		System.out.println(sb.toString());
	}

}

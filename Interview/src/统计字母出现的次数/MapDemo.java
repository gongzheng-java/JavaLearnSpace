package ͳ����ĸ���ֵĴ���;

import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��20�� ����9:20:10
 * @Description: 1����������һ���ַ���,����Ҫ��ÿ���ַ����з��������ֵĴ���,��ô�϶���Ҫ����ѭ������,Ҫ���б���һ��Ҫô�Ǽ���,Ҫô������,
 *               ��������������ȽϺ�,
 * 
 *               2:��������,���ǿ�����һ��map���ϴ洢�ַ��ͳ��ֵĴ���Ҳ����˵key��Character,value��Integer,
 *               Ȼ���ڱ�����ʱ����key��ȡvalueֵ�����ж����value��null,�ͱ�ʾ������û�����ַ���������1,
 *               �����Ϊnull�ʹ������������ַ�,���ִ�������++��Ȼ���ٴ洢��������
 * 
 *               3����������������ͱ�������,������ʲô���ϱȽϺ���,���Ƿ�����Ҫ������Ľ����a,b,c���ְ��ֵ�˳��,
 *               map�����д˹��ܵĿ�����TreeMap
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

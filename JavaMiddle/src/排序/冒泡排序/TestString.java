package 排序.冒泡排序;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年8月20日 下午8:45:45
 * @Description:对string类型数组排序
 */
public class TestString {
	public static void main(String[] args) {
     String[] str={"anc","abc","abg","abf"};
     String temp;
     for (int i = 0; i < str.length; i++) {
		for (int j = 0; j < str.length-i-1; j++) {
			if ((str[j].compareTo(str[j+1]))>0) {
				temp=str[j];
				str[j]=str[j+1];
				str[j+1]=temp;
			}
		}
	}
     
     System.out.println(Arrays.toString(str));
     
	}
}

package ����.ð������;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��8��20�� ����8:45:45
 * @Description:��string������������
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

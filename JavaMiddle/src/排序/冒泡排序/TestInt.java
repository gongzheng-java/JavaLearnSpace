package ����.ð������;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��8��19��   ����8:44:40 
 * @Description:��int��������
 */
public class TestInt {

	public static void main(String[] args) {
		int[] num={5,4,3,2}; 
		int temp;
		for(int i=0;i<num.length-1;i++){
			for(int j=0;j<num.length-i-1;j++ ){
				if (num[j]>num[j+1]) {
					 temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
				
			}
		}
		
		System.out.println(Arrays.toString(num));

	}

}

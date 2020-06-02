package 排序.冒泡排序;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年8月19日   下午8:44:40 
 * @Description:对int数组排序
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

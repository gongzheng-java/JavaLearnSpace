package ð������;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��12�� ����6:16:49
 * @Description:
 */
public class Test {
	public static void main(String[] args) {

		int[] num = { 9, 5, 1, 6, 2, 8, 3, 0, 4, 7 };
		System.out.println("����ǰ��");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		/*
		 * System.out.println(); for (int i : num) { System.out.print(i + "\t");
		 * }
		 */
		System.out.println();

		System.out.println("ð�������");
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = 0; j < num.length - i - 1; j++) {
				if (num[j] > num[j + 1]) {
					int temp;
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
		for (int i : num) {
			System.out.print(i + "\t");
		}

	}

}

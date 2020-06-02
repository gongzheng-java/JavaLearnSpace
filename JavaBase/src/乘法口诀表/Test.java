package 乘法口诀表;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月24日 上午11:38:27
 * @Description:
 */
public class Test {
	public static void main(String[] args) {

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + (j * i) + "  ");
			}
			System.out.println();
		}

	}

}

package 递归算法;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月24日 下午12:24:08
 * @Description:阶乘算法 5！=5*4*3*2*1
 */
public class Recursion {

	/**
	 * 递归方法体
	 * 
	 * @param num
	 *            参数
	 * @return 阶乘后的计算结果
	 */
	public static long test(long num) {
		if (num == 1) {
			return 1;
		} else {
			System.out.print(num + "*");
			if (num == 2) {
				System.out.println("1");
				System.out.println();
			}
			return num * test(num - 1);
		}
	}

	public static void main(String[] args) {
		long num = 10l;
		System.out.print(num + "!=");
		System.out.println(test(num));
	}

}

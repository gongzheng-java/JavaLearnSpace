package �ݹ��㷨;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��24�� ����12:24:08
 * @Description:�׳��㷨 5��=5*4*3*2*1
 */
public class Recursion {

	/**
	 * �ݹ鷽����
	 * 
	 * @param num
	 *            ����
	 * @return �׳˺�ļ�����
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

package 循环打印26英文字母;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月26日 下午10:38:06
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		// 定义变量，保存两个字母
		char xiaoxie = 'a';
		System.out.println((int)xiaoxie);
		char daxie = 'A';
		System.out.println((int)daxie);
		
		// 定义循环，次数26次
		for (int i = 0; i < 26; i++) { // 输出保存字母的变量
			System.out.println(xiaoxie + " " + daxie);
			xiaoxie++;
			daxie++;
		}
	}
}

package string字符串;

/**
 * string 字符串
 * 
 * @Author: gongZheng
 * @Date: 2019年3月16日 下午3:11:19
 * @Description: 不可变
 */
public class Test {

	public static void main(String[] args) {
		String str = "123456789abcdefg";
		String name = "张3三";

		// 字符串替换 需要被替换的字符存在时，可以替换，否则返回原字符串
		String a2 = name.replace("3", "三");
		String a3 = name.replace("里", "三");
		System.out.println(a2);
		System.out.println(a3);
		// 判断字符串是否以某某开头
		System.out.println("是否以a开头：" + str.startsWith("a"));
		System.out.println("是否以1开头：" + str.startsWith("1"));

		// 字符串分割
		String[] strArrary = str.split("");
		System.out.print("分割后的字符串：");
		for (int i = 0; i < strArrary.length; i++) {
			System.out.print(strArrary[i] + " ");
		}

		// 忽略大小写
		System.out.println();
		String A = "ABC";
		String B = "abc";
		System.out.println(A.equalsIgnoreCase(B));
		// 大小写转换
		System.out.println("ASDCD".toLowerCase());
		System.out.println("abccdefghijklmn".toUpperCase());
	}

}

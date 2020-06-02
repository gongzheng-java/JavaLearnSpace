package string字符串.StringBuilder;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月16日 下午10:37:28
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		// 通过查看源码可知，创建下面对象时，默认字符串长度是16
		StringBuilder sBuilderA = new StringBuilder();// 默认字符长度16
		StringBuilder sBuilderB = new StringBuilder(32);// 指定字符长度32
		StringBuilder sBuilderC = new StringBuilder("abc");// 实际字符长度=赋值字符长度+16

		System.out.println(sBuilderA.length());

		// 删除指定位置字符串
		StringBuilder sBuilder = new StringBuilder("abcdefghijklmn");
		sBuilder.reverse();// 字符串倒叙
		System.out.println(sBuilder);
		sBuilder.delete(3, 5);
		System.out.println("删除指定字符串后(包前不包后)：" + sBuilder);
	}

}

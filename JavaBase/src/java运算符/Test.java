package java运算符;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月23日 下午5:04:42
 * @Description: 常用的运算符在此处没有做记录。此类主要是位运算符和其他运算符
 */
public class Test {
	public static void main(String[] args) {
		// << :左移 相当于乘以2，右侧数字表示乘以几次2，如 3<<3 表示 3*2*2*2
		// >>:右移 相当于除以2，右侧数字除以几次2，如 8>>3 表示 8/2/2/2

		int a = 3 * 2 * 2 * 2;
		int aa = 3 << 3;
		int b = 12 >> 2;
		int bb = 12 >>1 ;
		System.out.println("a:" + a);
		System.out.println("aa:" + aa);
		System.out.println("b:" + b);
		System.out.println("bb:" + bb);
		
		
		//arrayList 扩容1.5倍
		int oldCapacity=6;
		
		 int newCapacity = oldCapacity + (oldCapacity >> 1);
		 System.out.println(newCapacity);
	}
}

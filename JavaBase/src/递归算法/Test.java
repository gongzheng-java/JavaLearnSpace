package 递归算法;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月24日 下午12:13:34
 * @Description:
 */
public class Test {

	public static int age = 2;

	public static int getAge() {
		age += 2;
		System.out.println("正在长两岁。。。。");
		if (age <= 16) {
			getAge();
		}
		System.out.println("已经长两岁。。。。");
		return age;
	}

	// 无论调用test1或test2 都会出现栈溢出现象
	public static void test1() {
		System.out.println("开始test1。。。。");
		test2();
		System.out.println("结束test1。。。。");
	}

	public static void test2() {
		System.out.println("开始test2。。。。");
		test1();
		System.out.println("结束test2。。。。");
	}

	public static void main(String[] args) {
		int a = getAge();
		System.out.println(a);

	}

}

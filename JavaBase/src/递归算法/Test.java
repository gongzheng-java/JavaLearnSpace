package �ݹ��㷨;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��24�� ����12:13:34
 * @Description:
 */
public class Test {

	public static int age = 2;

	public static int getAge() {
		age += 2;
		System.out.println("���ڳ����ꡣ������");
		if (age <= 16) {
			getAge();
		}
		System.out.println("�Ѿ������ꡣ������");
		return age;
	}

	// ���۵���test1��test2 �������ջ�������
	public static void test1() {
		System.out.println("��ʼtest1��������");
		test2();
		System.out.println("����test1��������");
	}

	public static void test2() {
		System.out.println("��ʼtest2��������");
		test1();
		System.out.println("����test2��������");
	}

	public static void main(String[] args) {
		int a = getAge();
		System.out.println(a);

	}

}

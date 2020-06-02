package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 
 * java������Ʋ�����
 * 
 * @Author: gongZheng
 * @Date: 2018��3��8�� ����3:13:40
 * @Description:
 */
public class ReflexTest {

	/**
	 * ������ƻ�ȡ������ַ���
	 */
	@Test
	public void test() {
		Class clazz = null;

		// 1 ֱ��ͨ������.Class�ķ�ʽ�õ�
		clazz = Person.class;
		System.out.println("ͨ������: " + clazz);
		System.out.println();

		// 2 ͨ�������getClass()������ȡ,���ʹ�õ��٣�һ���Ǵ�����Object����֪����ʲô���͵�ʱ����ã�
		Object obj = new Person();
		clazz = obj.getClass();
		System.out.println("ͨ��getClass(): " + clazz);
		System.out.println();

		// 3 ͨ��ȫ������ȡ���õıȽ϶࣬�������׳�ClassNotFoundException�쳣
		try {
			clazz = Class.forName("test.Person");
		} catch (ClassNotFoundException e) {
			System.err.println("�Ҳ�����");
			e.printStackTrace();
		}
		System.out.println("ͨ��ȫ������ȡ: " + clazz);
		System.out.println("ͨ��ȫ������ȡ: " + clazz.toString());
		System.out.println();
	}

	/**
	 * Class���newInstance()�������������һ������
	 */
	@Test
	public void testNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		Class clazz = Class.forName("test.Person");

		// ʹ��Class���newInstance()�����������һ������
		// ʵ�ʵ��õ�����Ǹ� �޲����Ĺ������������Ϊʲôд�����ʱ��Ҫдһ���޲����Ĺ����������Ǹ������õģ�
		// һ��ģ�һ�����������˴������Ĺ�������ҲҪ����һ���޲����Ĺ�����
		Object obj = clazz.newInstance();
		System.out.println(obj);

	}

	/**
	 * ClassLoader��װ����
	 */
	@Test
	public void testClassLoader1() throws ClassNotFoundException, IOException {
		// 1����ȡһ��ϵͳ���������
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println("��ȡϵͳ���������:   " + classLoader);

		// 2����ȡϵͳ��������ĸ��������(��չ���������extensions classLoader��)
		classLoader = classLoader.getParent();
		System.out.println("��ȡϵͳ��������ĸ��������:" + classLoader);

		// 3����ȡ��չ��������ĸ��������
		// ���ΪNull,�޷���Java����ֱ������
		classLoader = classLoader.getParent();
		System.out.println("��ȡ��չ��������ĸ��������:" + classLoader);

		//

		// 4�����Ե�ǰ�����ĸ�����������м��� ,�������ϵͳ���������
		classLoader = Class.forName("test.Person").getClassLoader();
		System.out.println("ǰ�����ĸ�����������м���:" + classLoader);

		// 5������JDK�ṩ��Object�����ĸ��������������ص�
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println("����JDK�ṩ��Object�����ĸ��������������ص� �� " + classLoader);

	}

	// ��ȡ����
	@Test
	public void testMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		// ��ȡ��
		Class class1 = null;
		try {
			class1 = Class.forName("test.Person");
		} catch (ClassNotFoundException e) {
			System.err.println("û���ҵ�����");
			e.printStackTrace();
		}

		// 1.��ȡ�������е�public���εķ���
		Method[] method = class1.getMethods();
		System.out.println("getMethods() ��ȡ�������е�public���εķ���:  ");
		System.out.print("\t");
		for (Method method2 : method) {
			System.out.print(method2.getName() + " ,");
		}
		System.out.println();
		System.out.println();

		// 2����ȡ�����������������з���,����˽�з���(��ǰ����û���������޷���ȡ)
		Method[] methods2 = class1.getDeclaredMethods();
		System.out.println("getDeclaredMethods() ��ȡ���������������ķ���(����˽��): ");
		System.out.print("\t");
		for (Method method1 : methods2) {
			System.out.print(method1.getName() + ", ");
		}

		System.out.println();
		// 3.��ȡ��ָ������ ��һ�������Ƿ�������������Ƿ�����Ĳ���
		Method method2 = class1.getDeclaredMethod("setName", String.class);
		System.out.println("getDeclaredMethod():" + method2);

		Method method3 = class1.getDeclaredMethod("setName", String.class, int.class);// ��һ�������Ƿ�������������Ƿ�����Ĳ���
		System.out.println("method2: " + method3);

		// 4��ִ�з�����
		Object obj = class1.newInstance();
		method2.invoke(obj, "changwen", 22);
		System.out.println(obj);

	}

}

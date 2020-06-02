package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 
 * java反射机制测试类
 * 
 * @Author: gongZheng
 * @Date: 2018年3月8日 下午3:13:40
 * @Description:
 */
public class ReflexTest {

	/**
	 * 反射机制获取类的三种方法
	 */
	@Test
	public void test() {
		Class clazz = null;

		// 1 直接通过类名.Class的方式得到
		clazz = Person.class;
		System.out.println("通过类名: " + clazz);
		System.out.println();

		// 2 通过对象的getClass()方法获取,这个使用的少（一般是传的是Object，不知道是什么类型的时候才用）
		Object obj = new Person();
		clazz = obj.getClass();
		System.out.println("通过getClass(): " + clazz);
		System.out.println();

		// 3 通过全类名获取，用的比较多，但可能抛出ClassNotFoundException异常
		try {
			clazz = Class.forName("test.Person");
		} catch (ClassNotFoundException e) {
			System.err.println("找不到类");
			e.printStackTrace();
		}
		System.out.println("通过全类名获取: " + clazz);
		System.out.println("通过全类名获取: " + clazz.toString());
		System.out.println();
	}

	/**
	 * Class类的newInstance()方法，创建类的一个对象。
	 */
	@Test
	public void testNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		Class clazz = Class.forName("test.Person");

		// 使用Class类的newInstance()方法创建类的一个对象
		// 实际调用的类的那个 无参数的构造器（这就是为什么写的类的时候，要写一个无参数的构造器，就是给反射用的）
		// 一般的，一个类若声明了带参数的构造器，也要声明一个无参数的构造器
		Object obj = clazz.newInstance();
		System.out.println(obj);

	}

	/**
	 * ClassLoader类装载器
	 */
	@Test
	public void testClassLoader1() throws ClassNotFoundException, IOException {
		// 1、获取一个系统的类加载器
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println("获取系统的类加载器:   " + classLoader);

		// 2、获取系统类加载器的父类加载器(扩展类加载器（extensions classLoader）)
		classLoader = classLoader.getParent();
		System.out.println("获取系统类加载器的父类加载器:" + classLoader);

		// 3、获取扩展类加载器的父类加载器
		// 输出为Null,无法被Java程序直接引用
		classLoader = classLoader.getParent();
		System.out.println("获取扩展类加载器的父类加载器:" + classLoader);

		//

		// 4、测试当前类由哪个类加载器进行加载 ,结果就是系统的类加载器
		classLoader = Class.forName("test.Person").getClassLoader();
		System.out.println("前类由哪个类加载器进行加载:" + classLoader);

		// 5、测试JDK提供的Object类由哪个类加载器负责加载的
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println("测试JDK提供的Object类由哪个类加载器负责加载的 ： " + classLoader);

	}

	// 获取方法
	@Test
	public void testMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 获取类
		Class class1 = null;
		try {
			class1 = Class.forName("test.Person");
		} catch (ClassNotFoundException e) {
			System.err.println("没有找到该类");
			e.printStackTrace();
		}

		// 1.获取类中所有的public修饰的方法
		Method[] method = class1.getMethods();
		System.out.println("getMethods() 获取类中所有的public修饰的方法:  ");
		System.out.print("\t");
		for (Method method2 : method) {
			System.out.print(method2.getName() + " ,");
		}
		System.out.println();
		System.out.println();

		// 2、获取加载类中声明的所有方法,包括私有方法(当前类中没有声明的无法获取)
		Method[] methods2 = class1.getDeclaredMethods();
		System.out.println("getDeclaredMethods() 获取所加载类中声明的方法(包括私有): ");
		System.out.print("\t");
		for (Method method1 : methods2) {
			System.out.print(method1.getName() + ", ");
		}

		System.out.println();
		// 3.获取类指定方法 第一个参数是方法名，后面的是方法里的参数
		Method method2 = class1.getDeclaredMethod("setName", String.class);
		System.out.println("getDeclaredMethod():" + method2);

		Method method3 = class1.getDeclaredMethod("setName", String.class, int.class);// 第一个参数是方法名，后面的是方法里的参数
		System.out.println("method2: " + method3);

		// 4、执行方法！
		Object obj = class1.newInstance();
		method2.invoke(obj, "changwen", 22);
		System.out.println(obj);

	}

}

package 集合框架.泛型;

import 集合框架.泛型.方法.MethodTest;
import 集合框架.泛型.普通类.Student;
import 集合框架.泛型.普通类.Student2;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年8月5日 下午7:41:52
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
    //没有泛型可以存放任何值，取值时需要转换
	Student s1=new Student(12, "12.3");
	//使用泛型，指定数据类型赋值，避免了数据强转
	Student2<String, Integer> s2=new Student2<String, Integer>("张三", 89);
	Student2<String, String> s3=new Student2<String, String>("李四", "语文");
	
	MethodTest method= new MethodTest();
	method.test("张三");
	
	}

}

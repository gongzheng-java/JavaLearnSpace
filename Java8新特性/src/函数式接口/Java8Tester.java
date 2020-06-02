package ����ʽ�ӿ�;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.jar.Attributes.Name;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��4��22�� ����3:33:10
 * @Description:JDK 1.8 �����ӵĺ����ӿڣ� java.util.function ����
 * 
 */
public class Java8Tester {
	
	@Test
	public void test0() {
	
	}

	//=========�Ĵ���ĺ���ʽ�ӿ�====================================
	/* T ��ʾ����   R��ʾ����ֵ
	 * 1�������ͽӿ�  Consumer<T>    ����һ������ �޷���ֵ
	 * 2�������ͼ���  Supplier<R>    �޲��� �з���ֵ
	 * 3�������ͽӿ�  Function<T,R>  ����һ������ �з���ֵ
	 * 4���϶��ͽӿ�  Predicate<T>   ����һ������ ����Boolean��ֵ
	 * */
	
	@Test
	public void test01() {
		
		/**
         * @name �����ͽӿ�
         * @use Consumer<T>
         * @param T �������
         * @fun ����һ������ �޷���ֵ
         * */
        Consumer<User> con=(str)->System.out.println(str);
        con.accept(new User());
	}
	
	
	@Test
	public void test02() {
		
		/**
         * @name �����ͽӿ�
         * @use Supplier<R>
         * @param R ����ֵ����
         * @fun �޲��� �з���ֵ
         * */
        Supplier<User> supplier =() -> new User();
        User user = supplier.get();
        System.out.println(user);
	}

	@Test
	public void test03() {
		
		  /**
         * @name �����ͽӿ�
         * @use Function<T,R>
         * @param T �������
         * @return R ����ֵ����
         * @fun ����һ������ �з���ֵ
         * */
        Function<Integer, User> function = (id) ->{
        	if (id == 1) {
				System.out.println("���user����");
				return new User();
			}else {
				System.out.println("�����user����");
				return null;
			}
			
        };
        
       User user1= function.apply(1);
       System.out.println(user1);
       User user2= function.apply(2);
       System.out.println(user2);
        
	}
	
	@Test
	public void test04() {
		
		/**
         * @name �϶��ͽӿ�
         * @use Predicate<T>
         * @param T �������
         * @return Boolean ����һ��Boolean��ֵ
         * @fun ����һ������ ����Boolean��ֵ
         * */
         Predicate<Integer> predicate =(id)->{
        	 if (id == 1) {
				return true;
			}else {
				return false;
			}
         };
         
        System.out.println("�Ƿ����idΪ1���û���"+predicate.test(1));
        System.out.println("�Ƿ����idΪ2���û���"+predicate.test(2));
	}
	
	
	//=============��������ʽ�ӿ�=================================================================
	@Test
	public void test00() {
		String code = "099";
		 int codetemp=Integer.parseInt(code.substring(code.length()-3));
		 System.out.println(codetemp);
		 
	}
	
	
	@Test
	public void test10() {
		/*BiConsumer<T,U>
		������һ������������������Ĳ��������Ҳ������κν��*/
		BiConsumer<String, String> biConsumer = (name,pwd)->System.out.println("�û���/���룺"+name+"/"+pwd);
	    biConsumer.accept("����", "1234567");
	}
	
	
	@Test
	public void test20() {
		/*BiFunction<T,U,R>
		������һ������������������ķ��������ҷ���һ�����*/
		BiFunction<Integer, String, User> biFunction =(id,name) ->{
			if (id==1 && name.equals("����")) {
				return new User();
			}else {
				return null;
			}
		};
		System.out.println(biFunction.apply(1, "����"));
		System.out.println(biFunction.apply(2, "����"));
	}
	
	
	
	
	
	
}

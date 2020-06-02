package 函数式接口;

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
 * @Date: 2018年4月22日 下午3:33:10
 * @Description:JDK 1.8 新增加的函数接口： java.util.function 包中
 * 
 */
public class Java8Tester {
	
	@Test
	public void test0() {
	
	}

	//=========四大核心函数式接口====================================
	/* T 表示参数   R表示返回值
	 * 1、消费型接口  Consumer<T>    接受一个参数 无返回值
	 * 2、供给型几口  Supplier<R>    无参数 有返回值
	 * 3、函数型接口  Function<T,R>  接受一个参数 有返回值
	 * 4、断定型接口  Predicate<T>   接受一个参数 返回Boolean型值
	 * */
	
	@Test
	public void test01() {
		
		/**
         * @name 消费型接口
         * @use Consumer<T>
         * @param T 传入参数
         * @fun 接受一个参数 无返回值
         * */
        Consumer<User> con=(str)->System.out.println(str);
        con.accept(new User());
	}
	
	
	@Test
	public void test02() {
		
		/**
         * @name 供给型接口
         * @use Supplier<R>
         * @param R 返回值类型
         * @fun 无参数 有返回值
         * */
        Supplier<User> supplier =() -> new User();
        User user = supplier.get();
        System.out.println(user);
	}

	@Test
	public void test03() {
		
		  /**
         * @name 函数型接口
         * @use Function<T,R>
         * @param T 传入参数
         * @return R 返回值类型
         * @fun 接受一个参数 有返回值
         * */
        Function<Integer, User> function = (id) ->{
        	if (id == 1) {
				System.out.println("存该user对象");
				return new User();
			}else {
				System.out.println("不存该user对象");
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
         * @name 断定型接口
         * @use Predicate<T>
         * @param T 传入参数
         * @return Boolean 返回一个Boolean型值
         * @fun 接受一个参数 返回Boolean型值
         * */
         Predicate<Integer> predicate =(id)->{
        	 if (id == 1) {
				return true;
			}else {
				return false;
			}
         };
         
        System.out.println("是否存在id为1的用户："+predicate.test(1));
        System.out.println("是否存在id为2的用户："+predicate.test(2));
	}
	
	
	//=============其他函数式接口=================================================================
	@Test
	public void test00() {
		String code = "099";
		 int codetemp=Integer.parseInt(code.substring(code.length()-3));
		 System.out.println(codetemp);
		 
	}
	
	
	@Test
	public void test10() {
		/*BiConsumer<T,U>
		代表了一个接受两个输入参数的操作，并且不返回任何结果*/
		BiConsumer<String, String> biConsumer = (name,pwd)->System.out.println("用户名/密码："+name+"/"+pwd);
	    biConsumer.accept("张三", "1234567");
	}
	
	
	@Test
	public void test20() {
		/*BiFunction<T,U,R>
		代表了一个接受两个输入参数的方法，并且返回一个结果*/
		BiFunction<Integer, String, User> biFunction =(id,name) ->{
			if (id==1 && name.equals("张三")) {
				return new User();
			}else {
				return null;
			}
		};
		System.out.println(biFunction.apply(1, "张三"));
		System.out.println(biFunction.apply(2, "张三"));
	}
	
	
	
	
	
	
}

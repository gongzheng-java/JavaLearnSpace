package Lambda拉姆达表达式.示例1;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月21日   下午10:12:57 
 * @Description: lambda表达式语法的简单介绍
 */
public class LambdaExample {
	public static void main(String[] args) {
		
		/*lambda表达式的重要特征:
			可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
			可选的参数括号：一个参数无需定义括号，但多个参数需要定义括号。
			可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
			可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。*/
		
		//遍历
		Arrays.asList("a","b","c","d","e").forEach(e -> System.out.print( e +","));
		System.out.println();
		
		//在上面这个代码中的参数e的类型是由编译器推理得出的，你也可以显式指定该参数的类型，例如：
		 String separator1 = ",";
		Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.print( e +separator1) );
		
		System.out.println();
		
		Arrays.asList( "a", "b", "d" ).forEach( e -> {
		    System.out.print( e ); //主体有多个语句，需要加{}号
		    System.out.println( e );
		} );
		
		//============================================================================================
		
		//Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同：
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator ) );
		//和
		final String separator2 = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator2 ) );
		
		//================================================================================================
		
		//Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句，下列两个代码片段效果相同：
		Arrays.asList( "a", "g", "b","d","c","e","f" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
	
		//和
		Arrays.asList( "a", "g", "b","d","c","e","f" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
	}

}

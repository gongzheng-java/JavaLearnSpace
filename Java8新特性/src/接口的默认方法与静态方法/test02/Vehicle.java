package 接口的默认方法与静态方法.test02;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月22日   下午2:19:50 
 * @Description:
 */
public interface Vehicle {
	
	 default void print2(){
	      System.out.println("我是一辆车,Vehicle!");
	   }
	 
	 default void print1(){
	      System.out.println("我是一辆车!");
	   }

}

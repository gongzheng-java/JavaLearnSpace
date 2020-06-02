package 接口的默认方法与静态方法.test02;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月22日   下午2:20:21 
 * @Description:
 */
public interface FourWheeler {
	
	 default void print2(){
	      System.out.println("我是一辆四轮车,FourWheeler!");
	   }

	

}

package �ӿڵ�Ĭ�Ϸ����뾲̬����.test02;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��22��   ����2:19:50 
 * @Description:
 */
public interface Vehicle {
	
	 default void print2(){
	      System.out.println("����һ����,Vehicle!");
	   }
	 
	 default void print1(){
	      System.out.println("����һ����!");
	   }

}

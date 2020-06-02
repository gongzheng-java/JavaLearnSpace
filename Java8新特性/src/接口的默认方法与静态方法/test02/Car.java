package 接口的默认方法与静态方法.test02;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年4月22日   下午2:21:00 
 * @Description: 实现两个接口
 */ 
public class Car implements Vehicle,FourWheeler{

	//不重写接口方法，而是制定调用哪个接口的默认方法
	public void print2(){
		Vehicle.super.print2();
		FourWheeler.super.print2();
	}
	
	@Override
	public void print1(){
		
	}

}

package �ӿڵ�Ĭ�Ϸ����뾲̬����.test02;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��22��   ����2:21:00 
 * @Description: ʵ�������ӿ�
 */ 
public class Car implements Vehicle,FourWheeler{

	//����д�ӿڷ����������ƶ������ĸ��ӿڵ�Ĭ�Ϸ���
	public void print2(){
		Vehicle.super.print2();
		FourWheeler.super.print2();
	}
	
	@Override
	public void print1(){
		
	}

}

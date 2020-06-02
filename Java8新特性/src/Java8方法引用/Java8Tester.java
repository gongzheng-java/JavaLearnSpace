package Java8��������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��22��   ����2:44:41 
 * @Description:
 */
public class Java8Tester {
	public static void main(String[] args) {
		
		//���������ã������﷨��Class::new�����߸�һ���Class< T >::newʵ�����£�
		final Car car = Car.create( Car::new );
		final List< Car > cars = Arrays.asList( car );
		
		//��̬�������ã������﷨��Class::static_method��ʵ�����£�
		cars.forEach( Car::collide );
		
		//�ض�����������ķ������ã������﷨��Class::methodʵ�����£�
		cars.forEach( Car::repair );
		
		//�ض�����ķ������ã������﷨��instance::methodʵ�����£�
		final Car police = Car.create( Car::new );
		cars.forEach( police::follow );
		//=======================================================
		 List names = new ArrayList();
	        
	      names.add("Google");
	      names.add("Runoob");
	      names.add("Taobao");
	      names.add("Baidu");
	      names.add("Sina");
	        
	      names.forEach(System.out::println);
	}

}

package Java8��������;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��4��22�� ����2:40:49
 * @Description:
 */
public class Car {

	// Supplier��jdk1.8�Ľӿڣ������lamdaһ��ʹ����
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(final Car car) {
		System.out.println("Collided" + car.toString());
	}

	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

}

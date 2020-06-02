package Java8方法引用;

/**
 *
 * @Author: gongZheng
 * @Date: 2018年4月22日 下午2:40:49
 * @Description:
 */
public class Car {

	// Supplier是jdk1.8的接口，这里和lamda一起使用了
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

package �̼߳�ͨѶ05;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��14�� ����10:36:34
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		Entity entity = new Entity();
		Input input = new Input(entity);
		Output output = new Output(entity);

		Thread t1 = new Thread(input, "������");
		Thread t2 = new Thread(output, "������");

		t1.start();
		t2.start();

	}

}

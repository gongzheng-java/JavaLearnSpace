package 线程间通讯05;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月14日 上午10:36:34
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		Entity entity = new Entity();
		Input input = new Input(entity);
		Output output = new Output(entity);

		Thread t1 = new Thread(input, "生产者");
		Thread t2 = new Thread(output, "消费者");

		t1.start();
		t2.start();

	}

}

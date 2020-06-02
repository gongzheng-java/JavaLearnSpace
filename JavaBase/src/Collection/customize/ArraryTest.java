package Collection.customize;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年3月17日 下午6:43:30
 * @Description:
 */
public class ArraryTest {

	public static void main(String[] args) {

		MyArrayList list = new MyArrayList();
		System.out.println(list.get(3));
		list.add(121312);
		list.add(new User("张三", 16));
		list.add("李四");
		list.add("wangwu");
		System.out.println("集合大小：" + list.size());
		System.out.println(list.get(0));
		System.out.println(((User) list.get(1)).getName());
		System.out.println(list.isEmpty());

	}

}

package Collection.customize;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��17�� ����6:43:30
 * @Description:
 */
public class ArraryTest {

	public static void main(String[] args) {

		MyArrayList list = new MyArrayList();
		System.out.println(list.get(3));
		list.add(121312);
		list.add(new User("����", 16));
		list.add("����");
		list.add("wangwu");
		System.out.println("���ϴ�С��" + list.size());
		System.out.println(list.get(0));
		System.out.println(((User) list.get(1)).getName());
		System.out.println(list.isEmpty());

	}

}

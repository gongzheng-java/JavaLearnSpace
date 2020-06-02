package 集合框架.模拟迭代器;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年8月6日 下午9:10:46
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		MyList mList = new MyList();
		while (mList.hasNext()) {
			System.out.println(mList.next());
		}

/*		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			String object = (String) iterator.next();
			iterator.remove();
			System.out.println(object);
			
		}*/

	}

}

package catch块的执行顺序;

/**
 * 
 * @Autho:  gongZheng
 * @Time:   2020年4月16日 上午10:05:13
 * @Description: 
*/
public class Test2 {
	public static void main(String[] args) {
		String s = "abcdefg";
		System.out.println(getFlashback(s));
	}

	public static String getFlashback(String s) {
		StringBuffer buffer = new StringBuffer(s);
		buffer = buffer.reverse();
		return buffer.toString();
	}

}

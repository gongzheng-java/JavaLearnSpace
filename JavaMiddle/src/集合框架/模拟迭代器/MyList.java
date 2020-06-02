package 集合框架.模拟迭代器;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年8月6日   下午9:01:55 
 * @Description:
 */
public class MyList {
	
	private String[] elem={"a","b","c","d","e","f","g"};
	
	private int size=elem.length;
	
	private int cursor=-1;
	
	public boolean hasNext(){
		return cursor+1<size;
	}
	
	public String next(){
		cursor++;
		return elem[cursor];
	}

}

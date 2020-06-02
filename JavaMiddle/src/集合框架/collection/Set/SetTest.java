package 集合框架.collection.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年7月24日   下午10:45:19 
 * @Description:
 */
public class SetTest {

	@Test
	public void test() {
		Set<String> set= new HashSet<>();
		Iterator i=set.iterator();
		while (i.hasNext()) {
			 i.next();
			
		}
		
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(map.put("123", "123"));
		System.out.println(map.put("3", "123"));
	}

}

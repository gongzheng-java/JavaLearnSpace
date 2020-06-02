package 集合框架.Map.other;

import java.util.WeakHashMap;

/**
 *WeakHasMap 键为弱类型，gc运行后会立即回收
 * @Author: gongZheng
 * @Date:   2019年8月28日   下午8:33:45 
 * @Description:
 */
public class WeakHashMapDemo {
public static void main(String[] args) {
	WeakHashMap<String, String> wHashMap=new WeakHashMap<String,String>();
	//前两个是常量池对象，不会被回收
	wHashMap.put("a","zhansgan");
	wHashMap.put("b","lisi");
	//后两个 gc运行会被回收
	wHashMap.put(new String("c"),"wangwu");
	wHashMap.put(new String("d"),"zhaoliu");
	
	//通知垃圾回收
	System.gc();
	System.runFinalization();
	System.out.println(wHashMap.get("a"));
	System.out.println(wHashMap.get("c"));
	System.out.println("个数："+wHashMap.size());
	
	
	
	
	
}
}

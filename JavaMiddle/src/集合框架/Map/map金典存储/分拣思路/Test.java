package 集合框架.Map.map金典存储.分拣思路;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词出现的次数
 * 
 * @Author: gongZheng
 * @Date: 2019年8月8日 下午5:07:36
 * @Description: 计算一段英文中 单词出现的次数 思路：map的key值保存单词，value值保存出现的次数
 * 
 * 
 */
public class Test {
	public static void main(String[] args) {
		String str = "because you have only one life and one chance to do all the things you want to do to";
		String[] strs = str.split(" ");
		Map<String, Save> map = new HashMap<String, Save>();

		// 思路1：为所有的key创建容器，为之后的容器中存放对应的value
		for (String string : strs) {
			// map的key值保存单词，如果第一次遍历该单词， 则创建容器，然后+1；如果不是，说明保存该单词的容器已经存在，则直接+1
			if (!map.containsKey(string)) {
				map.put(string, new Save());
			}
			// 取出上面刚刚存储的信息，然后将value值+1 用以计数
			Save save = map.get(string);
			save.setCount(save.getCount() + 1);
		}

		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key).getCount());
		}
		
		System.out.println();
		//思路2：第一次创建容器，并存放值value，第二次之后，直接使用容器存放值
		for(String string:strs){
			Save save=null;
			if (!map.containsKey(string)) {
				 save=new Save();
				save.setCount(1);
				map.put(string, save);
			}else {
				 save = map.get(string);
				save.setCount(save.getCount() + 1);
			}
		}
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key).getCount());
		}
		
		
		
	}

}

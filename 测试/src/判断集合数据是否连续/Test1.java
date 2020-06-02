package 判断集合数据是否连续;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;








public class Test1 {
	/**
	 * 初始化数据
	 * @return
	 */
	public static List<Integer> initialization(){
		//1.初始化源数据
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(4);
		numList.add(5);
		numList.add(6);
		numList.add(7);
		numList.add(8);
		numList.add(8);
		numList.add(9);
		numList.add(9);
		numList.add(10);
		numList.add(11);
		numList.add(12);
		numList.add(13);
		numList.add(14);
		return numList;
	}
	

	public static void main(String[] args) {
		
		//1.初始化数据
		List<Integer> numList=initialization();
		
		//2.逻辑处理
		boolean flag=true;
		List<Set<Integer>> reslutList=new ArrayList<>();
		Set<Integer> temSet=null;
		for (int i = 0; i < numList.size()-1; i++) {
			if (i==0) {
				temSet=new HashSet();
			}
			
			int before=numList.get(i);//当前元素
			int last=numList.get(i+1);//下一个元素
			System.out.println("before="+before+"\t"+"last="+last);
			//判读当前元素+1后是否=下一个元素
			if ((before+1)!=last) {
				System.out.println("不连续");
				if (i==0) {//当第一个数据就不连续，将第一个数据单独放到一个集合里面
					temSet.add(before);
				}
				reslutList.add(temSet);
				temSet=new HashSet();
				temSet.add(last);
				flag=false;
			}else {
				System.out.println("连续");
				temSet.add(before);
				temSet.add(last);
			}
			//当遍历到倒数第二个数据时(当前i的值只能遍历到倒数第二个数)，存在两个逻辑，如下
			if (last==numList.get(numList.size()-1)) {
				temSet.add(last);//1.倒数第二个数和最后一个数不连续
				reslutList.add(temSet);//2.当倒数第二个数和最后一个数连续，但是和前一个不连续
			}
		}
		
		//3.输出结果
		System.out.println("源数据是否连续："+false);
		
		for (Set<Integer> list : reslutList) {
			System.out.print("[");
			for (int list2 : list) {
				System.out.print(list2+"\t");
			}
			System.out.println("]");
		}
	}
	
	

}

package 测试同步程序;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		CEJA ceja= new CEJA();
		List<RainAll> rainAlls = ceja.query();
		/*System.out.println("获取的数据如下：");
		for (RainAll rainAll : rainAlls) {
			System.out.println(rainAll.getStcd()+"\t"+rainAll.getEndTime()+"\t"+rainAll.getRn());
		}*/
		//CEJC cejc =new CEJC();
		//int[] num = cejc.add(rainAlls);
		/*for (int i = 0; i < num.length; i++) {
			System.out.println("插入后的值是："+num[i]);
			
		}*/
		
	}

}

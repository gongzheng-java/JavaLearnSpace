package �жϼ��������Ƿ�����;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;








public class Test1 {
	/**
	 * ��ʼ������
	 * @return
	 */
	public static List<Integer> initialization(){
		//1.��ʼ��Դ����
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
		
		//1.��ʼ������
		List<Integer> numList=initialization();
		
		//2.�߼�����
		boolean flag=true;
		List<Set<Integer>> reslutList=new ArrayList<>();
		Set<Integer> temSet=null;
		for (int i = 0; i < numList.size()-1; i++) {
			if (i==0) {
				temSet=new HashSet();
			}
			
			int before=numList.get(i);//��ǰԪ��
			int last=numList.get(i+1);//��һ��Ԫ��
			System.out.println("before="+before+"\t"+"last="+last);
			//�ж���ǰԪ��+1���Ƿ�=��һ��Ԫ��
			if ((before+1)!=last) {
				System.out.println("������");
				if (i==0) {//����һ�����ݾͲ�����������һ�����ݵ����ŵ�һ����������
					temSet.add(before);
				}
				reslutList.add(temSet);
				temSet=new HashSet();
				temSet.add(last);
				flag=false;
			}else {
				System.out.println("����");
				temSet.add(before);
				temSet.add(last);
			}
			//�������������ڶ�������ʱ(��ǰi��ֵֻ�ܱ����������ڶ�����)�����������߼�������
			if (last==numList.get(numList.size()-1)) {
				temSet.add(last);//1.�����ڶ����������һ����������
				reslutList.add(temSet);//2.�������ڶ����������һ�������������Ǻ�ǰһ��������
			}
		}
		
		//3.������
		System.out.println("Դ�����Ƿ�������"+false);
		
		for (Set<Integer> list : reslutList) {
			System.out.print("[");
			for (int list2 : list) {
				System.out.print(list2+"\t");
			}
			System.out.println("]");
		}
	}
	
	

}

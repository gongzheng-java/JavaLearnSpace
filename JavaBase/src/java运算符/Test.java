package java�����;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��23�� ����5:04:42
 * @Description: ���õ�������ڴ˴�û������¼��������Ҫ��λ����������������
 */
public class Test {
	public static void main(String[] args) {
		// << :���� �൱�ڳ���2���Ҳ����ֱ�ʾ���Լ���2���� 3<<3 ��ʾ 3*2*2*2
		// >>:���� �൱�ڳ���2���Ҳ����ֳ��Լ���2���� 8>>3 ��ʾ 8/2/2/2

		int a = 3 * 2 * 2 * 2;
		int aa = 3 << 3;
		int b = 12 >> 2;
		int bb = 12 >>1 ;
		System.out.println("a:" + a);
		System.out.println("aa:" + aa);
		System.out.println("b:" + b);
		System.out.println("bb:" + bb);
		
		
		//arrayList ����1.5��
		int oldCapacity=6;
		
		 int newCapacity = oldCapacity + (oldCapacity >> 1);
		 System.out.println(newCapacity);
	}
}

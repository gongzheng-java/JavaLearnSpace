package string�ַ���;

/**
 * string �ַ���
 * 
 * @Author: gongZheng
 * @Date: 2019��3��16�� ����3:11:19
 * @Description: ���ɱ�
 */
public class Test {

	public static void main(String[] args) {
		String str = "123456789abcdefg";
		String name = "��3��";

		// �ַ����滻 ��Ҫ���滻���ַ�����ʱ�������滻�����򷵻�ԭ�ַ���
		String a2 = name.replace("3", "��");
		String a3 = name.replace("��", "��");
		System.out.println(a2);
		System.out.println(a3);
		// �ж��ַ����Ƿ���ĳĳ��ͷ
		System.out.println("�Ƿ���a��ͷ��" + str.startsWith("a"));
		System.out.println("�Ƿ���1��ͷ��" + str.startsWith("1"));

		// �ַ����ָ�
		String[] strArrary = str.split("");
		System.out.print("�ָ����ַ�����");
		for (int i = 0; i < strArrary.length; i++) {
			System.out.print(strArrary[i] + " ");
		}

		// ���Դ�Сд
		System.out.println();
		String A = "ABC";
		String B = "abc";
		System.out.println(A.equalsIgnoreCase(B));
		// ��Сдת��
		System.out.println("ASDCD".toLowerCase());
		System.out.println("abccdefghijklmn".toUpperCase());
	}

}

package string�ַ���.StringBuilder;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��16�� ����10:37:28
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		// ͨ���鿴Դ���֪�������������ʱ��Ĭ���ַ���������16
		StringBuilder sBuilderA = new StringBuilder();// Ĭ���ַ�����16
		StringBuilder sBuilderB = new StringBuilder(32);// ָ���ַ�����32
		StringBuilder sBuilderC = new StringBuilder("abc");// ʵ���ַ�����=��ֵ�ַ�����+16

		System.out.println(sBuilderA.length());

		// ɾ��ָ��λ���ַ���
		StringBuilder sBuilder = new StringBuilder("abcdefghijklmn");
		sBuilder.reverse();// �ַ�������
		System.out.println(sBuilder);
		sBuilder.delete(3, 5);
		System.out.println("ɾ��ָ���ַ�����(��ǰ������)��" + sBuilder);
	}

}

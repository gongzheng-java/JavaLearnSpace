package ������������;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��2��22�� ����9:50:04
 * @Description:java8�������������:
 *                           ���ͣ�byte(1�ֽ�)��short(2�ֽ�)��int��4�ֽڣ���long��8�ֽڣ�
 *                           �ַ���char��2�ֽڣ�
 *                           �����ͣ�float��4�ֽڣ���double��8�ֽڣ�
 *                           ������:boolean(��JVM�в�û���ṩbooleanר�õ��ֽ���ָ��)
 *        1���ֽ�=8��bit����
 */
public class Test {

	public static void main(String[] args) {

		// byte 1�ֽ� 8λ ��ʾ2��8�η�����256 �������������Դ�ֵ��Χ ��-128~127֮��
		byte b = 127;// 127��ʵ��int���ͣ����ڴ�Сû�г���byte�Ĵ�ֵ��Χ�������Զ�ת��
		System.out.println(b);

		// short 2�ֽ� 16λ����ֵ��Χ��-32768~32767
		short s = 32767;// ͬ��
		System.out.println(s);

		// int ռ4���ֽڣ� 32λ�� ��ֵ��Χ�� ��Լ����21��
		int i = 21_0000_0000;// ʹ���»��������ֱ����˹�����
		System.out.println(i);

		// long 8�ֽ� 64λ ��ֵ��Χ��2��63�η�
		// ע�⣺���ͳ����ĸ�ֵĬ�϶���int���ͣ�����
		long l = 1230;// û�м�L����ʵ1230��int���ͣ������Զ�ת��Ϊlong���ͣ��������ݴ�С���ܳ���int����Ҳ���ܳ�����ת�ͺ����������
		long l2 = 1230L;// ����L��˵��1230����long����
		System.out.println(l);

		// char 2�ֽ� 16λ �洢һ������ ��ֵ��Χ��0~65535
		char c = '��';
		char c2 = 120;
		System.out.println("c+c2��" + c + " " + c2);
		char aa = 'a';
		int ii = aa + 3;
		System.out.println("a:" + ii);
		System.out.println("ѭ����ӡA~Z��");
		for (int j = 0; j < 26; j++) {
			//char temp = (char) (aa + j);
			System.out.print(aa++);
		}
		System.out.println();
		// float 4�ֽ� 32λ
		int num = 234;
		float f = 0.123123123f;
		f = num;
		System.out.println("f:" + f);
		// double 8�ֽ� 64λ
		double d = 1.123123123123123123;// ����������Ĭ����double
		System.out.println(d);
		// ˵����float��double�ھ�ȷ���϶�������Ҫʹ��BigDecimal

		// boolean 1�ֽ� 8λ

		/* ʮ���� �˽��� ʮ������ */
		System.out.println("\nʮ���� �˽��� ʮ������");
		int a = 12;
		int a2 = 012;//�˽��� 0��ͷ���˴���ʾ 10
		// ʮ������1~15�ı�ʾ������0,1,2,3,4,5,6,7,8,9��a,b,c,d,e,f
		int a3 = 0x1e; //ʮ������ 0x ��ͷ 1��ʾ16 e��ʾ14 ���Դ˴���30
		System.out.print(a+"\t");
		System.out.print(a2+"\t");
		System.out.println(a3);
		// ����֮���ת��
		System.out.println("����֮���ת��:");
		System.out.println(Integer.toBinaryString(a));// ת������
		System.out.println(Integer.toOctalString(a));// ת�˽���
		System.out.println(Integer.toHexString(a));// תʮ������

	}

}

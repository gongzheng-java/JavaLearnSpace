package ѭ����ӡ26Ӣ����ĸ;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��3��26�� ����10:38:06
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		// �������������������ĸ
		char xiaoxie = 'a';
		System.out.println((int)xiaoxie);
		char daxie = 'A';
		System.out.println((int)daxie);
		
		// ����ѭ��������26��
		for (int i = 0; i < 26; i++) { // ���������ĸ�ı���
			System.out.println(xiaoxie + " " + daxie);
			xiaoxie++;
			daxie++;
		}
	}
}

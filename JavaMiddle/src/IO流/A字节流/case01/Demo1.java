package IO��.A�ֽ���.case01;

import java.io.File;

/**
 *��������
 *1��·���ָ���  ;
 *2�����Ʒָ��� \(windowϵͳ) /(���� Linux��)
 * @Author: gongZheng
 * @Date:   2019��10��16��   ����7:11:44 
 * @Description:
 */
public class Demo1 {
	//��ȡϵͳ�ָ�������Windows��\,Linux��/
	static String sign=File.separator;
	public static void main(String[] args) {
		System.out.println("·���ָ����"+File.pathSeparator);
		System.out.println("���Ʒָ�����"+File.separator);
		//·����ʾ ͨ����ͬ��ϵͳ�ָ�����һ������Windows��\,Linux��/
		// �˴�·����E:\java ��ѧ��Ƶ\Java�������������ڡ�\�� ��ת������ᱨ������ʹ�á�\\��
		String path="E:\\java ��ѧ��Ƶ\\Java����";
		String path2="E:"+sign+"java ��ѧ��Ƶ"+sign+"Java����";//����ֲ��һ�㶯̬ʱʹ��
		System.out.println(path+"\n"+path2);
		
		//�Ƽ���ʽ ������ϵͳ
		String paString="E:/java ��ѧ��Ƶ/Java����";
		
	}

}

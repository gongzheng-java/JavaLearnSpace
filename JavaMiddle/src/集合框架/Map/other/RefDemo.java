package ���Ͽ��.Map.other;

import java.lang.ref.WeakReference;

/**
 *���÷��ࣺǿ����������
 * �˴���ע ǿ��������
 * @Author: gongZheng
 * @Date:   2019��8��28��   ����8:18:59 
 * @Description:
 */
public class RefDemo {
	public static void main(String[] args) {
		//�ַ������ö��� �ᱻ��������
		String str=new String("��������");
		//�����ù������
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("gc����ǰ��"+wr.get());
	}
	
	public static void testStrong(){
		//�ַ��������� �����ܱ�����
		String str="��������";
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str=null;
		//֪ͨ�������� 
		System.gc();
		System.runFinalization();
		System.out.println("gc����ǰ��"+wr.get());
	}

}

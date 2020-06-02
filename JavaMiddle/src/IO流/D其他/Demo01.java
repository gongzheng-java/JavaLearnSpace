package IO��.D����;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 *��ӡ��
 * @Author: gongZheng
 * @Date:   2019��10��23��   ����11:33:19 
 * @Description:
 */
public class Demo01 {

	/**
	 * ֱ�ӽ��������뵽�ļ���
	 * @throws FileNotFoundException
	 */
	@Test
	public void test() throws FileNotFoundException {
		System.out.println("10086+10010");
		PrintStream pStream = System.out;
		pStream.println(false);

		// �����ָ���ļ� �ļ�������ʱ�����Զ�����
		File file = new File("F:/test/print.txt");
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(file));
		pStream = new PrintStream(oStream);
		pStream.println("�˴�ֱ�ӽ���ӡ����������ı��ļ��С�");
		pStream.flush();
		pStream.close();
	}

	/**
	 * ��ӡ�ض���
	 * @throws FileNotFoundException
	 */
	@Test
	public void test1() throws FileNotFoundException {
		// ͨ��ԭ���ķ������������ݻ��ӡ������̨
		System.out.println("�����ݻ��ӡ������̨");

		// �ض���System.out.println()���ݻ��ӡ��ָ���ļ�
		File file = new File("F:/test/print2.txt");
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		PrintStream printStream = new PrintStream(out, true);// true ��ʾˢ����
		System.setOut(printStream);
		System.out.println("�Ӵ˴������ݲ����ӡ������̨�����ӡ��ָ���ļ��С�");
		System.out.println("�η����������ڼ�����־��");

		// �ػ� ��ӡ������̨
		out = new BufferedOutputStream(new FileOutputStream(FileDescriptor.out));
		printStream = new PrintStream(out, true);// true ��ʾˢ����
		System.setOut(printStream);
		System.out.println("�Ӵ˴������ݻ����´�ӡ������̨");

	}

}

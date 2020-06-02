package IO��.C������;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 *���������ڵ���֮�ϣ��Ƕ��������Ĵ�����ǿ���ܣ��������
 * @Author: gongZheng
 * @Date:   2019��10��22��   ����5:07:51 
 * @Description: �����ڿ����ж����ϻ��������������
 *  ���������ڵ���֮�ϣ��Ƕ��������Ĵ�����ǿ���ܣ��������
 * һ��������
 *  1)�� �ֽڻ�����
 *      BufferedInputStream
 *      BufferedOutputSream
 *  2)���ַ�������
 *      BufferedReader
 *      BufferedWirter
 */
public class Demo {

	/**
	 * �ֽ��������� �ļ�����
	 * ��ԭ�����ϵĸ��Ƹ���
	 */
	@Test
	public void test() {
		// ����ȡ���ļ�
		File infile = new File("F:/��Ѷ/��ƽ̨�����ʼ�.txt");
		File outfile = new File("F:/test/test.txt");
		// 1.�ȶ�ȡ�ļ�����
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(infile));
			outputStream = new BufferedOutputStream(new FileOutputStream(outfile));
			byte[] bs = new byte[1024];
			int len = 0;
			String content = null;
			while ((len = inputStream.read(bs)) != -1) {
				content = new String(bs, 0, len);
				System.out.println(content);
				// д���ļ�
				outputStream.write(bs, 0, len);
			}
			outputStream.flush();// ����˴����ֶ�ˢ�£�����û����Ҫ�Ľ��
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��������ȡ�ļ��쳣��");
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * �ַ������� �����ļ�
	 * ��ԭ�����ϵĸ��Ƹ���
	 * �������ַ����ı��ļ��������ͼƬ��Ƶ�ȣ����޷���
	 */
	@Test
	public void test2() {
		File file = new File("F:/test/test.txt");
		File file3 = new File("F:/test/test3.txt");
		// �������·����Ͳ���ʹ�ö�̬������ʹ�����Լ��ķ���������ԭ����Reader Writer�ĳ����ڵ��ࣩ
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(file3, true));// true��ʾ׷�����ݣ�Ĭ��ֵ��false
			char[] flush = new char[1024];
			int len = 0;
			// ԭ���ľɷ���Ҳ����
			/*
			 * while ((len=reader.read(flush))!=-1) { String content=new
			 * String(flush); System.out.println(content); content=new
			 * String(content.getBytes(), "utf-8"); System.out.println(content);
			 * writer.write(content); writer.write(flush, 0, len); }
			 */

			// �����·���
			// reader.readLine() ����ܶ�ȡ�����ݣ��򷵻ض�ȡ���ַ�������֮���򷵻�null
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				// writer.append("\n");//ԭ���Ļ��з���
				writer.newLine();// �µĻ��з���
			}

			writer.flush();
			writer.close();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ַ����쳣��");
			e.printStackTrace();
		}
	}

}

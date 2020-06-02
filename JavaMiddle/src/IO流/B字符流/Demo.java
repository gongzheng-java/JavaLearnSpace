package IO��.B�ַ���;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * �ַ���
 * @Author: gongZheng
 * @Date:   2019��10��21��   ����8:48:43 
 * @Description:
 */
public class Demo {

	/**
	 *  ��ȡ���ı�
	 */
	@Test
	public void test() {
		File file = new File("F:/test/test.txt");
		Reader reader = null;
		try {
			reader = new FileReader(file);
			char[]  flush=new char[1024];
			int len=0;
			while ((len=reader.read(flush))!=-1) {
				String content=new String(flush,0,len);
				System.out.println(content);
			}
 		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�ַ����쳣��");
			e.printStackTrace();
		}finally{
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("�ַ�������ر�ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * д���ļ�
	 */
	@Test
	public void test1(){
		File file = new File("F:/test/test2.txt");
		Writer writer=null;
		try {
			writer=new FileWriter(file);
			String content="�ú�ѧϰ���������ϣ�\n����CEO,ӭȢ�׸�����";
			char[] cbuf = content.toCharArray();
			writer.write(content);
			writer.write(cbuf);
			writer.append(content);
			System.out.println("�ɹ�д�룡");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("���ر�ʧ�ܡ�");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * �����ļ�
	 * �������ַ����ı��ļ��������ͼƬ��Ƶ�ȣ����޷���
	 */
	@Test
	public void test2(){
		File file = new File("F:/test/test.txt");
		File file3 = new File("F:/test/test3.txt");
		Reader reader = null;
		Writer writer=null;
		try {
			reader = new FileReader(file);
			writer=new FileWriter(file3,true);//true��ʾ׷�����ݣ�Ĭ��ֵ��false
			char[]  flush=new char[1024];
			int len=0;
			while ((len=reader.read(flush))!=-1) {
				String content=new String(flush);
				System.out.println(content);
				content=new String(content.getBytes(), "utf-8");
				System.out.println(content);
				writer.write(content);
				writer.write(flush, 0, len);
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

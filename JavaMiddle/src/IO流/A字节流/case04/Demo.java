package IO��.A�ֽ���.case04;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * �ļ��Ķ�ȡ��д�롢����
 * @Author: gongZheng
 * @Date:   2019��10��17��   ����9:55:08 
 * @Description:
 */
public class Demo {

	/**
	 * �ļ��Ķ�ȡ
	 */
	@Test
	public void test() {
		
		File file=new File("F:/��Ѷ/��ƽ̨�����ʼ�.txt");
		InputStream inputStream=null;
		try {
			 inputStream=new FileInputStream(file);
			 //�ַ�����
			 byte[] bs=new byte[1024];
			 int len=0;
			 String content=null;
			 while ((len=inputStream.read(bs))!=-1) {
				 //����˴���ָ�����ȣ�������ظ�����
				content=new String(bs,0,len,"utf-8");
				System.out.println(content);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ָ���ļ��ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��ȡ�ļ��쳣��");
			e.printStackTrace();
		}finally {
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("���ر�ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * д�����ݵ��ļ�
	 * 
	 */
	@Test
	public void test1(){
		File file=new File("F:/test/test.txt");
		OutputStream outputStream=null;
		try {
			//���ļ�������ʱ����Ŀ¼���Զ����������ǵ�Ŀ¼������ʱ�ᱨ��
			//2��true ����Դ�ļ���׷�����ݣ�Ĭ����false
			outputStream=new FileOutputStream(file,true);
			String content="�ú�ѧϰ���������ϣ�";
			byte b[]=content.getBytes();
			outputStream.write(b);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ������ļ�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (outputStream!=null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println("������ر�ʧ�ܣ�");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * �ļ�����
	 * ��һ���ļ����ݸ��Ƶ���һ���ļ���
	 */
	@Test
	public void test2(){
		//����ȡ���ļ�
		File infile=new File("F:/��Ѷ/��ƽ̨�����ʼ�.txt");
		File outfile=new File("F:/test/test.txt");
		//1.�ȶ�ȡ�ļ�����
		InputStream inputStream=null;
		OutputStream outputStream=null;
		try {
			inputStream=new FileInputStream(infile);
			outputStream=new FileOutputStream(outfile);
			byte[] bs=new byte[1024];
			 int len=0;
			 String content=null;
			 while ((len=inputStream.read(bs))!=-1) {
				content=new String(bs, 0, len);
				System.out.println(content);
				//д���ļ�
			    outputStream.write(bs, 0, len);;
			}
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��������ȡ�ļ��쳣��");
			e.printStackTrace();
		}finally {
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

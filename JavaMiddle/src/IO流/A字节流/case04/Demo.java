package IO流.A字节流.case04;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * 文件的读取、写入、拷贝
 * @Author: gongZheng
 * @Date:   2019年10月17日   下午9:55:08 
 * @Description:
 */
public class Demo {

	/**
	 * 文件的读取
	 */
	@Test
	public void test() {
		
		File file=new File("F:/慧讯/云平台操作笔记.txt");
		InputStream inputStream=null;
		try {
			 inputStream=new FileInputStream(file);
			 //字符缓冲
			 byte[] bs=new byte[1024];
			 int len=0;
			 String content=null;
			 while ((len=inputStream.read(bs))!=-1) {
				 //如果此处不指定长度，会出现重复现象
				content=new String(bs,0,len,"utf-8");
				System.out.println(content);
			}
		} catch (FileNotFoundException e) {
			System.out.println("指定文件文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取文件异常！");
			e.printStackTrace();
		}finally {
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("流关闭失败！");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 写入内容到文件
	 * 
	 */
	@Test
	public void test1(){
		File file=new File("F:/test/test.txt");
		OutputStream outputStream=null;
		try {
			//当文件不存在时会在目录下自动创建，但是当目录不存在时会报错。
			//2、true 表在源文件中追加内容，默认是false
			outputStream=new FileOutputStream(file,true);
			String content="好好学习，天天向上！";
			byte b[]=content.getBytes();
			outputStream.write(b);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			System.out.println("找不到该文件");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (outputStream!=null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println("输出流关闭失败！");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 文件拷贝
	 * 将一个文件内容复制到另一个文件中
	 */
	@Test
	public void test2(){
		//被读取的文件
		File infile=new File("F:/慧讯/云平台操作笔记.txt");
		File outfile=new File("F:/test/test.txt");
		//1.先读取文件内容
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
				//写入文件
			    outputStream.write(bs, 0, len);;
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("输入流读取文件异常！");
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

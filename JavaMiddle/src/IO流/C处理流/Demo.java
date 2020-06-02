package IO流.C处理流;

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
 *处理流：节点流之上，是对其他流的处理，增强功能，提高性能
 * @Author: gongZheng
 * @Date:   2019年10月22日   下午5:07:51 
 * @Description: 建议在开发中都加上缓冲流，提高性能
 *  处理流：节点流之上，是对其他流的处理，增强功能，提高性能
 * 一、缓冲流
 *  1)、 字节缓冲流
 *      BufferedInputStream
 *      BufferedOutputSream
 *  2)、字符缓冲流
 *      BufferedReader
 *      BufferedWirter
 */
public class Demo {

	/**
	 * 字节流缓冲流 文件拷贝
	 * 在原方法上的复制改造
	 */
	@Test
	public void test() {
		// 被读取的文件
		File infile = new File("F:/慧讯/云平台操作笔记.txt");
		File outfile = new File("F:/test/test.txt");
		// 1.先读取文件内容
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
				// 写入文件
				outputStream.write(bs, 0, len);
			}
			outputStream.flush();// 如果此处不手动刷新，可能没有想要的结果
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("输入流读取文件异常！");
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
	 * 字符缓冲流 拷贝文件
	 * 在原方法上的复制改造
	 * 仅限于字符的文本文件，如果是图片视频等，将无法打开
	 */
	@Test
	public void test2() {
		File file = new File("F:/test/test.txt");
		File file3 = new File("F:/test/test3.txt");
		// （采用新方法就不能使用多态，必须使用类自己的方法，所以原来的Reader Writer改成现在的类）
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(file3, true));// true表示追加内容，默认值是false
			char[] flush = new char[1024];
			int len = 0;
			// 原来的旧方法也可以
			/*
			 * while ((len=reader.read(flush))!=-1) { String content=new
			 * String(flush); System.out.println(content); content=new
			 * String(content.getBytes(), "utf-8"); System.out.println(content);
			 * writer.write(content); writer.write(flush, 0, len); }
			 */

			// 采用新方法
			// reader.readLine() 如果能读取到内容，则返回读取的字符串；反之，则返回null
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				// writer.append("\n");//原来的换行方法
				writer.newLine();// 新的换行方法
			}

			writer.flush();
			writer.close();
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("字符流异常！");
			e.printStackTrace();
		}
	}

}

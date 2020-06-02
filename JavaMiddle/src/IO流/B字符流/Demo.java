package IO流.B字符流;

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
 * 字符流
 * @Author: gongZheng
 * @Date:   2019年10月21日   下午8:48:43 
 * @Description:
 */
public class Demo {

	/**
	 *  读取纯文本
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
			System.out.println("找不到指定文件。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("字符流异常！");
			e.printStackTrace();
		}finally{
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("字符流对象关闭失败！");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 写出文件
	 */
	@Test
	public void test1(){
		File file = new File("F:/test/test2.txt");
		Writer writer=null;
		try {
			writer=new FileWriter(file);
			String content="好好学习，天天向上！\n出任CEO,迎娶白富美！";
			char[] cbuf = content.toCharArray();
			writer.write(content);
			writer.write(cbuf);
			writer.append(content);
			System.out.println("成功写入！");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("流关闭失败。");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 拷贝文件
	 * 仅限于字符的文本文件，如果是图片视频等，将无法打开
	 */
	@Test
	public void test2(){
		File file = new File("F:/test/test.txt");
		File file3 = new File("F:/test/test3.txt");
		Reader reader = null;
		Writer writer=null;
		try {
			reader = new FileReader(file);
			writer=new FileWriter(file3,true);//true表示追加内容，默认值是false
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
			System.out.println("找不到指定文件。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("字符流异常！");
			e.printStackTrace();
		}
	}
	

}

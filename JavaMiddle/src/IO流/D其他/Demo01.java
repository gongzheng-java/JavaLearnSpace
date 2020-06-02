package IO流.D其他;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 *打印流
 * @Author: gongZheng
 * @Date:   2019年10月23日   上午11:33:19 
 * @Description:
 */
public class Demo01 {

	/**
	 * 直接将内容输入到文件中
	 * @throws FileNotFoundException
	 */
	@Test
	public void test() throws FileNotFoundException {
		System.out.println("10086+10010");
		PrintStream pStream = System.out;
		pStream.println(false);

		// 输出到指定文件 文件不存在时，会自动创建
		File file = new File("F:/test/print.txt");
		OutputStream oStream = new BufferedOutputStream(new FileOutputStream(file));
		pStream = new PrintStream(oStream);
		pStream.println("此处直接将打印内容输出到文本文件中。");
		pStream.flush();
		pStream.close();
	}

	/**
	 * 打印重定向
	 * @throws FileNotFoundException
	 */
	@Test
	public void test1() throws FileNotFoundException {
		// 通过原来的方法，文字内容会打印到控制台
		System.out.println("该内容会打印到控制台");

		// 重定向，System.out.println()内容会打印到指定文件
		File file = new File("F:/test/print2.txt");
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		PrintStream printStream = new PrintStream(out, true);// true 表示刷新流
		System.setOut(printStream);
		System.out.println("从此处的内容不会打印到控制台，会打印到指定文件中。");
		System.out.println("次方法可以用于记载日志。");

		// 重回 打印到控制台
		out = new BufferedOutputStream(new FileOutputStream(FileDescriptor.out));
		printStream = new PrintStream(out, true);// true 表示刷新流
		System.setOut(printStream);
		System.out.println("从此处的内容会重新打印到控制台");

	}

}

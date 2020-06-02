package IO流.A字节流.case02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * file常用方法
 * @Author: gongZheng
 * @Date:   2019年10月16日   下午7:45:56 
 * @Description:
 */
public class Demo {

	/**
	 * 文件名
	 */
	@Test
	public void test() {
		String path="F:/tmp/bpm/cache/test.sql";
		File file=new File(path);
		System.out.println("文件名："+file.getName());
		System.out.println("路径："+file.getPath());
		System.out.println("上一级目录："+file.getParent());//没有上一级目录，返回null
		System.out.println("绝对路径："+file.getAbsolutePath());
	}
	
	
	/**
	 * 文件判断
	 */
	@Test
	public void test1() {
		String path="F:/tmp/bpm/cache/test.sql";
		//path="F:/tmp/bpm/cache";
		File file=new File(path);
		System.out.println("文件是否存在："+file.exists());
		System.out.println("文件是否可读写："+file.canRead()+"/"+file.canWrite());
		
		System.out.println("是否是文件："+file.isFile());//如果文件不存在，默认是false
		System.out.println("是否是文件夹(目录)："+file.isDirectory());
		System.out.println("是否是绝对路径："+file.isAbsolute());
	}
	
	/**
	 * 文件操作
	 * 创建 、删除
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws IOException, InterruptedException {
		String path = "F:/test/测试.txt";
		File file=new File(path);
		//如果文件不存在，则创建
		if (!file.exists()) {
			boolean flag=file.createNewFile();
			System.out.println("是否创建成功："+flag);//如果文件存在则穿件失败
		}else {
			System.out.println("文件已经存在！");
		}
		Thread.sleep(3000);
		//删除文件
		boolean flag=file.delete();
		System.out.println("是否删除成功："+flag);
		
		//创建临时文件 createTempFile(prefix, suffix, directory) 
		//前缀3个字节长 后缀默认0.temp,目录
		File temp=File.createTempFile("测试而已", ".jsp",new File("F:/test"));
		Thread.sleep(5000);
		temp.deleteOnExit();//退出即删除
	}
	

}

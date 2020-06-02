package IO流.A字节流.case03;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * 文件夹操作
 * @Author: gongZheng
 * @Date:   2019年10月16日   下午8:38:26 
 * @Description:
 */
public class Demo {

	/**
	 * 创建文件夹
	 * 
	 */
	@Test
	public void test() {
		String path = "F:/test/a/b";
		String path2 = "F:/test/a/b";
		File file = new File(path);
		File file2 = new File(path2);
		// mkdir() 必须保证父级目录存在，如果不存在，则创建失败
		boolean flag = file.mkdir();
		// mkdir() 如果父级目录链不存在，则一同创建
		boolean flag2 = file.mkdirs();
		System.out.println("是否创建成功：" + flag);
		System.out.println("是否创建成功：" + flag2);

	}

	/**
	 * 操作文件夹内容
	 */
	@Test
	public void test2() {
		String path = "F:/test";
		File file = new File(path);
       
		
		if (file.isDirectory()) {
			
			//获取文件夹里面的文件名称
		/*	System.out.println("获取文件夹里面的子文件和子目录名称:");
			String[] fileNames = file.list();
			for (int i = 0; i < fileNames.length; i++) {
				System.out.println(fileNames[i]);
			}*/
			
			File[] files= file.listFiles();
			//获取文件夹里面的文件对象
		/*	System.out.println("获取文件夹里面的文件对象:");
			for (File file2 : files) {
				System.out.println(file2.getName());
				System.out.println(file2.getAbsolutePath());
				System.out.println();
			}
			*/
			
			//获取文件夹里面指定后缀的文件
			files=file.listFiles(new FilenameFilter() {
				/**
				 * dir 父级路径 此处相当于file对象
				 */
				public boolean accept(File dir, String name) {
					// new File(dir,name).isFile() 表示是必须是文件，有可能目录名后缀也是参数name
					return new File(dir,name).isFile() && name.endsWith(".java");
				}
			});
			for (File file2 : files) {
				System.out.println(file2.getName());
				System.out.println(file2.getAbsolutePath());
				System.out.println();
			}
			
			
		}

	}

}

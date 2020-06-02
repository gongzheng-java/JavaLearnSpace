package IO流.A字节流.case03;

import java.io.File;
import java.util.Arrays;

/**
 * 递归获取子孙级文件
 * @Author: gongZheng
 * @Date:   2019年10月16日   下午9:21:59 
 * @Description:
 */
public class Demo2 {
	public static void main(String[] args) {
		String path = "F:/test";
		File file = new File(path);
		getFilePathName(file, 0);

		// 获取所有的根盘符，这样可以通过递归获取所有的文件
		File[] files = File.listRoots();
		System.out.println(Arrays.toString(files));
	}

	public static void getFilePathName(File file, int level) {
		if (file == null) {
			return;
		}
		for (int i = 0; i < level; i++) {
			System.out.print("*");
		}
		System.out.println(file.getName());

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				getFilePathName(file2, level + 1);
			}
		}
	}
}

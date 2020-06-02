package 递归打印树状目录;

import java.io.File;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年5月15日 下午7:59:55
 * @Description:
 */
public class FileTree {
	public static void main(String[] args) {
		File file = new File("E:/影视娱乐");
		System.out.println("文件目录名称：" + file.getName());
		System.out.println("父级目录：" + file.getParent());
		System.out.println("当前文件目录：" + file.getPath());
		printFile(file, 0);
	}

	/**
	 * 打印树状目录
	 * 
	 * @param file
	 * @param level
	 * @Description 以“*”代替目录层级图标
	 */
	public static void printFile(File file, int level) {
		// 首先输出目录层级
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		// 打印目录名称
		System.out.println(file.getName());
		// 判断文件是否是目录，如果是则递归获取子目录
		if (file.isDirectory()) {
			File[] fils = file.listFiles();// 获取目录下的子目录
			for (File nodeFile : fils) {
				printFile(nodeFile, level + 1);

			}
		}
	}

}

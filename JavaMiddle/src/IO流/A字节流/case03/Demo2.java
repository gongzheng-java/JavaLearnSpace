package IO��.A�ֽ���.case03;

import java.io.File;
import java.util.Arrays;

/**
 * �ݹ��ȡ���Ｖ�ļ�
 * @Author: gongZheng
 * @Date:   2019��10��16��   ����9:21:59 
 * @Description:
 */
public class Demo2 {
	public static void main(String[] args) {
		String path = "F:/test";
		File file = new File(path);
		getFilePathName(file, 0);

		// ��ȡ���еĸ��̷�����������ͨ���ݹ��ȡ���е��ļ�
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

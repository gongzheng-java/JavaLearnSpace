package �ݹ��ӡ��״Ŀ¼;

import java.io.File;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��5��15�� ����7:59:55
 * @Description:
 */
public class FileTree {
	public static void main(String[] args) {
		File file = new File("E:/Ӱ������");
		System.out.println("�ļ�Ŀ¼���ƣ�" + file.getName());
		System.out.println("����Ŀ¼��" + file.getParent());
		System.out.println("��ǰ�ļ�Ŀ¼��" + file.getPath());
		printFile(file, 0);
	}

	/**
	 * ��ӡ��״Ŀ¼
	 * 
	 * @param file
	 * @param level
	 * @Description �ԡ�*������Ŀ¼�㼶ͼ��
	 */
	public static void printFile(File file, int level) {
		// �������Ŀ¼�㼶
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		// ��ӡĿ¼����
		System.out.println(file.getName());
		// �ж��ļ��Ƿ���Ŀ¼���������ݹ��ȡ��Ŀ¼
		if (file.isDirectory()) {
			File[] fils = file.listFiles();// ��ȡĿ¼�µ���Ŀ¼
			for (File nodeFile : fils) {
				printFile(nodeFile, level + 1);

			}
		}
	}

}

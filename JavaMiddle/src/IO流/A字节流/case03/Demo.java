package IO��.A�ֽ���.case03;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * �ļ��в���
 * @Author: gongZheng
 * @Date:   2019��10��16��   ����8:38:26 
 * @Description:
 */
public class Demo {

	/**
	 * �����ļ���
	 * 
	 */
	@Test
	public void test() {
		String path = "F:/test/a/b";
		String path2 = "F:/test/a/b";
		File file = new File(path);
		File file2 = new File(path2);
		// mkdir() ���뱣֤����Ŀ¼���ڣ���������ڣ��򴴽�ʧ��
		boolean flag = file.mkdir();
		// mkdir() �������Ŀ¼�������ڣ���һͬ����
		boolean flag2 = file.mkdirs();
		System.out.println("�Ƿ񴴽��ɹ���" + flag);
		System.out.println("�Ƿ񴴽��ɹ���" + flag2);

	}

	/**
	 * �����ļ�������
	 */
	@Test
	public void test2() {
		String path = "F:/test";
		File file = new File(path);
       
		
		if (file.isDirectory()) {
			
			//��ȡ�ļ���������ļ�����
		/*	System.out.println("��ȡ�ļ�����������ļ�����Ŀ¼����:");
			String[] fileNames = file.list();
			for (int i = 0; i < fileNames.length; i++) {
				System.out.println(fileNames[i]);
			}*/
			
			File[] files= file.listFiles();
			//��ȡ�ļ���������ļ�����
		/*	System.out.println("��ȡ�ļ���������ļ�����:");
			for (File file2 : files) {
				System.out.println(file2.getName());
				System.out.println(file2.getAbsolutePath());
				System.out.println();
			}
			*/
			
			//��ȡ�ļ�������ָ����׺���ļ�
			files=file.listFiles(new FilenameFilter() {
				/**
				 * dir ����·�� �˴��൱��file����
				 */
				public boolean accept(File dir, String name) {
					// new File(dir,name).isFile() ��ʾ�Ǳ������ļ����п���Ŀ¼����׺Ҳ�ǲ���name
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

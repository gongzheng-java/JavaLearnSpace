package IO��.A�ֽ���.case01;

import java.io.File;

/**
 *���·���;���·��
 * @Author: gongZheng
 * @Date:   2019��10��16��   ����7:29:04 
 * @Description:
 */
public class Demo2 {
	public static void main(String[] args) {
		// ����·������
		String path = "E:/java ��ѧ��Ƶ/Java����";
		String name = "index.jsp";
		File file = new File(path, name);
		System.out.println(file);
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getName());

		System.out.println();
		// ���·�� �������ļ��Ե�ǰ��ĿΪ����·��
		file = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println("����·����" + file.getAbsolutePath());

	}

}

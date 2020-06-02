package IO流.A字节流.case01;

import java.io.File;

/**
 *相对路径和绝对路径
 * @Author: gongZheng
 * @Date:   2019年10月16日   下午7:29:04 
 * @Description:
 */
public class Demo2 {
	public static void main(String[] args) {
		// 绝对路径构建
		String path = "E:/java 教学视频/Java基础";
		String name = "index.jsp";
		File file = new File(path, name);
		System.out.println(file);
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getName());

		System.out.println();
		// 相对路径 所创建文件以当前项目为绝对路径
		file = new File("test.txt");
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println("绝对路径：" + file.getAbsolutePath());

	}

}

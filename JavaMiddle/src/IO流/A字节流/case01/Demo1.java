package IO流.A字节流.case01;

import java.io.File;

/**
 *两个常量
 *1、路径分隔符  ;
 *2、名称分隔符 \(window系统) /(其他 Linux等)
 * @Author: gongZheng
 * @Date:   2019年10月16日   下午7:11:44 
 * @Description:
 */
public class Demo1 {
	//获取系统分隔符，如Windows是\,Linux是/
	static String sign=File.separator;
	public static void main(String[] args) {
		System.out.println("路径分割符："+File.pathSeparator);
		System.out.println("名称分隔符："+File.separator);
		//路径表示 通常不同的系统分隔符不一样，如Windows是\,Linux是/
		// 此处路径是E:\java 教学视频\Java基础，但是由于‘\’ 是转义符，会报错，所以使用‘\\’
		String path="E:\\java 教学视频\\Java基础";
		String path2="E:"+sign+"java 教学视频"+sign+"Java基础";//可移植，一般动态时使用
		System.out.println(path+"\n"+path2);
		
		//推荐方式 在其他系统
		String paString="E:/java 教学视频/Java基础";
		
	}

}

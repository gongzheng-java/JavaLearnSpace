package 集合框架.Map.other;

import java.lang.ref.WeakReference;

/**
 *引用分类：强、软、弱、虚
 * 此处关注 强与弱引用
 * @Author: gongZheng
 * @Date:   2019年8月28日   下午8:18:59 
 * @Description:
 */
public class RefDemo {
	public static void main(String[] args) {
		//字符串引用对象 会被立即回收
		String str=new String("垃圾回收");
		//弱引用管理对象
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("gc运行前后："+wr.get());
	}
	
	public static void testStrong(){
		//字符串常量池 共享不能被回收
		String str="垃圾回收";
		WeakReference<String> wr=new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str=null;
		//通知垃圾回收 
		System.gc();
		System.runFinalization();
		System.out.println("gc运行前后："+wr.get());
	}

}

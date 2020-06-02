package 基本数据类型;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月22日 下午9:50:04
 * @Description:java8大基本数据类型:
 *                           整型：byte(1字节)、short(2字节)、int（4字节）、long（8字节）
 *                           字符：char（2字节）
 *                           浮点型：float（4字节）、double（8字节）
 *                           布尔型:boolean(在JVM中并没有提供boolean专用的字节码指令)
 *        1个字节=8个bit长度
 */
public class Test {

	public static void main(String[] args) {

		// byte 1字节 8位 表示2的8次方等于256 由于正负数所以储值范围 ：-128~127之间
		byte b = 127;// 127其实的int类型，由于大小没有超过byte的储值范围，可以自动转型
		System.out.println(b);

		// short 2字节 16位；储值范围：-32768~32767
		short s = 32767;// 同理
		System.out.println(s);

		// int 占4个字节， 32位； 储值范围： 大约正负21亿
		int i = 21_0000_0000;// 使用下划线做划分便于人工读数
		System.out.println(i);

		// long 8字节 64位 储值范围：2的63次方
		// 注意：整型常量的赋值默认都是int类型，所以
		long l = 1230;// 没有加L，其实1230的int类型，程序自动转型为long类型，但是数据大小不能超过int自身，也不能超过被转型后的数据类型
		long l2 = 1230L;// 加了L，说明1230就是long类型
		System.out.println(l);

		// char 2字节 16位 存储一个文字 储值范围：0~65535
		char c = '测';
		char c2 = 120;
		System.out.println("c+c2：" + c + " " + c2);
		char aa = 'a';
		int ii = aa + 3;
		System.out.println("a:" + ii);
		System.out.println("循环打印A~Z：");
		for (int j = 0; j < 26; j++) {
			//char temp = (char) (aa + j);
			System.out.print(aa++);
		}
		System.out.println();
		// float 4字节 32位
		int num = 234;
		float f = 0.123123123f;
		f = num;
		System.out.println("f:" + f);
		// double 8字节 64位
		double d = 1.123123123123123123;// 浮点数常量默认是double
		System.out.println(d);
		// 说明：float和double在精确度上都有误差，需要使用BigDecimal

		// boolean 1字节 8位

		/* 十进制 八进制 十六进制 */
		System.out.println("\n十进制 八进制 十六进制");
		int a = 12;
		int a2 = 012;//八进制 0开头，此处表示 10
		// 十六进制1~15的表示方法：0,1,2,3,4,5,6,7,8,9，a,b,c,d,e,f
		int a3 = 0x1e; //十六进制 0x 开头 1表示16 e表示14 所以此处是30
		System.out.print(a+"\t");
		System.out.print(a2+"\t");
		System.out.println(a3);
		// 进制之间的转换
		System.out.println("进制之间的转换:");
		System.out.println(Integer.toBinaryString(a));// 转二进制
		System.out.println(Integer.toOctalString(a));// 转八进制
		System.out.println(Integer.toHexString(a));// 转十六进制

	}

}

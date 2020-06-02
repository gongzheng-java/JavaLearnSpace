package TCP上传图片.客户端并发上传图片;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @Author: gongZheng
 * @Date: 2018年2月7日 下午4:43:46
 * @Description: 在原来的基础上，使用多线程并发传输图片
 */
public class TCPclient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		String[] args1 = new String[1];

		args1[0] = "D:\\test.jpg";

		aa(args1);

	}

	public static void aa(String[] args) throws IOException {
		// 判断是否有文件
		if (args.length != 1) {
			System.out.println("请选择一个图片文件。");
			return;
		}

		File file = new File(args[0]);

		// 判断文件是否存在，判断是否是文件
		if (!(file.exists() && file.isFile())) {
			System.out.println("文件不存在或不是标准文件");
			return;
		}

		// 判断图片格式 必须的.jpg格式
		if (!file.getName().endsWith(".jpg")) {
			System.out.println("图片格式不正确，必须是JPG。");
			return;
		}

		// 设置图片大小 不能大于5M
		if (file.length() > 1024 * 1024 * 5) {
			System.out.println("对不起，图片过大(不能大于5M)。");
		}

		// 创建服务
		Socket socket = new Socket("192.168.10.146", 10009);

		// 读取数据
		// FileInputStream fInputStream = new FileInputStream("D:\\test2.jpg");
		FileInputStream fInputStream = new FileInputStream(file);

		// 获取socket输出流
		OutputStream outputStream = socket.getOutputStream();

		byte[] b = new byte[1024];// 创建字节缓冲区
		int num = 0;
		// 循环将图片数据流读取到字节缓冲区中，再将通过socket输出流将缓冲区的数据写出去
		while ((num = fInputStream.read(b)) != -1) {
			// outputStream.write(b, 0, num);
			outputStream.write(b);
		}

		/*
		 * 关闭客户端输出流，相当于给流中加入一个结束标记 -1 ，否则服务端循环读取部分无法结束，
		 * 一直处于阻塞等待状态，从而导致客户端和服务端都处于等待状态
		 */
		socket.shutdownOutput();

		// 获取服务端反馈的信息
		InputStream inputStream = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len = inputStream.read(b1);
		System.out.println("len：" + len);
		System.out.println(new String(b1, 0, len));
		System.out.println(new String(b1));

		fInputStream.close();
		socket.close();
	}

}

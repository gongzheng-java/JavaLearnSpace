package TCP上传图片.客户端并发上传图片;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务端线程类
 * @Author: gongZheng
 * @Date:   2018年2月8日   下午4:54:58 
 * @Description:
 *  明确每个客户端要在服务端的代码，将该代码放入run()方法中
 */
public class PicThread implements Runnable {
	private Socket socket;

	
	public PicThread() {
		
	}
	
	public PicThread(Socket socket) {
		System.out.println("开启线程！！");
		this.socket = socket;
	}

	
	@Override
	public void run() {
		/*创建标记，用于防止文件名重复，而导致覆盖现象
		 * 此处之所以不将此标记设置为共享对象，是为了保证每台不同的主机客户端操作时，文件名都是从新开始定义的
		 * 而不是说，当第一台主机客户端执行一次后，第二台主机客户端第文件名是延续第一台主机的*/
		int count = 0;
		
		String IP= socket.getInetAddress().getHostAddress();
	    String name=socket.getInetAddress().getHostName();
		try {
			System.out.println("来自 " + IP + "  的用户  " + name + "  的连接");
			//获取客户端的输入流，读取客户端socket流中的信息
			InputStream inputStream = socket.getInputStream();
			
			
			//创建文件输出流对象（处理文件名重复而导致的文件覆盖问题）
			File file = new File("D:\\test("+count+").jpg");
			while (file.exists()) { //判断上面的文件名是否存在，如果存在则重新生成新的文件名
				 file = new File("D:\\test("+(count++)+").jpg");
			}
			
			FileOutputStream fOutputStream = new FileOutputStream(file);
			
			byte[] buff = new byte[1024];
			int num = 0;
			//循环将数据写入文件中
			while ((num = inputStream.read(buff)) != -1) {
				fOutputStream.write(buff, 0, num);
			}
			
			//给客户端反馈消息
			OutputStream outputStream = socket.getOutputStream();
			byte[] bs = "上传成功，注意查看".getBytes();
			outputStream.write(bs);
			System.out.println("字节长度："+bs.length);
			
			fOutputStream.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(IP +"   图片传输失败！！！！！！");
			e.printStackTrace();
		}
		
		
	}
	

}

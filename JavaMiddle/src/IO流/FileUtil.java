package IO流;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的工具类
 * @Author: gongZheng
 * @Date:   2019年10月22日   下午8:42:24 
 * @Description:
 */
public class FileUtil {

	/**
	 * 工具类 关闭流
	 * @param io 可变参数
	 */
	public static void close(Closeable... io) {
		try {
			for (Closeable closeable : io) {
				if (closeable != null) {
					closeable.close();
				}
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}

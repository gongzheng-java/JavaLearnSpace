package IO��;

import java.io.Closeable;
import java.io.IOException;

/**
 * �ر����Ĺ�����
 * @Author: gongZheng
 * @Date:   2019��10��22��   ����8:42:24 
 * @Description:
 */
public class FileUtil {

	/**
	 * ������ �ر���
	 * @param io �ɱ����
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

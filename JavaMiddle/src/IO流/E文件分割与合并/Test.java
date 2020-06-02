package IO流.E文件分割与合并;

import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年10月23日   下午5:35:38 
 * @Description:
 */
public class Test {
	public static void main(String[] args) {
		String filePath="F:/test/print2.txt";
		SplitFile sFile=new SplitFile(filePath,20);
		sFile.init();
		System.out.println(sFile.size);
		
		List<String> sList=sFile.blockPath;
		for (String string : sList) {
			System.out.println(string);
		}
	}

}

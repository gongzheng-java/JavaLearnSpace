package IO��.E�ļ��ָ���ϲ�;

import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��10��23��   ����5:35:38 
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

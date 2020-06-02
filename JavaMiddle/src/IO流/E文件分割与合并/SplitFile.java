package IO��.E�ļ��ָ���ϲ�;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��10��23��   ����4:09:20 
 * @Description:
 */
public class SplitFile {
	
	//�ļ�·��
	public String filePath;
	
	//�ļ���
	public String fileName;
	//�ļ���С
	private long length;
	//�ָ�Ŀ���  =�ļ���С/ÿ���С
	public int size;
	
	//ÿ���С
	public long blockSize;

	//ÿ������
	public List<String> blockPath;

	//���캯��
	public SplitFile() {
		blockPath=new ArrayList<String>();
	}
	
	/**
	 * ������
	 * @param filePath �ļ�·��
	 * @param blockSzie  ÿ���С
	 */
	public SplitFile(String filePath,long blockSzie) {
		this();
		this.filePath=filePath;
		this.blockSize=blockSzie;
	}
	
	/**
	 * ������
	 * @param filePath �ļ�·��
	 */
	public SplitFile(String filePath){
		this(filePath,1024);
	}
	
	/**
	 * ��ʼ��
	 */
	public void init(){
		File file=new File(filePath);
		//�ж��ļ��Ƿ����
		if (filePath==null || !file.exists()) {
			System.err.println("�ļ�·�������ڣ�");
			return;
		}
		if (file.isDirectory()) {
			System.err.println("����һ���ļ��У������ļ���");
		}
		//�ļ���
		this.fileName=file.getName();
		//����ָ����  �ļ���С/ÿ���С
		this.length=file.length();
		if (this.blockSize>=this.length) {//�ж�ÿ���С�Ƿ�����ļ���С
			this.blockSize=this.length;
		}
		//������������������Էָ��2�飻û�еĻ���ֻ��һ�飬������Math.ceil()����ȡֵ
		this.size=(int) Math.ceil(this.length*1.0/this.blockSize);
		//��ʼ���ļ���
		this.initPathName();
	}
	
	/**
	 * ��ʼ���ָ��ÿ���ļ���
	 */
	private void initPathName(){
		for(int i=0;i<size;i++){
			this.blockPath.add(this.fileName+".part"+i);
		}
	}
	
	/**
	 * �ļ��ָ�
	 * @param filePath �ļ�·��
	 */
	public void spilt(String filePath){
		long beginPso=0;//��ʼ��
		
	}
	
	
	
	
}

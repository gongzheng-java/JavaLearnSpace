package IO流.E文件分割与合并;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author: gongZheng
 * @Date:   2019年10月23日   下午4:09:20 
 * @Description:
 */
public class SplitFile {
	
	//文件路径
	public String filePath;
	
	//文件名
	public String fileName;
	//文件大小
	private long length;
	//分割的块数  =文件大小/每块大小
	public int size;
	
	//每块大小
	public long blockSize;

	//每块名称
	public List<String> blockPath;

	//构造函数
	public SplitFile() {
		blockPath=new ArrayList<String>();
	}
	
	/**
	 * 构造器
	 * @param filePath 文件路径
	 * @param blockSzie  每块大小
	 */
	public SplitFile(String filePath,long blockSzie) {
		this();
		this.filePath=filePath;
		this.blockSize=blockSzie;
	}
	
	/**
	 * 构造器
	 * @param filePath 文件路径
	 */
	public SplitFile(String filePath){
		this(filePath,1024);
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		File file=new File(filePath);
		//判断文件是否存在
		if (filePath==null || !file.exists()) {
			System.err.println("文件路径不存在！");
			return;
		}
		if (file.isDirectory()) {
			System.err.println("这是一个文件夹，不是文件！");
		}
		//文件名
		this.fileName=file.getName();
		//计算分割块数  文件大小/每块大小
		this.length=file.length();
		if (this.blockSize>=this.length) {//判断每块大小是否大于文件大小
			this.blockSize=this.length;
		}
		//如果整除有余数，可以分割成2块；没有的话则只有一块，所以用Math.ceil()向上取值
		this.size=(int) Math.ceil(this.length*1.0/this.blockSize);
		//初始化文件名
		this.initPathName();
	}
	
	/**
	 * 初始化分割的每块文件名
	 */
	private void initPathName(){
		for(int i=0;i<size;i++){
			this.blockPath.add(this.fileName+".part"+i);
		}
	}
	
	/**
	 * 文件分割
	 * @param filePath 文件路径
	 */
	public void spilt(String filePath){
		long beginPso=0;//起始点
		
	}
	
	
	
	
}

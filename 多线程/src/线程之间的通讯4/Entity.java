package 线程之间的通讯4;

/**
 *
 * @Author: gongZheng
 * @Date:   2017年11月16日   下午7:29:34 
 * @Description:
 */
public class Entity {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	
	//创建标识，通过判断标识，来保证两个(多个就无效)线程交替输入与输出，即赋值一次，紧接着就输出一次
	//如果不使用建标识判断的话，会出现连续多次赋值或多次打印输出值
	public boolean flag=false; 
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
   
	
	
	
	

}

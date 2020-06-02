package test;

/**
 *
 * @Author: gongZheng
 * @Date:   2018年3月8日   下午3:09:59 
 * @Description:
 */
public class Person {
	private String name;  
	
    private int age;  
  
    
    
    public Person() {  
        System.out.println("无参构造器");  
    }  
  
    public Person(String name, int age) {  
        System.out.println("有参构造器");  
        this.name = name;  
        this.age = age;  
    }
    
    private void privateMthod(){  
    	System.out.println("这是Person类中一个私有的方法。。。。。。。。");
    }
    
    public void publicteMthod2(){  
    	System.out.println("这是Person类中一个私有的方法。。。。。。。。");
    }

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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	  
    
    
}

package ��ĳ�ʼ��;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��2��8��   ����10:35:07 
 * @Description:
 */
public class Test1 {
	
	/** 
     * ��������������ĳ�ʼ���ĵ����������������Test1��main����ʱ 
     * ����Test1��ʼ������һ��ܺ���⣬�Ͳ��ر���ʾ�ˡ� 
     * ��������ʾ��ǰ������������´��붼������InitClass�ĳ�ʼ���� 
     * �����ڳ�ʼ��ֻ�����һ�Σ�����ʱ�뽫ע��ȥ�����������в鿴����� 
     * @param args 
     * @throws Exception 
     */  
    public static void main(String[] args) throws Exception{  
    //  ��������������ĳ�ʼ��һ: new���󡢶�ȡ��������ľ�̬������������ľ�̬������  
//      new InitClass();  
//      InitClass.a = "";  
//      String a = InitClass.a;  
//      InitClass.method();  
          
    //  ��������������ĳ�ʼ������ͨ������ʵ�������󡢶�ȡ��������ľ�̬������������ľ�̬������  
//      Class cls = InitClass.class;  
//      cls.newInstance();  
          
      /*getDeclaredField�ǿ��Ի�ȡһ����������ֶ�. 
      getFieldֻ�ܻ�ȡ���public �ֶ�. */
//      Field f = cls.getDeclaredField("a");
//      System.out.println();
//      f.get(null);  
//      f.set(null, "s");
//      
//      
//      Method md = cls.getDeclaredMethod("method");  
//      md.invoke(null, null);  
              
    //  ��������������ĳ�ʼ������ʵ�������࣬�������ʼ����  
      new SubInitClass();  
      
  
    }  

}

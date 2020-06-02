package guava���.ʵ�ù���;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *HashMap keyΨһ value�����ظ�
 *BiMap ˫��map  key��value�������ظ�
 * @Author: gongZheng
 * @Date: 2019��8��29�� ����10:42:16
 * @Description:
 * Ӧ�ã���������û������䣬�����������û�
 */
public class BiMapDemo {
	public static void main(String[] args) {
		//���key�ظ����Ḳ��ԭ����ֵ�����value�ظ���ֱ�ӱ���
         BiMap<String, String> biMap=HashBiMap.create();
         biMap.put("a", "110");
         biMap.put("a", "111");
         biMap.put("c", "112");
         biMap.put("d", "113");
         biMap.put("e", "114");
         System.out.println("a��ֵ��"+biMap.get("a"));//ֵ��111������ԭ����100
         System.out.println("bimap��С��"+biMap.size());//��С��4
         System.out.println("����value��keyֵ��"+biMap.inverse().get("111"));//inverse()�Ƿ�ת����˼
	     System.out.println("��η�ת��"+biMap.inverse().inverse().get("a"));
	}
	
}

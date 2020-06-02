package guava���.ʵ�ù���;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * �鿴ÿ����ʦ���ڵĿγ� Multimap key-value key�����ظ�
 * 
 * @Author: gongZheng
 * @Date: 2019��8��29�� ����9:44:56
 * @Description:
 */
public class MultimapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("����", "����ʦ");
		map.put("��ѧ", "����ʦ");
		map.put("����", "����ʦ");
		map.put("����", "����ʦ");
		map.put("��ѧ", "����ʦ");
		map.put("����", "����ʦ");
		map.put("����", "����ʦ");
		map.put("Ӣ��", "����ʦ");

		Multimap<String, String> multimap = ArrayListMultimap.create();

		//multimap��key�����ظ������Խ�map��valueֵ��keyֵ��������multimap��
		//�����Ļ���������multimap�б����Ƕ����ͬ��keyֵ����Ӧ��ͬ��valueֵ
		for (String key : map.keySet()) {
			multimap.put(map.get(key), key);
		}

		for (String string : multimap.keySet()) {
			//����keyȡvalueֵ����Ϊ������ͬ��key�����Կ���ȡ��keyֵ��ͬ��value������һ��value�ļ���
			//������Ͼ���ͬһ����ʦ�������ڵĲ�ͬ�Ŀγ�
			Collection<String> collection = multimap.get(string);
			System.out.println(string + "--->" + collection.toString());
		}

	}

}

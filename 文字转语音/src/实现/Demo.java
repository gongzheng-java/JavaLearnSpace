package ʵ��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *��ȡ�ĵ������ĵ�����ת����
 * @Author: gongZheng
 * @Date:   2019��12��13��   ����2:22:31 
 * @Description:
 */
public class Demo {
	public static void main(String[] args) {
	    //����һ��txt�ı�
	    readText(new File("D:\\StoreSpace\\����.txt"));
	}
	
	public static void readText(File text) {
	    Reader reader=null;
	    BufferedReader br=null;
	    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo=sap.getObject();
	    try {
            reader=new FileReader(text);
            br =new BufferedReader(reader);
            //����
            sap.setProperty("Volume", new Variant(100));
            //����
            sap.setProperty("Rate",new Variant(0.1));
            String info="";
            while((info=br.readLine())!=null) {
                //�������ŵ�ǰ�е�����
                Dispatch.call(sapo,"Speak",new Object[]{info});
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}

package 实现;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *读取文档，将文档内容转语音
 * @Author: gongZheng
 * @Date:   2019年12月13日   下午2:22:31 
 * @Description:
 */
public class Demo {
	public static void main(String[] args) {
	    //传入一个txt文本
	    readText(new File("D:\\StoreSpace\\文字.txt"));
	}
	
	public static void readText(File text) {
	    Reader reader=null;
	    BufferedReader br=null;
	    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo=sap.getObject();
	    try {
            reader=new FileReader(text);
            br =new BufferedReader(reader);
            //音量
            sap.setProperty("Volume", new Variant(100));
            //语速
            sap.setProperty("Rate",new Variant(0.1));
            String info="";
            while((info=br.readLine())!=null) {
                //语音播放当前行的内容
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

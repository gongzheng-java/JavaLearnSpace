package ����;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��12��13��   ����10:49:50 
 * @Description:
 */
public class Voice {
	 public static void main(String[] args) {
	       speak("����ʱ�ƽ�������ʱ��ɳ����Ϊ���۲�ͬ���飬�ҹ¶�Ҳ�գ���˼Ҳ�ϣ��������ѷ����");
	    }




	    private static void speak(String value) {
	        // ���� ���Sapi.SpVoice����Ҫ��װʲô�����𣬸о�ƽ���޹ʾ�����
	        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
	        // Dispatch����ʲô�ģ�
	        Dispatch sapo = (Dispatch) sap.getObject();


	            // ���� 0-100
	            sap.setProperty("Volume", new Variant(50));
	            // �����ʶ��ٶ� -10 �� +10
	            sap.setProperty("Rate", new Variant(-2));

	            Variant defalutVoice = sap.getProperty("Voice");

	            Dispatch dispdefaultVoice = (Dispatch) defalutVoice.toDispatch();
	            Variant allVoices = Dispatch.call(sapo, "GetVoices");
	            Dispatch dispVoices = (Dispatch) allVoices.toDispatch();

	            Dispatch setvoice = Dispatch.call(dispVoices, "Item", new Variant(1)).toDispatch();
	           // ActiveXComponent voiceActivex = new ActiveXComponent(dispdefaultVoice);
	            //ActiveXComponent setvoiceActivex = new ActiveXComponent(setvoice);

	            //Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
	            // ִ���ʶ�
	            Dispatch.call(sapo, "Speak", new Variant(value));
	            sapo.safeRelease();
	            sap.safeRelease();
	    }
}

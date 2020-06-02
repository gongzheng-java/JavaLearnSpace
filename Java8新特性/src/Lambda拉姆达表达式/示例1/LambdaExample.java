package Lambda��ķ����ʽ.ʾ��1;

import java.util.Arrays;

/**
 *
 * @Author: gongZheng
 * @Date:   2018��4��21��   ����10:12:57 
 * @Description: lambda���ʽ�﷨�ļ򵥽���
 */
public class LambdaExample {
	public static void main(String[] args) {
		
		/*lambda���ʽ����Ҫ����:
			��ѡ��������������Ҫ�����������ͣ�����������ͳһʶ�����ֵ��
			��ѡ�Ĳ������ţ�һ���������趨�����ţ������������Ҫ�������š�
			��ѡ�Ĵ����ţ�������������һ����䣬�Ͳ���Ҫʹ�ô����š�
			��ѡ�ķ��عؼ��֣��������ֻ��һ�����ʽ����ֵ����������Զ�����ֵ����������Ҫָ�������ʽ������һ����ֵ��*/
		
		//����
		Arrays.asList("a","b","c","d","e").forEach(e -> System.out.print( e +","));
		System.out.println();
		
		//��������������еĲ���e���������ɱ���������ó��ģ���Ҳ������ʽָ���ò��������ͣ����磺
		 String separator1 = ",";
		Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.print( e +separator1) );
		
		System.out.println();
		
		Arrays.asList( "a", "b", "d" ).forEach( e -> {
		    System.out.print( e ); //�����ж����䣬��Ҫ��{}��
		    System.out.println( e );
		} );
		
		//============================================================================================
		
		//Lambda���ʽ�����������Ա�;ֲ��������Ὣ��Щ������ʽ��ת����final�ģ���������������������Ч����ȫ��ͬ��
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator ) );
		//��
		final String separator2 = ",";
		Arrays.asList( "a", "b", "d" ).forEach( 
		    ( String e ) -> System.out.print( e + separator2 ) );
		
		//================================================================================================
		
		//Lambda���ʽ�з���ֵ������ֵ������Ҳ�ɱ���������ó������Lambda���ʽ�е�����ֻ��һ�У�����Բ���ʹ��return��䣬������������Ƭ��Ч����ͬ��
		Arrays.asList( "a", "g", "b","d","c","e","f" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
	
		//��
		Arrays.asList( "a", "g", "b","d","c","e","f" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		
	}

}

package �߳�֮���ͨѶ4;

/**
 *
 * @Author: gongZheng
 * @Date:   2017��11��16��   ����7:43:00 
 * @Description:
 */
public class MainTest {

	public static void main(String[] args) {
		
		Entity entity=new Entity();
		//��������ι��캯�����Թ�ͬ��Entity������Ϊ��������Ϊ�˱�֤�����߳�ʹ����ͬ��������
		Input input=new Input(entity);
		Output output=new Output(entity);
		
		Thread thread=new Thread(input);
		Thread thread2=new Thread(output);
		Thread thread1=new Thread(input);
		Thread thread3=new Thread(output);
		
		thread2.start();
		thread.start();
		//thread1.start();
		//thread3.start();
		
		/*
		 * �ܽ�˵�������д���ῴ����ȷ������������������ж���̣߳�������ʾ��������ֵ�̺߳���������̵߳Ļ�����ô����ֲ��ǽ��������Ч����
		 *       ����뿴������Ч����������һ��ʾ���������ߺ�������
		 * 
		 */

	}

}

package �����ߺ�������202;

/**
 *
 * @Author: gongZheng
 * @Date:   2017��11��25��   ����4:13:23 
 * @Description:
 */
public class MainTest {

	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		
		Produce produce = new Produce(pojo);
		Consumer consumer = new Consumer(pojo);
		
		Thread thread2 = new Thread(produce);
		Thread thread1 = new Thread(consumer);
		Thread thread4 = new Thread(produce);
		Thread thread3 = new Thread(consumer);
		Thread thread5 = new Thread(produce);
		Thread thread6 = new Thread(consumer);
		
		//��ֻ�������̵߳ģ�����������һ����ʱ�򣩣����������������Ľ����������̵߳�ʱ��ͻ��������
		thread2.start();
		thread1.start();
		
		//����������������ֶ���̵߳�ʱ�򣬻����������ӡ�����������Ϣ���߶����������Ϣ������������һ��ȴ�������˶��
		thread4.start();
		thread3.start();
		thread5.start();
		thread6.start();
		

	}

}

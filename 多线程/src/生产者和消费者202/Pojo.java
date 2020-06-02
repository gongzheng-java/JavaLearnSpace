package �����ߺ�������202;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Author: gongZheng
 * @Date:   2017��11��25��   ����3:39:04 
 * @Description:
 */
public class Pojo {
	
	private String name;
	private int count=1;
	private boolean flag=false;
	
	//jdk APIԭ����Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�á�
	//JDK1.5֮��Lock������synchronized��Condition������object����������synchronized�����󣨹��ڲ�ͬ״̬��synchronized����Ӧ�����������⣬�ο�ʾ������Ʊ�����ӡ���
	private final Lock lock= new ReentrantLock();
	private final Condition condition_Pro=lock.newCondition();//������
	private final Condition condition_Con=lock.newCondition();//������
	
	//��ֵ  ʹ��JDK1.5�����Ժ󣬲���Ҫ�ڷ����ϼ�synchronized����
	public  void set(String name) throws InterruptedException{
		lock.lock();//��ȡ��
		try {
			while (flag) {
				condition_Pro.await();//�������̵߳ȴ�
			}
			this.name=name+"--->"+count++;
			System.out.println(Thread.currentThread().getName()+"������:"+this.name);
			flag=true;
			//this.notify();
			condition_Con.signal();//���ѶԷ��������ߣ��߳�
		} finally  {
			lock.unlock();//�ͷ�����Դ
		}
		
	}

	//���
	public  void out() throws InterruptedException{
		lock.lock();//��ȡ������
		try {
			while (!flag) {
				condition_Con.await();
			}
			System.out.println(Thread.currentThread().getName()+"*******������*********"+this.name);
			flag=false;
			condition_Pro.signal();//���ѶԷ��������ߣ��߳�
		} finally {
			lock.unlock();//�ͷ�����Դ
		}
		
	}
	
	
}

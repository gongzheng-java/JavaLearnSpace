package ���д�Ǯ������2;

/**
 * ������ 
 * @Author: gongZheng
 * @Date:   2017��11��14��   ����6:03:21 
 * @Description: ���д�Ǯ�ķ���
 */
public class Bank {
	
	int sum;
	Object object =new Object();
	
	//��ԭ����ͬ�����룬�ĳ�ͬ������
	public synchronized void addMoney(int money){
		//synchronized (object) { 
			sum=sum+money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"�����е�ǰ����"+sum);	
		//}
		
	}

}

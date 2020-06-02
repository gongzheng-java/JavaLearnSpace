package queue��ϸ����;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *����һ��װƻ��������
 * @Author: gongZheng
 * @Date:   2019��9��25��   ����11:38:00 
 * @Description:
 */
public class Basket {
	// ���ӣ��ܹ�����3��ƻ��
	BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

	// ����ƻ������������
	public void produce() throws InterruptedException {
		// put���һ��Ԫ�� �������������������
		// ����һ��ƻ������basket���ˣ��ȵ�basket��λ��
		basket.put("An apple");
	}

	// ����ƻ������������ȡ��
	public String consume() throws InterruptedException {
		//take()�Ƴ������ض���ͷ����Ԫ��     �������Ϊ�գ�������
		//ȡ��һ��ƻ������basketΪ�գ��ȵ�basket��ƻ��Ϊֹ
		return basket.take();
	}
	
	public int getAppleNumber() {
		return basket.size();
		
	}

}

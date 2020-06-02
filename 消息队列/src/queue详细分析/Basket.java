package queue详细分析;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *定义一个装苹果的篮子
 * @Author: gongZheng
 * @Date:   2019年9月25日   上午11:38:00 
 * @Description:
 */
public class Basket {
	// 篮子，能够容纳3个苹果
	BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

	// 生产苹果，放入篮子
	public void produce() throws InterruptedException {
		// put添加一个元素 如果队列满，则阻塞；
		// 放入一个苹果，若basket满了，等到basket有位置
		basket.put("An apple");
	}

	// 消费苹果，从篮子中取走
	public String consume() throws InterruptedException {
		//take()移除并返回队列头部的元素     如果队列为空，则阻塞
		//取出一个苹果，若basket为空，等到basket有苹果为止
		return basket.take();
	}
	
	public int getAppleNumber() {
		return basket.size();
		
	}

}

package 实例01;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年9月24日 下午4:15:09
 * @Description:队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作
 *              LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
 */
public class Main {

	public static void main(String[] args) {
		// add()和remove()方法在失败的时候会抛出异常(不推荐)
		Queue<String> queue = new LinkedList<String>();
		// offer添加一个元素并返回true 如果队列已满，则返回false
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		prinlt(queue);

		/*
		 * poll： 移除并返问队列头部的元素    如果队列为空，则返回null
		 * peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
		 * element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
		 */
		System.out.println("poll():" + queue.poll());// poll()返回第一个元素，并在队列中删除
		prinlt(queue);
		System.out.println("element():" + queue.element());// 返回第一个元素
		prinlt(queue);
		System.out.println("peek():" + queue.peek());// 返回第一个元素;
		prinlt(queue);

	}

	public static void prinlt(Queue<String> queue) {
		for (String q : queue) {
			System.out.print(q + "\t");
		}
		System.out.println();
	}

}

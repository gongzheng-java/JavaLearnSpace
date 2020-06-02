package ʵ��01;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Author: gongZheng
 * @Date: 2019��9��24�� ����4:15:09
 * @Description:������һ����������Ա���ֻ�����ڱ��ǰ�˽���ɾ�����������ڱ�ĺ�˽��в������
 *              LinkedList��ʵ����Queue�ӿڣ�������ǿ��԰�LinkedList����Queue���á�
 */
public class Main {

	public static void main(String[] args) {
		// add()��remove()������ʧ�ܵ�ʱ����׳��쳣(���Ƽ�)
		Queue<String> queue = new LinkedList<String>();
		// offer���һ��Ԫ�ز�����true ��������������򷵻�false
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		prinlt(queue);

		/*
		 * poll�� �Ƴ������ʶ���ͷ����Ԫ��    �������Ϊ�գ��򷵻�null
		 * peek���鿴�׸�Ԫ�أ������Ƴ��׸�Ԫ�أ���������ǿյľͷ���null
		 * element���鿴�׸�Ԫ�أ������Ƴ��׸�Ԫ�أ���������ǿյľ��׳��쳣NoSuchElementException
		 */
		System.out.println("poll():" + queue.poll());// poll()���ص�һ��Ԫ�أ����ڶ�����ɾ��
		prinlt(queue);
		System.out.println("element():" + queue.element());// ���ص�һ��Ԫ��
		prinlt(queue);
		System.out.println("peek():" + queue.peek());// ���ص�һ��Ԫ��;
		prinlt(queue);

	}

	public static void prinlt(Queue<String> queue) {
		for (String q : queue) {
			System.out.print(q + "\t");
		}
		System.out.println();
	}

}

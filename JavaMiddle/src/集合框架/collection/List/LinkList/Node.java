package ���Ͽ��.collection.List.LinkList;

/**
 *
 * @Author: gongZheng
 * @Date:   2019��6��2��   ����1:53:03 
 * @Description:
 */
public class Node {
	
	//������һ��ֵ
	private Node previous;
	//���浱ǰֵ
	private Object obj;
	//������һ��ֵ
	private Node next;
	
	
	public Node() {
		super();
	}


	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}


	/**
	 * @return the previous
	 */
	public Node getPrevious() {
		return previous;
	}


	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}


	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}


	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}


	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	


	
	

}

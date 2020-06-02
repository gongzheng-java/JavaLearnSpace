package 集合框架.collection.List.LinkList;

/**
 * 手写linkList
 * @Author: gongZheng
 * @Date: 2019年6月2日 下午3:07:48
 * @Description: linkList底层实现是双向链表
 */
public class MyLinkedList {

	private Node firstNode;

	private Node lastNode;

	private int size;

	/**
	 * 添加元素
	 * @param obj
	 */
	public void add(Object obj) {
		Node node = new Node();
		if (firstNode == null) {
			// 如果当前添加的元素是第一个元素，那么第一个元素的前一个元素值是null，
			// 后一个元素仍是当前元素
			node.setPrevious(null);
			node.setObj(obj);
			node.setNext(null);
			firstNode = node;
			lastNode = node;
		} else {
			// 当前元素不是第一个元素时，当前元素的前一个元素是之前最后一个元素，当前元素的下一个元素还是null
			// 然后再将当前元素值赋给上一个元素的下一个值，最后将链表最后一个值设置为当前元素
			node.setPrevious(lastNode);
			node.setObj(obj);
			node.setNext(null);
			lastNode.setNext(node);
			lastNode = node;
		}
		size++;
	}

	/**
	 * 获取集合大小
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 根据索引获取元素 
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		checkIndex(index);
		return getNode(index).getObj();
		
	}
	
	/**
	 * 根据下标获取对应的元素 
	 * @param index
	 * @return 
	 * 说明：此处对获取元素做优化，如果容器中存在1000个元素，而我们想找的是第998个的话，就没必要从第一个遍历起，可以从最后一个遍历起
	 *      所以在遍历的时候，将要获取的元素位置和容器大小的1/2做比较，如果小于，则顺着遍历，否则逆向遍历。
	 *      
	 *      采用位移算法(速度最快)： << :左移 相当于乘以2，右侧数字表示乘以几次2，如 3<<3 表示 3*2*2*2
	 *	                         >>:右移 相当于除以2，右侧数字除以几次2，如 8>>3 表示 8/2/2/2
	 */
	private Node getNode(int index) {
		Node temp = null;
		if (firstNode != null) {
			if (index<(size>>1)) {
				System.out.println("顺向查找");
				temp = firstNode;
				for (int i = 0; i < index; i++) {
	               temp=temp.getNext();
				}
			}else {
				System.out.println("逆向查找");
				temp = lastNode;
				for (int i = size-1; i > index; i--) {
	               temp=temp.getPrevious();
				}
			}
			
		}
		return temp;
	}
	/**
	 * 检查数组越界
	 * @param index
	 */
	public void checkIndex(int index){
		if (index>=size||index<0) {
			try {
				throw new Exception("集合元素越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 删除指定位置的元素
	 * @param index
	 */
	public void remove(int index){
		checkIndex(index);//检查是否越界
		//获取指定位置的元素
		Node node=getNode(index);
		if (node!=null) {
			return;
		}
		//获取该位置的上一个元素和下一个元素，然后再将上一个元素赋值给下一个元素的上一个元素
		//将下一个元素的复制给上一个元素的下一个元素
		Node beforeNode=node.getPrevious();
		Node laterNode=node.getNext();
		beforeNode.setNext(laterNode);
		laterNode.setPrevious(laterNode);
		size--;
	}
	
	/**
	 * 删除某个对象
	 * @param obj
	 */
	public boolean remove(Object obj) {
		return false;
	}
	
	/**
	 * 向指定位置添加元素
	 * @param index
	 * @param obj
	 */
	public void add(int index,Object obj){
		checkIndex(index);//检查是否越界
		Node node=getNode(index);//获取插入位置的元素
		//创建新的元素，用于保存要插入的元素
		Node newNode=new Node();
		newNode.setPrevious(node.getPrevious());
		newNode.setObj(obj);
		newNode.setNext(node);
		//将当前元素的上一个元素的下一个元素赋值为新创建的元素
		node.getPrevious().setNext(newNode);
		//将当前元素的上个元素，赋值为新创建的元素
		node.setPrevious(newNode);
		size++;
	}

}

package ���Ͽ��.collection.List.LinkList;

/**
 * ��дlinkList
 * @Author: gongZheng
 * @Date: 2019��6��2�� ����3:07:48
 * @Description: linkList�ײ�ʵ����˫������
 */
public class MyLinkedList {

	private Node firstNode;

	private Node lastNode;

	private int size;

	/**
	 * ���Ԫ��
	 * @param obj
	 */
	public void add(Object obj) {
		Node node = new Node();
		if (firstNode == null) {
			// �����ǰ��ӵ�Ԫ���ǵ�һ��Ԫ�أ���ô��һ��Ԫ�ص�ǰһ��Ԫ��ֵ��null��
			// ��һ��Ԫ�����ǵ�ǰԪ��
			node.setPrevious(null);
			node.setObj(obj);
			node.setNext(null);
			firstNode = node;
			lastNode = node;
		} else {
			// ��ǰԪ�ز��ǵ�һ��Ԫ��ʱ����ǰԪ�ص�ǰһ��Ԫ����֮ǰ���һ��Ԫ�أ���ǰԪ�ص���һ��Ԫ�ػ���null
			// Ȼ���ٽ���ǰԪ��ֵ������һ��Ԫ�ص���һ��ֵ������������һ��ֵ����Ϊ��ǰԪ��
			node.setPrevious(lastNode);
			node.setObj(obj);
			node.setNext(null);
			lastNode.setNext(node);
			lastNode = node;
		}
		size++;
	}

	/**
	 * ��ȡ���ϴ�С
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * ����������ȡԪ�� 
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		checkIndex(index);
		return getNode(index).getObj();
		
	}
	
	/**
	 * �����±��ȡ��Ӧ��Ԫ�� 
	 * @param index
	 * @return 
	 * ˵�����˴��Ի�ȡԪ�����Ż�����������д���1000��Ԫ�أ����������ҵ��ǵ�998���Ļ�����û��Ҫ�ӵ�һ�������𣬿��Դ����һ��������
	 *      �����ڱ�����ʱ�򣬽�Ҫ��ȡ��Ԫ��λ�ú�������С��1/2���Ƚϣ����С�ڣ���˳�ű������������������
	 *      
	 *      ����λ���㷨(�ٶ����)�� << :���� �൱�ڳ���2���Ҳ����ֱ�ʾ���Լ���2���� 3<<3 ��ʾ 3*2*2*2
	 *	                         >>:���� �൱�ڳ���2���Ҳ����ֳ��Լ���2���� 8>>3 ��ʾ 8/2/2/2
	 */
	private Node getNode(int index) {
		Node temp = null;
		if (firstNode != null) {
			if (index<(size>>1)) {
				System.out.println("˳�����");
				temp = firstNode;
				for (int i = 0; i < index; i++) {
	               temp=temp.getNext();
				}
			}else {
				System.out.println("�������");
				temp = lastNode;
				for (int i = size-1; i > index; i--) {
	               temp=temp.getPrevious();
				}
			}
			
		}
		return temp;
	}
	/**
	 * �������Խ��
	 * @param index
	 */
	public void checkIndex(int index){
		if (index>=size||index<0) {
			try {
				throw new Exception("����Ԫ��Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * ɾ��ָ��λ�õ�Ԫ��
	 * @param index
	 */
	public void remove(int index){
		checkIndex(index);//����Ƿ�Խ��
		//��ȡָ��λ�õ�Ԫ��
		Node node=getNode(index);
		if (node!=null) {
			return;
		}
		//��ȡ��λ�õ���һ��Ԫ�غ���һ��Ԫ�أ�Ȼ���ٽ���һ��Ԫ�ظ�ֵ����һ��Ԫ�ص���һ��Ԫ��
		//����һ��Ԫ�صĸ��Ƹ���һ��Ԫ�ص���һ��Ԫ��
		Node beforeNode=node.getPrevious();
		Node laterNode=node.getNext();
		beforeNode.setNext(laterNode);
		laterNode.setPrevious(laterNode);
		size--;
	}
	
	/**
	 * ɾ��ĳ������
	 * @param obj
	 */
	public boolean remove(Object obj) {
		return false;
	}
	
	/**
	 * ��ָ��λ�����Ԫ��
	 * @param index
	 * @param obj
	 */
	public void add(int index,Object obj){
		checkIndex(index);//����Ƿ�Խ��
		Node node=getNode(index);//��ȡ����λ�õ�Ԫ��
		//�����µ�Ԫ�أ����ڱ���Ҫ�����Ԫ��
		Node newNode=new Node();
		newNode.setPrevious(node.getPrevious());
		newNode.setObj(obj);
		newNode.setNext(node);
		//����ǰԪ�ص���һ��Ԫ�ص���һ��Ԫ�ظ�ֵΪ�´�����Ԫ��
		node.getPrevious().setNext(newNode);
		//����ǰԪ�ص��ϸ�Ԫ�أ���ֵΪ�´�����Ԫ��
		node.setPrevious(newNode);
		size++;
	}

}

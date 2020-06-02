package �����ߺ�������201;

/**
 *
 * @Author: gongZheng
 * @Date: 2017��11��25�� ����3:39:04
 * @Description:
 */
public class Pojo {

	private String name;
	private int count = 1;
	private boolean flag = false;

	// ��ֵ
	public synchronized void set(String name) {
		// �˴�ʹ��while����������if��Ϊ�˷�ִֹ����ͬ��������һ���߳�,��wait()���ѹ�����ȡcpuִ��Ȩʱ��û�о�����ʶ�ж϶�ֱ��ִ�������߲�����
		// �Ӷ���������ִ�����������߲���������ʱ���˴��ĳ�if�жϣ�ͬʱ��notifyAll()�ĳ�notify()���Ա�Ч����
		while (flag) {
			// if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "--->" + count++;
		System.out.println(Thread.currentThread().getName() + "������:" + this.name);
		flag = true;
		// this.notify();
		this.notifyAll();// �����жϸĳ���while������˴���ʹ��notifyAll()�����������д���wait()�е��̣߳���ô������߳��������̣߳������е��̶߳�����wait()״̬
	}

	// ���
	public synchronized void out() {
		// �˴�ʹ��while �ĵ���ͬ��
		while (!flag) {
			// if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "*******������*********" + this.name);
		flag = false;
		// this.notify();
		this.notifyAll();// ԭ��ͬ��
	}
}

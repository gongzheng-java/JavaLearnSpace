package Collection.customize;

/**
 * ģ���дjdk�е� ArrayList��
 * 
 * @Author: gongZheng
 * @Date: 2019��3��17�� ����7:12:46
 * @Description:
 */
public class MyArrayList {

	private Object[] value;

	private int size;

	/**
	 * ���弯�ϳ�ʼ��С �����ü���Ĭ�ϴ�С��
	 */
	public MyArrayList() {
		this(2);// ������һ��������
	}

	/**
	 * ָ�����ϴ�С
	 * 
	 * @param count
	 */
	public MyArrayList(int size) {
		if (size <= 0) {
			try {
				throw new Exception("���ϴ�С����С�ڵ���0");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		value = new Object[size];
	}

	/**
	 * ���ؼ��ϴ�С
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * ��Ӽ���Ԫ��
	 * 
	 * @param obj
	 */
	public void add(Object obj) {
		this.value[size] = obj;
		size++;
		// ��������
		if (size >= value.length) {
			int newSize = value.length * 2 + 2;
			Object[] newObj = new Object[newSize];
			for (int i = 0; i < value.length; i++) {
				newObj[i] = value[i];
			}
			value = newObj;
		}
	}

	/**
	 * ȡ������Ԫ��
	 * 
	 * @param indexOf
	 * @return
	 */
	public Object get(int indexOf) {
		indexOfCheck(indexOf);
		return value[indexOf];
	}

	/**
	 * ����Խ�紦��
	 * 
	 * @param indexOf
	 */
	private void indexOfCheck(int indexOf) {
		if (indexOf < 0 || indexOf >= size) {
			try {
				throw new Exception("����Ԫ��Խ��!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �жϼ����Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * �жϼ������Ƿ����ĳԪ��
	 * 
	 * @param obj
	 * @return
	 */
	public int indexOf(Object obj) {
		if (obj == null) {
			return -1;
		}
		for (int i = 0; i < value.length; i++) {
			if (obj.equals(value[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Ԫ���滻
	 * 
	 * @param index
	 *            �滻λ�õ�����
	 * @param obj
	 *            ��Ҫ�滻��Ԫ��
	 */
	public void set(int index, Object obj) {

	}

}

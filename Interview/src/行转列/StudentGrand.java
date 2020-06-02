package 行转列;

/**
 *
 * @Author: gongZheng
 * @Date: 2019年2月21日 下午8:05:49
 * @Description:
 */
public class StudentGrand {
	// public int num;
	private String id;

	private String name;

	private String subject;

	private String grand;

	public StudentGrand() {
		super();
	}

	public StudentGrand(String id, String name, String subject, String grand) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.grand = grand;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the grang
	 */
	public String getGrand() {
		return grand;
	}

	/**
	 * @param grang
	 *            the grang to set
	 */
	public void setGrang(String grand) {
		this.grand = grand;
	}

	// get和set方法，main()中的构造方法这里省略了

}

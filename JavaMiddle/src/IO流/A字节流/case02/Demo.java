package IO��.A�ֽ���.case02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * file���÷���
 * @Author: gongZheng
 * @Date:   2019��10��16��   ����7:45:56 
 * @Description:
 */
public class Demo {

	/**
	 * �ļ���
	 */
	@Test
	public void test() {
		String path="F:/tmp/bpm/cache/test.sql";
		File file=new File(path);
		System.out.println("�ļ�����"+file.getName());
		System.out.println("·����"+file.getPath());
		System.out.println("��һ��Ŀ¼��"+file.getParent());//û����һ��Ŀ¼������null
		System.out.println("����·����"+file.getAbsolutePath());
	}
	
	
	/**
	 * �ļ��ж�
	 */
	@Test
	public void test1() {
		String path="F:/tmp/bpm/cache/test.sql";
		//path="F:/tmp/bpm/cache";
		File file=new File(path);
		System.out.println("�ļ��Ƿ���ڣ�"+file.exists());
		System.out.println("�ļ��Ƿ�ɶ�д��"+file.canRead()+"/"+file.canWrite());
		
		System.out.println("�Ƿ����ļ���"+file.isFile());//����ļ������ڣ�Ĭ����false
		System.out.println("�Ƿ����ļ���(Ŀ¼)��"+file.isDirectory());
		System.out.println("�Ƿ��Ǿ���·����"+file.isAbsolute());
	}
	
	/**
	 * �ļ�����
	 * ���� ��ɾ��
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws IOException, InterruptedException {
		String path = "F:/test/����.txt";
		File file=new File(path);
		//����ļ������ڣ��򴴽�
		if (!file.exists()) {
			boolean flag=file.createNewFile();
			System.out.println("�Ƿ񴴽��ɹ���"+flag);//����ļ������򴩼�ʧ��
		}else {
			System.out.println("�ļ��Ѿ����ڣ�");
		}
		Thread.sleep(3000);
		//ɾ���ļ�
		boolean flag=file.delete();
		System.out.println("�Ƿ�ɾ���ɹ���"+flag);
		
		//������ʱ�ļ� createTempFile(prefix, suffix, directory) 
		//ǰ׺3���ֽڳ� ��׺Ĭ��0.temp,Ŀ¼
		File temp=File.createTempFile("���Զ���", ".jsp",new File("F:/test"));
		Thread.sleep(5000);
		temp.deleteOnExit();//�˳���ɾ��
	}
	

}

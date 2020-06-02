package com.jdbc.demo;

import java.sql.*;


public class TEXT {
	public static void main(String[] args) {
		System.out.println("����ǰ��");
		query();
		update("���","���");
		System.out.println("���º�");
		query();
		
	}

	//�����ֶ��ֶ�
	private static String driver = "com.mysql.jdbc.Driver";// ���ݿ������ַ���
	private static String url = "jdbc:mysql://localhost:3306/xsd";// ����URL�ַ���
	private static String user = "root"; // ���ݿ��û���
	private static String password = "123456"; // �û�����
	static Connection conn = null;
	static PreparedStatement pStatement = null;
	static ResultSet rSet = null;

	/**
	 * �رյķ���
	 * 
	 * @throws SQLException
	 */
	static void close() throws SQLException {
		// 7.�ر�
		if (rSet != null) {
			rSet.close();
		}
		if (pStatement != null) {
			pStatement.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * �޲β�ѯ����
	 */
	static void query() {
		try {
			// 1.��������
			Class.forName(driver);
			// 2.�������Ӷ���
			conn = DriverManager.getConnection(url, user, password);
			// 3.��дSQL���
			String sql = "select StudntNo,StudentName,Sex from dbo.Student";
			// 4.����ִ�ж���
			pStatement = conn.prepareStatement(sql);
			// 5.ִ�в���
			rSet = pStatement.executeQuery();
			// 6.������
			System.out.println("ѧ����Ϣ���£�");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t"+ rSet.getString(2) + "\t" + rSet.getString(3));
			}
			//7.�ر�����
			close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * ���β�ѯ
	 * @param name ѧ������   
	 */
	static void query(String name) {

		try {
			// 1.��������
			Class.forName(driver);
			// 2.��������
			conn = DriverManager.getConnection(url, user, password);
			// 3.��дSQL���
			String sql = "select StudntNo,StudentName,Sex from dbo.Student where StudentName=?";
			// 4.��ȡִ�ж���
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, name);
			// 5.ִ�в�ѯ����
			rSet = pStatement.executeQuery();
			// 6.������
			System.out.println("ѧ����Ϣ���£�");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "    "
						+ rSet.getString(2) + "   " + rSet.getString(3));

			}
			//7.�ر�
			close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * �����������ģ����ѯ
	 * @param name ����          
	 * @param sex �Ա�            
	 */
	public static void query(String name, String sex) {

		try {
			// 1.��������
			Class.forName(driver);
			// 2.�������Ӷ���
			conn = DriverManager.getConnection(url, user, password);
			// 3.��дsql���
			String sql = "select StudntNo,StudentName,Sex from dbo.Student where StudentName like ? and Sex=?";
			// 4.����ִ�ж���
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, name + "%");
			pStatement.setString(2, sex);
			// 5.ִ�в�ѯ����
			rSet = pStatement.executeQuery();
			// 6.������
			System.out.println("ѧ����Ϣ���£�");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "    "
						+ rSet.getString(2) + "   " + rSet.getString(3));

			}
			close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	/**
	 * ���²���
	 * @param name ԭ��
	 * @param newName ���º������
	 */
	public static void update(String name,String newName){
		
		try {
			//1.��������
			Class.forName(driver);
			//2.�������Ӷ���
			conn=DriverManager.getConnection(url, user, password);
			//3.sql���
			String sql="update dbo.Student set StudentName=? where StudentName=?";
			//4.����ִ�ж���
			pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, newName);
			pStatement.setString(2, name);
			//5.ִ�и��²��� ����int����
		int num=pStatement.executeUpdate();//ע�⣺����ɾ����  ��������һ�ַ���
		if (num>=1) {
			System.out.println("���³ɹ���");
		}else if (num<1) {
			System.out.println("����ʧ�ܣ�");
		}
		//�رն���
		close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

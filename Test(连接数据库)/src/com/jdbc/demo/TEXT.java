package com.jdbc.demo;

import java.sql.*;


public class TEXT {
	public static void main(String[] args) {
		System.out.println("更新前：");
		query();
		update("金飞","金蝶");
		System.out.println("更新后：");
		query();
		
	}

	//常用字段字段
	private static String driver = "com.mysql.jdbc.Driver";// 数据库驱动字符串
	private static String url = "jdbc:mysql://localhost:3306/xsd";// 连接URL字符串
	private static String user = "root"; // 数据库用户名
	private static String password = "123456"; // 用户密码
	static Connection conn = null;
	static PreparedStatement pStatement = null;
	static ResultSet rSet = null;

	/**
	 * 关闭的方法
	 * 
	 * @throws SQLException
	 */
	static void close() throws SQLException {
		// 7.关闭
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
	 * 无参查询方法
	 */
	static void query() {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建连接对象
			conn = DriverManager.getConnection(url, user, password);
			// 3.编写SQL语句
			String sql = "select StudntNo,StudentName,Sex from dbo.Student";
			// 4.创建执行对象
			pStatement = conn.prepareStatement(sql);
			// 5.执行操作
			rSet = pStatement.executeQuery();
			// 6.输出结果
			System.out.println("学生信息如下：");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t"+ rSet.getString(2) + "\t" + rSet.getString(3));
			}
			//7.关闭连接
			close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * 带参查询
	 * @param name 学生姓名   
	 */
	static void query(String name) {

		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建连接
			conn = DriverManager.getConnection(url, user, password);
			// 3.编写SQL语句
			String sql = "select StudntNo,StudentName,Sex from dbo.Student where StudentName=?";
			// 4.获取执行对象
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, name);
			// 5.执行查询操作
			rSet = pStatement.executeQuery();
			// 6.输出结果
			System.out.println("学生信息如下：");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "    "
						+ rSet.getString(2) + "   " + rSet.getString(3));

			}
			//7.关闭
			close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * 带多个参数的模糊查询
	 * @param name 姓氏          
	 * @param sex 性别            
	 */
	public static void query(String name, String sex) {

		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建连接对象
			conn = DriverManager.getConnection(url, user, password);
			// 3.编写sql语句
			String sql = "select StudntNo,StudentName,Sex from dbo.Student where StudentName like ? and Sex=?";
			// 4.创建执行对象
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, name + "%");
			pStatement.setString(2, sex);
			// 5.执行查询操作
			rSet = pStatement.executeQuery();
			// 6.输出结果
			System.out.println("学生信息如下：");
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
	 * 更新操作
	 * @param name 原名
	 * @param newName 更新后的名称
	 */
	public static void update(String name,String newName){
		
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.创建连接对象
			conn=DriverManager.getConnection(url, user, password);
			//3.sql语句
			String sql="update dbo.Student set StudentName=? where StudentName=?";
			//4.创建执行对象
			pStatement=conn.prepareStatement(sql);
			pStatement.setString(1, newName);
			pStatement.setString(2, name);
			//5.执行更新操作 返回int类型
		int num=pStatement.executeUpdate();//注意：增、删、改  都是用这一种方法
		if (num>=1) {
			System.out.println("更新成功！");
		}else if (num<1) {
			System.out.println("更新失败！");
		}
		//关闭对象
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

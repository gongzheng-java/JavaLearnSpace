package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		query();
	}
	//  BZH_SafetyMonitor
	//远程连接 标准化服务器
	/*private static String driver = "net.sourceforge.jtds.jdbc.Driver";
	private static String url = "jdbc:jtds:sqlserver://120.76.230.93:4322/YGSKDB";
	private static String user = "sa"; // 数据库用户名
	private static String password = "123qwe=-~SBBS"; // 用户密码
	*/
	
	// 远程连接 曹娥江服务器  不成功
	/*  private static String driver = "net.sourceforge.jtds.jdbc.Driver";
	  private static String url ="jdbc:jtds:sqlserver://122.224.39.108:1434/CEJ"; 
	  private static String user = "sa"; 
	  private static String password = "sa85626419"; */
	 
	

	// 两种连接方式的比较(注意：要分别导入jdbc和jtds的jar包) 本地连接
	// jdbc方式
	/*
	 * private static String driver =
	 * "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串 private static
	 * String url = "jdbc:sqlserver://localhost:1433;database=CEJ"
	 */// 连接URL字符串

	// jtds方式 本地连接
	private static String driver = "net.sourceforge.jtds.jdbc.Driver";
	// 本机IP三种连接方式 
	private static String url ="jdbc:jtds:sqlserver://127.0.0.1:1433/CEJ";  
	//private static String url ="jdbc:jtds:sqlserver:/localhost:1433/CEJ";
	//private static String url = "jdbc:jtds:sqlserver:/192.168.10.148:1433/CEJ";
	private static String user = "sa"; // 数据库用户名
	private static String password= "123456"; // 用户密码

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
			//String sql = "select * from dbo.sys_role";
			String sql="insert into sys_role(id,name,create_by,create_date,update_by,update_date,del_flag) values (7,'测试','1','2016-06-06 17:28:58','1','2016-12-02 16:18:08','0')";
			//String sql="SELECT * from ProYGSKCurrentFloodForecastRecord";
			// 4.创建执行对象
			pStatement = conn.prepareStatement(sql);
			// 5.执行操作
			rSet = pStatement.executeQuery();
			// 6.输出结果
			System.out.println("数据信息如下：");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t" + rSet.getString(2) + "\t" + rSet.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7.关闭连接
			try {
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

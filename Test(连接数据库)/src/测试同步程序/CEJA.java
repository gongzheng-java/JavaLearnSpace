package 测试同步程序;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CEJA {

	// 常用字段字段
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串
	private static String url = "jdbc:sqlserver://localhost:1433;database=yurun";// 连接URL字符串
	private static String user = "sa"; // 数据库用户名
	private static String password = "123456"; // 用户密码
	private static Connection conn = null;
	private static PreparedStatement pStatement = null;
	private static ResultSet rSet = null;
	
	/**
	 * 关闭的方法
	 * 
	 * @throws SQLException
	 */
	private void close() throws SQLException {
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

	private List<RainAll> rainAlls=new ArrayList<RainAll>();
	
	public List<RainAll> query(){
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建连接对象
			conn = DriverManager.getConnection(url, user, password);
			// 3.编写SQL语句
			//String sql="select top 50000 * from dbo.RainAll";
			String sql = "insert into dbo.WATER values ('3239','2017-07-04 22:40:01.000',10.25,0,6,null)";//通过SQL语句访问另一个数据库中的表数据
			// 4.创建执行对象
			pStatement = conn.prepareStatement(sql);
			
			// 5.执行操作
			int num=pStatement.executeUpdate();//注意：增、删、改  都是用这一种方法
			System.out.println(num);
			//rSet = pStatement.executeQuery();
			// 6.输出结果
			/*System.out.println("获取的值是：");
			while (rSet.next()) {
				System.out.println(rSet.getString(1)+rSet.getTimestamp(2)+rSet.getFloat(3));
				
			}*/
			/*while (rSet.next()) {
				RainAll rainAll = new RainAll();
				rainAll.setStcd(rSet.getString(1));
				rainAll.setEndTime(rSet.getTimestamp(2));
				rainAll.setRn(rSet.getBigDecimal(3));
				rainAlls.add(rainAll);
			}*/
          
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7.关闭连接
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rainAlls;
	}
	
	
	
	
}

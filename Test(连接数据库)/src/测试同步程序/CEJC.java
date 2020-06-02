package 测试同步程序;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CEJC {

	// 常用字段字段
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串
	private static String url = "jdbc:sqlserver://localhost:1433;database=CEJB";// 连接URL字符串
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

	private List<RainAll> rainAlls = new ArrayList<RainAll>();
    private int[]	 num;
	public int[] add(List<RainAll> rainAlls) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.创建连接对象
			conn = DriverManager.getConnection(url, user, password);
			// 3.编写SQL语句
			String sql = "insert into dbo.RainAll values(?,?,?)";
			// 4.创建执行对象
			pStatement = conn.prepareStatement(sql);
			// 5.执行操作
			for (RainAll rainAll : rainAlls) {
				pStatement.setString(1, rainAll.getStcd());
				pStatement.setTimestamp(2, (Timestamp) rainAll.getEndTime());;
				pStatement.setBigDecimal(3, rainAll.getRn());
				pStatement.addBatch();
			}
		 num =pStatement.executeBatch();
		 conn.commit();
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
		return num;
	}

}
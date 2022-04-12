package cn.itcast.Librarymanage.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 工具类
 */
public class JDBCUtils {
	// 加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&characterEncoding=utf-8";
		String username = "root";
		String password = "639163";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	// 关闭数据库连接，释放资源
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	//释放数据库
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}
	
	//关闭数据库
	public static void close(Connection connection) {
		if(connection!=null){
             try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
    }
		
	/* 
	判断是否为空
	*/
			public static boolean isEmpty(String str)  {
				if(str==null||"".equals(str.trim())) {
					return true;//1真
				}else {
					return false;//0假
				}
			}
		/*
		判断是否不为空
			
		*/
			public static boolean isNotEmpty(String str) {
				if(str!=null&&!"".equals(str.trim())) {
					return true;
				}else {
					return false;
				}
			}
		
}

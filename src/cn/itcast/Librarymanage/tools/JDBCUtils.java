package cn.itcast.Librarymanage.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ������
 */
public class JDBCUtils {
	// �������������������ݿ�����
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&characterEncoding=utf-8";
		String username = "root";
		String password = "639163";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	// �ر����ݿ����ӣ��ͷ���Դ
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
	//�ͷ����ݿ�
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
	
	//�ر����ݿ�
	public static void close(Connection connection) {
		if(connection!=null){
             try {
				connection.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
        }
    }
		
	/* 
	�ж��Ƿ�Ϊ��
	*/
			public static boolean isEmpty(String str)  {
				if(str==null||"".equals(str.trim())) {
					return true;//1��
				}else {
					return false;//0��
				}
			}
		/*
		�ж��Ƿ�Ϊ��
			
		*/
			public static boolean isNotEmpty(String str) {
				if(str!=null&&!"".equals(str.trim())) {
					return true;
				}else {
					return false;
				}
			}
		
}

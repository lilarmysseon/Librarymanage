package cn.itcast.Librarymanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.itcast.Librarymanage.domain.BookInformation;
import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.User;
import cn.itcast.Librarymanage.tools.JDBCUtils;

public class UserDao {
	// ��ȡ��������
		public ArrayList<BookItem> queryAllData() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<BookItem> list1 = new ArrayList<BookItem>();
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
				String sql = "SELECT * FROM book";
				rs = stmt.executeQuery(sql);
				// ��������
				while (rs.next()) {
					BookItem bookItem = new BookItem();
					bookItem.setNumbering(rs.getString("numbering"));
					bookItem.setBookname(rs.getString("bookname"));
					bookItem.setNumber(rs.getInt("number"));
					bookItem.setPrice(rs.getString("price"));
					list1.add(bookItem);
				}
				return list1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return null;
		}

	//�û�ע��
	public void addUser(Connection con,User user) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "INSERT INTO user(user_id,user_name,user_phone,user_password)"
					+ "VALUES('" + user.getuser_id() + "','" + user.getuser_name()
					+ "','" + user.getuser_phone() + "','" + user.getuser_password()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("�������ݳɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	
	//�������

	public void bookborrow(BookInformation BookInformation) {// ������ظ�һ��

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "INSERT INTO book_information(numbering,user_name,book_status)"
					+ "VALUES(" + BookInformation.getNumbering() + ",'" + BookInformation.getUser_name()
					+  "','" + BookInformation.getBook_status()+")";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("����ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	//����
	public void bookreturn(String reNumbering) {// ������ظ�һ��

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
		   String sql = "delete FROM book_information WHERE numbering=" + reNumbering;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("����ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	/**
	 * �û���Ϣ����,�����ã��û�id������ͬ
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public static User query(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql ="select * from user where user_name=? and user_password=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, user.getuser_name());
		pstmt.setString(2, user.getuser_password());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			resultUser = new User();
			resultUser.setuser_id(rs.getString("user_id"));
			resultUser.setuser_name(rs.getString("user_name"));
			resultUser.setuser_phone(rs.getString("user_phone"));
			resultUser.setuser_password(rs.getString("user_password"));
		}
		return resultUser;
    }
}	
    //�û���¼





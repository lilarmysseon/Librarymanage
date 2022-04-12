package cn.itcast.Librarymanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.Admin;
import cn.itcast.Librarymanage.service.User;
import cn.itcast.Librarymanage.tools.JDBCUtils;

/*
 * ����Ա���ݷ�����
 */
public class AdminDao {
	/*
	 * 
	//��ȡ��������
	public ArrayList<BookItem> queryAllData() {		
		return DataBase.data;
	}
	//�������
	public void addBookItem(BookItem bookItem) {
		DataBase.data.add(bookItem);
	}
	//ɾ������
	public void delBookItem(String delNumber) {
		//��ѯ����������
		for (int i = 0; i < DataBase.data.size(); i++) {
			FruitItem thisBookItem = DataBase.data.get(i);
			//�����ͼ����ı���봫������ͬ����Ӽ�����ɾ��
			if(thisBookItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
  */
//------Ϊ�˷������ѧϰ������Ϊԭ��ʹ�ü���ģ�����ݿ�ķ���������Ϊ����MySQL���ݿ��ķ���--------------------------------------------	

	// ��ȡ��������
	public ArrayList<BookItem> queryAllData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookItem> list = new ArrayList<BookItem>();
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
				list.add(bookItem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//�������
	public void addBookItem(BookItem BookItem) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "INSERT INTO book(numbering,bookname,number,price)"
					+ "VALUES(" + BookItem.getNumbering() + ",'" + BookItem.getBookname()
					+ "','" + BookItem.getNumber() + "','" + BookItem.getPrice()+ "')";
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
	
	//ɾ������
	public void delBookItem(String delNumbering) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "DELETE FROM book WHERE numbering=" + delNumbering;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("ɾ�����ݳɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	 //��¼������Ϣ
	public Admin login(Connection con,Admin admin) throws Exception{
		cn.itcast.Librarymanage.service.Admin  resultUser = null;
		String sql = "select * from admin where admin_name=? and admin_password=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,admin.getAdmin_name());//��ָ����������Ϊ���� Java String ֵ
		pstmt.setString(2,admin.getAdmin_password());
		ResultSet rs = pstmt.executeQuery();//�ڴ� PreparedStatement ������ִ�� SQL ��ѯ�������ظò�ѯ���ɵ� ResultSet ����
		if(rs.next()) {
			resultUser = new Admin();
			resultUser.setAdmin_id(rs.getString("admin_id"));
			resultUser.setAdmin_name(rs.getString("admin_name"));
			resultUser.setAdmin_phone(rs.getString("admin_phone"));
			resultUser.setAdmin_password(rs.getString("admin_password"));
		}
		return resultUser; 
	}
	

	/**
	 * ͨ���û�Id��ѯ�û�������Ϣ
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con, int userId)throws Exception{
		String sql = "select * from user where user_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, userId);
		return pstmt.executeQuery();
	}
	
	public ArrayList<User> queryAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			// ��������
			while (rs.next()) {
				User user = new User();
				user.setuser_id(rs.getString("user_id"));
				user.setuser_name(rs.getString("user_name"));
				user.setuser_phone(rs.getString("user_phone"));
				user.setuser_password(rs.getString("user_password"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	//ɾ���û�
	public int delete(Connection con, int userId)throws Exception{
		String sql = "delete from user where user_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, userId);
		return pstmt.executeUpdate();
	}

	
	//�������
	public void addUser(User BookItem) {
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
					+ "VALUES('" + BookItem.getuser_id() + "','" + BookItem.getuser_name()
					+ "','" + BookItem.getuser_phone() + "','" + BookItem.getuser_password()+ "')";
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
	
	//ɾ������
	public void delUser(String delNumbering) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "DELETE FROM user WHERE user_id=" + delNumbering;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("ɾ�����ݳɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	
}
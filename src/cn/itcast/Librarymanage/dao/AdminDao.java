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
 * 管理员数据访问类
 */
public class AdminDao {
	/*
	 * 
	//获取所有数据
	public ArrayList<BookItem> queryAllData() {		
		return DataBase.data;
	}
	//添加数据
	public void addBookItem(BookItem bookItem) {
		DataBase.data.add(bookItem);
	}
	//删除数据
	public void delBookItem(String delNumber) {
		//查询集合中数据
		for (int i = 0; i < DataBase.data.size(); i++) {
			FruitItem thisBookItem = DataBase.data.get(i);
			//如果有图书项的编号与传入编号相同，则从集合中删除
			if(thisBookItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
  */
//------为了方便读者学习，以上为原来使用集合模拟数据库的方法，以下为连接MySQL数据库后的方法--------------------------------------------	

	// 获取所有数据
	public ArrayList<BookItem> queryAllData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookItem> list = new ArrayList<BookItem>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM book";
			rs = stmt.executeQuery(sql);
			// 处理结果集
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
	
	//添加数据
	public void addBookItem(BookItem BookItem) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "INSERT INTO book(numbering,bookname,number,price)"
					+ "VALUES(" + BookItem.getNumbering() + ",'" + BookItem.getBookname()
					+ "','" + BookItem.getNumber() + "','" + BookItem.getPrice()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	
	//删除数据
	public void delBookItem(String delNumbering) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "DELETE FROM book WHERE numbering=" + delNumbering;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("删除数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	 //登录查找信息
	public Admin login(Connection con,Admin admin) throws Exception{
		cn.itcast.Librarymanage.service.Admin  resultUser = null;
		String sql = "select * from admin where admin_name=? and admin_password=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1,admin.getAdmin_name());//将指定参数设置为给定 Java String 值
		pstmt.setString(2,admin.getAdmin_password());
		ResultSet rs = pstmt.executeQuery();//在此 PreparedStatement 对象中执行 SQL 查询，并返回该查询生成的 ResultSet 对象。
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
	 * 通过用户Id查询用户所有信息
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
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			// 处理结果集
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
	//删除用户
	public int delete(Connection con, int userId)throws Exception{
		String sql = "delete from user where user_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, userId);
		return pstmt.executeUpdate();
	}

	
	//添加数据
	public void addUser(User BookItem) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "INSERT INTO user(user_id,user_name,user_phone,user_password)"
					+ "VALUES('" + BookItem.getuser_id() + "','" + BookItem.getuser_name()
					+ "','" + BookItem.getuser_phone() + "','" + BookItem.getuser_password()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	
	//删除数据
	public void delUser(String delNumbering) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "DELETE FROM user WHERE user_id=" + delNumbering;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("删除数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	
}
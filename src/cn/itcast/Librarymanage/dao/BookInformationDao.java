package cn.itcast.Librarymanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import cn.itcast.Librarymanage.domain.BookInformation;



public class BookInformationDao {
	/**
	 * book_borrow����Ӳ���
	 * @param con
	 * @param booki
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookInformation booki) throws Exception{
		String sql = "insert into book_information values(?,?,?)";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		
		pstmt.setString(1, booki.getNumbering());
		pstmt.setString(2, booki.getUser_name());
		pstmt.setString(5, booki.getBook_status());
		
		return pstmt.executeUpdate();
	}
	/**
	 * book_borrow��黹����
	 * @param con
	 * @param booki
	 * @return
	 * @throws SQLException
	 */
	public ResultSet returnn(Connection con, BookInformation booki) throws SQLException { 
		ResultSet rs = null;
		String sql = "select * from book_information where book_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, booki.getNumbering());
		rs = pstmt.executeQuery();
		return rs;
	}
	/**
	 * book_borrow��ɾ������
	 * @param con
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,int bookId) throws Exception{
		String sql = "delete from book_information where book_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		return pstmt.executeUpdate();
	}
}

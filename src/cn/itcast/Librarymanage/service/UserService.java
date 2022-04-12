package cn.itcast.Librarymanage.service;



import java.sql.Connection;
import java.sql.ResultSet;
/*
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;  */
import java.util.ArrayList;


import javax.swing.JOptionPane;

import javax.swing.JTextField;


import cn.itcast.Librarymanage.dao.BookInformationDao;
import cn.itcast.Librarymanage.dao.UserDao;
import cn.itcast.Librarymanage.domain.BookInformation;
import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.tools.JDBCUtils;


		
public class UserService{


	private UserDao userDao = new UserDao();
	private JTextField book_idTxt;
	private JTextField book_nameTxt;
	private JTextField book_statusTxt;
	private JDBCUtils util= new JDBCUtils();
	private BookInformationDao bookInformationDao = new BookInformationDao();
	private JTextField borrowNumberingText;
	public static String userName;
	public static String adminName;

	//获取数据	
	
	public ArrayList<BookItem> queryBookItem()  {
		//调用Dao层的获取所有数据方法获取所有数据
	   ArrayList<BookItem> data1 = userDao.queryAllData();
		//返回数据
		return data1;
	

      }
	  public  boolean bookborrow(String borrownumbering,String user_name) {
		//String numbering,String user_name,String book_status,int number
	//       String bookId = this.borrowNumberingText.getText();
		  BookItem bi =new BookItem();
	/*	  if(JDBCUtils.isEmpty(bookId)) {
				JOptionPane.showMessageDialog(null, "图书信息不能为空！");
				return true;
		  }*/
		//调用Dao层的获取所有数据方法获取所有数据
				ArrayList<BookItem> data = queryBookItem();
				//使用输入的编号与所有数据对比
				for (int i = 0; i < data.size(); i++) {
					BookItem bookItem = data.get(i);
					//如果数量为零，则借书不成功
					if(bi.getNumber() == 0 && borrownumbering == bi.getNumbering()) {
						JOptionPane.showMessageDialog(null, "没有图书！");
						return true;
					}
				  }
		/*		if(JDBCUtils.isEmpty(bookId)) {
					JOptionPane.showMessageDialog(null, "图书信息不能为空！");
					return true;
				
				}
		*/	
//					BookInformation bif =new BookInformation();
					//如果数量不为零，将数据封装为BookInformation对象
				BookInformation thisBI= new BookInformation();//bookinformation记录加一，BookItem数量减一
					//调用Dao层的添加数据方法
				     userDao.bookborrow(thisBI);
					//在成功借书后，返回借书成功
					JOptionPane.showMessageDialog(null, "借书成功！");
					return true;
}
			

	  /**
		 * 归还图书函数
		 */
		protected  void bookreturn(String delNumbering) {
			String bookId = this.book_idTxt.getText();
			String bookName = this.book_nameTxt.getText();

			String bookStatus = this.book_statusTxt.getText();
			
			if(JDBCUtils.isEmpty(bookId)) {
				JOptionPane.showMessageDialog(null, "图书信息不能为空！");
				return ;
			}
			
			Connection con = null;
			try {
				BookInformation bi = new BookInformation();
		         	BookItem book = new BookItem();
				bi.setBook_status("无借出");//把图书状态改变为0
				
				con = util.getConnection();
				ResultSet rs = bookInformationDao.returnn(con,bi);//得到符合bookId的那一行。
				
				//读者对比，只有借此书的读者才能还此书
				if((rs.next() && rs.getString(2).equals(userName))||((JDBCUtils.isNotEmpty(adminName))&&rs.getString(5).equals("1"))) {
					bookInformationDao.delete(con, Integer.parseInt(bookId));//删除借书表里的哪一行数据
					JOptionPane.showMessageDialog(null, "归还成功！");
					return;
				}else{
					JOptionPane.showMessageDialog(null, "归还失败！");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					 util.close(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		public static void setUserId(String name) {
			userName = name;
		}
		public static void setAdminId(String name) {
			adminName = name;
		}

}

		



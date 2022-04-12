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

	//��ȡ����	
	
	public ArrayList<BookItem> queryBookItem()  {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
	   ArrayList<BookItem> data1 = userDao.queryAllData();
		//��������
		return data1;
	

      }
	  public  boolean bookborrow(String borrownumbering,String user_name) {
		//String numbering,String user_name,String book_status,int number
	//       String bookId = this.borrowNumberingText.getText();
		  BookItem bi =new BookItem();
	/*	  if(JDBCUtils.isEmpty(bookId)) {
				JOptionPane.showMessageDialog(null, "ͼ����Ϣ����Ϊ�գ�");
				return true;
		  }*/
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
				ArrayList<BookItem> data = queryBookItem();
				//ʹ������ı�����������ݶԱ�
				for (int i = 0; i < data.size(); i++) {
					BookItem bookItem = data.get(i);
					//�������Ϊ�㣬����鲻�ɹ�
					if(bi.getNumber() == 0 && borrownumbering == bi.getNumbering()) {
						JOptionPane.showMessageDialog(null, "û��ͼ�飡");
						return true;
					}
				  }
		/*		if(JDBCUtils.isEmpty(bookId)) {
					JOptionPane.showMessageDialog(null, "ͼ����Ϣ����Ϊ�գ�");
					return true;
				
				}
		*/	
//					BookInformation bif =new BookInformation();
					//���������Ϊ�㣬�����ݷ�װΪBookInformation����
				BookInformation thisBI= new BookInformation();//bookinformation��¼��һ��BookItem������һ
					//����Dao���������ݷ���
				     userDao.bookborrow(thisBI);
					//�ڳɹ�����󣬷��ؽ���ɹ�
					JOptionPane.showMessageDialog(null, "����ɹ���");
					return true;
}
			

	  /**
		 * �黹ͼ�麯��
		 */
		protected  void bookreturn(String delNumbering) {
			String bookId = this.book_idTxt.getText();
			String bookName = this.book_nameTxt.getText();

			String bookStatus = this.book_statusTxt.getText();
			
			if(JDBCUtils.isEmpty(bookId)) {
				JOptionPane.showMessageDialog(null, "ͼ����Ϣ����Ϊ�գ�");
				return ;
			}
			
			Connection con = null;
			try {
				BookInformation bi = new BookInformation();
		         	BookItem book = new BookItem();
				bi.setBook_status("�޽��");//��ͼ��״̬�ı�Ϊ0
				
				con = util.getConnection();
				ResultSet rs = bookInformationDao.returnn(con,bi);//�õ�����bookId����һ�С�
				
				//���߶Աȣ�ֻ�н����Ķ��߲��ܻ�����
				if((rs.next() && rs.getString(2).equals(userName))||((JDBCUtils.isNotEmpty(adminName))&&rs.getString(5).equals("1"))) {
					bookInformationDao.delete(con, Integer.parseInt(bookId));//ɾ������������һ������
					JOptionPane.showMessageDialog(null, "�黹�ɹ���");
					return;
				}else{
					JOptionPane.showMessageDialog(null, "�黹ʧ�ܣ�");
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

		



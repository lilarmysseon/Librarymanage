package cn.itcast.Librarymanage.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import cn.itcast.Librarymanage.dao.AdminDao;
import cn.itcast.Librarymanage.domain.BookItem;

/*
 * 管理员服务类
 */
public class AdminService {
	
	public static String adminName;
	
	private AdminDao adminDao = new AdminDao();	
	//查询服务
	public ArrayList<BookItem> queryBookItem() {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<BookItem> data = adminDao.queryAllData();
		//返回数据
		return data;
	} 
	//添加服务
	public boolean addBookItem(String numbering, String bookname, String number,
			String price) {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<BookItem> data = queryBookItem();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//如果存在重复编号数据，则添加不成功
			if(numbering.equals(bookItem.getNumbering())) {
				return false;
			}
		}
		//如果没有重复编号，将数据封装为BookItem对象
		BookItem thisBookItem = new BookItem(numbering, bookname,
				Integer.parseInt(number), price);
		//调用Dao层的添加数据方法
		adminDao.addBookItem(thisBookItem);
		//在添加数据后，返回添加成功
		return true;
	}
	//修改服务
	public boolean updateBookItem(String numbering, String bookname,
			String number, String price) {		
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<BookItem> data = queryBookItem();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//如果存在相同编号数据，则可以更新
			if(numbering.equals(bookItem.getNumbering())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delBookItem(numbering);
				//如果没有重复编号，将数据封装为BookItemItem对象
				BookItem thisBookItem = new BookItem(numbering, bookname,
						Integer.parseInt(number), price);
				//调用Dao层的添加数据方法
				adminDao.addBookItem(thisBookItem);
				//在修改数据后，返回添加成功
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以更新
		return true;
	}
	//删除服务
	public boolean delBookItem(String delNumbering) {		
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<BookItem> data = queryBookItem();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//如果存在相同编号数据，则可以删除
			if(delNumbering.equals(bookItem.getNumbering())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delBookItem(delNumbering);
				//在删除数据后，返回添加成功
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以删除
		return false;
	}
	public static void setAdminId(String userName) {
		adminName = userName;
		
	}
/*	public ResultSet query() {
		//调用Dao层的获取所有数据方法获取所有数据
		ResultSet qu = null;
		try {
			qu = adminDao.query(null, 0);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//返回数据
		return qu;
	} */
	//查询服务
		public ArrayList<User> queryReader() {
			//调用Dao层的获取所有数据方法获取所有数据
			ArrayList<User> data = adminDao.queryAll();
			//返回数据
			return data;
		} 
		public boolean addUser(String numbering, String bookname, String number,
				String price) {
			//调用Dao层的获取所有数据方法获取所有数据
			ArrayList<User> data = queryReader();
			//使用输入的编号与所有数据对比
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//如果存在重复编号数据，则添加不成功
				if(numbering.equals(bookItem.getuser_id())) {
					return false;
				}
			}
			//如果没有重复编号，将数据封装为BookItem对象
			User thisBookItem = new User(numbering, bookname,
					number, price);
			//调用Dao层的添加数据方法
			adminDao.addUser(thisBookItem);
			//在添加数据后，返回添加成功
			return true;
		}
		//修改服务
		public boolean updateUser(String user_id, String user_name,
				String number, String price) {		
			//调用Dao层的获取所有数据方法获取所有数据
			ArrayList<User> data = queryReader();
			//使用输入的编号与所有数据对比
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//如果存在相同编号数据，则可以更新
				if(user_id.equals(bookItem.getuser_id())) {
					//调用Dao层的删除指定编号数据方法
					adminDao.delUser(user_id);
					//如果没有重复编号，将数据封装为BookItemItem对象
					User thisBookItem = new User(user_id, user_name,
							number, price);
					//调用Dao层的添加数据方法
					adminDao.addUser(thisBookItem);
					//在修改数据后，返回添加成功
					return true;
				}
			}
			//如果不存在相同编号数据，则不可以更新
			return true;
		}
		//删除服务
		public boolean delUser(String delNumbering) {		
			//调用Dao层的获取所有数据方法获取所有数据
			ArrayList<User> data = queryReader();
			//使用输入的编号与所有数据对比
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//如果存在相同编号数据，则可以删除
				if(delNumbering.equals(bookItem.getuser_id())) {
					//调用Dao层的删除指定编号数据方法
					adminDao.delBookItem(delNumbering);
					//在删除数据后，返回添加成功
					return true;
				}
			}
			//如果不存在相同编号数据，则不可以删除
			return false;
		}
}

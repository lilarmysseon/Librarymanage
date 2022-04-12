package cn.itcast.Librarymanage.test;

import java.util.ArrayList;

import cn.itcast.Librarymanage.dao.AdminDao;
import cn.itcast.Librarymanage.dao.UserDao;
import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.User;

/**
 * ≤‚ ‘JDBC
 */
public class TestDao {
	public static void main(String[] args) {
		AdminDao ad = new AdminDao();
		UserDao ud = new UserDao();
		AdminDao qu = new AdminDao();
		System.out.println(ad.queryAllData());
		System.out.println(ud.queryAllData());
		System.out.println(qu.queryAll());
		
		ArrayList<BookItem> list = new ArrayList<BookItem>();
		ArrayList<BookItem> list1 = new ArrayList<BookItem>();//”√ªß
		ArrayList<User> list3 = new ArrayList<User>();
		
		list = ad.queryAllData();
		list1 = ud.queryAllData();
		list3 =qu.queryAll();
		for (BookItem bookItem : list) {
			System.out.println(bookItem.getNumbering());
			System.out.println(bookItem.getBookname());
			System.out.println(bookItem.getNumber());
			System.out.println(bookItem.getPrice());
		}
		for (BookItem bookItem1 : list1) {
			System.out.println(bookItem1.getNumbering());
			System.out.println(bookItem1.getBookname());
			System.out.println(bookItem1.getNumber());
			System.out.println(bookItem1.getPrice());
	}
		for (User user : list3) {
			System.out.println(user.getuser_id());
			System.out.println(user.getuser_name());
			System.out.println(user.getuser_phone());
			System.out.println(user.getuser_password());
	}
	}
}
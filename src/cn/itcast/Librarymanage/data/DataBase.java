package cn.itcast.Librarymanage.data;

import java.util.ArrayList;

import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.User;

/**
 * 存储数据
 */
public class DataBase {
	public static ArrayList<BookItem> data = new ArrayList<BookItem>();	
	//初始数据
	static {		
		data.add(new BookItem("1","傲慢与偏见",5,"40.0"));
	}
	public static ArrayList<User> data1 = new ArrayList<User>();	
	//初始数据
	static {		
		data1.add(new User("1","123", "123","123"));
	}
}

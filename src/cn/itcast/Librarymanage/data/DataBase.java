package cn.itcast.Librarymanage.data;

import java.util.ArrayList;

import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.User;

/**
 * �洢����
 */
public class DataBase {
	public static ArrayList<BookItem> data = new ArrayList<BookItem>();	
	//��ʼ����
	static {		
		data.add(new BookItem("1","������ƫ��",5,"40.0"));
	}
	public static ArrayList<User> data1 = new ArrayList<User>();	
	//��ʼ����
	static {		
		data1.add(new User("1","123", "123","123"));
	}
}

package cn.itcast.Librarymanage.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import cn.itcast.Librarymanage.dao.AdminDao;
import cn.itcast.Librarymanage.domain.BookItem;

/*
 * ����Ա������
 */
public class AdminService {
	
	public static String adminName;
	
	private AdminDao adminDao = new AdminDao();	
	//��ѯ����
	public ArrayList<BookItem> queryBookItem() {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<BookItem> data = adminDao.queryAllData();
		//��������
		return data;
	} 
	//��ӷ���
	public boolean addBookItem(String numbering, String bookname, String number,
			String price) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<BookItem> data = queryBookItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//��������ظ�������ݣ�����Ӳ��ɹ�
			if(numbering.equals(bookItem.getNumbering())) {
				return false;
			}
		}
		//���û���ظ���ţ������ݷ�װΪBookItem����
		BookItem thisBookItem = new BookItem(numbering, bookname,
				Integer.parseInt(number), price);
		//����Dao���������ݷ���
		adminDao.addBookItem(thisBookItem);
		//��������ݺ󣬷�����ӳɹ�
		return true;
	}
	//�޸ķ���
	public boolean updateBookItem(String numbering, String bookname,
			String number, String price) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<BookItem> data = queryBookItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//���������ͬ������ݣ�����Ը���
			if(numbering.equals(bookItem.getNumbering())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delBookItem(numbering);
				//���û���ظ���ţ������ݷ�װΪBookItemItem����
				BookItem thisBookItem = new BookItem(numbering, bookname,
						Integer.parseInt(number), price);
				//����Dao���������ݷ���
				adminDao.addBookItem(thisBookItem);
				//���޸����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿��Ը���
		return true;
	}
	//ɾ������
	public boolean delBookItem(String delNumbering) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<BookItem> data = queryBookItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			BookItem bookItem = data.get(i);
			//���������ͬ������ݣ������ɾ��
			if(delNumbering.equals(bookItem.getNumbering())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delBookItem(delNumbering);
				//��ɾ�����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿���ɾ��
		return false;
	}
	public static void setAdminId(String userName) {
		adminName = userName;
		
	}
/*	public ResultSet query() {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ResultSet qu = null;
		try {
			qu = adminDao.query(null, 0);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//��������
		return qu;
	} */
	//��ѯ����
		public ArrayList<User> queryReader() {
			//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
			ArrayList<User> data = adminDao.queryAll();
			//��������
			return data;
		} 
		public boolean addUser(String numbering, String bookname, String number,
				String price) {
			//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
			ArrayList<User> data = queryReader();
			//ʹ������ı�����������ݶԱ�
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//��������ظ�������ݣ�����Ӳ��ɹ�
				if(numbering.equals(bookItem.getuser_id())) {
					return false;
				}
			}
			//���û���ظ���ţ������ݷ�װΪBookItem����
			User thisBookItem = new User(numbering, bookname,
					number, price);
			//����Dao���������ݷ���
			adminDao.addUser(thisBookItem);
			//��������ݺ󣬷�����ӳɹ�
			return true;
		}
		//�޸ķ���
		public boolean updateUser(String user_id, String user_name,
				String number, String price) {		
			//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
			ArrayList<User> data = queryReader();
			//ʹ������ı�����������ݶԱ�
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//���������ͬ������ݣ�����Ը���
				if(user_id.equals(bookItem.getuser_id())) {
					//����Dao���ɾ��ָ��������ݷ���
					adminDao.delUser(user_id);
					//���û���ظ���ţ������ݷ�װΪBookItemItem����
					User thisBookItem = new User(user_id, user_name,
							number, price);
					//����Dao���������ݷ���
					adminDao.addUser(thisBookItem);
					//���޸����ݺ󣬷�����ӳɹ�
					return true;
				}
			}
			//�����������ͬ������ݣ��򲻿��Ը���
			return true;
		}
		//ɾ������
		public boolean delUser(String delNumbering) {		
			//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
			ArrayList<User> data = queryReader();
			//ʹ������ı�����������ݶԱ�
			for (int i = 0; i < data.size(); i++) {
				User bookItem = data.get(i);
				//���������ͬ������ݣ������ɾ��
				if(delNumbering.equals(bookItem.getuser_id())) {
					//����Dao���ɾ��ָ��������ݷ���
					adminDao.delBookItem(delNumbering);
					//��ɾ�����ݺ󣬷�����ӳɹ�
					return true;
				}
			}
			//�����������ͬ������ݣ��򲻿���ɾ��
			return false;
		}
}

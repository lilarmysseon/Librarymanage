package cn.itcast.Librarymanage.controller;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.UserService;
import cn.itcast.Librarymanage.view.AbstractUserDialog;


/**
 * �û���������ࣨ�������黹�飩
 */
@SuppressWarnings("serial")
public  class UserDialogController extends AbstractUserDialog{
	//��������࣬�ṩ�������ܷ���
	private UserService userService = new UserService();	
	//���췽��
	public UserDialogController() {
		super();
	}
	public UserDialogController(Frame owner, boolean modal) {
		super(owner, modal);//??????????????????????????????????????????
		//��������ʱչʾ����
	      queryBookItem();
	}	
	
	
	//��ѯ����
	@Override
	public void queryBookItem() {
		//������ͷ
		String[] thead = {"ͼ����","ͼ������","ͼ������","ͼ��۸�"};
		
		//����adminService�Ĳ�ѯ����
		ArrayList<BookItem> dataList = userService.queryBookItem();
		//����list2Array����������ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody = list2Array(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
	    table.setModel(dataModel);
	}
	//��������תΪ��ά���鷽��
	public String[][] list2Array(ArrayList<BookItem> list){		
		//����BookItem��model�뼯�����ݶ���JTable�����ݶ�ά����
		String[][] tbody = new String[list.size()][4];	
		for (int i = 0; i < list.size(); i++) {
			BookItem bookItem = list.get(i);
			tbody[i][0] = bookItem.getNumbering();
			tbody[i][1] = bookItem.getBookname();
			tbody[i][2] = bookItem.getNumber()+"";
			tbody[i][3] = bookItem.getPrice();
		}		
		return tbody;
	}
    //����
	public void bookborrow() {
		//��ȡ����
		String borrowNumbering  = borrowNumberingText.getText();
		String borrowBookname = borrowBooknameText.getText();
	//	String book_status = borrowBooknameText.getText();
		
		//����adminService����ӷ���
		boolean borrowSuccess = userService.bookborrow(borrowNumbering, borrowBookname);
		//�����ӳɹ�
		if(borrowSuccess) {
			//��Ӻ�ˢ�±��
			queryBookItem();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "ͼ���Ų����ظ�,��������!");
		}
	}
	//����
	public void bookreturn() {
		
	}

	
}
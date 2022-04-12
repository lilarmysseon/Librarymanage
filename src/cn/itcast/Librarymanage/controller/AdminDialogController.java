package cn.itcast.Librarymanage.controller;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.AdminService;
import cn.itcast.Librarymanage.view.abstractAdminDialog;

/**
 * ����Ա���������
 */
@SuppressWarnings("serial")
public class AdminDialogController extends abstractAdminDialog {
	//��������࣬�ṩ�������ܷ���
	private AdminService adminService = new AdminService();	
	//���췽��
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner, boolean modal) {
		super(owner, modal);
		//��������ʱչʾ����
		queryBookItem();
	}	
	//��ѯ����
	@Override
	public void queryBookItem() {
		//������ͷ
		String[] thead = {"ͼ����","ͼ������","ͼ������","ͼ��۸�"};
		
		//����adminService�Ĳ�ѯ����
		ArrayList<BookItem> dataList = adminService.queryBookItem();
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
	//��ӷ���
	@Override
	public void addBookItem() {
		//��ȡ����
		String addNumbering  = addNumberingText.getText();
		String addBookname = addBooknameText.getText();
		String addNumber = addNumberText.getText();
		String addPrice = addPriceText.getText();
		//����adminService����ӷ���
		boolean addSuccess = adminService.addBookItem(addNumbering, addBookname,
				addNumber, addPrice);
		//�����ӳɹ�
		if(addSuccess) {
			//��Ӻ�ˢ�±��
			queryBookItem();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "ͼ���Ų����ظ�,��������!");
		}
	}
	//�޸ķ���
	@Override
	public void updateBookItem() {		
		//��ȡ����
		String updateNumbering = updateNumberingText.getText();
		String updateBookname = updateBooknameText.getText();
		String updateNumber = updateNumberText.getText();
		String updatePrice = updatePriceText.getText();
		//����adminService���޸ķ���
		boolean updateSuccess = adminService.updateBookItem(updateNumbering,
				updateBookname, updateNumber, updatePrice);		
		//����޸ĳɹ�
		if(updateSuccess) {
			//�޸ĺ�ˢ�±��
			queryBookItem();
		}else {
			//û���޸ĳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵ�ͼ��,��������!");
		}
	}
	//ɾ������
	@Override
	public void delBookItem() {		
		//��ȡ����
		String delNumbering = delNumberingText.getText();
		//����adminService��ɾ������
		boolean delSuccess = adminService.delBookItem(delNumbering);		
		//���ɾ���ɹ�
		if(delSuccess) {
			//ɾ����ˢ�±��
			queryBookItem();
		}else {
			//û��ɾ���ɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵ�ͼ��,��������!");
		}
	}	
}
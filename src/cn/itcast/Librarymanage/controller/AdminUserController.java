package cn.itcast.Librarymanage.controller;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




import cn.itcast.Librarymanage.service.AdminService;
import cn.itcast.Librarymanage.service.User;
import cn.itcast.Librarymanage.view.AdminUser;

@SuppressWarnings("serial")
public class AdminUserController extends AdminUser{
	
	private AdminService adminService = new AdminService();	
	public AdminUserController(Frame owner, boolean modal) {
		super(owner, modal );
		//��������ʱչʾ����
		queryReader();
	}
	public void queryReader() {
		//������ͷ
		String[] thead = {"�û����","�û�����","�û��绰","�û�����"};
		
		//����adminService�Ĳ�ѯ����
		ArrayList<User> dataList = adminService.queryReader();
		//����list2Array����������ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody = list3Array(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	private String[][] list3Array(ArrayList<User> dataList) {
		//����BookItem��model�뼯�����ݶ���JTable�����ݶ�ά����
				String[][] tbody = new String[dataList.size()][4];	
				for (int i = 0; i < dataList.size(); i++) {
					User user = dataList.get(i);
					tbody[i][0] = user.getuser_id();
					tbody[i][1] = user.getuser_name();
					tbody[i][2] = user.getuser_phone();
					tbody[i][3] = user.getuser_password();
				}		
				return tbody;
			}
	
	@Override
	public void addUser() {
		//��ȡ����
		String addNumbering  = addNumberingText.getText();
		String addBookname = addBooknameText.getText();
		String addNumber = addNumberText.getText();
		String addPrice = addPriceText.getText();
		//����adminService����ӷ���
		boolean addSuccess = adminService.addUser(addNumbering, addBookname,
				addNumber, addPrice);
		//�����ӳɹ�
		if(addSuccess) {
			//��Ӻ�ˢ�±��
			queryReader();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "�û���Ų����ظ�,��������!");
		}
	}
	//�޸ķ���
	@Override
	public void updateUser() {		
		//��ȡ����
		String updateNumbering = updateNumberingText.getText();
		String updateBookname = updateBooknameText.getText();
		String updateNumber = updateNumberText.getText();
		String updatePrice = updatePriceText.getText();
		//����adminService���޸ķ���
		boolean updateSuccess = adminService.updateUser(updateNumbering,
				updateBookname, updateNumber, updatePrice);		
		//����޸ĳɹ�
		if(updateSuccess) {
			//�޸ĺ�ˢ�±��
			queryReader();
		}else {
			//û���޸ĳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵ��û�,��������!");
		}
	}
	//ɾ������
	@Override
	public void delUser() {		
		//��ȡ����
		String delNumbering = delNumberingText.getText();
		//����adminService��ɾ������
		boolean delSuccess = adminService.delUser(delNumbering);		
		//���ɾ���ɹ�
		if(delSuccess) {
			//ɾ����ˢ�±��
			queryReader();
		}else {
			//û��ɾ���ɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵ��û�,��������!");
		}
	}	
	
}
	


package cn.itcast.Librarymanage.test;



import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import cn.itcast.Librarymanage.view.AdminUser;
@SuppressWarnings("serial")
public class AdminUserTest extends AdminUser{
	public AdminUserTest() {
			super();
			queryReader();//��������
		}

	public void queryReader() {
		String[] thead = new String[]{"�û����","�û�����","�û��绰","�û�����"};
		String[][] tbody = new String[][]{
				{"1","123","123","123"}
				};
		TableModel data = new DefaultTableModel(tbody,thead);
		
		table.setModel(data);
		
	}
	@Override
	public void addUser() {
	}
	@Override
	public void updateUser() {
	}
	@Override
	public void delUser() {
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new AdminUserTest().setVisible(true);

	}

}

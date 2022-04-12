package cn.itcast.Librarymanage.test;



import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import cn.itcast.Librarymanage.view.AdminUser;
@SuppressWarnings("serial")
public class AdminUserTest extends AdminUser{
	public AdminUserTest() {
			super();
			queryReader();//测试数据
		}

	public void queryReader() {
		String[] thead = new String[]{"用户编号","用户名称","用户电话","用户密码"};
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
		// TODO 自动生成的方法存根
		new AdminUserTest().setVisible(true);

	}

}

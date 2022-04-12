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
		//创建对象时展示数据
		queryReader();
	}
	public void queryReader() {
		//定义表格头
		String[] thead = {"用户编号","用户名称","用户电话","用户密码"};
		
		//调用adminService的查询服务
		ArrayList<User> dataList = adminService.queryReader();
		//调用list2Array方法，将查询到的集合转为数组，方便为JTable赋值
		String[][] tbody = list3Array(dataList);
		//将查询到的结果为table赋值
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	private String[][] list3Array(ArrayList<User> dataList) {
		//根据BookItem的model与集合数据定义JTable的数据二维数组
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
		//获取数据
		String addNumbering  = addNumberingText.getText();
		String addBookname = addBooknameText.getText();
		String addNumber = addNumberText.getText();
		String addPrice = addPriceText.getText();
		//调用adminService的添加服务
		boolean addSuccess = adminService.addUser(addNumbering, addBookname,
				addNumber, addPrice);
		//如果添加成功
		if(addSuccess) {
			//添加后刷新表格
			queryReader();
		}else {
			//没有添加成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "用户编号不能重复,请检查数据!");
		}
	}
	//修改方法
	@Override
	public void updateUser() {		
		//获取数据
		String updateNumbering = updateNumberingText.getText();
		String updateBookname = updateBooknameText.getText();
		String updateNumber = updateNumberText.getText();
		String updatePrice = updatePriceText.getText();
		//调用adminService的修改服务
		boolean updateSuccess = adminService.updateUser(updateNumbering,
				updateBookname, updateNumber, updatePrice);		
		//如果修改成功
		if(updateSuccess) {
			//修改后刷新表格
			queryReader();
		}else {
			//没有修改成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的用户,请检查数据!");
		}
	}
	//删除方法
	@Override
	public void delUser() {		
		//获取数据
		String delNumbering = delNumberingText.getText();
		//调用adminService的删除服务
		boolean delSuccess = adminService.delUser(delNumbering);		
		//如果删除成功
		if(delSuccess) {
			//删除后刷新表格
			queryReader();
		}else {
			//没有删除成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的用户,请检查数据!");
		}
	}	
	
}
	


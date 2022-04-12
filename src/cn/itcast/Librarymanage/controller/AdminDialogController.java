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
 * 管理员界面操作类
 */
@SuppressWarnings("serial")
public class AdminDialogController extends abstractAdminDialog {
	//定义服务类，提供完整功能服务
	private AdminService adminService = new AdminService();	
	//构造方法
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner, boolean modal) {
		super(owner, modal);
		//创建对象时展示数据
		queryBookItem();
	}	
	//查询方法
	@Override
	public void queryBookItem() {
		//定义表格头
		String[] thead = {"图书编号","图书名称","图书数量","图书价格"};
		
		//调用adminService的查询服务
		ArrayList<BookItem> dataList = adminService.queryBookItem();
		//调用list2Array方法，将查询到的集合转为数组，方便为JTable赋值
		String[][] tbody = list2Array(dataList);
		//将查询到的结果为table赋值
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	//集合数据转为二维数组方法
	public String[][] list2Array(ArrayList<BookItem> list){		
		//根据BookItem的model与集合数据定义JTable的数据二维数组
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
	//添加方法
	@Override
	public void addBookItem() {
		//获取数据
		String addNumbering  = addNumberingText.getText();
		String addBookname = addBooknameText.getText();
		String addNumber = addNumberText.getText();
		String addPrice = addPriceText.getText();
		//调用adminService的添加服务
		boolean addSuccess = adminService.addBookItem(addNumbering, addBookname,
				addNumber, addPrice);
		//如果添加成功
		if(addSuccess) {
			//添加后刷新表格
			queryBookItem();
		}else {
			//没有添加成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "图书编号不能重复,请检查数据!");
		}
	}
	//修改方法
	@Override
	public void updateBookItem() {		
		//获取数据
		String updateNumbering = updateNumberingText.getText();
		String updateBookname = updateBooknameText.getText();
		String updateNumber = updateNumberText.getText();
		String updatePrice = updatePriceText.getText();
		//调用adminService的修改服务
		boolean updateSuccess = adminService.updateBookItem(updateNumbering,
				updateBookname, updateNumber, updatePrice);		
		//如果修改成功
		if(updateSuccess) {
			//修改后刷新表格
			queryBookItem();
		}else {
			//没有修改成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的图书,请检查数据!");
		}
	}
	//删除方法
	@Override
	public void delBookItem() {		
		//获取数据
		String delNumbering = delNumberingText.getText();
		//调用adminService的删除服务
		boolean delSuccess = adminService.delBookItem(delNumbering);		
		//如果删除成功
		if(delSuccess) {
			//删除后刷新表格
			queryBookItem();
		}else {
			//没有删除成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的图书,请检查数据!");
		}
	}	
}
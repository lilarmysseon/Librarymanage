package cn.itcast.Librarymanage.test;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.Librarymanage.view.AbstractUserDialog;
//import cn.itcast.Librarymanage.view.SignIn;

@SuppressWarnings("serial")
public class AbstractUserDialogTest extends AbstractUserDialog{//不能是抽象类
	//定义构造函数初始化数据
		public AbstractUserDialogTest() {
		//	super();
			queryBookItem();//测试数据
		}	
		//加入测试table数据
		@Override
		public void queryBookItem() {
			String[] thead = new String[]{"图书编号","图书名","图书数量","图书单价(元)"};
			String[][] tbody = new String[][]{
					{"1","傲慢与偏见","5","40"},
					{"2","三国演义","7","50"},
					{"3","飘(全一册)","8","80"},
					{"4","假如给我三天光明","6","30"}
					};
			TableModel data = new DefaultTableModel(tbody,thead);
			table.setModel(data);
		}
		@Override
		public void bookborrow() {
		}
		@Override
		public void bookreturn() {
		}
		
	    //定义主函数运行程序
		public static void main(String[] args) {
			//创建界面并显示
			
			new AbstractUserDialogTest().setVisible(true);
		}
	}
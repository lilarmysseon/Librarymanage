package cn.itcast.Librarymanage.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import cn.itcast.Librarymanage.dao.AdminDao;
import cn.itcast.Librarymanage.tools.GUItools;
import cn.itcast.Librarymanage.tools.JDBCUtils;



@SuppressWarnings("serial")
public class AdminUser extends JDialog{
	//定义界面使用到的组件作为成员变量
		private JLabel tableLabel = new JLabel("用户列表");//图书列表标题
		private JScrollPane tablePane = new JScrollPane();//滚动视口
		protected JTable table = new JTable(); //图书列表	
		private JLabel numberingLabel = new JLabel("用户编号");//编号标题
		private JLabel booknameLabel = new JLabel("用户名称");//名称标题
		private JLabel numberLabel = new JLabel("用户电话");//数量标题
		private JLabel priceLabel = new JLabel("用户密码");//价格标题
		//添加功能组件
		protected JTextField addNumberingText = new JTextField(6);//添加编号文本框
		protected JTextField addBooknameText = new JTextField(6);//添加名称文本框
		protected JTextField addNumberText = new JTextField(6);//添加数量文本框
		protected JTextField addPriceText = new JTextField(6);//添加价格文本框
		private JButton addBtn = new JButton("添加用户");//添加按钮
		//修改功能组件
		protected JTextField updateNumberingText = new JTextField(6);//修改编号文本框
		protected JTextField updateBooknameText = new JTextField(6);//修改名称文本框
		protected JTextField updateNumberText = new JTextField(6);//修改数量文本框
		protected JTextField updatePriceText = new JTextField(6);//修改价格文本框
		private JButton updateBtn = new JButton("修改用户");//修改按钮
		//删除功能组件
		protected JTextField delNumberingText = new JTextField(6);//添加编号文本
		private JButton delBtn = new JButton("删除用户");//删除按钮	
	
		//构造方法
		public AdminUser() {
			this(null,true);
		}
		public AdminUser(Frame owner, boolean modal) {
			super(owner, modal);
			this.init();// 初始化操作
			this.addComponent();// 添加组件
			this.addListener();// 添加监听器
		}
		// 初始化操作
		private void init() {
			this.setTitle("用户管理!");// 标题
			this.setSize(600, 400);// 窗体大小与位置
			GUItools.center(this);//设置窗口在屏幕上的位置
			this.setResizable(true);// 窗体大小固定
		}	
		// 添加组件
		private void addComponent() {		
			//取消布局
			this.setLayout(null);		
			//表格标题
			tableLabel.setBounds(265, 20, 70, 25);
			this.add(tableLabel);		
			//表格
			table.getTableHeader().setReorderingAllowed(false);	//列不能移动
			table.getTableHeader().setResizingAllowed(false); 	//不可拉动表格
			table.setEnabled(true);							//不可更改数据
			tablePane.setBounds(50, 50, 500, 200);				
			tablePane.setViewportView(table);					//视口装入表格
			this.add(tablePane);		
			//字段标题
			numberingLabel.setBounds(50, 250, 70, 25);	
			booknameLabel.setBounds(150, 250, 70, 25);	
			numberLabel.setBounds(250, 250, 70, 25);	
			priceLabel.setBounds(350, 250, 70, 25);	
			this.add(numberingLabel);
			this.add(booknameLabel);
			this.add(numberLabel);
			this.add(priceLabel);		
			//增加组件
			addNumberingText.setBounds(50, 280, 80, 25);
			addBooknameText.setBounds(150, 280, 80, 25);
			addNumberText.setBounds(250, 280, 80, 25);
			addPriceText.setBounds(350, 280, 80, 25);
			this.add(addNumberingText);
			this.add(addBooknameText);
			this.add(addNumberText);
			this.add(addPriceText);
			addBtn.setBounds(460, 280, 90, 25);
			this.add(addBtn);		
			//修改组件
			updateNumberingText.setBounds(50, 310, 80, 25);
			updateBooknameText.setBounds(150, 310, 80, 25);
			updateNumberText.setBounds(250, 310, 80, 25);
			updatePriceText.setBounds(350, 310, 80, 25);
			this.add(updateNumberingText);
			this.add(updateBooknameText);
			this.add(updateNumberText);
			this.add(updatePriceText);
			
			updateBtn.setBounds(460, 310, 90, 25);
			this.add(updateBtn);		
			//删除组件
			delNumberingText.setBounds(50, 340, 80, 25);
			this.add(delNumberingText);
			delBtn.setBounds(460, 340, 90, 25);
			this.add(delBtn);
		}	
		// 添加监听器
		private void addListener() {		
			//添加按钮监听
			addBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//调用添加方法
					addUser();
				}
			});
			//修改按钮监听
			updateBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//调用修改方法
					updateUser();
				}
			});
			//删除按钮监听
			delBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//调用删除方法
					delUser();
				}
			});
		}	
		protected void updateUser() {
			// TODO 自动生成的方法存根
			
		}
		protected void delUser() {
			// TODO 自动生成的方法存根
			
		}
		protected void addUser() {
			// TODO 自动生成的方法存根
			
		}
		//查询方法
		public void queryReader() {
		}
		
	}
	/**
	 * 删除用户功能
	 */
/*	protected void deleteReader() {
		
		readerIdTxt=  new JTextField();
		String readerId  = this.readerIdTxt.getText();
		
		if(JDBCUtils.isEmpty(readerId)) {
			JOptionPane.showMessageDialog(null, "用户编号不能为空");
		}
		
		Connection con = null;
		try {
			con = util.getConnection();
			ResultSet rs = adminDao.query(con, Integer.parseInt(readerId));
			if(rs.next()) {
				adminDao.delete(con, Integer.parseInt(readerId));
				JOptionPane.showMessageDialog(null, "删除成功!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "删除失败！");
				return;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败！");
			return;
		}finally {
			try {
				 util.close (con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 用户查询
	 */

/*	protected void queryReader() {
		String readerId = this.readerIdTxt.getText();
		DefaultTableModel dtm = (DefaultTableModel) readerTable.getModel();
		dtm.setRowCount(0);
		
		if(JDBCUtils.isEmpty(readerId)) {
			JOptionPane.showMessageDialog(null, "用户编号不能为空");
			return ;
		}
		
		Connection con = null;
		try {
			con =  util.getConnection();
			ResultSet rs = adminDao.query(con, Integer.parseInt(readerId));
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("user_id"));
				v.add(rs.getNString("user_name"));
				v.add(rs.getString("user_phone"));
				v.add(rs.getString("user_password"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/

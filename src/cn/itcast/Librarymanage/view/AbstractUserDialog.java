package cn.itcast.Librarymanage.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.itcast.Librarymanage.tools.GUItools;



@SuppressWarnings("serial")
public class AbstractUserDialog extends JDialog{
	//定义界面使用到的组件作为成员变量
		private JLabel tableLabel = new JLabel("图书列表");//图书列表标题
		private JScrollPane tablePane = new JScrollPane();//滚动视口
		protected JTable table = new JTable(); //图书列表
		private JLabel numberingLabel = new JLabel("图书编号");//编号标题
		private JLabel booknameLabel = new JLabel("图书名称");//名称标题
		private JLabel numberLabel = new JLabel("图书数量");//数量标题
		private JLabel priceLabel = new JLabel("图书价格");//价格标题
//		private JLabel book_statusLabel = new JLabel("图书价格");//状态标题
		
		//输入书的编号或者名称借书还书
		protected JTextField NumberingText = new JTextField(6);//编号文本框,
		protected JTextField BooknameText = new JTextField(6);// 名称文本框
		
		protected JTextField borrowNumberingText = new JTextField(6);//编号文本框,
		protected JTextField borrowBooknameText = new JTextField(6);// 名称文本框
		 
		private JButton borrowBtn = new JButton("借出图书");//添加按钮
		
		private JButton returnBtn = new JButton("归还图书");//修改按钮
		
		public AbstractUserDialog() {
			this(null,true);
		}
		public AbstractUserDialog(Frame owner, boolean modal) {
			super(owner, modal);
			this.init();// 初始化操作
			this.addComponent();// 添加组件
			this.addListener();// 添加监听器
		}
		// 初始化操作
		private void init() {
			this.setTitle("图书管理用户界面");// 标题
			this.setSize(600, 400);// 窗体大小与位置
			GUItools.center(this);//设置窗口在屏幕上的位置
			this.setResizable(false);// 窗体大小固定
		}	
		// 添加组件
		private void addComponent() {		
			//取消布局
			this.setLayout(null);		
			//表格标题
			tableLabel.setBounds(265, 20, 70, 25);
			this.add(tableLabel);	
			tableLabel.setVisible(true);
			//表格
			table.getTableHeader().setReorderingAllowed(false);	//列不能移动
			table.getTableHeader().setResizingAllowed(false); 	//不可拉动表格
			table.setEnabled(false);							//不可更改数据
			tablePane.setBounds(50, 50, 500, 200);				
			tablePane.setViewportView(table);					//视口装入表格
			this.add(tablePane);		
			//字段标题
			numberingLabel.setBounds(50, 250, 70, 25);	
			booknameLabel.setBounds(150, 250, 70, 25);	
	//		numberLabel.setBounds(250, 250, 70, 25);	
	//		priceLabel.setBounds(350, 250, 70, 25);	
	//		book_statusLabel.setBounds(450, 250, 70, 25);
			this.add(numberingLabel);
			this.add(booknameLabel);
			this.add(numberLabel);
			this.add(priceLabel);
			
	//		this.add(book_statusLabel);
			//借书组件
			borrowNumberingText.setBounds(50, 280, 80, 25);//填写编号文本框
			borrowBooknameText.setBounds(150, 280, 80, 25);//填写名称文本框
			
			this.add( borrowNumberingText);
			this.add( borrowBooknameText);
			
			borrowBtn.setBounds(460, 280, 90, 25);
			this.add(borrowBtn);	
			
			//还书组件
			NumberingText.setBounds(50, 310, 80, 25);
			BooknameText.setBounds(150, 310, 80, 25);
			
			this.add(NumberingText);//填写编号文本框
			this.add(BooknameText);//填写名称文本框
			
			returnBtn.setBounds(460, 310, 90, 25);
			this.add(returnBtn);		
			
			
		}	
		// 添加监听器
		private void addListener() {		
			//添加按钮监听
			borrowBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//调用借书方法，在UserService类里
					bookborrow();
				}
			});
			//修改按钮监听
			returnBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//调用修改方法
					bookreturn();
				}
			});
		}
		//借书方法
			public void bookborrow() {
		}
		//还书方法
			public void bookreturn() {
			}
		//测试数据
			public void queryBookItem() {
			}
}







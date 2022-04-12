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

/**
 * 管理窗口类
 */
@SuppressWarnings("serial")
public class abstractAdminDialog extends JDialog{
	//定义界面使用到的组件作为成员变量
	private JLabel tableLabel = new JLabel("图书列表");//图书列表标题
	private JScrollPane tablePane = new JScrollPane();//滚动视口
	protected JTable table = new JTable(); //图书列表	
	private JLabel numberingLabel = new JLabel("图书编号");//编号标题
	private JLabel booknameLabel = new JLabel("图书名称");//名称标题
	private JLabel numberLabel = new JLabel("图书数量");//数量标题
	private JLabel priceLabel = new JLabel("图书价格");//价格标题
	//添加功能组件
	protected JTextField addNumberingText = new JTextField(6);//添加编号文本框
	protected JTextField addBooknameText = new JTextField(6);//添加名称文本框
	protected JTextField addNumberText = new JTextField(6);//添加数量文本框
	protected JTextField addPriceText = new JTextField(6);//添加价格文本框
	private JButton addBtn = new JButton("添加图书");//添加按钮
	//修改功能组件
	protected JTextField updateNumberingText = new JTextField(6);//修改编号文本框
	protected JTextField updateBooknameText = new JTextField(6);//修改名称文本框
	protected JTextField updateNumberText = new JTextField(6);//修改数量文本框
	protected JTextField updatePriceText = new JTextField(6);//修改价格文本框
	private JButton updateBtn = new JButton("修改图书");//修改按钮
	//删除功能组件
	protected JTextField delNumberingText = new JTextField(6);//添加编号文本
	private JButton delBtn = new JButton("删除图书");//删除按钮	
	//构造方法
	public abstractAdminDialog() {
		this(null,true);
	}
	public abstractAdminDialog(Frame owner, boolean modal) {
		super(owner, modal);
		this.init();// 初始化操作
		this.addComponent();// 添加组件
		this.addListener();// 添加监听器
	}
	// 初始化操作
	private void init() {
		this.setTitle("图书管理!");// 标题
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
				addBookItem();
			}
		});
		//修改按钮监听
		updateBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用修改方法
				updateBookItem();
			}
		});
		//删除按钮监听
		delBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用删除方法
				delBookItem();
			}
		});
	}	
	//查询方法
	public void queryBookItem() {
	}
	//添加方法
	public void addBookItem() {
	}
	//修改方法
	public void updateBookItem() {
	}
	//删除方法
	public void delBookItem() {
	}
	
}
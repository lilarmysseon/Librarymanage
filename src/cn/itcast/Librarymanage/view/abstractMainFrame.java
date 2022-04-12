package cn.itcast.Librarymanage.view;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.itcast.Librarymanage.tools.GUItools;

/**
 * 主窗口类
 */
@SuppressWarnings("serial")
public abstract class abstractMainFrame extends JFrame {
	//组件
	private JLabel titleLabel = new JLabel(new ImageIcon("图书.jpg"));//标题图片

//	private JButton btn = new JButton("进入系统");//进入系统按钮
    private JButton btn1 = new JButton("管理员");
    private JButton btn2 = new JButton("用户");
    private JButton btn3 = new JButton("管理用户");
    
    
	
    
    //构造函数
	public abstractMainFrame() {
		this.init();// 初始化操作
		this.addComponent();// 添加组件
		this.addListener();// 添加监听器
	}	
	
	
	
	//初始化操作
	private void init() {
		this.setTitle("欢迎使用图书管理系统!");// 标题
		this.setSize(600, 400);// 窗体大小与位置
		GUItools.center(this);//设置窗口在屏幕上的位置
		GUItools.setTitleImage(this, "title.jpg");
		this.setResizable(true);// 窗体大小固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口默认操作
	}	
	
	
	
	//添加组件
	private void addComponent() {
		//窗体使用默认的边界布局,北区放入图片
		this.add(this.titleLabel, BorderLayout.NORTH);
	//	this.add(this.btn, BorderLayout.CENTER);
        this.add(this.btn1, BorderLayout.SOUTH);
        this.add(this.btn2, BorderLayout.SOUTH);
        this.add(this.btn3, BorderLayout.SOUTH);
       
        
		//创建JPanel对象
		JPanel btnPanel = new JPanel();
         JPanel btn1Panel =new JPanel();
		//清除布局，使JPanel中的组件可以自定义位置
		
	//	btnPanel.setLayout(null);
	//	btn1Panel.setLayout(null);
		
		//将JPanel对象添加到窗体中
		this.add(btnPanel);	
 		this.add(btn1Panel);
		//定义边界位置
//		btn.setBounds(240,20,100, 30);
    	btn1.setBounds(240,60,100, 30);
    	btn1.setBounds(240,90,100, 30);
    	btn1.setBounds(240,120,100, 30);
		//将按钮添加到JPanel对象中
//		btnPanel.add(btn);
        btn1Panel.add(btn1);
        btn1Panel.add(btn2);
        btn1Panel.add(btn3);
	//	JPanel btn1Panel = new JPanel();
	//	this.add(btn1Panel);
	}
	
	
	
	//添加监听器
	private void addListener() {
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdminDialog(); //登录界面
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserDialog(); //登录界面
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdminUser(); //登录界面
			}
		});
		
	}	
	

	
	
	public abstract void showAdminUser();



	//展示登录界面方法
	public abstract void showAdminDialog();
	
	public abstract void showUserDialog();
//	public abstract void showAdminDialog();//改成Frame
//	public abstract void showUserDialog();//其实设置的是Frame，用户登录
}
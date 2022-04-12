package cn.itcast.Librarymanage.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cn.itcast.Librarymanage.dao.UserDao;
import cn.itcast.Librarymanage.service.User;
import cn.itcast.Librarymanage.tools.JDBCUtils;

public class SignUp extends JFrame{

	JFrame frame = new JFrame();
	private JPanel contentPane;
	private JTextField user_id;
	private JTextField user_name;
	private JTextField user_phone;
	private JTextField user_password;
	private JDBCUtils  util= new JDBCUtils();
	GroupLayout layout = new GroupLayout(contentPane);
	
	public SignUp() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel label = new JLabel("用户账号");
		
		user_id = new JTextField();
		user_id.setColumns(10);
		
		JLabel label_1 = new JLabel("用户名字");
		
		user_name = new JTextField();
		user_name.setColumns(10);
		
		JLabel label_2 = new JLabel("手机号码");
		
		user_phone = new JTextField();
		user_phone.setColumns(10);
		
		JLabel label_3 = new JLabel("用户密码");
		
		user_password = new JTextField();
		user_password.setColumns(10);
		contentPane.add(user_id);
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userRegister(e);
			}
		});
		
		JButton buttonNot = new JButton("重输");
		buttonNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delActiontxt();
			}
		});
	
	GroupLayout Groupl = new GroupLayout(contentPane);
	 GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addComponent(user_id);
	 GroupLayout.ParallelGroup vParalGroup02 = layout.createParallelGroup().addComponent(user_id).addComponent(user_name);

	Groupl.setHorizontalGroup(
			Groupl.createParallelGroup(Alignment.LEADING)
				.addGroup(Groupl.createSequentialGroup()
					.addGap(136)
					.addGroup(Groupl.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(Groupl.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Groupl.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonNot))
						.addComponent(user_password)
						.addComponent(user_phone)
						.addComponent(user_name)
						.addComponent(user_id, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addContainerGap(194, Short.MAX_VALUE))
		);
	Groupl.setVerticalGroup(
			Groupl.createParallelGroup(Alignment.LEADING)
				.addGroup(Groupl.createSequentialGroup()
					.addGap(83)
					.addGroup(Groupl.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(user_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(Groupl.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(user_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(Groupl.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(user_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(Groupl.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(user_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(Groupl.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(buttonNot))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPane.setLayout(Groupl);
		
	}
	// 读者注册  *@param e
	 
		private void userRegister(ActionEvent e) {
			
			 String userIdStr = this.user_id.getText().toString();
		     String userId = null;
			 if(!JDBCUtils.isEmpty(userIdStr)) {
				 userId = userIdStr;
			 }
			
			 String userName = this.user_name.getText();
			 String userPhone = this.user_phone.getText();
			 String userPassword = this.user_password.getText();
			 
			 if(JDBCUtils.isEmpty(userIdStr)) {
				 JOptionPane.showMessageDialog(null,"用户编号不能为空!");
				 return;
			 }
			 if(JDBCUtils.isEmpty(userName)) {
				 JOptionPane.showMessageDialog(null, "用户姓名不能为空！");
				 return;
			 }
			 if(JDBCUtils.isEmpty(userPhone)) {
				 JOptionPane.showMessageDialog(null, "用户手机号不能为空！");
				 return;
			 }
			 if(JDBCUtils.isEmpty(userPassword)) {
				 JOptionPane.showMessageDialog(null, "用户密码不能为空！");
				 return;
			 }
			 
			 Connection con = null;
			 UserDao ud = new UserDao();
			 try { 
				User user = new User(userId,userName,userPhone,userPassword);
				con =  util.getConnection();
				User rs = ud.query(con, user);

				if(String.valueOf(rs.getuser_id()).equals(userIdStr)) {
					JOptionPane.showMessageDialog(null, "账号已存在，注册失败!");
					return;
				}
				else {
					ud.addUser(con, user);
					JOptionPane.showMessageDialog(null, "注册成功!");
					return;
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "账号已存在，注册失败!");
				e1.printStackTrace();
				return;
			} finally {
				  try {
					 util.close(con);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	private void delActiontxt() {
		this.user_id.setText("");
		this.user_name.setText("");
		this.user_password.setText("");
		this.user_phone.setText("");
     }
	
}
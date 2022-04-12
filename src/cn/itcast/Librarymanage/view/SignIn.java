package cn.itcast.Librarymanage.view;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.itcast.Librarymanage.dao.UserDao;
import cn.itcast.Librarymanage.service.Admin;
import cn.itcast.Librarymanage.service.AdminService;
import cn.itcast.Librarymanage.service.User;
import cn.itcast.Librarymanage.service.UserService;
import java.awt.BorderLayout;
/* 
 * ѡ��ѡ��ť�л���Ƭ�����¼ϵͳ��������
 */

/*
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.itcast.Librarymanage.dao.AdminDao;
import cn.itcast.Librarymanage.dao.UserDao;
import cn.itcast.Librarymanage.service.User;
*/
import cn.itcast.Librarymanage.tools.GUItools;
import cn.itcast.Librarymanage.tools.JDBCUtils;
import cn.itcast.Librarymanage.dao.AdminDao;

public  class SignIn extends JFrame {

	private AdminDao adminDao = new AdminDao();
	private UserDao userDao = new UserDao();
	private final ButtonGroup group = new ButtonGroup();
	
	private JLabel label;
	private JLabel label_1;
    private JRadioButton userBut;//�û���ѡ��ť
    private JRadioButton adminBut;//����Ա��ѡ��ť
	JTextField id;       //�û�����ı���
	JPasswordField password; //�û������ı���
	JPanel panel;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JButton signup;//ע��
	JButton signin;//��¼
	private int action = 0;
    JFrame frame = new JFrame();
    
    private JDBCUtils  util= new JDBCUtils();
	
	public SignIn() {
		this.init();// ��ʼ������
		this.addComponent();// ������
		this.addListener();// ��Ӽ�����
	
	}
	
	//
	private void init() {
		this.setTitle("���¼!");// ����
		this.setSize(400, 300);// �����С��λ��
		GUItools.center(this);//���ô�������Ļ�ϵ�λ��
		this.setResizable(true);// �����С�̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���Ĭ�ϲ���
		this.setVisible(true);
	}	
	//������
	private void addComponent() {


	//	this.setLayout(new GroupLayout(panel));
	//   GroupLayout layout = new GroupLayout(panel); //���鲼��
		this.setLayout(null);
    	this.setSize(800, 600);
	    GUItools.center(this);
	    
		id =new JTextField();
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(16);
		
		
	//	label_1.setIcon(null);
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
	//	addJRadioButton("�û�");
    //  addJRadioButton("����Ա");
	
		
	  
        label = new JLabel("�û�",JLabel.CENTER);//����һ����ǩ
		label_1 = new JLabel("����",JLabel.CENTER);//����һ����ǩ
		
		panel2.add(label);//��ǩ��ӵ�panel���
		panel1.add(id);//����ı�����ӵ�panel���
		panel2.add(label_1);//��ǩ��ӵ�panel���
		panel1.add(password);//�����ı�����ӵ�panel���
//	    this.add(id);
//	    this.add(password);
	//	group.add(adminBut);

		userBut= new JRadioButton("�û�");
	     adminBut= new JRadioButton("����Ա");
        panel.add(userBut);//��ѡ��ť��ӵ�panel���
	    panel.add(adminBut);
	    signup= new JButton("ע��");
	     signin= new JButton("��¼");
	    signup.setBounds(220, 350, 90, 25);
	    signin.setBounds(320, 300, 90, 25);
	    panel2.add(signin);//��ť��ӵ�panel���
	    panel2.add(signup);
	    
	    
	}


	 private void addListener() { 
		 JButton button = new JButton("��¼");
		 button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(0 == action)
					JOptionPane.showMessageDialog(null, "��ѡ���¼��ʽ��");
				}
			});
		 button.setForeground(Color.BLUE);
		 
		 JButton button_1 = new JButton("ע��");
		 button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userRegister(e);
				}
			});
		 button_1.setForeground(Color.BLUE);
			
			userBut = new JRadioButton("�û�");
			group.add(userBut);
			userBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action =1;
				}
			});
			
			adminBut = new JRadioButton("����Ա");
			group.add(adminBut);
			adminBut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					action = 2;
				}
			});
			JRadioButton button2= new JRadioButton( );
			group.add(button2);
			button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
					if(1 == action) {
						int toRmif = userLogin(e2);
						if(1 == toRmif) {
							AbstractUserDialog Rmif = new AbstractUserDialog();
							Rmif.setVisible(true);
						}
					}	
					if(2 == action) {
						int toAmif = adminLogin(e2);
						if(1 == toAmif) {
							abstractAdminDialog Amif = new abstractAdminDialog();
							Amif.setVisible(true);
						}
					}
				}
			});
		
			
			signup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userRegister(e);//����ע�����
				}

			});

			JLayeredPane layeredPane = new JLayeredPane();
			
			JLayeredPane layeredPane_1 = new JLayeredPane();
			
			JLayeredPane layeredPane_2 = new JLayeredPane();
			
			GroupLayout gl_contentPane = new GroupLayout( panel);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createSequentialGroup() //��ֱ����(����)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createSequentialGroup()//��ֱ����(����)
						.addGap(129)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(260)
								.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(46)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
														.addGap(32))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(label, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(id, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
															.addComponent(password, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
												.addComponent(userBut)
												.addGap(31)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(37)
														.addComponent(adminBut))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(layeredPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(77))
													.addComponent(button_1))))
										.addGap(138))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
										.addGap(119)))))
						.addGap(190))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(adminBut)
									.addComponent(userBut))
								.addGap(24)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label))
								.addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1)))
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button)
								.addGap(137)
								.addComponent(layeredPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(button_1)))
			);
			panel.setLayout(gl_contentPane);
	    

 
	 }	

		//Ϊ��¼��ť����¼�

	 private int adminLogin(ActionEvent e)  {
			String userName = this.id.getText();
			String password = new String(this.password.getPassword());//��ȡ����
			//��һ����ĺ����еõ�һ����Ա���������䵽��һ�����н���ʹ��
			AdminService.setAdminId(userName);
			//��ʾ��
			if(JDBCUtils.isEmpty(userName)) {
				JOptionPane.showMessageDialog(null, "����Ա������Ϊ�գ�");
				return 0;
			}
			if(JDBCUtils.isEmpty(password)) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
				return 0;
			}
			Admin admin = new Admin(userName,password);
			Connection con =null;
			try {
			con = util.getConnection();//�������ݿ�
			Admin curreatAdmin= adminDao.login(con, admin);
			
			if(curreatAdmin!=null) {
				//��ʾ��
				JOptionPane.showMessageDialog(null, "����Ա��½�ɹ���");
				return 1;
			}else {
				JOptionPane.showMessageDialog(null, "����Ա�������������");
				return 0;
			}
			}catch(Exception e1){
				e1.printStackTrace();
				return 0;
			}finally {
				  try {
					  util.close(con);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	 private int userLogin(ActionEvent e)  {
			String userName1 = this.id.getText();
			String password1 = new String(this.password.getPassword());//��ȡ����
			//��һ����ĺ����еõ�һ����Ա���������䵽��һ�����н���ʹ��
			 UserService.setUserId(userName1);
			//��ʾ��
			if(JDBCUtils.isEmpty(userName1)) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
				return 0;
			}
			if(JDBCUtils.isEmpty(password1)) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
				return 0;
			}
			User user =new User(userName1,password1);
			Connection con =null;
			try {
			con = util.getConnection();//�������ݿ�
			User curreatUser= UserDao.query(con, user);
			
			if(curreatUser!=null) {
				//��ʾ��
				JOptionPane.showMessageDialog(null, "��½�ɹ���");
				return 1;
			}else {
				
				JOptionPane.showMessageDialog(null, "�û��������������");
				return 0;
			}
			}catch(Exception e1){
				e1.printStackTrace();
				return 0;
			}finally {
				  try {
					util.close(con);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	private void userRegister(ActionEvent e) {
		SignUp su = new SignUp();
		su.setVisible(true);
	}
	
	protected void addUser() {
	// TODO �Զ����ɵķ������
	
}
//��ѯ����
//	public abstract void queryBookItem();

//	public   void showAdminDialog();

	public void showSignInFrame() {
}

	public void showAdminDialog() {
		// TODO �Զ����ɵķ������
		
	}
	
}
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
 * ��������
 */
@SuppressWarnings("serial")
public abstract class abstractMainFrame extends JFrame {
	//���
	private JLabel titleLabel = new JLabel(new ImageIcon("ͼ��.jpg"));//����ͼƬ

//	private JButton btn = new JButton("����ϵͳ");//����ϵͳ��ť
    private JButton btn1 = new JButton("����Ա");
    private JButton btn2 = new JButton("�û�");
    private JButton btn3 = new JButton("�����û�");
    
    
	
    
    //���캯��
	public abstractMainFrame() {
		this.init();// ��ʼ������
		this.addComponent();// ������
		this.addListener();// ��Ӽ�����
	}	
	
	
	
	//��ʼ������
	private void init() {
		this.setTitle("��ӭʹ��ͼ�����ϵͳ!");// ����
		this.setSize(600, 400);// �����С��λ��
		GUItools.center(this);//���ô�������Ļ�ϵ�λ��
		GUItools.setTitleImage(this, "title.jpg");
		this.setResizable(true);// �����С�̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���Ĭ�ϲ���
	}	
	
	
	
	//������
	private void addComponent() {
		//����ʹ��Ĭ�ϵı߽粼��,��������ͼƬ
		this.add(this.titleLabel, BorderLayout.NORTH);
	//	this.add(this.btn, BorderLayout.CENTER);
        this.add(this.btn1, BorderLayout.SOUTH);
        this.add(this.btn2, BorderLayout.SOUTH);
        this.add(this.btn3, BorderLayout.SOUTH);
       
        
		//����JPanel����
		JPanel btnPanel = new JPanel();
         JPanel btn1Panel =new JPanel();
		//������֣�ʹJPanel�е���������Զ���λ��
		
	//	btnPanel.setLayout(null);
	//	btn1Panel.setLayout(null);
		
		//��JPanel������ӵ�������
		this.add(btnPanel);	
 		this.add(btn1Panel);
		//����߽�λ��
//		btn.setBounds(240,20,100, 30);
    	btn1.setBounds(240,60,100, 30);
    	btn1.setBounds(240,90,100, 30);
    	btn1.setBounds(240,120,100, 30);
		//����ť��ӵ�JPanel������
//		btnPanel.add(btn);
        btn1Panel.add(btn1);
        btn1Panel.add(btn2);
        btn1Panel.add(btn3);
	//	JPanel btn1Panel = new JPanel();
	//	this.add(btn1Panel);
	}
	
	
	
	//��Ӽ�����
	private void addListener() {
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdminDialog(); //��¼����
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserDialog(); //��¼����
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAdminUser(); //��¼����
			}
		});
		
	}	
	

	
	
	public abstract void showAdminUser();



	//չʾ��¼���淽��
	public abstract void showAdminDialog();
	
	public abstract void showUserDialog();
//	public abstract void showAdminDialog();//�ĳ�Frame
//	public abstract void showUserDialog();//��ʵ���õ���Frame���û���¼
}
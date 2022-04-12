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
 * ��������
 */
@SuppressWarnings("serial")
public class abstractAdminDialog extends JDialog{
	//�������ʹ�õ��������Ϊ��Ա����
	private JLabel tableLabel = new JLabel("ͼ���б�");//ͼ���б����
	private JScrollPane tablePane = new JScrollPane();//�����ӿ�
	protected JTable table = new JTable(); //ͼ���б�	
	private JLabel numberingLabel = new JLabel("ͼ����");//��ű���
	private JLabel booknameLabel = new JLabel("ͼ������");//���Ʊ���
	private JLabel numberLabel = new JLabel("ͼ������");//��������
	private JLabel priceLabel = new JLabel("ͼ��۸�");//�۸����
	//��ӹ������
	protected JTextField addNumberingText = new JTextField(6);//��ӱ���ı���
	protected JTextField addBooknameText = new JTextField(6);//��������ı���
	protected JTextField addNumberText = new JTextField(6);//��������ı���
	protected JTextField addPriceText = new JTextField(6);//��Ӽ۸��ı���
	private JButton addBtn = new JButton("���ͼ��");//��Ӱ�ť
	//�޸Ĺ������
	protected JTextField updateNumberingText = new JTextField(6);//�޸ı���ı���
	protected JTextField updateBooknameText = new JTextField(6);//�޸������ı���
	protected JTextField updateNumberText = new JTextField(6);//�޸������ı���
	protected JTextField updatePriceText = new JTextField(6);//�޸ļ۸��ı���
	private JButton updateBtn = new JButton("�޸�ͼ��");//�޸İ�ť
	//ɾ���������
	protected JTextField delNumberingText = new JTextField(6);//��ӱ���ı�
	private JButton delBtn = new JButton("ɾ��ͼ��");//ɾ����ť	
	//���췽��
	public abstractAdminDialog() {
		this(null,true);
	}
	public abstractAdminDialog(Frame owner, boolean modal) {
		super(owner, modal);
		this.init();// ��ʼ������
		this.addComponent();// ������
		this.addListener();// ��Ӽ�����
	}
	// ��ʼ������
	private void init() {
		this.setTitle("ͼ�����!");// ����
		this.setSize(600, 400);// �����С��λ��
		GUItools.center(this);//���ô�������Ļ�ϵ�λ��
		this.setResizable(true);// �����С�̶�
	}	
	// ������
	private void addComponent() {		
		//ȡ������
		this.setLayout(null);		
		//������
		tableLabel.setBounds(265, 20, 70, 25);
		this.add(tableLabel);		
		//���
		table.getTableHeader().setReorderingAllowed(false);	//�в����ƶ�
		table.getTableHeader().setResizingAllowed(false); 	//�����������
		table.setEnabled(true);							//���ɸ�������
		tablePane.setBounds(50, 50, 500, 200);				
		tablePane.setViewportView(table);					//�ӿ�װ����
		this.add(tablePane);		
		//�ֶα���
		numberingLabel.setBounds(50, 250, 70, 25);	
		booknameLabel.setBounds(150, 250, 70, 25);	
		numberLabel.setBounds(250, 250, 70, 25);	
		priceLabel.setBounds(350, 250, 70, 25);	
		this.add(numberingLabel);
		this.add(booknameLabel);
		this.add(numberLabel);
		this.add(priceLabel);		
		//�������
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
		//�޸����
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
		//ɾ�����
		delNumberingText.setBounds(50, 340, 80, 25);
		this.add(delNumberingText);
		delBtn.setBounds(460, 340, 90, 25);
		this.add(delBtn);
	}	
	// ��Ӽ�����
	private void addListener() {		
		//��Ӱ�ť����
		addBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				addBookItem();
			}
		});
		//�޸İ�ť����
		updateBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����޸ķ���
				updateBookItem();
			}
		});
		//ɾ����ť����
		delBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ɾ������
				delBookItem();
			}
		});
	}	
	//��ѯ����
	public void queryBookItem() {
	}
	//��ӷ���
	public void addBookItem() {
	}
	//�޸ķ���
	public void updateBookItem() {
	}
	//ɾ������
	public void delBookItem() {
	}
	
}
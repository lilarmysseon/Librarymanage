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
	//�������ʹ�õ��������Ϊ��Ա����
		private JLabel tableLabel = new JLabel("ͼ���б�");//ͼ���б����
		private JScrollPane tablePane = new JScrollPane();//�����ӿ�
		protected JTable table = new JTable(); //ͼ���б�
		private JLabel numberingLabel = new JLabel("ͼ����");//��ű���
		private JLabel booknameLabel = new JLabel("ͼ������");//���Ʊ���
		private JLabel numberLabel = new JLabel("ͼ������");//��������
		private JLabel priceLabel = new JLabel("ͼ��۸�");//�۸����
//		private JLabel book_statusLabel = new JLabel("ͼ��۸�");//״̬����
		
		//������ı�Ż������ƽ��黹��
		protected JTextField NumberingText = new JTextField(6);//����ı���,
		protected JTextField BooknameText = new JTextField(6);// �����ı���
		
		protected JTextField borrowNumberingText = new JTextField(6);//����ı���,
		protected JTextField borrowBooknameText = new JTextField(6);// �����ı���
		 
		private JButton borrowBtn = new JButton("���ͼ��");//��Ӱ�ť
		
		private JButton returnBtn = new JButton("�黹ͼ��");//�޸İ�ť
		
		public AbstractUserDialog() {
			this(null,true);
		}
		public AbstractUserDialog(Frame owner, boolean modal) {
			super(owner, modal);
			this.init();// ��ʼ������
			this.addComponent();// ������
			this.addListener();// ��Ӽ�����
		}
		// ��ʼ������
		private void init() {
			this.setTitle("ͼ������û�����");// ����
			this.setSize(600, 400);// �����С��λ��
			GUItools.center(this);//���ô�������Ļ�ϵ�λ��
			this.setResizable(false);// �����С�̶�
		}	
		// ������
		private void addComponent() {		
			//ȡ������
			this.setLayout(null);		
			//������
			tableLabel.setBounds(265, 20, 70, 25);
			this.add(tableLabel);	
			tableLabel.setVisible(true);
			//���
			table.getTableHeader().setReorderingAllowed(false);	//�в����ƶ�
			table.getTableHeader().setResizingAllowed(false); 	//�����������
			table.setEnabled(false);							//���ɸ�������
			tablePane.setBounds(50, 50, 500, 200);				
			tablePane.setViewportView(table);					//�ӿ�װ����
			this.add(tablePane);		
			//�ֶα���
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
			//�������
			borrowNumberingText.setBounds(50, 280, 80, 25);//��д����ı���
			borrowBooknameText.setBounds(150, 280, 80, 25);//��д�����ı���
			
			this.add( borrowNumberingText);
			this.add( borrowBooknameText);
			
			borrowBtn.setBounds(460, 280, 90, 25);
			this.add(borrowBtn);	
			
			//�������
			NumberingText.setBounds(50, 310, 80, 25);
			BooknameText.setBounds(150, 310, 80, 25);
			
			this.add(NumberingText);//��д����ı���
			this.add(BooknameText);//��д�����ı���
			
			returnBtn.setBounds(460, 310, 90, 25);
			this.add(returnBtn);		
			
			
		}	
		// ��Ӽ�����
		private void addListener() {		
			//��Ӱ�ť����
			borrowBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//���ý��鷽������UserService����
					bookborrow();
				}
			});
			//�޸İ�ť����
			returnBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//�����޸ķ���
					bookreturn();
				}
			});
		}
		//���鷽��
			public void bookborrow() {
		}
		//���鷽��
			public void bookreturn() {
			}
		//��������
			public void queryBookItem() {
			}
}







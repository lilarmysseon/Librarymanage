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
	//�������ʹ�õ��������Ϊ��Ա����
		private JLabel tableLabel = new JLabel("�û��б�");//ͼ���б����
		private JScrollPane tablePane = new JScrollPane();//�����ӿ�
		protected JTable table = new JTable(); //ͼ���б�	
		private JLabel numberingLabel = new JLabel("�û����");//��ű���
		private JLabel booknameLabel = new JLabel("�û�����");//���Ʊ���
		private JLabel numberLabel = new JLabel("�û��绰");//��������
		private JLabel priceLabel = new JLabel("�û�����");//�۸����
		//��ӹ������
		protected JTextField addNumberingText = new JTextField(6);//��ӱ���ı���
		protected JTextField addBooknameText = new JTextField(6);//��������ı���
		protected JTextField addNumberText = new JTextField(6);//��������ı���
		protected JTextField addPriceText = new JTextField(6);//��Ӽ۸��ı���
		private JButton addBtn = new JButton("����û�");//��Ӱ�ť
		//�޸Ĺ������
		protected JTextField updateNumberingText = new JTextField(6);//�޸ı���ı���
		protected JTextField updateBooknameText = new JTextField(6);//�޸������ı���
		protected JTextField updateNumberText = new JTextField(6);//�޸������ı���
		protected JTextField updatePriceText = new JTextField(6);//�޸ļ۸��ı���
		private JButton updateBtn = new JButton("�޸��û�");//�޸İ�ť
		//ɾ���������
		protected JTextField delNumberingText = new JTextField(6);//��ӱ���ı�
		private JButton delBtn = new JButton("ɾ���û�");//ɾ����ť	
	
		//���췽��
		public AdminUser() {
			this(null,true);
		}
		public AdminUser(Frame owner, boolean modal) {
			super(owner, modal);
			this.init();// ��ʼ������
			this.addComponent();// ������
			this.addListener();// ��Ӽ�����
		}
		// ��ʼ������
		private void init() {
			this.setTitle("�û�����!");// ����
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
					addUser();
				}
			});
			//�޸İ�ť����
			updateBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//�����޸ķ���
					updateUser();
				}
			});
			//ɾ����ť����
			delBtn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					//����ɾ������
					delUser();
				}
			});
		}	
		protected void updateUser() {
			// TODO �Զ����ɵķ������
			
		}
		protected void delUser() {
			// TODO �Զ����ɵķ������
			
		}
		protected void addUser() {
			// TODO �Զ����ɵķ������
			
		}
		//��ѯ����
		public void queryReader() {
		}
		
	}
	/**
	 * ɾ���û�����
	 */
/*	protected void deleteReader() {
		
		readerIdTxt=  new JTextField();
		String readerId  = this.readerIdTxt.getText();
		
		if(JDBCUtils.isEmpty(readerId)) {
			JOptionPane.showMessageDialog(null, "�û���Ų���Ϊ��");
		}
		
		Connection con = null;
		try {
			con = util.getConnection();
			ResultSet rs = adminDao.query(con, Integer.parseInt(readerId));
			if(rs.next()) {
				adminDao.delete(con, Integer.parseInt(readerId));
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				return;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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
	 * �û���ѯ
	 */

/*	protected void queryReader() {
		String readerId = this.readerIdTxt.getText();
		DefaultTableModel dtm = (DefaultTableModel) readerTable.getModel();
		dtm.setRowCount(0);
		
		if(JDBCUtils.isEmpty(readerId)) {
			JOptionPane.showMessageDialog(null, "�û���Ų���Ϊ��");
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

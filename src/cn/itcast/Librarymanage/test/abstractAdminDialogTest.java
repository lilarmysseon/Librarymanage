package cn.itcast.Librarymanage.test;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.Librarymanage.view.abstractAdminDialog;

/*
 * ������������
 */
@SuppressWarnings("serial")
public class abstractAdminDialogTest extends abstractAdminDialog{
	//���幹�캯����ʼ������
	public abstractAdminDialogTest() {
		super();
		queryBookItem();//��������
	}	
	//�������table����
	@Override
	public void queryBookItem() {
		String[] thead = new String[]{"ͼ����","ͼ����","ͼ������","ͼ�鵥��(Ԫ)"};
		String[][] tbody = new String[][]{
				{"1","������ƫ��","5","40"},
				{"2","��������","7","50"},
				{"3","Ʈ(ȫһ��)","8","80"},
				{"4","��������������","6","30"}
				};
		TableModel data = new DefaultTableModel(tbody,thead);
		table.setModel(data);
	}
	@Override
	public void addBookItem() {
	}
	@Override
	public void updateBookItem() {
	}
	@Override
	public void delBookItem() {
	}
    //�������������г���
	public static void main(String[] args) {
		//�������沢��ʾ
		new abstractAdminDialogTest().setVisible(true);
	}
}
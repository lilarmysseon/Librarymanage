package cn.itcast.Librarymanage.test;

import cn.itcast.Librarymanage.view.abstractMainFrame;

/**
 * �����ڲ�����
 */
@SuppressWarnings("serial")
public class abstractMainFrameTest extends abstractMainFrame {
	//����������
	public static void main(String[] args) {
		new abstractMainFrameTest().setVisible(true);
	}
	//���Ǹ�����չʾ����Ա����ķ���
	@Override
	public void showAdminDialog() {
		System.out.println("�������Ա����");
	}
	@Override
	public void showUserDialog() {
		// TODO �Զ����ɵķ������
		System.out.println("�����û�����");
	} 
	public void showAdminUser() {
		// TODO �Զ����ɵķ������
		System.out.println("�����û��������");
	} 
}
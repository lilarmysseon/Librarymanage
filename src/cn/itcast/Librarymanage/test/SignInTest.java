package cn.itcast.Librarymanage.test;

import cn.itcast.Librarymanage.view.SignIn;

public class SignInTest extends SignIn{

	public static void main(String[] args) {
		//����������
		new SignInTest().setVisible(true);

	}
	//���Ǹ�����չʾ����Ա����ķ���
	
	@Override
		public void showAdminDialog() {
			System.out.println("�����¼����");
		} 

	@Override
	public void showSignInFrame() {
		// TODO �Զ����ɵķ������
		
	}
/*
	@Override
	public void login() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void queryBookItem() {
		// TODO �Զ����ɵķ������
		
	}
*/

}

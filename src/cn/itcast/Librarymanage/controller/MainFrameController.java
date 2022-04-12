package cn.itcast.Librarymanage.controller;

import java.awt.Frame;

import cn.itcast.Librarymanage.test.abstractAdminDialogTest;
import cn.itcast.Librarymanage.view.AbstractUserDialog;
import cn.itcast.Librarymanage.view.SignIn;
import cn.itcast.Librarymanage.view.abstractAdminDialog;
import cn.itcast.Librarymanage.view.abstractMainFrame;


/**
 * �����������
 */
@SuppressWarnings("serial")
public class MainFrameController extends abstractMainFrame {
	public static void main(String[] args) {
		//�������沢��ʾ
		
	}
	@Override
	public void showAdminDialog() {
		//�ڸ÷����д�����¼���沢��ʾ
		//thisΪ������(������)  true������Ϊģ̬����չʾ
	
		new AdminDialogController(this, true).setVisible(true);
	}

	@Override
	public void showUserDialog() {
		// TODO �Զ����ɵķ������
		new UserDialogController(this, true).setVisible(true);
		
	}
	public void showSignInFrame() {
		// TODO �Զ����ɵķ������
		new SignInController().setVisible(true);
	}
	@Override
	public void showAdminUser() {
		
		// TODO �Զ����ɵķ������
		new AdminUserController(this, true).setVisible(true);
	}
	
}
package cn.itcast.Librarymanage.controller;

import java.awt.Frame;

import cn.itcast.Librarymanage.test.abstractAdminDialogTest;
import cn.itcast.Librarymanage.view.AbstractUserDialog;
import cn.itcast.Librarymanage.view.SignIn;
import cn.itcast.Librarymanage.view.abstractAdminDialog;
import cn.itcast.Librarymanage.view.abstractMainFrame;


/**
 * 主界面操作类
 */
@SuppressWarnings("serial")
public class MainFrameController extends abstractMainFrame {
	public static void main(String[] args) {
		//创建界面并显示
		
	}
	@Override
	public void showAdminDialog() {
		//在该方法中创建登录界面并显示
		//this为父窗口(主界面)  true：设置为模态窗口展示
	
		new AdminDialogController(this, true).setVisible(true);
	}

	@Override
	public void showUserDialog() {
		// TODO 自动生成的方法存根
		new UserDialogController(this, true).setVisible(true);
		
	}
	public void showSignInFrame() {
		// TODO 自动生成的方法存根
		new SignInController().setVisible(true);
	}
	@Override
	public void showAdminUser() {
		
		// TODO 自动生成的方法存根
		new AdminUserController(this, true).setVisible(true);
	}
	
}
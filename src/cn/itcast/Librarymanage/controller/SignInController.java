package cn.itcast.Librarymanage.controller;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.Librarymanage.domain.BookItem;
import cn.itcast.Librarymanage.service.AdminService;
import cn.itcast.Librarymanage.service.UserService;
import cn.itcast.Librarymanage.test.SignInTest;
import cn.itcast.Librarymanage.view.AbstractUserDialog;
import cn.itcast.Librarymanage.view.SignIn;
import cn.itcast.Librarymanage.view.SignUp;
import cn.itcast.Librarymanage.view.abstractAdminDialog;

public  class SignInController extends SignIn{
	public void showSignInFrame() {
		AbstractUserDialog si =new AbstractUserDialog();
		si.setVisible(true);
		
	}
}

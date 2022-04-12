package cn.itcast.Librarymanage.test;

import cn.itcast.Librarymanage.view.SignIn;

public class SignInTest extends SignIn{

	public static void main(String[] args) {
		//定义主函数
		new SignInTest().setVisible(true);

	}
	//覆盖父类中展示管理员界面的方法
	
	@Override
		public void showAdminDialog() {
			System.out.println("进入登录界面");
		} 

	@Override
	public void showSignInFrame() {
		// TODO 自动生成的方法存根
		
	}
/*
	@Override
	public void login() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void queryBookItem() {
		// TODO 自动生成的方法存根
		
	}
*/

}

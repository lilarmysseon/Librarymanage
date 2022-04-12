package cn.itcast.Librarymanage.test;

import cn.itcast.Librarymanage.view.abstractMainFrame;

/**
 * 主窗口测试类
 */
@SuppressWarnings("serial")
public class abstractMainFrameTest extends abstractMainFrame {
	//定义主函数
	public static void main(String[] args) {
		new abstractMainFrameTest().setVisible(true);
	}
	//覆盖父类中展示管理员界面的方法
	@Override
	public void showAdminDialog() {
		System.out.println("进入管理员界面");
	}
	@Override
	public void showUserDialog() {
		// TODO 自动生成的方法存根
		System.out.println("进入用户界面");
	} 
	public void showAdminUser() {
		// TODO 自动生成的方法存根
		System.out.println("进入用户管理界面");
	} 
}
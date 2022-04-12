package cn.itcast.Librarymanage.app;

import cn.itcast.Librarymanage.controller.MainFrameController;
//import cn.itcast.Util.Connect;

/**
 * 项目运行
 */
public class MainApp {
	public static void main(String[] args) {		
		new MainFrameController().setVisible(true);
	}
}

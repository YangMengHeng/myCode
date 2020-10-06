package cn.edu.ncu.fruitstore.test;

import cn.edu.ncu.fruitstore.view.AbstractMainFrame;

public class MainFrame extends AbstractMainFrame {

	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
	//覆盖父类中展示管理员界面的方法
	@Override
	public void showAdminDialog() {
		System.out.println("进入管理界面");
		//this.dispose();
		new AdminDialog().setVisible(true);
	} 
}

package cn.edu.ncu.fruitstore.test;

import cn.edu.ncu.fruitstore.view.AbstractMainFrame;

public class MainFrame extends AbstractMainFrame {

	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
	//���Ǹ�����չʾ����Ա����ķ���
	@Override
	public void showAdminDialog() {
		System.out.println("����������");
		//this.dispose();
		new AdminDialog().setVisible(true);
	} 
}

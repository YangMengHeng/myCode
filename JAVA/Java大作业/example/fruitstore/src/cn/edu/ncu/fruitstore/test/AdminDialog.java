package cn.edu.ncu.fruitstore.test;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.ncu.fruitstore.domain.FruitItem;
import cn.edu.ncu.fruitstore.service.AdminService;
import cn.edu.ncu.fruitstore.view.AbstractAdminDialog;


public class AdminDialog extends AbstractAdminDialog {
	// ��������࣬�ṩ�������ܷ���
	private AdminService adminService = new AdminService();

	public AdminDialog() {
		super();
		queryFruitItem();// ��������
	}

	// ��ѯ����
	@Override
	public void queryFruitItem() {
		// ������ͷ
		String[] thead = { "ˮ�����", "ˮ������", "ˮ������(/Ԫ)", "�Ƽ۵�λ" };

		// ����adminService�Ĳ�ѯ����
		ArrayList<FruitItem> dataList = adminService.queryFruitItem();
		// ����list2Array����������ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody = list2Array(dataList);
		// ����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}

	// ��������תΪ��ά���鷽��
	public String[][] list2Array(ArrayList<FruitItem> list) {
		// ����FruitItem��model�뼯�����ݶ���JTable�����ݶ�ά����
		String[][] tbody = new String[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			FruitItem fruitItem = list.get(i);
			tbody[i][0] = fruitItem.getNumber();
			tbody[i][1] = fruitItem.getName();
			tbody[i][2] = fruitItem.getPrice() + "";
			tbody[i][3] = fruitItem.getUnit();
		}
		return tbody;
	}

	// ��ӷ���
	@Override
	public void addFruitItem() {
		// ��ȡ����
		String addNumber = addNumberText.getText();
		String addName = addNameText.getText();
		String addPrice = addPriceText.getText();
		String addUnit = addUnitText.getText();
		// ����adminService����ӷ���
		try {
			boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
			// �����ӳɹ�
			if (addSuccess) {
				// ��Ӻ�ˢ�±��
				queryFruitItem();
			} else {
				// û����ӳɹ�����������ʾ
				JOptionPane.showMessageDialog(this, "ˮ����Ų����ظ�,��������!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "�����������ݸ�ʽ!");
		} finally {
			addNumberText.setText("");
			addNameText.setText("");
			addPriceText.setText("");
			addUnitText.setText("");
		}
	}

	// �޸ķ���
	@Override
	public void updateFruitItem() {
		// ��ȡ����
		String updateNumber = updateNumberText.getText();
		String updateName = updateNameText.getText();
		String updatePrice = updatePriceText.getText();
		String updateUnit = updateUnitText.getText();
		// ����adminService���޸ķ���
		try {
			boolean updateSuccess = adminService.updateFruitItem(updateNumber, updateName, updatePrice, updateUnit);
			// ����޸ĳɹ�
			if (updateSuccess) {
				// �޸ĺ�ˢ�±��
				queryFruitItem();
			} else {
				// û���޸ĳɹ�����������ʾ
				JOptionPane.showMessageDialog(this, "û�������ŵ�ˮ��,��������!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "�����������ݸ�ʽ!");
		} finally {
			updateNumberText.setText("");
			updateNameText.setText("");
			updatePriceText.setText("");
			updateUnitText.setText("");
		}
	}

	// ɾ������
	@Override
	public void delFruitItem() {
		// ��ȡ����
		String delNumber = delNumberText.getText();
		// ����adminService��ɾ������
		boolean delSuccess = adminService.delFruitItem(delNumber);
		// ���ɾ���ɹ�
		if (delSuccess) {
			// ɾ����ˢ�±��
			queryFruitItem();
		} else {
			// û��ɾ���ɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵ�ˮ��,��������!");
		}

		delNumberText.setText("");
	} 
	
	// �������������г���
	/*
	 * public static void main(String[] args) { //�������沢��ʾ new
	 * AbstractAdminDialogTest().setVisible(true); }
	 */

	@Override
	public void queryFruitItemForCon() {
		// TODO Auto-generated method stub

		// ��ȡ����
		String conNumber = queryNumberText.getText();
		String conName = queryNameText.getText();
		String conPrice = queryPriceText.getText();
		String conUnit = queryUnitText.getText();

		// ������ͷ
		String[] thead = { "ˮ�����", "ˮ������", "ˮ������(/Ԫ)", "�Ƽ۵�λ" };
		// ����adminService�Ĳ�ѯ����
		ArrayList<FruitItem> dataList = adminService.queryFruitItemForCon(conNumber, conName, conPrice, conUnit);
		// ����list2Array����������ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody = list2Array(dataList);
		// ����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);

		queryNumberText.setText("");
		queryNameText.setText("");
		queryPriceText.setText("");
		queryUnitText.setText("");

	}
}

package cn.edu.ncu.fruitstore.service;

import java.util.ArrayList;

import cn.edu.ncu.fruitstore.dao.AdminDao;
import cn.edu.ncu.fruitstore.domain.FruitItem;


public class AdminService {
	private AdminDao adminDao = new AdminDao();	
	//��ѯ����
	public ArrayList<FruitItem> queryFruitItem() {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<FruitItem> data = adminDao.queryAllData();
		//��������
		return data;
	} 
	
	public ArrayList<FruitItem> queryFruitItemForCon(String conNumber,String conName,String conPrice,String conUnit){
	
		ArrayList<FruitItem> data = adminDao.queryDataForCon(conNumber,conName,conPrice,conUnit);
		//��������
		return data;
	}
	//��ӷ���
	public boolean addFruitItem(String number, String name, String price,String unit) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<FruitItem> data = queryFruitItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			FruitItem fruitItem = data.get(i);
			//��������ظ�������ݣ�����Ӳ��ɹ�
			if(number.equals(fruitItem.getNumber())) {
				return false;
			}
		}
		//���û���ظ���ţ������ݷ�װΪFruitItem����
		FruitItem thisFruitItem = new FruitItem(number, name,Double.parseDouble(price), unit);
		//����Dao���������ݷ���
		adminDao.addFruitItem(thisFruitItem);
		//��������ݺ󣬷�����ӳɹ�
		return true;
	}
	//�޸ķ���
	public boolean updateFruitItem(String number, String name,String price, String unit) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<FruitItem> data = queryFruitItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			FruitItem fruitItem = data.get(i);
			//���������ͬ������ݣ�����Ը���
			if(number.equals(fruitItem.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				FruitItem thisFruitItem = new FruitItem(number, name,Double.parseDouble(price), unit);
				adminDao.updateFruitItem(thisFruitItem);
				/*adminDao.delFruitItem(number);
				//���û���ظ���ţ������ݷ�װΪFruitItem����
				FruitItem thisFruitItem = new FruitItem(number, name,Double.parseDouble(price), unit);
				//����Dao���������ݷ���
				adminDao.addFruitItem(thisFruitItem);*/
				//���޸����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿��Ը���
		return false;
	}
	//ɾ������
	public boolean delFruitItem(String delNumber) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<FruitItem> data = queryFruitItem();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			FruitItem fruitItem = data.get(i);
			//���������ͬ������ݣ������ɾ��
			if(delNumber.equals(fruitItem.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delFruitItem(delNumber);
				//��ɾ�����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿���ɾ��
		return false;
	}

}

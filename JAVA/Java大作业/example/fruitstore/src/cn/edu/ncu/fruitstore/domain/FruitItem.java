package cn.edu.ncu.fruitstore.domain;

public class FruitItem {
	//����
	private String number;//���
	private String name;  //����
	private double price; //�۸�
	private String unit;  //��λ
	//���췽��
	public FruitItem() {
	} 
	public FruitItem(String number, String name, double price, String unit) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}
	//get/set����
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}

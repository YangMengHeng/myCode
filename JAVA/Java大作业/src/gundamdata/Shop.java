package gundamdata;

public class Shop {
	private String productArea;
	private String Brand;
	private String Series;
	private String Gundam;
	private String Id;
	private String Pro;
	private int GNum;
	private int productC;
	private int Price;
	private int Camp;
	public static int Count = 0;
	
	public Shop(String pa, String br, String ser, String gundam, String id, String pro, int num, int pc, int pr, int camp) {
		this.productArea = pa;
		this.Brand = br;
		this.Series = ser;
		this.Gundam = gundam;
		this.Id = id;
		this.Pro = pro;
		this.GNum = num;
		this.productC = pc;
		this.Price = pr;
		this.Camp = camp;
		this.Count++;
	}
	public Shop() {this.Count++;}
	public void setProductArea(String pc) {
		this.productArea = pc;
	}
	public void setBrand(String br) {
		this.Brand = br;
	}
	public void setSeries(String ser) {
		this.Series = ser;
	}
	public void setGundam(String gundam) {
		this.Gundam = gundam;
	}
	public void setIdentifier(String id) {
		this.Id = id;
	}
	public void setProportion(String pro) {
		this.Pro = pro;
	}
	public void setGNumber(int num) {
		this.GNum = num;
	}
	public void setProductCapacity(int pc) {
		this.productC = pc;
	}
	public void setPrice(int pr) {
		this.Price = pr;
	}
	public void setCamp(int c) {
		this.Camp = c;
	}
	public String getProductArea() {
		return this.productArea;
	}
	public String getBrand() {
		return this.Brand;
	}
	public String getSeries() {
		return this.Series;
	}
	public String getGundam() {
		return this.Gundam;
	}
	public String getIdentifier() {
		return this.Id;
	}
	public String getProportion() {
		return this.Pro;
	}
	public int getGNumber() {
		return this.GNum;
	}
	public int getProductCapacity() {
		return this.productC;
	}
	public int getPrice() {
		return this.Price;
	}
	public int getCamp() {
		return this.Camp;
	}
}
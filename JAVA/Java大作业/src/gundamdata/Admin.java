package gundamdata;

public class Admin {
	private int Num;
	private String adminName;
	private String adminAccount;
	private String adminPass;
	private String Addr;
	private String Contact;
	private String openTime;
	private int Capital;
	private String Goods;
	public static int Count = 0;
	
	public Admin(int num, String adn, String adc, String adp, String addr, String con, String opent, int cap, String g) {
		this.Num = num;
		this.adminName = adn;
		this.adminPass = adp;
		this.adminAccount = adc;
		this.Addr = addr;
		this.Contact = con;
		this.openTime = opent;
		this.Capital = cap;
		this.Goods = g;
		this.Count++;
	}
	public Admin() {this.Count++;}
	public void setNum(int num) {
		this.Num = num;
	}
	public void setAdminName(String adn) {
		this.adminName = adn;
	}
	public void setAddr(String addr) {
		this.Addr = addr;
	}
	public void setAdminAccount(String adc) {
		this.adminAccount = adc;
	}
	public void setAdminP(String adp) {
		this.adminPass = adp;
	}
	public void setContact(String c) {
		this.Contact = c;
	}
	public void setOpenTime(String t) {
		this.openTime = t;
	}
	public void setCapital(int cap) {
		this.Capital = cap;
	}
	public void setGoods(String g) {
		this.Goods = g;
	}
	public int getNum() {
		return this.Num;
	}
	public String getAccount() {
		return this.adminAccount;
	}
	public String getAccP() {
		return this.adminPass;
	}
	public String getAdminName() {
		return this.adminName;
	}
	public String getAddr() {
		return this.Addr;
	}
	public String getContact() {
		return this.Contact;
	}
	public String getOpenTime() {
		return this.openTime;
	}
	public int getCapital() {
		return this.Capital;
	}
	public String getGoods() {
		return this.Goods;
	}
}
package gundamdata;

public class User {
	private int Num;
	private String userA;
	private String userP;
	private String userN;
	private String userC;
	private String userAddr;
	private int userM;
	private String openTime;
	private String Goods;
	public static int Count = 0;
	
	public User(int num, String user, String usp, String usn, String usc, String usa, int usm, String opent, String g){
		this.Num = num;
		this.userA = user;
		this.userP = usp;
		this.userN = usn;
		this.userC = usc;
		this.userAddr = usa;
		this.userM = usm;
		this.openTime = opent;
		this.Goods = g;
		this.Count++;
	}
	public User() {this.Count++;}
	public void setNum(int num) {
		this.Num = num;
	}
	public void setUserA(String user) {
		this.userA = user;
	}
	public void setUserP(String usp) {
		this.userP = usp;
	}
	public void setUserN(String usn) {
		this.userN = usn;
	}
	public void setUserC(String usc) {
		this.userC = usc;
	}
	public void setUserAddr(String adr) {
		this.userAddr = adr;
	}
	public void setUserMoney(int usm) {
		this.userM = usm;
	}
	public void setOpenT(String time) {
		this.openTime = time;
	}
	public void setGoods(String g) {
		this.Goods = g;
	}
	public String getUserA() {
		return this.userA;
	}
	public String getUserC() {
		return this.userC;
	}
	public String getUserP() {
		return this.userP;
	}
	public String getUserName() {
		return this.userN;
	}
	public String getUserAddr() {
		return this.userAddr;
	}
	public int getUserMoney() {
		return this.userM;
	}
	public String getOpenTime() {
		return this.openTime;
	}
	public String getGoods() {
		return this.Goods;
	}
	public int getCount() {
		return this.Count;
	}
	public int getNum() {
		return this.Num;
	}
}

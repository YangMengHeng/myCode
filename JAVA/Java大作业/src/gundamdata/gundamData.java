package gundamdata;

import java.sql.*;
import java.util.ArrayList;
import gundamTools.GundamJDBC;

public class gundamData {
	private Connection con;
	private Statement s;
	private ResultSet rs;
	public ArrayList<Admin> admin;
	public ArrayList<User> user;
	public ArrayList<Shop> shop;
	
	public gundamData(String table) {
		try {
			con = GundamJDBC.getMySQL();
			s = con.createStatement();
			String sql = "SELECT * from " + table;
			rs = s.executeQuery(sql);
			Shop.Count = 0;
			User.Count = 0;
			Admin.Count = 0;
			
			switch(table) {
			case "gundamprc":{
				this.shop = new ArrayList<Shop>();
				while(rs.next()) {
					Shop gs = new Shop();
					gs.setProductArea(rs.getString("ProductArea"));
					gs.setBrand(rs.getString("Brand"));
					gs.setSeries(rs.getString("Series"));
					gs.setGundam(rs.getString("Gundam"));
					gs.setIdentifier(rs.getString("Identifier"));
					gs.setProportion(rs.getString("Proportion"));
					gs.setGNumber(rs.getInt("GNumber"));
					gs.setProductCapacity(rs.getInt("ProductCapacity"));
					gs.setPrice(rs.getInt("Price"));
					gs.setCamp(rs.getInt("Camp"));
					shop.add(gs);
				}
				break;
			}
			case "user":{
				this.user = new ArrayList<User>();
				while(rs.next()) {
					User gu = new User();
					gu.setNum(rs.getInt("Number"));
					gu.setUserA(rs.getString("UserAccount"));
					gu.setUserN(rs.getString("UserName"));
					gu.setUserP(rs.getString("UserPassword"));
					gu.setUserC(rs.getString("UserContact"));
					gu.setUserAddr(rs.getString("UserAddress"));
					gu.setUserMoney(rs.getInt("UserMoney"));
					gu.setOpenT(rs.getString("OpenTime"));
					gu.setGoods(rs.getString("Goods"));
					user.add(gu);
				}
				break;
			}
			case "admin":{
				this.admin = new ArrayList<Admin>();
				while(rs.next()) {
					Admin ad = new Admin();
					ad.setNum(rs.getInt("Number"));
					ad.setAdminName(rs.getString("AdminName"));
					ad.setAdminAccount(rs.getString("Account"));
					ad.setAdminP(rs.getString("Password"));
					ad.setAddr(rs.getString("Address"));
					ad.setContact(rs.getString("Contact"));
					ad.setOpenTime(rs.getString("OpenTime"));
					ad.setCapital(rs.getInt("Capital"));
					ad.setGoods(rs.getString("Goods"));
					admin.add(ad);
				}
				break;
			}
			default:{
				System.out.println("Error Code:1004! Pls contact administrator!");
				break;
			}
			}	
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		}
		catch(SQLException e) {
			 e.printStackTrace();  
		}catch (Exception e) {
			 e.printStackTrace();
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con);
		}
	}
	
	public gundamData(boolean sign) {
		try {
			con = GundamJDBC.getMySQL();
			s = con.createStatement();
			String sql = "SELECT * from user" ;
			rs = s.executeQuery(sql);
			User.Count = 0;
			Admin.Count = 0;
			this.admin = new ArrayList<Admin>();
			this.user = new ArrayList<User>();
			
			while(rs.next()) {
				User gu = new User();
				gu.setNum(rs.getInt("Number"));
				gu.setUserA(rs.getString("UserAccount"));
				gu.setUserN(rs.getString("UserName"));
				gu.setUserP(rs.getString("UserPassword"));
				gu.setUserC(rs.getString("UserContact"));
				gu.setUserAddr(rs.getString("UserAddress"));
				gu.setUserMoney(rs.getInt("UserMoney"));
				gu.setOpenT(rs.getString("OpenTime"));
				gu.setGoods(rs.getString("Goods"));
				user.add(gu);
			}
			sql = "SELECT * from admin" ;
			ResultSet rs1;
			rs1 = s.executeQuery(sql);
			while(rs1.next()) {
				Admin ad = new Admin();
				ad.setNum(rs1.getInt("Number"));
				ad.setAdminName(rs1.getString("AdminName"));
				ad.setAdminAccount(rs1.getString("Account"));
				ad.setAdminP(rs1.getString("Password"));
				ad.setAddr(rs1.getString("Address"));
				ad.setContact(rs1.getString("Contact"));
				ad.setOpenTime(rs1.getString("OpenTime"));
				ad.setCapital(rs1.getInt("Capital"));
				ad.setGoods(rs1.getString("Goods"));
				admin.add(ad);
			}
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		}
		catch(SQLException e) {
			 e.printStackTrace();  
		}catch (Exception e) {
			 e.printStackTrace();
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con);
		}
	}
	
	//updateData, DeleteData, addData
	//admin
	public boolean updateData(Admin ad) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "UPDATE admin SET Number=" + ad.getNum() 
			+ ",AdminName='" + ad.getAdminName() + "',Account='" +
			ad.getAccount() + "',Password='" + ad.getAccP() + "',Address='"
			+ ad.getAddr() + "',Contact='" + ad.getContact() + "',OpenTime='"
			+ ad.getOpenTime() + "',Capital=" + ad.getCapital() + ",Goods='" + ad.getGoods() 
			 + "' WHERE Number=" + ad.getNum() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1013!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean DeleteData(Admin ad) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "DELETE from admin WHERE Number=" + ad.getNum() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1023!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean addData(Admin ad) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "INSERT INTO admin(Number,AdminName,Account,Password,Address,Contact,OpenTime,Capital,Goods)"
					+ "Values(" + ad.getNum() + ",'" + ad.getAdminName() + "','" + ad.getAccount() + "','"
					+ ad.getAccP() + "','" + ad.getAddr() + "','" + ad.getContact() + "','" + ad.getOpenTime() + 
					"'," + ad.getCapital() + ",'" + ad.getGoods() +"');";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1033!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	//user
	public boolean updateData(User us) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "UPDATE user SET Number=" + us.getNum() 
			+ ",UserAccount='" + us.getUserA() + "',UserPassword='" +
			us.getUserP() + "',UserName='" + us.getUserName() + "',UserContact='"
			+ us.getUserC() + "',UserAddress='" + us.getUserAddr() + "',UserMoney=" + us.getUserMoney() + ",OpenTime='"
			+ us.getOpenTime() + "',Goods='" + us.getGoods() + "' WHERE Number=" + us.getNum() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1012!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean DeleteData(User us) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "DELETE from user WHERE Number=" + us.getNum() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1022!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean addData(User us) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "INSERT INTO user(Number,UserAccount,UserPassword,UserName,UserContact,UserAddress,UserMoney,OpenTime,Goods)"
					+ "Values(" + us.getNum() + ",'" + us.getUserA() + "','" + us.getUserP() + "','"
					+ us.getUserName() + "','" + us.getUserC() + "','" + us.getUserAddr() + "'," 
					+ us.getUserMoney() + ",'" + us.getOpenTime() + "','" + us.getGoods() + "');";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1032!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con);
		}
		
		return true;
	}
	//shop
	public boolean updateData(Shop sh) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "UPDATE gundamprc SET ProductArea='" + sh.getProductArea() 
			+ "',Brand='" + sh.getBrand() + "',Series='" + sh.getSeries()
			+ "',Gundam='" + sh.getGundam() + "',Identifier='" + sh.getIdentifier()
			+ "',Proportion='" + sh.getProportion() + "',GNumber=" + sh.getGNumber()
			+ ",ProductCapacity=" + sh.getProductCapacity() + ",Price=" + sh.getPrice()
			+ ",Camp=" + sh.getCamp() + " WHERE GNumber=" + sh.getGNumber() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1011!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean updateData(Shop sh, int t) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "UPDATE gundamprc SET ProductArea='" + sh.getProductArea() 
			+ "',Brand='" + sh.getBrand() + "',Series='" + sh.getSeries()
			+ "',Gundam='" + sh.getGundam() + "',Identifier='" + sh.getIdentifier()
			+ "',Proportion='" + sh.getProportion() + "',GNumber=" + sh.getGNumber()
			+ ",ProductCapacity=" + sh.getProductCapacity() + ",Price=" + sh.getPrice()
			+ ",Camp=" + sh.getCamp() + " WHERE GNumber=" + (sh.getGNumber() + 1) + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1011!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean DeleteData(Shop sh) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "DELETE from gundamprc WHERE GNumber=" + sh.getGNumber() + ";";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1021!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
	public boolean addData(Shop sh) {
		try {
			this.con = GundamJDBC.getMySQL();
			this.s = con.createStatement();
			String sql = "INSERT INTO gundamprc(ProductArea,Brand,Series,Gundam,Identifier,Proportion, GNumber,ProductCapacity,Price,Camp)"
					+ "Values('"+ sh.getProductArea() + "','" + sh.getBrand() + "','" + sh.getSeries() + "','"
					+ sh.getGundam() + "','" + sh.getIdentifier() + "','" + sh.getProportion() + "'," + sh.getGNumber() + "," + 
					sh.getProductCapacity() + "," + sh.getPrice() + "," + sh.getCamp() + ");";
			if(s.executeUpdate(sql) <= 0) {
				System.out.println("Error Code:1013!");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			GundamJDBC.Release(rs, this.s, this.con); 
		}
		
		return true;
	}
}

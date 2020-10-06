package cn.edu.ncu.fruitstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.ncu.fruitstore.domain.FruitItem;
import cn.edu.ncu.fruitstore.tools.JDBCUtils;


public class AdminDao {
	// 获取所有数据
	public ArrayList<FruitItem> queryAllData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FruitItem> list = new ArrayList<FruitItem>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM fruit";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				FruitItem fruitItem = new FruitItem();
				fruitItem.setNumber(rs.getString("number"));
				fruitItem.setName(rs.getString("fruitname"));
				fruitItem.setPrice(rs.getDouble("price"));
				fruitItem.setUnit(rs.getString("unit"));
				list.add(fruitItem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	public ArrayList<FruitItem> queryDataForCon(String conNumber,String conName,String conPrice,String conUnit){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FruitItem> list = new ArrayList<FruitItem>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM fruit where 1=1";
			if(conNumber!=null&&conNumber.trim().length()!=0)
				sql=sql+" and number="+conNumber.trim();
			if(conName!=null&&conName.trim().length()!=0)
				sql=sql+" and fruitname like '%"+conName.trim()+"%'";
			if(conPrice!=null&&conPrice.trim().length()!=0)
				sql=sql+" and price="+conPrice.trim();
			if(conUnit!=null&&conUnit.trim().length()!=0)
				sql=sql+" and unit='"+conUnit.trim()+"'";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				FruitItem fruitItem = new FruitItem();
				fruitItem.setNumber(rs.getString("number"));
				fruitItem.setName(rs.getString("fruitname"));
				fruitItem.setPrice(rs.getDouble("price"));
				fruitItem.setUnit(rs.getString("unit"));
				list.add(fruitItem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;	
	}
	//添加数据
	public void addFruitItem(FruitItem fruitItem) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "INSERT INTO fruit(number,fruitname,price,unit)"
					+ "VALUES(" + fruitItem.getNumber() + ",'" + fruitItem.getName()
					+ "','" + fruitItem.getPrice() + "','" + fruitItem.getUnit()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	//修改数据
	public void updateFruitItem(FruitItem fruitItem) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "update fruit set fruitname='" + fruitItem.getName()+ "',price='"
					+fruitItem.getPrice()+"',unit='"+fruitItem.getUnit()+ "' where number='"
					+fruitItem.getNumber()+"'";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("修改数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	
	//删除数据
	public void delFruitItem(String delNumber) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "DELETE FROM fruit WHERE number=" + delNumber;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("删除数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}

}

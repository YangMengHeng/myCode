package gundamTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GundamJDBC {
	//load driver, connect with database
		public static Connection getMySQL() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/gundamclub?useSSL=false&serverTimezone=UTC";
			String userName = "root";
			String Password = "YangmhSQL5549";
			Connection conn = DriverManager.getConnection(URL, userName, Password);
			return conn;				
		}
		//Close connection with database, release resource
		public static void Release(Statement stmt, Connection conn) {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		public static void Release(ResultSet rs, Statement stmt, Connection conn) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			Release(stmt, conn);
		}
}

package kh.edu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

	public static Connection makeConnection() {
		// 오라클 데이터베이스 정보(주소, 유저, 패스워드)
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "sqlDB";
		String password = "sqlDB";
		// 오라클 데이터베이스 객체 참조 변수
		Connection con = null;
		// oracle jdbc library class load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc driver load success");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("database connection success");
		} catch (ClassNotFoundException e) {
			System.out.println("loading failure");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("connection fail");
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		Connection con = makeConnection();
	}
}
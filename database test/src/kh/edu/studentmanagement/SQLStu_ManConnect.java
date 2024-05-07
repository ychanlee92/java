package kh.edu.studentmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLStu_ManConnect {
	public static Connection makeConnection() throws FileNotFoundException, IOException {
		// 오라클 데이터베이스 정보(주소, 유저, 패스워드)
		String filePath = "D:/doitjava/student_management/stu_man.properties";
		Properties properties = new Properties();
		properties.load(new FileReader(filePath));
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		// 오라클 데이터베이스 객체 참조 변수
		Connection con = null;
		// oracle jdbc library class load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("jdbc driver load success");
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("database connection success");
		} catch (ClassNotFoundException e) {
			System.out.println("loading failure");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("connection fail");
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Connection con = makeConnection() ;
	}
}

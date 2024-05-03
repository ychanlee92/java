package kh.edu.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ConnectingTest {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectDatabase.makeConnection();
		// sql문 작성 > 실행 > 결과 result set 가져오기
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userTBL");
		ArrayList<User> user = new ArrayList<User>();
		ArrayList<Buy> buy = new ArrayList<Buy>();
		
		String userID; 
		String userName;
		int birthYear;
		String addr;
		String mobile1;
		String mobile2;
		int height;
		Date mDate;
		
		int idNum;
		String userID2;
		String prodName;
		String groupName;
		double price;
		int amount;
		
		while (rs.next()) {
			userID = rs.getString("userID");
			userName = rs.getString("userName");
			birthYear = rs.getInt("birthYear");
			addr = rs.getString("addr");
			mobile1 = rs.getString("mobile1");
			mobile2 = rs.getString("mobile2");
			height = rs.getInt("height");
			mDate = rs.getDate("mDate");
			User us = new User(userID,userName,birthYear,addr,mobile1,mobile2,height,mDate);
			user.add(us);
		}
		userPrint(user);
	}

	private static void userPrint(ArrayList<User> user) {
		for (User data : user) {
			System.out.println(data.toString());
		}
	}

}

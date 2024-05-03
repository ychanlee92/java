package kh.edu.database;

import java.util.Date;
import java.util.Objects;

public class User {
	private String userID = null; 
	private String userName = null;
	private	int birthYear = 0;
	private String addr = null;
	private String mobile1 = null;
	private String mobile2 = null;
	private	int height = 0;
	private Date mDate;
	
	public User(String userID, String userName, int birthYear, String addr, String mobile1, String mobile2,
			int height, Date mDate) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.birthYear = birthYear;
		this.addr = addr;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.height = height;
		this.mDate = mDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userID, other.userID);
	}

	@Override
	public String toString() {
		return "[" + userID + "|" + userName + "\t|" + birthYear + "\t|" + addr
				+ "\t|" + mobile1 + "\t|" + mobile2 + "\t|" + height + "\t|" + mDate + "]";
	}
	
	
}

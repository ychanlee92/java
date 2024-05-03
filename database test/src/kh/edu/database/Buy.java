package kh.edu.database;

import java.util.Objects;

public class Buy {
	private int idNum;
	private String userID;
	private String prodName;
	private String groupName;
	private double price;
	private int amount;
	
	public Buy(int idNum, String userID, String prodName, String groupName, double price, int amount) {
		super();
		this.idNum = idNum;
		this.userID = userID;
		this.prodName = prodName;
		this.groupName = groupName;
		this.price = price;
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buy other = (Buy) obj;
		return idNum == other.idNum;
	}

	@Override
	public String toString() {
		return "[" + idNum + "|" + userID + "\t|" + prodName + "\t|" + groupName
				+ "\t|" + price + "\t|" + amount + "]";
	}
	
	
}

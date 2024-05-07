package kh.edu.studentmanagement;

import java.util.Date;

public class Student {
	private int num;
	private String stu_num;
	private String stu_name;
	private String stu_id;
	private String stu_pw;
	private String stu_bd;
	private String stu_phone;
	private String stu_addr;
	private String stu_email;
	private Date stu_date;
	
	public Student() {
		super();
	}

	public Student(int num, String stu_num, String stu_name, String stu_id, String stu_pw, String stu_bd,
			String stu_phone, String stu_addr, String stu_email, Date stu_date) {
		super();
		this.num = num;
		this.stu_num = stu_num;
		this.stu_name = stu_name;
		this.stu_id = stu_id;
		this.stu_pw = stu_pw;
		this.stu_bd = stu_bd;
		this.stu_phone = stu_phone;
		this.stu_addr = stu_addr;
		this.stu_email = stu_email;
		this.stu_date = stu_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_pw() {
		return stu_pw;
	}

	public void setStu_pw(String stu_pw) {
		this.stu_pw = stu_pw;
	}

	public String getStu_bd() {
		return stu_bd;
	}

	public void setStu_bd(String stu_bd) {
		this.stu_bd = stu_bd;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public String getStu_addr() {
		return stu_addr;
	}

	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}

	public String getStu_email() {
		return stu_email;
	}

	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}

	public Date getStu_date() {
		return stu_date;
	}

	public void setStu_date(Date stu_date) {
		this.stu_date = stu_date;
	}

	@Override
	public String toString() {
		return "[" + num + "\t|" + stu_num + "\t|" + stu_name + "\t|" + stu_id
				+ "\t|" + stu_pw + "\t|" + stu_bd + "\t|" + stu_phone + "\t|" + stu_addr
				+ "\t|" + stu_email + "\t|" + stu_date + "]";
	}
}

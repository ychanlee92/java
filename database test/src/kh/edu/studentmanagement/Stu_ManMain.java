package kh.edu.studentmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Stu_ManMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		System.out.println("");
		System.out.println("");
		System.out.println("                   Welcome to KH352 자바 프로그램!!");
		System.out.println("");
		System.out.println("");
		System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
		boolean loginFlag = false;
		boolean flag = false;
		Student student = new Student();
		while (!loginFlag) {
			// 로그인
			Connection login = SQLStu_ManConnect.loginConnection();
			if (login != null) {
				while (!flag) {
					// 메뉴
					String menu = menu();
					switch (menu) {
					case "1":
						// 전체 학생 조회
						selectAllStudent();
						break;
					case "2":
						// 신규 학생 등록
						student = inputNewStudent();
						insertStudent(student);
						break;
					case "3":
						// 학생 정보 조회
						searchStudent();
						break;
					case "4":
						// 학생 정보 수정
						updateStudent();
						break;
					case "5":
						// 학생 정보 삭제
						deleteStudent();
						break;
					case "6":
						// 종료
						System.out.println("the end");
						flag = true;
						loginFlag = true;
						break;
					default:
						System.out.println("잘못 입력했습니다. ");
						break;
					}
				}
			}
		}
	}

	// 학생 정보 삭제하기
	public static void deleteStudent() throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = new Student();
		try {
			con = SQLStu_ManConnect.makeConnection();
			String sql = "select * from stu_man";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String stu_num = rs.getString("stu_num");
				String stu_name = rs.getString("stu_name");
				String stu_id = rs.getString("stu_id");
				String stu_pw = rs.getString("stu_pw");
				String stu_bd = rs.getString("stu_bd");
				String stu_phone = rs.getString("stu_phone");
				String stu_addr = rs.getString("stu_addr");
				String stu_email = rs.getString("stu_email");
				Date stu_date = rs.getDate("stu_date");
				student = new Student(num, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr, stu_email,
						stu_date);
				System.out.println(student.toString());
			}
			System.out.print("삭제할 학번을 입력하세요: ");
			int number = sc.nextInt();
			sql = "delete from stu_man where stu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 학생 정보 수정하기
	private static void updateStudent() throws ParseException, FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = new Student();
		try {
			con = SQLStu_ManConnect.makeConnection();
			String sql = "select * from stu_man";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String stu_num = rs.getString("stu_num");
				String stu_name = rs.getString("stu_name");
				String stu_id = rs.getString("stu_id");
				String stu_pw = rs.getString("stu_pw");
				String stu_bd = rs.getString("stu_bd");
				String stu_phone = rs.getString("stu_phone");
				String stu_addr = rs.getString("stu_addr");
				String stu_email = rs.getString("stu_email");
				Date stu_date = rs.getDate("stu_date");
				student = new Student(num, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr, stu_email,
						stu_date);
				System.out.println(student.toString());
			}
			System.out.print("수정할 학생의 번호를 입력하세요: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("수정할 학번을 입력하세요: ");
			String stu_num = sc.nextLine();
			System.out.print("수정할 이름을 입력하세요: ");
			String stu_name = sc.nextLine();
			System.out.print("수정할 ID를 입력하세요: ");
			String stu_id = sc.nextLine();
			System.out.print("수정할 비밀번호를 입력하세요: ");
			String stu_pw = sc.nextLine();
			System.out.print("수정할 생일을 입력하세요: ");
			String stu_bd = sc.nextLine();
			System.out.print("수정할 전화번호를 입력하세요: ");
			String stu_phone = sc.nextLine();
			System.out.print("수정할 주소를 입력하세요: ");
			String stu_addr = sc.nextLine();
			System.out.print("수정할 이메일을 입력하세요: ");
			String stu_email = sc.nextLine();
			System.out.print("수정할 입학날짜를 입력하세요: ");
			String date = sc.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			Date stringToDate = dateFormat.parse(date);
			Timestamp stu_date = new Timestamp(stringToDate.getTime());
			student = new Student(0, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr, stu_email,
					stu_date);
			sql = "update stu_man set stu_num = ?, stu_name = ?, stu_id = ?, stu_pw = ?, stu_bd = ?, stu_phone = ?, stu_addr = ?, stu_email = ?, stu_date = to_date(?) where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStu_num());
			pstmt.setString(2, student.getStu_name());
			pstmt.setString(3, student.getStu_id());
			pstmt.setString(4, student.getStu_pw());
			pstmt.setString(5, student.getStu_bd());
			pstmt.setString(6, student.getStu_phone());
			pstmt.setString(7, student.getStu_addr());
			pstmt.setString(8, student.getStu_email());
			pstmt.setString(9, date);
			pstmt.setInt(10, number);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(student.getStu_name() + "정보가 수정되었습니다.");
			} else {
				System.out.println("정보 입력 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 학생 정보 조회
	public static void searchStudent() {
		System.out.print("검색할 학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = SQLStu_ManConnect.makeConnection();
			String sql = "select * from stu_man where stu_name= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next() == false) {
				System.out.println("조회 되지않았습니다.");
				return;
			}
			while (rs.next()) {
				int num = rs.getInt("num");
				String stu_num = rs.getString("stu_num");
				String stu_name = rs.getString("stu_name");
				String stu_id = rs.getString("stu_id");
				String stu_pw = rs.getString("stu_pw");
				String stu_bd = rs.getString("stu_bd");
				String stu_phone = rs.getString("stu_phone");
				String stu_addr = rs.getString("stu_addr");
				String stu_email = rs.getString("stu_email");
				Date stu_date = rs.getDate("stu_date");
				Student student = new Student(num, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr,
						stu_email, stu_date);
				System.out.println(student.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 학생 정보 데이터베이스에 입력
	public static void insertStudent(Student student) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdFormat.format(student.getStu_date());
			con = SQLStu_ManConnect.makeConnection();
			String sql = "insert into stu_man values (num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStu_num());
			pstmt.setString(2, student.getStu_name());
			pstmt.setString(3, student.getStu_id());
			pstmt.setString(4, student.getStu_pw());
			pstmt.setString(5, student.getStu_bd());
			pstmt.setString(6, student.getStu_phone());
			pstmt.setString(7, student.getStu_addr());
			pstmt.setString(8, student.getStu_email());
			pstmt.setString(9, str);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(student.getStu_name() + "정보가 입력되었습니다.");
			} else {
				System.out.println("책 정보 입력 실패했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 학생 정보 입력
	private static Student inputNewStudent() throws ParseException {
		System.out.print("학번을 입력하세요: ");
		String stu_num = sc.nextLine();
		System.out.print("학생 이름을 입력하세요: ");
		String stu_name = sc.nextLine();
		System.out.print("ID를 입력하세요: ");
		String stu_id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요: ");
		String stu_pw = sc.nextLine();
		System.out.print("생일을 입력하세요: ");
		String stu_bd = sc.nextLine();
		System.out.print("전화번호를 입력하세요: ");
		String stu_phone = sc.nextLine();
		System.out.print("주소를 입력하세요: ");
		String stu_addr = sc.nextLine();
		System.out.print("이메일을 입력하세요: ");
		String stu_email = sc.nextLine();
		System.out.print("입학 날짜를 입력하세요: ");
		String date = sc.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		Date stringToDate = dateFormat.parse(date);
		Timestamp stu_date = new Timestamp(stringToDate.getTime());
		Student student = new Student(0, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr, stu_email,
				stu_date);
		return student;
	}

	// 전체 학생 조회
	public static void selectAllStudent() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = SQLStu_ManConnect.makeConnection();
			String sql = "select * from stu_man";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String stu_num = rs.getString("stu_num");
				String stu_name = rs.getString("stu_name");
				String stu_id = rs.getString("stu_id");
				String stu_pw = rs.getString("stu_pw");
				String stu_bd = rs.getString("stu_bd");
				String stu_phone = rs.getString("stu_phone");
				String stu_addr = rs.getString("stu_addr");
				String stu_email = rs.getString("stu_email");
				Date stu_date = rs.getDate("stu_date");
				Student student = new Student(num, stu_num, stu_name, stu_id, stu_pw, stu_bd, stu_phone, stu_addr,
						stu_email, stu_date);
				System.out.println(student.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 메뉴 출력
	public static String menu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 전체 학생 조회하기");
		System.out.println("2. 신규 학생 등록하기");
		System.out.println("3. 학생 정보 조회하기");
		System.out.println("4. 학생 정보 수정하기");
		System.out.println("5. 학생 정보 삭제하기");
		System.out.print("6. 종료   ");
		String menu = sc.nextLine();
		return menu;
	}
}

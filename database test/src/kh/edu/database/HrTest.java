package kh.edu.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class HrTest {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectDatabase.makeConnection();
		// sql문 작성 > 실행 > 결과 result set 가져오기
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees");
		ArrayList<Employee> employee = new ArrayList<Employee>();
		// 변수 선언
		int employeeId;
		String firstName;
		String lastName;
		String email;
		String phoneNumber;
		Date hireDate;
		String jobId;
		double salary;
		double commissionPct;
		int managerId;
		int departmentId;
		// rs.next를 하면 커서가 한칸 내려간다.
		while (rs.next()) {
			employeeId = rs.getInt("EMPLOYEE_ID");
			firstName = rs.getString("FIRST_NAME");
			lastName = rs.getString("LAST_NAME");
			email = rs.getString("EMAIL");
			phoneNumber = rs.getString("PHONE_NUMBER");
			hireDate = rs.getDate("HIRE_DATE");
			jobId = rs.getString("JOB_ID");
			salary = rs.getDouble("SALARY");
			commissionPct = rs.getDouble("COMMISSION_PCT");
			managerId = rs.getInt("MANAGER_ID");
			departmentId = rs.getInt("DEPARTMENT_ID");
			Employee emp = new Employee(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary,
					commissionPct, managerId, departmentId);
			employee.add(emp);
		}
		employeePrint(employee);
	}

	private static void employeePrint(ArrayList<Employee> employee) {
		for (Employee data : employee) {
			System.out.println(data.toString());
		}
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class Callable {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false", "root", "hoilamgi123");
			callableStatement = (CallableStatement) connection.prepareCall("{CALL Bai4(? , ?, ? )}");
			int emp_no = 10049;
			String dept_no = "d005";
			String title = "Assistant Engineer";
			callableStatement.setInt(1, emp_no);
			callableStatement.setString(2, dept_no);
			callableStatement.setString(3, title);

			rs = callableStatement.executeQuery();
			System.out.println("emp_no" + "\t" + "Fullname" + "\t" + "gender" + "\t" + "title" + "\t\t" + "dept_name");
			while (rs.next()) {
				System.out.println(rs.getInt("emp_no") + "\t" + rs.getString("Fullname") + "\t" + rs.getString("gender")
						+ "\t" + rs.getString("title") + "\t" + rs.getString("dept_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
			callableStatement.close();
			rs.close();
		}
	}

}

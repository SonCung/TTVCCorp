package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Prepared {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false", "root", "hoilamgi123");
			preparedStatement = (PreparedStatement) connection.prepareStatement("{CALL Bai4(? , ?, ? )}");

			int emp_no = 10051;
			String dept_no = "d006";
			String title = "Engineer";
			preparedStatement.setInt(1, emp_no);
			preparedStatement.setString(2, dept_no);
			preparedStatement.setString(3, title);

			rs = preparedStatement.executeQuery();
			System.out.println("emp_no" + "\t" + "Fullname" + "\t" + "gender" + "\t" + "title" + "\t\t" + "dept_name");
			while (rs.next()) {
				System.out.println(rs.getInt("emp_no") + "\t" + rs.getString("Fullname") + "\t" + rs.getString("gender")
						+ "\t" + rs.getString("title") + "\t" + rs.getString("dept_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				if( connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(preparedStatement!= null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			
			
		}

	}

}

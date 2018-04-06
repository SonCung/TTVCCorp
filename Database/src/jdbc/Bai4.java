package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class Bai4 {
	public static void createConnection() throws SQLException {
		Connection conn= null;
		PreparedStatement pstmt= null;
		//ResultSet rs = null ;
		String query = "{CALL Bai4(? , ?, ? )}";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false", "root", "hoilamgi123");
			pstmt = conn.prepareStatement(query);
			
			int emp_no = 10045;
			String dept_no = "d003";
			String title = "Staff";
			pstmt.setInt(1, emp_no);
			pstmt.setString(2, dept_no);
			pstmt.setString(3, title);
			
			pstmt.execute();
			/*while (rs.next()) {
				System.out.println(String.format("%d - %s - %s - %s - %s", rs.getInt("emp_no"), rs.getString("first_name")+rs.getString("last_name") , rs.getString("gender") ,
						rs.getString("title"), rs.getString("dept_name")));
			}*/
			System.out.println("Database connections");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//rs.close();
			conn.close();
			pstmt.close();
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		createConnection();
	}

}

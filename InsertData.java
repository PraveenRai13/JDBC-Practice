package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			//Create a query
			String q = "insert into table1(tname,tcity) values (?,?)";
			// get the preparedStatement object
					PreparedStatement psmt=con.prepareStatement(q);
					psmt.setString(1, "Praveen Rai");
					psmt.setString(2, "Mumbai");
					psmt.executeUpdate();
					System.out.println("Data Inserted");
					con.close();
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

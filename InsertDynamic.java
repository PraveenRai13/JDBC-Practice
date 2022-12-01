package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDynamic {

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
					// scanner for take dynamic data from console
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter Name: ");
					String name = sc.next();
					System.out.println("Enter City: ");
					String city = sc.next();
					psmt.setString(1, name);
					psmt.setString(2, city);
					psmt.executeUpdate();
					System.out.println("Data inserted");
					con.close();		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

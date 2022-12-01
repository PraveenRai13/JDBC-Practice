package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			//Create a query
			String q = "create table table1(tid int(20) primary key auto_increment , "
					+ "tname varchar(25) not null, tcity varchar(25))";
			//Create statement 
			Statement stmt=con.createStatement();
			stmt.executeUpdate(q);
			System.out.println("table is created..");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 

}

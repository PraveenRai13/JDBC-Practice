package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo01 {

	public static void main(String[] args) {
	try {
		// Create a connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
		if(con.isClosed()) {
			System.out.println("Connection is close");
		}else {
			System.out.println("Connection is started");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}	
	}

}

package mypackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ReadDataFromDataBase {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			String q = "select * from table1";
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(q);
			while(rst.next()) {
				int id = rst.getInt(1);
				String name = rst.getString(2);
				String city = rst.getString(3);
				System.out.println(id+" : "+name+" : "+city);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

package mypackage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UploadImage {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			String q = "insert into image(pic) values(?)";
			PreparedStatement pstmt= con.prepareStatement(q);
			//file details
			FileInputStream fis = new FileInputStream("D:/Practice01/JDBC/src/MyPic.jpg");
			pstmt.setBinaryStream(1, fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("Data inserted");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

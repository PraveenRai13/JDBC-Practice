package mypackage;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InsertLargeImage {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			String q = "insert into image(pic) values(?)";
			PreparedStatement pstmt= con.prepareStatement(q);
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			File file = jfc.getSelectedFile();
			FileInputStream fis = new FileInputStream(file);
			pstmt.setBinaryStream(1, fis,fis.available());
			pstmt.executeUpdate();
			//System.out.println("Data inserted");
			JOptionPane.showMessageDialog(null, "Success");
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

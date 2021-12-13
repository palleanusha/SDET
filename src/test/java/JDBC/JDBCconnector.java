package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCconnector {
public static void main(String[] args) throws SQLException {
	
	Driver dr=new Driver();
	DriverManager.registerDriver(dr);
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	Statement stat = conn.createStatement();
	 ResultSet rs = stat.executeQuery("select * from employee;");
	 while(rs.next())
	 {
		 System.out.println(rs.getString(2));
	 }
}
	
}

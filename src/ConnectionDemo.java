import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.*;
import java.sql.*;

public class ConnectionDemo {

	
public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		String userName="root";
		String password="Welcome123";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Diagnostic_DB",userName,password);
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from patient");  

		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDate(5));
		}
		
		con.close();
		
	}
	
}

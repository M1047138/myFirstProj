package connectionEstablish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hospitalService.InvalidEmailException;
import hospitalService.MyException;

public class ConnectionOne {

	Connection con;
	public ConnectionOne() throws InvalidEmailException, MyException {
		
		String userName="root";
		String password="Welcome123" ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Diagnostic_DB",userName,password);
		}
		catch (ClassNotFoundException e) {
			throw new InvalidEmailException("Error class not there");
			
		}
		catch(SQLException ex)
		{
			throw new MyException("Error with connectivity");
		}
	}
	
	public Connection sendConnection() {
		return con;
		
	}
	
	public void closeConnection() throws SQLException {
		try {
			
		} finally {
			con.close();
		}
	}

	
}

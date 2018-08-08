package hospitalDao;

import java.sql.SQLException;
import java.util.ArrayList;

import hospitalService.InvalidEmailException;
import hospitalService.MyException;

public interface InterfaceDao {

	
	public void testDetailsByEmail(String email,String testName) throws SQLException;
	public void testDetailsByPhone(String phone,String testName) throws SQLException;
	public ArrayList<Report> report(String receive, String testDate,String status) throws SQLException, MyException;
	
	
}

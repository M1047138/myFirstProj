package hospitalDao;

import hospitalEntity.Test;
import hospitalService.InvalidEmailException;
import hospitalService.MyException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connectionEstablish.ConnectionOne;



public class DatabaseConn implements InterfaceDao{

	
	Connection con;
//	public DatabaseConn()
//	{
//		String userName="root";
//		String password="Welcome123";
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Diagnostic_DB",userName,password);
//		} catch (ClassNotFoundException e) {
//			//throw new InvalidEmailException("Error class not there");
//		}
//		catch(SQLException ex)
//		{
//			//throw new InvalidEmailException("Error with connectivity");
//		}
//	}
	
	public DatabaseConn() throws MyException {
		ConnectionOne obj;
		try {
			obj = new ConnectionOne();
			con=obj.sendConnection();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void testDetailsByEmail(String email,String testName)throws SQLException
	{
		//PID as per email
		
		PreparedStatement getPatientQuery = con.prepareStatement("Select pid from patient where email=?");
		getPatientQuery.setString(1, email);
		
		ResultSet emailResultSet = getPatientQuery.executeQuery();
		int pid=-1;
		if(emailResultSet.next())
		{
			pid = emailResultSet.getInt(1);
		}
		emailResultSet.close();
		getPatientQuery.close();
		//Get TID
		PreparedStatement getTIDQuery = con.prepareStatement("Select tid from test where name=?");
		getTIDQuery.setString(1, testName);
		int tid=-1;
		ResultSet tidResultSet = getTIDQuery.executeQuery();
		if(tidResultSet.next())
		{
			tid = tidResultSet.getInt(1);
		}
		getTIDQuery.close();
		
		if(pid>0 && tid>0)
		{
			
			//setting current date
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			//prepared statement call
			PreparedStatement insertPatientDetails=con.prepareStatement("insert into patient_test values(?,?,?)");
			insertPatientDetails.setInt(1, pid);
			insertPatientDetails.setInt(2, tid);
			insertPatientDetails.setString(3, strDate);
			insertPatientDetails.executeUpdate();
			insertPatientDetails.close();
		}
		else
		{
			System.out.println("Invalid data");
		}
		
	}
	
	public void testDetailsByPhone(String phone,String testName)throws SQLException
	{
		//PID as per email
		
		
		PreparedStatement getPatientQuery = con.prepareStatement("Select pid from patient where phone=?");
		getPatientQuery.setString(1, phone);
		
		ResultSet phoneResultSet = getPatientQuery.executeQuery();
		int pid=-1;
		if(phoneResultSet.next())
		{
			pid = phoneResultSet.getInt(1);
		}
		phoneResultSet.close();
		getPatientQuery.close();
		//System.out.println(pid);
		//Get TID
		PreparedStatement getTIDQuery = con.prepareStatement("Select tid from test where name=?");
		getTIDQuery.setString(1, testName);
		int tid=-1;
		ResultSet tidResultSet = getTIDQuery.executeQuery();
		if(tidResultSet.next())
		{
			tid = tidResultSet.getInt(1);
		}
		getTIDQuery.close();
		if(pid>0 && tid>0)
		{
			
			//setting current date
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = formatter.format(date);
			//prepared statement call
			PreparedStatement insertPatientDetails=con.prepareStatement("insert into patient_test values(?,?,?)");
			insertPatientDetails.setInt(1, pid);
			insertPatientDetails.setInt(2, tid);
			insertPatientDetails.setString(3, strDate);
			insertPatientDetails.executeUpdate();
		}
		else
		{
			System.out.println("Invalid data");
		}
	}

	public ArrayList<Report> report(String receive, String testDate,String status) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Test t=new Test();
		
		PreparedStatement getRep=null;
		if(status.equals("e")){
			getRep = con.prepareStatement("select p.name , p.email, p.phone , pt.pat_date , t.name ,t.cost from patient p inner join patient_test pt inner join test t on p.pid=pt.pid and t.tid=pt.tid and p.email=? and pt.pat_date=? order by t.name");
			
		}
		else if(status.equals("p"))
		{
			getRep = con.prepareStatement("select p.name , p.email, p.phone , pt.pat_date , t.name,t.cost from patient p inner join patient_test pt inner join test t on p.pid=pt.pid and t.tid=pt.tid and p.phone=? and pt.pat_date=? order by t.name");
		}
		getRep.setString(1,receive);
		getRep.setString(2, testDate.trim());
		ResultSet rSet=getRep.executeQuery();
		ArrayList< Report> reportList=new ArrayList<Report>();
		while(rSet.next()){
			Report obj = new Report();
			obj.setPatientName(rSet.getString(1));
			obj.setPatientEmail(rSet.getString(2));
			obj.setPatientPhone(rSet.getString(3));
			obj.setDate(rSet.getString(4));
			obj.setTestName(rSet.getString(5));
			obj.setTestCost(rSet.getString(6));
			reportList.add(obj);
		//System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3)+" "+rSet.getString(4)+" "+rSet.getString(5));
		}
		//con.close();
		ConnectionOne obj;
		try {
			obj = new ConnectionOne();
			obj.closeConnection();
		} catch (InvalidEmailException | MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getRep.close();
		rSet.close();
		return reportList;
		
		
	}
	
	
	
	
}

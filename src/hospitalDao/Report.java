package hospitalDao;

public class Report {

	private String patientName;
	private String patientEmail;
	private String patientPhone;
	private String testName;
	private String testCost;
	private String date;
	//private static String totalCost;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestCost() {
		return testCost;
	}
	public void setTestCost(String testCost) {
		this.testCost = testCost;
	}
	
	
	
	
}

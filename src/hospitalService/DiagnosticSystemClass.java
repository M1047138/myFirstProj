package hospitalService;

public class DiagnosticSystemClass implements InterfaceService{

	public void testDetails() throws InvalidEmailException, InvalidPhoneException {
		// TODO Auto-generated method stub
		FunctionClass fn=new FunctionClass();
		try{
		
			try {
				fn.testDetails();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		catch(InvalidEmailException e){
			System.out.println("Invalid email");
		}
		catch(InvalidPhoneException e) {
			System.out.println("Invalid phone");
		}
		
		
	}

	public void generateReport() throws InvalidEmailException, InvalidPhoneException {
		// TODO Auto-generated method stub
		try {
		FunctionClass fn=new FunctionClass();
		try {
			fn.generateReport();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(InvalidEmailException e){
			System.out.println("Invalid email");
		}
		catch(IndexOutOfBoundsException ee) {
			System.out.println("Invalid data");
		}
		
	}

	
	
}

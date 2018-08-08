package hospitalClient;

import java.util.InputMismatchException;
import java.util.Scanner;

import hospitalService.DiagnosticSystemClass;
import hospitalService.InvalidEmailException;
import hospitalService.InvalidPhoneException;
public class MainCaller {

public static void main(String [] args) throws InvalidPhoneException, InvalidEmailException{
//		DiagnosticSystemClass ds=new DiagnosticSystemClass();
//		//FunctionClass fun=new FunctionClass();
//		try {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("=============DIAGNOSTIC CENTRE=============");
//		System.out.println("1.Add diagnostic tests");
//		System.out.println("2.Generate Report");
//		System.out.println("3.EXIT");
//		int choice = 0;
//		
//		System.out.println("Enter your choice:");
//		choice=sc.nextInt();
//		
//		do {
//			switch(choice){
//				case 1:
//					ds.testDetails();
//					break;
//				case 2:
//					ds.generateReport();
//					break;
//				case 3:
//					System.exit(0);
//					break;
//			}
//			System.out.println("=============DIAGNOSTIC CENTRE=============");
//			System.out.println("1.Add diagnostic tests");
//			System.out.println("2.Generate Report");
//			System.out.println("3.EXIT");
//			System.out.println("Enter your choice:");
//			choice=sc.nextInt();
//			
//		}while(choice != 4);
//	}
//		catch(InputMismatchException e) {
//			System.out.println("InputMismatch");
//			continue outer;
//		}
	
	MainCaller obj=new MainCaller();
	obj.functionCall();
}


	public void functionCall() throws InvalidPhoneException, InvalidEmailException{
		MainCaller obj=new MainCaller();
		DiagnosticSystemClass ds=new DiagnosticSystemClass();
		//FunctionClass fun=new FunctionClass();
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("=============DIAGNOSTIC CENTRE=============");
		System.out.println("1.Add diagnostic tests");
		System.out.println("2.Generate Report");
		System.out.println("3.EXIT");
		int choice = 0;
		
		System.out.println("Enter your choice:");
		choice=sc.nextInt();
		
		do {
			switch(choice){
				case 1:
					ds.testDetails();
					break;
				case 2:
					ds.generateReport();
					break;
				case 3:
					System.exit(0);
					break;
			}
			System.out.println("=============DIAGNOSTIC CENTRE=============");
			System.out.println("1.Add diagnostic tests");
			System.out.println("2.Generate Report");
			System.out.println("3.EXIT");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
		}while(choice != 4);
	}
		catch(InputMismatchException e) {
			System.out.println("InputMismatch");
			obj.functionCall();
		}
	}
}

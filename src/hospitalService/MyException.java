package hospitalService;

public class MyException extends Exception{

	public MyException(String str) {
		//super(str);
		System.out.println(str);
		System.exit(0);
	}
}

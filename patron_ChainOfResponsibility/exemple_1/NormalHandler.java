package exemple_1;

public class NormalHandler extends Handler {
	
	@Override
	public void handleRequest(Mail mail) {
		System.out.println("This e-mail is normal.\t\t\t\t SEND TO CUSTOMER SERVICE.");
	}
}

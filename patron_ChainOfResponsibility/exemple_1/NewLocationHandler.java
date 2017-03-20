package exemple_1;

public class NewLocationHandler extends Handler {
	
	@Override
	public void handleRequest(Mail mail) {
		if (mail.getSubject().toLowerCase().contains("location"))
			System.out.println("This e-mail is a request for a new location.\t FORWARD TO BUSINESS DEVL.");
		else
			successor.handleRequest(mail);
	}
}

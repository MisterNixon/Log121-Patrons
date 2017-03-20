package exemple_1;

public class ComplaintHandler extends Handler {
	
	@Override
	public void handleRequest(Mail mail) {
		if (mail.getSubject().toLowerCase().contains("complaint"))
			System.out.println("This e-mail is a complaint.\t\t\t FORWARD TO LEGAL DEPT.");
		else
			successor.handleRequest(mail);
	}
}


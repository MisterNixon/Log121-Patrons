package exemple_1;

public class FanHandler extends Handler {
    public static final String[] FANS = {
    		"un.ami@hotmail.ca",
    		"un.tres.bon.ami@yahoo.com",
    		"je.vous.adore@gmail.com" };
	
	@Override
	public void handleRequest(Mail mail) {
		if (match(mail.getFrom()))
			System.out.println("This e-mail is from a fan.\t\t\t FORWARD TO CEO.");
		else
			successor.handleRequest(mail);
	}
	
	private boolean match(String m) {
		for (String s : FANS)
			if (m.toLowerCase().contains(s.toLowerCase()))
				return true;
		return false;
	}
}


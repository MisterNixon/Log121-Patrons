package exemple_1;

public class SpamHandler extends Handler {
	public static final int MAX_TO = 3;
	public static final int MAX_CC = 20;
    public static final String[] EXCLURE = {
    		"viagra",
    		"financing available",
    		"oil change",
    		"discount",
    		"mortgage" };
	
	@Override
	public void handleRequest(Mail mail) {
		if (match(mail.getSubject()) || mail.getCcSize() > 100)
			System.out.println("This e-mail is a spam.\t\t\t\t DELETED.");
		else
			successor.handleRequest(mail);
	}
	
	private boolean match(String m) {
		for (String s : EXCLURE)
			if (m.toLowerCase().contains(s.toLowerCase()))
				return true;
		return false;
	}
}

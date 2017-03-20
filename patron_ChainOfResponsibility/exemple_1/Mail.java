package exemple_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Mail {
	private String from;
	private List<String> to = new ArrayList<String>();
	private List<String> cc = new ArrayList<String>();
	private String subject;
	private String text;
	
	public Mail(String from, String[] to, String[] cc, String subject, String text) {
		this.from = from;
		this.to = new ArrayList<String>(Arrays.asList(to));
		this.cc = new ArrayList<String>(Arrays.asList(cc));
		this.subject = subject;
		this.text = text;
	}
	
	public String getFrom() { return from; }
	public Iterator<String> getTo() { return to.iterator(); }
	public Iterator<String> getCc() { return cc.iterator(); }
	public String getSubject() { return subject; }
	public String getText() { return text; }
	public int getToSize() { return to.size(); }
	public int getCcSize() { return cc.size(); }
}

package exemple_1;

public abstract class Handler{
	
	Handler successor;
	
	public void setProchain(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(Mail mail);
}

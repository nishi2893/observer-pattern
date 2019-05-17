//author: Nishigandha

public interface Subject {

	//methods to register and unregister observers or subscribers
	public void register(Observer ob);
	public void unregister(Observer ob);
	
	//method to notify
	
	public void notifyObservers();
	
	
}

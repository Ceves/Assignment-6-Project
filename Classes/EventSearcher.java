package Classes;

import java.util.ArrayList;

public class EventSearcher {
	
	public static final int MAX_LENGTH = 30;
	private EventFileReader m_reader;
	
	public EventSearcher() {
		m_reader = new EventFileReader();
		m_reader.load("EVENTS.csv");
		System.out.println(m_reader.getEventArray().size());
	}
	

	
	/*public ArrayList<Contact> FindByName(String name) throws Exception {
		if (name.length() > MAX_LENGTH) {
			throw new Exception("Error: The search criteria" +
					" must be less than or equal to "
					  +MAX_LENGTH+" characters!");
		}
		EventFileReader reader = new EventFileReader();
		reader.load(m_fileLocation)
		return ArrayList<Contact>;
	}*/
	
	public static void main(String[] args) {
		EventSearcher search = new EventSearcher();
		
	}

}

package Classes;

import java.util.ArrayList;
import java.lang.*;

public class EventSearcher {
	
	public static final int MAX_LENGTH = 30;
	private EventFileReader m_reader;
	private ArrayList<Event> m_eventArray;
	
	public EventSearcher() {
		m_reader = new EventFileReader();
		m_eventArray = new ArrayList<Event>();
		m_eventArray = m_reader.load("EVENTS.csv");
	}
	
	public ArrayList<Event> FindByName(String name) throws Exception {
		ArrayList<Event> events = new ArrayList<Event>();
		
		if (name.length() > MAX_LENGTH) {
			throw new Exception("Error: The search criteria" +
					" must be less than or equal to "
					  +MAX_LENGTH+" characters!");
		}
		
		for(int i=0;i<m_eventArray.size();i++) {
			String title = m_eventArray.get(i).GetTitle();
			if(title.toLowerCase().indexOf(name.toLowerCase())>=0) {
				events.add(m_eventArray.get(i));
			}
		}
		return events;
	}
	
	public static void main(String[] args) {
		EventSearcher search = new EventSearcher();
		ArrayList<Event> result = new ArrayList<Event>();
		try {
			result = search.FindByName("");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("The results are: \n");
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i).GetDescription());
		}
	}

}

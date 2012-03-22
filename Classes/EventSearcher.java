package Classes;

import java.util.ArrayList;

/**
 * @file EventSearcher.java
 * @author Adam Barrell
 * 
 * @brief This class finds and returns events that match a search criteria of
 *        type String.
 * 
 *        EventSearcher contains methods which allow searches to be performed on
 *        a collection of Event objects and return a collection of events that
 *        meet a specified criteria.
 */
public class EventSearcher extends Searcher {

	private EventFileReader m_reader;
	private ArrayList<Event> m_eventArray;

	/**
	 * The default constructor initialises the global variables and loads the
	 * EVENTS.csv file into an array list.
	 */
	public EventSearcher() {
		m_reader = new EventFileReader();
		m_eventArray = new ArrayList<Event>();
		m_eventArray = m_reader.load("EVENTS.csv");
	}

	/**
	 * The FindByName method takes a String which will be matched to a
	 * substrings of existing Events held in the collection array. If an
	 * existing event's title is matched to the name parameter, that event is
	 * added to an array list. A collection of events which contain the
	 * substring are returned on completion.
	 * 
	 * @param name
	 *            Title to match to existing events.
	 * @return An array list of matching existing events.
	 * @throws Exception
	 *             Exception thrown if parameter is overloaded.
	 */
	public ArrayList<Event> FindByName(String name) throws Exception {
		ArrayList<Event> events = new ArrayList<Event>();
		name = name.toLowerCase();

		if (name.length() > MAX_LENGTH) {
			throw new Exception("Error: The search criteria"
					+ " must be less than or equal to " + MAX_LENGTH
					+ " characters!");
		}

		for (int i = 0; i < m_eventArray.size(); i++) {
			String title = m_eventArray.get(i).GetTitle().toLowerCase();

			if (title.indexOf(name) >= MATCH_ANYWHERE) {
				events.add(m_eventArray.get(i));
			}
		}
		return events;
	}

	public static void main(String[] args) {
		EventSearcher search = new EventSearcher();
		ArrayList<Event> result = new ArrayList<Event>();

		/* Testing FindByName method */

		// Test overloading the String parameter
		try {
			result = search.FindByName("iiiiiiiiiiiiiiiiii"
					+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			System.out.println("Fail: Parameter too long!");
		} catch (Exception e) {
			System.out.println("Pass: " + e.getMessage());
		}

		// Test regular String input
		try {
			result = search.FindByName("");
			System.out.println("Pass: Method returned successfully");
		} catch (Exception e) {
			System.out.println("Fail: " + e.getMessage());
		}

		System.out.println("The results are: \n");
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).GetTitle());
		}
	}

}

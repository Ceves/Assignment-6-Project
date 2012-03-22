package Classes;

import java.util.ArrayList;

/**
 * @file ContactSearcher.java
 * @author Adam Barrell
 * 
 * @brief This class finds and returns contacts that match a search criteria of
 *        type String.
 * 
 *        ContactSearcher contains methods which allow searches to be performed
 *        on a collection of Contact objects and return a collection of contacts
 *        that meet a specified criteria.
 */
public class ContactSearcher extends Searcher<Contact> {

	ContactManager contacts;

	public ContactSearcher() {
		super();
		try {
			contacts = new ContactManager();
			m_dataArray = contacts.Load();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * The FindByFirstName method takes a String which will be matched to a
	 * substrings of existing contacts held in the collection array. If an
	 * existing contact's first name is matched to the name parameter, that
	 * contact is added to an array list. A collection of contacts which contain
	 * the substring are returned on completion.
	 * 
	 * @param name
	 *            First name to match to existing contacts.
	 * @return An array list of matching existing contacts.
	 * @throws Exception
	 *             Exception thrown if parameter is overloaded.
	 */
	public ArrayList<Contact> FindByFirstName(String name) throws Exception {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		name = name.toLowerCase();

		if (name.length() > MAX_LENGTH) {
			throw new Exception("Error: The search criteria"
					+ " must be less than or equal to " + MAX_LENGTH
					+ " characters!");
		}

		for (int i = 0; i < m_dataArray.size(); i++) {
			String firstName = m_dataArray.get(i).GetFirstName().toLowerCase();

			if (firstName.indexOf(name) >= MATCH_ANYWHERE) {
				contacts.add(m_dataArray.get(i));
			}
		}
		return contacts;
	}

	public static void main(String[] args) {

	}

}

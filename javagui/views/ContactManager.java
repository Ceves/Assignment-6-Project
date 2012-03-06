package javagui.views;
/**
 * The ContactManager class handles all of the administration involved with the Digital Address Book,
 * such as adding, deleting, editing contacts and reading them in from and writing them to csv files.
 * This class also makes use of the opencsv library which is freely available to use and modify under
 * the Apache 2.0 license.
 * 
 * @author Tim Morris
 * @date 24/02/12
 * 
 */
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.awt.event.*;

public class ContactManager{
	
	private ArrayList<Contact> m_contactList;
	private CSVReader m_contactReader;
	private BufferedWriter m_contactWriter;
	private int CSV_ELEMENTS;
	private final File CONTACTS_FILE;
	
	/**
	 * The ContactManager constructor initialises all of the class variables, while also checking
	 * for the existence of class files.  If they don't exist, then the constructor will create
	 * them.
	 * 
	 * @throws Exception
	 */
	public ContactManager() throws Exception{
		CSV_ELEMENTS = 9;
		CONTACTS_FILE = new File("CONTACTS.csv");
		
		//if the following files don't exist, create them
		if (!CONTACTS_FILE.exists()) {
			CONTACTS_FILE.createNewFile();
		}
		
		m_contactWriter = new BufferedWriter(new FileWriter(CONTACTS_FILE, true));
		m_contactReader = new CSVReader(new FileReader(CONTACTS_FILE));
		m_contactList = new ArrayList<Contact>();
		
	}
	
	/**
	 * The GetContact method takes a contact as a parameter and returns that contact from the main
	 * contactList ArrayList of the class.
	 * 
	 * @param contact The contact that the user wants to access
	 * @return specified contact
	 */
	public Contact GetContact(Contact contact) {
		//get the index of the contact, then use that index to return the contact
		return m_contactList.get(m_contactList.indexOf(contact));
	}
	
	/**
	 * The GetContactList method returns the contactList ArrayList of contacts.
	 * 
	 * @return m_contactList
	 */
	public ArrayList<Contact> GetContactList() {
		return m_contactList;
	}	
	
	/**
	 * The SetContactList method will take an ArrayList of Contacts as a parameter and set
	 * the ContactManager class's contactList array to the given parameter.
	 * 
	 * @param contactList the ArrayList of contacts that's used to set the main ArrayList
	 */
	public void SetContactList(ArrayList<Contact> contactList) {
		this.m_contactList = contactList;
	}	
	
	 /**
	  * The AddContact method will take as input the values of the variables to be set for the contact
	  * that's to be added.  It will then add that contact to the csv file through use of the StoreContact
	  * method.
	  * 
	  * @param firstName the first name of the contact
	  * @param surname the surname of the contact
	  * @param address the address of the contact
	  * @param postcode the postcode of the contact
	  * @param mobileNo the mobile number of the contact
	  * @param homeNo the home number of the contact
	  * @param email the email address of the contact
	  * @param faxNo the fax number of the contact
	  * @param website the website of the contact
	  */
	public void AddContact(String firstName, String surname, String address, String postcode,
			 String mobileNo, String homeNo, String email, String faxNo, String website) throws Exception {
		
		Contact contact = new Contact(firstName, surname, address, postcode, mobileNo, homeNo, email, faxNo, website);
		m_contactList.add(contact);
		store(contact);
		
		
	}
	
	/**
	 * The DeleteContact method removes the given Contact from the main ArrayList of contacts
	 * and will also remove that contact from the contacts csv file by deleting the file and
	 * re-making it with the current contact ArrayList. 
	 * 
	 * @param contact a variable of type Contact which is to be removed from the DAB
	 * @throws Exception
	 */
	public void DeleteContact(Contact contact) throws Exception {
		//remove the contact from the main ArrayList
		m_contactList.remove(contact);
		
		//make sure there are no streams open to interfere with 
		//the manipulating of files
		m_contactWriter.close();
		m_contactReader.close();
		
		//delete the old csv and create a new, blank one
		CONTACTS_FILE.delete();
		CONTACTS_FILE.createNewFile();
		
		//iterate through the ArrayList, adding each contact to the csv
		for (int i = 0;i<m_contactList.size();i++) {
			store(m_contactList.get(i));
		}
	}
	
	/**
	 * The Load method will take the current CONTACTS.csv file and read it into the program,
	 * creating each contact whilst adding them to the main contact ArrayList m_contactList.
	 * 
	 * This method should only be run at startup of the program.
	 * 
	 * @param fileLocation the location of the main contacts csv file to be read.
	 * @throws Exception
	 */
	public void Load(String fileLocation) throws Exception {
		/*
		 * A note to make here is that the csvreader method .readAll() reads each line of the csv file
		 * and stores each line as a String[] element in the list myEntries. 
		 */
		
		List myEntries = m_contactReader.readAll();
		//Here we begin to extract the information of each contact from the myEntries List. 
		//create an array to house the elements of each String[] for processing
		String[] contact = new String[CSV_ELEMENTS];
		//for every String[] in the list
		for (int i = 0;i < myEntries.size();i++) {
			//for every element of the current String[]
			for (int j = 0;j < Array.getLength(myEntries.get(i));j++) {
				//populate the array with the values
				contact[j] = (Array.get(myEntries.get(i), j)).toString();
			}
			//add that contact to the contactList
			m_contactList.add(new Contact(contact[0],contact[1],contact[2],contact[3],contact[4],contact[5],
					contact[6],contact[7],contact[8]));
		}
		
		m_contactReader.close();
		
	}
	
	/**
	 * The store method takes in a contact as a parameter and will then convert it into a csv String,
	 * which will then be appended onto the main contacts csv file.
	 * 
	 * @param contact a variable of type Contact to be added to the csv
	 * @throws Exception
	 */
	private void store(Contact contact) throws Exception {
		m_contactWriter = new BufferedWriter(new FileWriter(CONTACTS_FILE, true));
		//create a temporary array to store the values of the contact
		String[] entries = new String[CSV_ELEMENTS];
		//initialise a temporary String which is to hold the csv of the contact by the end
		//of the algorithm
		String entry = "";
		
		//assign the fields in order to each array index
        entries[0] = contact.GetFirstName();
        entries[1] = contact.GetSurname(); 
        entries[2] = contact.GetAddress();
        entries[3] = contact.GetPostcode();
   		entries[4] = contact.GetMobileNo();
		entries[5] = contact.GetHomeNo();
		entries[6] = contact.GetEmail();
		entries[7] = contact.GetFaxNo();
		entries[8] = contact.GetWebsite();
	    
		//iterate through each of the indices of the array, adding the value to the string
		//while adding a comma after each entry, as long as it's not the final entry 
		for (int i = 0;i < entries.length;i++) {
			entry += entries[i];
			
			//add commas between entries; not after the final entry
			if (i < entries.length-1) {
				entry += ",";
			}
		}
		
		//write the new entry to the csv file
		m_contactWriter.append(entry);
		m_contactWriter.newLine();
		
		//close the BufferedWriter
	    m_contactWriter.close();
	}
	
}
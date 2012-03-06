package javagui.views;
/**
 * The ContactPanel class is largely an attempt to keep the GUI code as neat and understandable as possible.
 * This class is a subclass of JPanel that sets up all of the necessary components for the mutable contact view.
 * The class doesn't have a default size and so must be specified when creating an instance.
 * 
 * @author Tim Morris
 * @date 24/02/12
 * 
 */

import javax.swing.*;

import java.awt.*;

public class ContactPanel extends JPanel{
	
	//these are the labels that will mark which piece of data that you
	//would expect after them such as "Name: ", "Address: " etc
	private JLabel m_nameLabel;
	private JLabel m_addressLabel;
	private JLabel m_postcodeLabel;
	private JLabel m_mobileNoLabel;
	private JLabel m_homeNoLabel;
	private JLabel m_emailLabel;
	private JLabel m_faxNoLabel;
	private JLabel m_websiteLabel;
	
	//these labels are the mutable labels that display the data.
	//they can be changed using the SetInfo public method
	private JLabel m_nameValue;
	private JLabel m_addressValue;
	private JLabel m_postcodeValue;
	private JLabel m_mobileNoValue;
	private JLabel m_homeNoValue;
	private JLabel m_emailValue;
	private JLabel m_faxNoValue;
	private JLabel m_websiteValue;
	
	//these variables will store the actual data from the contact
	private String m_firstName;
	private String m_surname;
	private String m_address;
	private String m_postcode;
 	private String m_mobileNo;
	private String m_homeNo;
	private String m_email;
	private String m_faxNo;
	private String m_website;
	
	//symbolic constants
	private final int NUM_ROWS;
	private final int NUM_COLUMNS;
	
	/**
	 * The ContactPanel constructor will simply construct the panel and will display the first contact
	 * that's read in as the default value.
	 * 
	 * @param contact a variable of type Contact that is used to display the default (top) value to the panel.
	 */
	public ContactPanel(Contact contact) {
		
		//initialise the labels
		m_nameLabel = new JLabel("Name:");
		m_addressLabel = new JLabel("Address:");
		m_postcodeLabel = new JLabel("Postcode:");
		m_mobileNoLabel = new JLabel("Mobile Number:");
		m_homeNoLabel = new JLabel("Home Number");
		m_emailLabel = new JLabel("Email Address");
		m_faxNoLabel = new JLabel("Fax Number");
		m_websiteLabel = new JLabel("Website");
		
		//initialise the values to be displayed
		m_nameValue = new JLabel(m_firstName + " " + m_surname);
		m_addressValue = new JLabel(m_address);
		m_postcodeValue = new JLabel(m_postcode);
		m_mobileNoValue = new JLabel(m_mobileNo);
		m_homeNoValue = new JLabel(m_homeNo);
		m_emailValue = new JLabel(m_email);
		m_faxNoValue = new JLabel(m_faxNo);
		m_websiteValue = new JLabel(m_website);
		
		//initialise the symbolic constants
		NUM_ROWS = 9;
		NUM_COLUMNS = 2;
		
		//sets the layout of the panel
		setLayout(new GridLayout(NUM_ROWS,NUM_COLUMNS));
		
		//add the labels to the panel
		add(m_nameLabel);
		add(m_nameValue);
		add(m_addressLabel);
		add(m_addressValue);
		add(m_postcodeLabel);
		add(m_postcodeValue);
		add(m_mobileNoLabel);
		add(m_mobileNoValue);
		add(m_homeNoLabel);
		add(m_homeNoValue);
		add(m_emailLabel);
		add(m_emailValue);
		add(m_faxNoLabel);
		add(m_faxNoValue);
		add(m_websiteLabel);
		add(m_websiteValue);
	}
	
	/**
	 * The SetInfo class takes in a Contact variable and will then set the class variables to the values of the
	 * given variable, and sets the 'value' labels to the new variable values.  It then repaints the panel, effectively
	 * displaying the new information.
	 * 
	 * @param contact a variable of type Contact from which the new data will be extracted and displayed
	 */
	public void SetInfo(Contact contact) {
		
		//set the new values from the given contact to the class variables
		m_firstName = contact.GetFirstName();
		m_surname = contact.GetSurname();
		m_address = contact.GetAddress();
		m_postcode = contact.GetPostcode();
		m_mobileNo = contact.GetMobileNo();
		m_homeNo = contact.GetHomeNo();
		m_email = contact.GetEmail();
		m_faxNo = contact.GetFaxNo();
		m_website = contact.GetWebsite();
		
		//set the text of the 'value' labels to the new values taken in 
		m_nameValue.setText(m_firstName + " " + m_surname);
		m_addressValue.setText(m_address);
		m_postcodeValue.setText(m_postcode);
		m_mobileNoValue.setText(m_mobileNo);
		m_homeNoValue.setText(m_homeNo);
		m_emailValue.setText(m_email);
		m_faxNoValue.setText(m_faxNo);
		m_websiteValue.setText(m_website);
		
		//repaint the panel so that the new information is displayed
		repaint();
	}

}

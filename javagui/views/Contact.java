package javagui.views;

/** 
 * @file Contact
 * @author Daniel Mallory (632628) & Adam Barrell (632975)
 * @date 26/02/2012
 * @brief This class creates an object to hold attributes on a contact.
 *  
 * This class defines the attributes which identify a contact, also provides
 * getter and setter methods to retrieve data on a contact. The ContactManager
 * class parses attributes from a contact object to a CSV file holding contacts.
 */
 
 public class Contact {
	public static final int MAX_STRING = 31; //Maximum characters
	public static final int PHONENUM_LENGTH = 11; //Phone number length
	
	private String m_firstName;
	private String m_surname;
	private String m_address;
	private String m_postcode;
	private String m_mobileNo;
	private String m_homeNo; //Defined as String so length can be validated
	private String m_email;
	private String m_faxNo;
	private String m_website;
	
	//Getter Methods
	
	/**
	 * Gets contact's first name.
	 * @return Returns contact's first name as a String.
	 */
	public String GetFirstName() {
		return m_firstName;
	}
	
	/** 
	 * Gets contact's surname.
	 * @return Returns contact's surname as a String.
	 */
	public String GetSurname() { return m_surname; }
	
	/** 
	 * Gets contact's address.
	 * @return Returns contact's address as a String.
	 */
	public String GetAddress() { return m_address; }
	
	/** 
	 * Gets contact's post code.
	 * @return Returns contact's post code as a String.
	 */
	public String GetPostcode() { return m_postcode; }
		
	/** 
	 * Gets contact's mobile number.
	 * @return Returns contact's mobile number as a String.
	 */
	public String GetMobileNo() { return m_mobileNo;	}
	
	/** 
	 * Gets contact's home phone number.
	 * @return Returns contact's home phone number as a String.
	 */
	public String GetHomeNo() { return m_homeNo;	}
	
	/** 
	 * Gets contact's email address.
	 * @return Returns contact's email address as a String.
	 */
	public String GetEmail() { return m_email; }
	
	/** 
	 * Gets contact's web site.
	 * @return Returns contact's web site as a String.
	 */
	public String GetWebsite() {	return m_website; }
	
	/** 
	 * Gets contact's FAX number.
	 * @return Returns contact's FAX number as a String.
	 */
	public String GetFaxNo() { return m_faxNo; }
	
	//Setter Methods
	
	/**
	 * Sets the contact's first name.
	 * @param m_firstName First name of the contact.
	 */
	public void SetFirstName(String m_firstName) throws Exception {
		if(m_firstName.length() < MAX_STRING) {
			this.m_firstName = m_firstName;
		}
		else {
			throw new Exception(
			"Error: First name too long. Must be less than"+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's surname.
	 * @param m_surname Surname of the contact.
	 */
	public void SetSurname(String m_surname) throws Exception {
		if(m_surname.length() < MAX_STRING) {
			this.m_surname = m_surname;
		}
		else {
			throw new Exception(
			"Error: Surname too long. Must be less than"+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's address.
	 * @param m_address Address of contact.
	 */
	public void SetAddress(String m_address) throws Exception {
		if(m_address.length() < MAX_STRING) {
			this.m_address = m_address;
		}
		else {
			throw new Exception(
			"Error: Address too long. Must be less than"+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's post code.
	 * @param m_postcode Contact's post code.
	 */
	public void SetPostcode(String m_postcode) throws Exception {
		if(m_postcode.length() < MAX_STRING) {
			this.m_postcode = m_postcode;
		}
		else {
			throw new Exception(
			"Error: Post code too long. Must be less than"+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's mobile number.
	 * @param m_mobileNo Contact's mobile number.
	 */
	public void SetMobileNo(String m_mobileNo) throws Exception {
		if(m_mobileNo.length() == PHONENUM_LENGTH) {
			this.m_mobileNo = m_mobileNo;
		}
		else {
			throw new Exception(
			"Error: Mobile number must be "
			+PHONENUM_LENGTH+" digits long.");
		}
	}
	
	/** 
	 * Sets the contact's home phone number.
	 * @param m_homeNo contact's home phone number.
	 */
	public void SetHomeNo(String m_homeNo) throws Exception {
		if(m_homeNo.length() == PHONENUM_LENGTH) {
			this.m_homeNo = m_homeNo;
		}
		else {
			throw new Exception(
			"Error: Home phone number must be " +
			+PHONENUM_LENGTH+" digits long.");
		}
	}
	
	/** 
	 * Sets the contact's email address.
	 * @param m_email Contact's email address.
	 */
	public void SetEmail(String m_email) throws Exception {
		if(m_email.length() < MAX_STRING) {
			this.m_email = m_email;
		}
		else {
			throw new Exception(
			"Error: Email address too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's web site.
	 * @param m_website Contact's web site.
	 */
	public void SetWebsite(String m_website) throws Exception {
		if(m_website.length() < MAX_STRING) {
			this.m_website = m_website;
		}
		else {
			throw new Exception(
			"Error: Web site too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
	}
	
	/** 
	 * Sets the contact's FAX number.
	 * @param m_faxNo Contact's FAX number.
	 */
	public void SetFaxNo(String m_faxNo) throws Exception {
		if(m_faxNo.length() < MAX_STRING) {
			this.m_faxNo = m_faxNo;
		}
		else {
			throw new Exception(
			"Error: FAX number too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
	}
	
	/**
	 * Creates an object of the class to initialise contact data.
	 * 
	 * @param m_firstName The contact's first name
	 * @param m_surname The contact's surname
	 * @param m_address The contact's address
	 * @param m_postcode The contact's post code
	 * @param m_mobileNo The contact's mobile number
	 * @param m_homeNo The contact's home number
	 * @param m_email The contact's email
	 * @param m_faxNo The contact's FAX number
	 * @param m_website The contact's web site
	 */
	public Contact(String m_firstName, String m_surname,
				   String m_address,   String m_postcode, 
				   String m_mobileNo,  String m_homeNo, 
				   String m_email,     String m_faxNo,
				   String m_website) throws Exception {
		
		if(m_firstName.length() < MAX_STRING) {
			this.m_firstName = m_firstName;
		}
		else {
			throw new Exception(
			"Error: First name too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_surname.length() < MAX_STRING) {
			this.m_surname = m_surname;
		}
		else {
			throw new Exception(
			"Error: Surname too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_address.length() < MAX_STRING) {
			this.m_address = m_address;
		}
		else {
			throw new Exception(
			"Error: Address too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_postcode.length() < MAX_STRING) {
			this.m_postcode = m_postcode;
		}
		else {
			throw new Exception(
			"Error: Postcode too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_mobileNo.length() == PHONENUM_LENGTH) {
			this.m_mobileNo = m_mobileNo;
		}
		else {
			throw new Exception(
			"Error: Mobile number must be " +
			+PHONENUM_LENGTH+" digits long.");
		}
		
		if(m_homeNo.length() == PHONENUM_LENGTH) {
			this.m_homeNo = m_homeNo;
		}
		else {
			throw new Exception(
			"Error: Home phone number must be " +
			+PHONENUM_LENGTH+" digits long.");
		}
		
		if(m_email.length() < MAX_STRING) {
			this.m_email = m_email;
		}
		else {
			throw new Exception(
			"Error: Email address too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_website.length() < MAX_STRING) {
			this.m_website = m_website;
		}
		else {
			throw new Exception(
			"Error: Web site too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
		
		if(m_faxNo.length() < MAX_STRING) {
			this.m_faxNo = m_faxNo;
		}
		else {
			throw new Exception(
			"Error: FAX number too long. Must be less than "+
			+MAX_STRING+" characters.");
		}
	}
	
	public static void main(String args[]) {
		//Start Testing
		
		
	}
	
 }
 
 
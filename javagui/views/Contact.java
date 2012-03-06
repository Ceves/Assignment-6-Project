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
	public static final int MAX = 30; //Maximum characters
	public static final int NUMBERMAX = 11;	//Valid phone number length
	
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
	public void SetFirstName(String m_firstName) {
		if(m_firstName.length() < MAX){
			this.m_firstName = m_firstName;
		}
		else{
			System.out.println("Error: first name too long.");
		}
	}
	
	/** 
	 * Sets the contact's surname.
	 * @param m_surname Surname of the contact.
	 */
	public void SetSurname(String m_surname) {
		if(m_surname.length() < MAX){
			this.m_surname = m_surname;
		}
		else{
			System.out.println("Error: surname too long.");
		}
	}
	
	/** 
	 * Sets the contact's address.
	 * @param m_address Address of contact.
	 */
	public void SetAddress(String m_address) {
		if(m_address.length() < MAX){
			this.m_address = m_address;
		}
		else{
			System.out.println("Error: address too long.");
		}
	}
	
	/** 
	 * Sets the contact's post code.
	 * @param m_postcode Contact's post code.
	 */
	public void SetPostcode(String m_postcode) {
		if(m_postcode.length() < MAX){
			this.m_postcode = m_postcode;
		}
		else{
			System.out.println("Error: postcode too long.");
		}
	}
	
	/** 
	 * Sets the contact's mobile number.
	 * @param m_mobileNo Contact's mobile number.
	 */
	public void SetMobileNo(String m_moblileNo) {
		if(m_mobileNo.length() == NUMBERMAX){
			this.m_mobileNo = m_mobileNo;
		}
		else{
			System.out.println("Error: mobile number must be 11 " +
							   "characters long.");
		}
	}
	
	/** 
	 * Sets the contact's home phone number.
	 * @param m_homeNo contact's home phone number.
	 */
	public void SetHomeNo(String m_homeNo) {
		if(m_homeNo.length() == NUMBERMAX){
			this.m_homeNo = m_homeNo;
		}
		else{
			System.out.println("Error: home number must be 11 " +
							   "characters long.");
		}
	}
	
	/** 
	 * Sets the contact's email address.
	 * @param m_email Contact's email address.
	 */
	public void SetEmail(String m_email) {
		if(m_email.length() < MAX){
			this.m_email = m_email;
		}
		else{
			System.out.println("Error: email too long.");
		}
	}
	
	/** 
	 * Sets the contact's web site.
	 * @param m_website Contact's web site.
	 */
	public void SetWebsite(String m_website) {
		if(m_website.length() < MAX){
			this.m_website = m_website;
		}
		else{
			System.out.println("Error: website too long.");
		}
	}
	
	/** 
	 * Sets the contact's FAX number.
	 * @param m_faxNo Contact's FAX number.
	 */
	public void SetFaxNo(String m_faxNo) {
		if(m_faxNo.length() < MAX){
			this.m_faxNo = m_faxNo;
		}
		else{
			System.out.println("Error: faxNo too long.");
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
				   String m_website) {
		
		if(m_firstName.length() < MAX) {
			this.m_firstName = m_firstName;
		}
		else {
			System.out.println("Error: first name too long.");
		}
		
		if(m_surname.length() < MAX) {
			this.m_surname = m_surname;
		}
		else {
			System.out.println("Error: surname too long.");
		}
		
		if(m_address.length() < MAX) {
			this.m_address = m_address;
		}
		else {
			System.out.println("Error: address too long.");
		}
		
		if(m_postcode.length() < MAX) {
			this.m_postcode = m_postcode;
		}
		else {
			System.out.println("Error: postcode too long.");
		}
		
		if(m_mobileNo.length() == NUMBERMAX) {
			this.m_mobileNo = m_mobileNo;
		}
		else {
			System.out.println("Error: mobile number must be 11 " +
							   "characters long.");
		}
		
		if(m_homeNo.length() == NUMBERMAX) {
			this.m_homeNo = m_homeNo;
		}
		else {
			System.out.println("Error: home number must be 11 " +
							   "characters long.");
		}
		
		if(m_email.length() < MAX) {
			this.m_email = m_email;
		}
		else {
			System.out.println("Error: email too long.");
		}
		
		if(m_website.length() < MAX) {
			this.m_website = m_website;
		}
		else {
			System.out.println("Error: website too long.");
		}
		
		if(m_faxNo.length() < MAX) {
			this.m_faxNo = m_faxNo;
		}
		else {
			System.out.println("Error: faxNo too long.");
		}
	}
	
	
 }
 
 
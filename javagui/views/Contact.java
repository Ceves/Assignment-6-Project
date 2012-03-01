package javagui.views;

/** @file Contact.java
 * @author Daniel Mallory (632628)
 * @date 26/02/2012
 * @see ContactManager.h
 * @brief Defines what a contact is and what variables it needs to have.
 *  
 * This class defines what it is to be a contact, it describes the variables a contact needs to have,
 * and contains all the accessor and mutator methods for a contact. The ContactManager class then uses
 * this class to read in CSV files containing details about contacts, and add/delete contacts.
 */
 
 public class Contact{
	
	private int MAX = 30;	//constant, max amount of characters
	private int NUMBERMAX = 11;	//constant for mobile and home numbers
	
	private String m_firstName;
	private String m_surname;
	private String m_address;
	private String m_postcode;
	private String m_mobileNo;
	private String m_homeNo;	//home and mobile number are strings, because we want them to behave as strings not as numbers
	private String m_email;
	private String m_faxNo;
	private String m_website;	//a website associated with the contact, e.g. their facebook profile
	
	//accessor methods
	/** accessor for first name
	* @return m_firstname - returns first name
	*/
	public String getFirstName(){
		return m_firstName;
	}
	
	/** accessor for surname
	* @return m_surname - returns surname
	*/
	public String getSurname(){
		return m_surname;
	}
	
	/** accessor for address
	* @return m_address - returns address
	*/	
	public String getAddress(){
		return m_address;
	}
	
	/** accessor for post code
	* @return m_postcode - returns postcode
	*/
	public String getPostcode(){
		return m_postcode;
	}
		
	/** accessor for mobile number
	* @return m_mobileNo - returns mobile number
	*/
	public String getMobileNo(){
		return m_mobileNo;
	}
	
	/** accessor for home number
	* @return m_homeNo - returns home number
	*/
	public String getHomeNo(){
		return m_homeNo;
	}
	
	/** accessor for email
	* @return m_email - returns email
	*/
	public String getEmail(){
		return m_email;
	}
	
	/** accessor for website
	* @return m_website - returns website
	*/
	public String getWebsite(){
		return m_website;
	}
	
	/** accessor for fax number
	* @return m_faxNo - returns fax number
	*/
	public String getFaxNo(){
		return m_faxNo;
	}
	
	//mutator methods
	
	/** mutator for first name
	* @param m_firstname - changes first name
	*/
	public void setFirstName(String m_firstName){
		if(m_firstName.length() < MAX){
			this.m_firstName = m_firstName;
		}
		else{
			System.out.println("Error: first name too long.");
		}
	}
	
	/** mutator for surname
	* @param m_surname - changes surname
	*/
	public void setSurname(String m_surname){
		if(m_surname.length() < MAX){
			this.m_surname = m_surname;
		}
		else{
			System.out.println("Error: surname too long.");
		}
	}
	
	/** mutator for address
	* @param m_address - changes address
	*/
	public void setAddress(String m_address){
		if(m_address.length() < MAX){
			this.m_address = m_address;
		}
		else{
			System.out.println("Error: address too long.");
		}
	}
	
	/** mutator for postcode
	* @param m_postcode - changes postcode
	*/
	public void setPostcode(String m_postcode){
		if(m_postcode.length() < MAX){
			this.m_postcode = m_postcode;
		}
		else{
			System.out.println("Error: postcode too long.");
		}
	}
	
	/** mutator for mobile number
	* @param m_mobileNo - changes mobile number
	*/
	public void setMobileNo(String m_moblileNo){
		if(m_mobileNo.length() == NUMBERMAX){
			this.m_mobileNo = m_mobileNo;
		}
		else{
			System.out.println("Error: mobile number must be 11 characters long.");
		}
	}
	
	/** mutator for home number
	* @param m_homeNo - changes home number
	*/
	public void setHomeNo(String m_homeNo){
		if(m_homeNo.length() == NUMBERMAX){
			this.m_homeNo = m_homeNo;
		}
		else{
			System.out.println("Error: home number must be 11 characters long.");
		}
	}
	
	/** mutator for email
	* @param m_email - changes email
	*/
	public void setEmail(String m_email){
		if(m_email.length() < MAX){
			this.m_email = m_email;
		}
		else{
			System.out.println("Error: email too long.");
		}
	}
	
	/** mutator for website
	* @param m_website - changes website
	*/
	public void setWebsite(String m_website){
		if(m_website.length() < MAX){
			this.m_website = m_website;
		}
		else{
			System.out.println("Error: website too long.");
		}
	}
	
	/** mutator for faxNo
	* @param m_faxNo - changes fax number
	*/
	public void setFaxNo(String m_faxNo){
		if(m_faxNo.length() < MAX){
			this.m_faxNo = m_faxNo;
		}
		else{
			System.out.println("Error: faxNo too long.");
		}
	}
	
	/**creates contact object to hold contact data
	* @param m_firstName - sets contact first name
	* @param m_surname - sets contact surname
	* @param m_address - sets contact address
	* @param m_postcode - sets contact postcode
	* @param m_mobileNo - sets contact mobile number
	* @param m_homeNo - sets contact home number
	* @param m_email - sets contact email
	* @param m_faxNo - sets contact fax number
	* @param m_website - sets contact website
	*/
	public Contact(String m_firstName, String m_surname, String m_address, String m_postcode,
				 String m_mobileNo, String m_homeNo, String m_email, String m_faxNo, String m_website){
		
		if(m_firstName.length() < MAX){
			this.m_firstName = m_firstName;
		}
		else{
			System.out.println("Error: first name too long.");
		}
		
		if(m_surname.length() < MAX){
			this.m_surname = m_surname;
		}
		else{
			System.out.println("Error: surname too long.");
		}
		
		if(m_address.length() < MAX){
			this.m_address = m_address;
		}
		else{
			System.out.println("Error: address too long.");
		}
		
		if(m_postcode.length() < MAX){
			this.m_postcode = m_postcode;
		}
		else{
			System.out.println("Error: postcode too long.");
		}
		
		if(m_mobileNo.length() == NUMBERMAX){
			this.m_mobileNo = m_mobileNo;
		}
		else{
			System.out.println("Error: mobile number must be 11 characters long.");
		}
		
		if(m_homeNo.length() == NUMBERMAX){
			this.m_homeNo = m_homeNo;
		}
		else{
			System.out.println("Error: home number must be 11 characters long.");
		}
		
		if(m_email.length() < MAX){
			this.m_email = m_email;
		}
		else{
			System.out.println("Error: email too long.");
		}
		
		if(m_website.length() < MAX){
			this.m_website = m_website;
		}
		else{
			System.out.println("Error: website too long.");
		}
		
		if(m_faxNo.length() < MAX){
			this.m_faxNo = m_faxNo;
		}
		else{
			System.out.println("Error: faxNo too long.");
		}
	}
	
	
 }
 
 
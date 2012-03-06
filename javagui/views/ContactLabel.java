package javagui.views;
/**
 * The ContactLabel class is a subclass of the JLabel class almost specifically designed to
 * hold a Contact variable as a way to solve the problem of having a dynamic amount of
 * Contacts without a dynamic variable-allocating allocating algorithm for each one.
 * It displays the name of a contact as well as having specific MouseEvents attributed to it.
 * It also needs to be tied to a ContactPanel onto which its Contact's details will be displayed.
 * 
 * @author Tim Morris
 * @date 24/02/12
 * 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ContactLabel extends JLabel implements MouseListener {
	
	private Contact m_contact;
	private String m_firstName;
	private String m_surname;
	private ContactPanel m_contactPanel;
	private ContactGUI m_gui;
	
	/**
	 * The ContactLabel constructor initialises all class variables and provides each instance with a mouseListener.
	 * 
	 * @param contact a variable of type Contact that this instance of ContactLabel will henceforth represent
	 * @param contactPanel a variable of type ContactPanel that will be used to display the data of this instance's Contact class variable
	 */
	public ContactLabel(ContactGUI gui, Contact contact, ContactPanel contactPanel) {
		m_contact = contact;
		m_firstName = contact.GetFirstName();
		m_surname = contact.GetSurname();
		m_contactPanel = contactPanel;
		m_gui = gui;
		setOpaque(true);
		setBackground(Color.LIGHT_GRAY);
		setText(m_firstName + " " + m_surname);
		addMouseListener(this);
	}
	
	/**
	 * The GetContact method simply returns the class's Contact variable.
	 * 
	 * @return the class's Contact variable
	 */
	public Contact GetContact() {
		return m_contact;
	}
	
	//physically can't change these public method named to start with an uppercase character
	/**
	 * The mouseEntered method handles everything that happens
	 * when the cursor enters the bounds of a ContactLabel
	 */
	public void mouseEntered(MouseEvent e) {
		setBackground(Color.GRAY);
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	 /**
	  * The mouseExited method handles everything that happens
	  * when the cursor enters the bounds of a ContactLabel
	  */
	public void mouseExited(MouseEvent e) {
		setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 * The mouseClicked method handles the events that 
	 * occur when a ContactLabel is clicked.
	 */
	public void mouseClicked(MouseEvent e) {
		//set the information on the rightPanel of the GUI
		m_contactPanel.SetInfo(GetContact());
		//set the labelFocus of the gui to this instance of the
		//ContactLabel class
		m_gui.SetLabelFocus(this);
	}
	
}

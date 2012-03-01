package javagui.views;

/**
 * The ContactAddForm class is a custom JFrame used to gather the details of new contacts to be
 * added to the address book, and will add them to the main contact ArrayList and will also
 * cause the ContactGUI to update with the new addition.
 * 
 * @author Tim Morris
 * @date 24/02/12
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactAddForm extends JFrame implements ActionListener{
	
	private final int FRAME_HEIGHT;
	private final int FRAME_WIDTH;
	private final int PANEL_HEIGHT;
	private final int PANEL_WIDTH;
	private final int GRID_ROWS;
	private final int GRID_COLUMNS;
	private final int MAX;
	private final int NUMBER_MAX;
	private final int FAX_MAX;
	private final int HGAP;
	private final int VGAP;
	private final Dimension FRAME_SIZE;
	private final Dimension PANEL_SIZE;
	private JPanel m_container;
	private JTextField m_firstName;
	private JTextField m_surname;
	private JTextField m_address;
	private JTextField m_postcode;
	private JTextField m_mobileNo;
	private JTextField m_homeNo;
	private JTextField m_email;
	private JTextField m_faxNo;
	private JTextField m_website;
	private JButton m_addButton;
	private JButton m_cancelButton;
	private ContactManager m_manager;
	private ContactGUI m_gui;
	
	/**
	 * The ContactAddForm constructor will construct and display the ContactAddForm
	 * Frame.
	 * 
	 * @param gui a variable of type ContactGUI which should be the main ContactGUI of the program
	 */
	public ContactAddForm(ContactGUI gui) {
		FRAME_HEIGHT = 400;
		FRAME_WIDTH = 450;
		PANEL_HEIGHT = 350;
		PANEL_WIDTH = 425;
		GRID_ROWS = 5;
		GRID_COLUMNS = 4;
		MAX = 30;
		NUMBER_MAX = 11;
		FAX_MAX = 10;
		HGAP = 5;
		VGAP = 55;
		FRAME_SIZE = new Dimension(FRAME_WIDTH,FRAME_HEIGHT);
		PANEL_SIZE = new Dimension(PANEL_WIDTH,PANEL_HEIGHT);
		
		m_gui = gui;
		m_manager = gui.GetContactManager();
		
		initComponents();
	}	
	
	/**
	 * The actionPerformed method deals with the events that can occur
	 * through button presses.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//if the add button has been pressed
		if (e.getSource() == m_addButton) {
			
			//set the variables to the input in the JTextAreas
			String firstName = m_firstName.getText();
			String surname = m_surname.getText();
			String address = m_address.getText();
			String postcode = m_mobileNo.getText();
			String mobileNo = m_mobileNo.getText();
			String homeNo = m_homeNo.getText();
			String email = m_email.getText();
			String faxNo = m_faxNo.getText();
			String website = m_website.getText();
			
			//do tests on these variables
			if (firstName.length() > MAX) {
				JOptionPane.showMessageDialog(this,"Your first name can't be over " + MAX + " characters.");
				return;
			}
			if (surname.length() > MAX) {
				JOptionPane.showMessageDialog(this,"Your surname can't be over " + MAX + " characters.");
				return;
			}
			if (postcode.length() > MAX) {
				JOptionPane.showMessageDialog(this,"Your postcode can't be over " + MAX + " characters.");
				return;
			}
			if (mobileNo.length() != NUMBER_MAX) {
				JOptionPane.showMessageDialog(this,"Your mobile number must be " + NUMBER_MAX + " characters.");
				return;
			}
			if (homeNo.length() != NUMBER_MAX) {
				JOptionPane.showMessageDialog(this,"Your home number must be " + NUMBER_MAX + " characters.");
				return;
			}
			if (faxNo.length() != FAX_MAX) {
				JOptionPane.showMessageDialog(this,"Your fax number must be " + FAX_MAX + " characters.");
				return;
			}
			if (firstName.length() == 0||surname.length() == 0||address.length() == 0||postcode.length() == 0||
				mobileNo.length() == 0||homeNo.length() == 0||email.length() == 0||faxNo.length() == 0||website.length() == 0) {
				JOptionPane.showMessageDialog(this,"Every field must be filled out.");
				return;
			}
			
			//use those variables to add that contact to the DAB
			try {
				m_manager.AddContact(firstName, surname, address, postcode, mobileNo, homeNo, email, faxNo, website);
			} catch (Exception ex) {};
			
			//dispose of this Frame
			this.dispose();
			
			//refresh the main gui to display the new information
			m_gui.Refresh();
			
		}
		
		//if the cancel button is pressed
		if (e.getSource() == m_cancelButton) {
			//dispose of this Frame
			this.dispose();
		}
		
	}
	
	/**
	 * The initComponents is largely to keep the code looking clean.  It deals with initialising all of the components
	 * of the class and also populates the leftPanel with the contacts from the central contact ArrayList
	 */
	private void initComponents() {
		
		//things concerning m_container
		m_container = new JPanel(new GridLayout(GRID_ROWS,GRID_COLUMNS,HGAP,VGAP));
		m_container.setSize(PANEL_SIZE);
		m_container.setPreferredSize(PANEL_SIZE);
		m_container.setBackground(Color.LIGHT_GRAY);
		
		//things concerning the JTextFields
		m_firstName = new JTextField(MAX);
		m_surname = new JTextField(MAX);
		m_address = new JTextField(MAX);
		m_postcode = new JTextField(MAX);
		m_mobileNo = new JTextField(NUMBER_MAX);
		m_homeNo = new JTextField(NUMBER_MAX);
		m_email = new JTextField();
		m_faxNo = new JTextField(FAX_MAX);
		m_website = new JTextField();
		
		//populate the GridLayout with components
		m_container.add(new JLabel("First Name:"));
		m_container.add(m_firstName);
		m_container.add(new JLabel("Surname:"));
		m_container.add(m_surname);
		m_container.add(new JLabel("Address:"));
		m_container.add(m_address);
		m_container.add(new JLabel("Postcode:"));
		m_container.add(m_postcode);
		m_container.add(new JLabel("Mobile Number:"));
		m_container.add(m_mobileNo);
		m_container.add(new JLabel("Home Number:"));
		m_container.add(m_homeNo);
		m_container.add(new JLabel("Email Address:"));
		m_container.add(m_email);
		m_container.add(new JLabel("Fax Number:"));
		m_container.add(m_faxNo);
		m_container.add(new JLabel("Website:"));
		m_container.add(m_website);
		
		//things concerning JButtons
		m_addButton = new JButton("Add");
		m_addButton.addActionListener(this);
		m_cancelButton = new JButton("Cancel");
		m_cancelButton.addActionListener(this);
		
		m_container.add(m_addButton);
		m_container.add(m_cancelButton);
		
		//add things to the frame
		add(m_container);
		
		//things concerning the frame
		setTitle("Add Contact");
		setSize(FRAME_SIZE);
		setPreferredSize(FRAME_SIZE);
		setLayout(new FlowLayout());
		//setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
}

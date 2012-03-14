package javagui.views;

/**
 * The ContactGUI class is a GUI for the admin involved with the contacts i.e. addition, deletion and
 * modification of contacts.
 * 
 * @author Tim Morris
 * @date 24/02/12
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ContactGUI extends JFrame implements ActionListener {
	
	//symbolic constants
	private final int FRAME_WIDTH;
	private final int FRAME_HEIGHT;
	private final int PANEL_HEIGHT;
	private final int LEFT_PANEL_WIDTH;
	private final int RIGHT_PANEL_WIDTH;
	private final int BOTTOM_PANEL_HEIGHT;
	private final int BOTTOM_PANEL_WIDTH;
	private final int GRID_ROWS;
	private final int GRID_COLUMNS;
	private final int GAP;
	private final Dimension FRAME_SIZE;
	private final Dimension LEFT_PANEL_SIZE;
	private final Dimension RIGHT_PANEL_SIZE;
	private final Dimension BOTTOM_PANEL_SIZE;
	
	//panel components
	private JScrollPane m_leftPanelScroll;
	private JPanel m_leftPanel;
	private ContactPanel m_rightPanel;
	private JPanel m_bottomPanel;
	private JButton m_deleteButton;
	private JButton m_addButton;
	private ContactLabel m_labelFocus;
	
	//contact-based variables
	private ContactManager m_manager;
	private Contact m_contact;
	
	/**
	 * The ContactGUI constructor initialises all class variables and also sets up the GUI, while taking the central (and only)
	 * ContactManager of the program as an input parameter so that the central contacts ArrayList can be read in to display
	 * the contacts and their information visually.
	 * 
	 * @param manager a variable of type ContactManager to be the central (and only) ContactManager of the program
	 */
	public ContactGUI(ContactManager manager) {

		//initialise symbolic constants
		FRAME_WIDTH = 600;
		FRAME_HEIGHT = 450;
		PANEL_HEIGHT = 353;
		LEFT_PANEL_WIDTH = 150;
		RIGHT_PANEL_WIDTH = 410;
		BOTTOM_PANEL_HEIGHT = 35;
		GAP = 5;
		BOTTOM_PANEL_WIDTH = LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH + GAP;
		FRAME_SIZE = new Dimension(FRAME_WIDTH,FRAME_HEIGHT);
		LEFT_PANEL_SIZE = new Dimension(LEFT_PANEL_WIDTH,PANEL_HEIGHT);
		RIGHT_PANEL_SIZE = new Dimension(RIGHT_PANEL_WIDTH,PANEL_HEIGHT);
		BOTTOM_PANEL_SIZE = new Dimension(BOTTOM_PANEL_WIDTH,BOTTOM_PANEL_HEIGHT);
		GRID_ROWS = 0;
		GRID_COLUMNS = 1;
		
		//initialise contact-based variables
		//this is done before initialising a ContactPanel because it will take the first
		//contact as a parameter
		m_manager = manager;
		m_labelFocus = null;
		
		//initialise components
		initComponents();
	}
	
	/**
	 * The GetContactManager method will return the ContactManager that this
	 * class is using.
	 * 
	 * @return the ContactManager that this class is using
	 */
	public ContactManager GetContactManager() {
		return m_manager;
	}
	
	/**
	 * The GetLabelFocus method returns a pointer to the currently
	 * focused ContactLabel
	 * 
	 * @return the ContactLabel that has most recently been clicked
	 */
	public ContactLabel GetLabelFocus() {
		return m_labelFocus;
	}
	
	/**
	 * The SetLabelFocus method will set the given ContactLabel
	 * as the new focused label.
	 */
	public void SetLabelFocus(ContactLabel cLabel) {
		m_labelFocus = cLabel;
	}
	
	//can't physically change the start character of this method name to be uppercase
	/**
	 * The actionPerformed method processes what happens when buttons are pressed within
	 * the ContactGUI.
	 */
	public void actionPerformed(ActionEvent e) {
		
		//if the delete button is pressed
		if (e.getSource() == m_deleteButton) {
			try {
				//delete the contact, using its attributed contact
				m_manager.DeleteContact(m_labelFocus.GetContact());
				m_labelFocus = null;
			} catch (Exception ex) {};
			Refresh();
		}
		
		//opens a new ContactAddForm
		if (e.getSource() == m_addButton) {
			new ContactAddForm(this);
		}
		
	}
	
	/**
	 * The Refresh method essentially builds the ContactGUI again when some change has occurred 
	 * within it e.g. a new Contact has been added.
	 */
	public void Refresh() {
		remove(m_leftPanelScroll);
		remove(m_rightPanel);
		remove(m_bottomPanel);
		initComponents();
		repaint();
	}
	
	/**
	 * The initComponents is largely to keep the code looking clean.  It deals with initialising all of the components
	 * of the class and also populates the leftPanel with the contacts from the central contact ArrayList
	 */
	private void initComponents() {
		
		//things concerning the m_leftPanel
		m_leftPanel = new JPanel(new GridLayout(GRID_ROWS,GRID_COLUMNS));
		m_leftPanel.setSize(LEFT_PANEL_SIZE);
		//m_leftPanel.setPreferredSize(LEFT_PANEL_SIZE);
		m_leftPanel.setBackground(Color.LIGHT_GRAY);
		m_leftPanel.setLayout(new BoxLayout(m_leftPanel,BoxLayout.PAGE_AXIS));
		
		//things concerning the m_leftPanelScroll
		m_leftPanelScroll = new JScrollPane(m_leftPanel);
		m_leftPanelScroll.setPreferredSize(LEFT_PANEL_SIZE);
		
		//things concerning the m_rightPanel
		m_rightPanel = new ContactPanel(m_contact);
		m_rightPanel.setSize(RIGHT_PANEL_SIZE);
		m_rightPanel.setPreferredSize(RIGHT_PANEL_SIZE);
		m_rightPanel.setBackground(Color.LIGHT_GRAY);
		
		//things concerning the m_bottomPanel
		m_bottomPanel = new JPanel(new FlowLayout());
		m_bottomPanel.setSize(BOTTOM_PANEL_SIZE);
		m_bottomPanel.setPreferredSize(BOTTOM_PANEL_SIZE);
		m_bottomPanel.setBackground(Color.LIGHT_GRAY);
		
		//things concerning m_deleteButton
		m_deleteButton = new JButton("Delete");
		m_deleteButton.addActionListener(this);
		
		//things concerning m_addButton
		m_addButton = new JButton("Add");
		m_addButton.addActionListener(this);
		
		//add the contacts to the list
		//for every element in the central contact list
		for (int i = 0;i<m_manager.GetContactList().size();i++) {
			//set 'contact' to the current element of the list
			Contact contact = m_manager.GetContactList().get(i);
			//create a new ContactLabel, using this contact as a parameter
			m_leftPanel.add(new ContactLabel(this,contact,m_rightPanel));
		}
		
		//add the components to the frame/other components
		add(m_leftPanelScroll,BorderLayout.LINE_START);
		add(m_rightPanel,BorderLayout.CENTER);
		add(m_bottomPanel,BorderLayout.PAGE_END);
		m_bottomPanel.add(m_addButton);
		m_bottomPanel.add(m_deleteButton);
		
		//things concerning the frame
		setTitle("Contact List");
		setSize(FRAME_SIZE);
		setPreferredSize(FRAME_SIZE);
		getContentPane().setBackground(Color.GRAY);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
}
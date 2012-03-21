package Classes;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import CalendarViews.MonthView;
import AddressBookViews.*;

@SuppressWarnings("serial")
public class JFrame_Main extends JFrame {

	/**
	 * THIS IS THE MAIN APPLICATION
	 */
	//Declare all objects to be used in the main window
	
	//panels
	private JPanel contentPane = new JPanel();
	private AddressBookView AddressBook = new AddressBookView();
	private JPanel dailyView = new JPanel();
	private JPanel weeklyView = new JPanel();
	private MonthView monthlyView = new MonthView();
	
	//Tables
	private static JTable tbl_monthly_view;
	private JTable tbl_address_book;
	
	//buttons
	private JButton btnUseAlternativeAddress = 
			new JButton("Use Alternative Address Book Manager");
	private JButton btnUpdatedeleteContact = new JButton(
			"Update/Delete Contact");
	private JButton btnAddContact = new JButton("Add Contact");
	private JButton btnAddEvent = new JButton("Add Event");;
	private JButton btnEditDelete = new JButton("Edit/Delete");
	private JButton btnAddTask;
	
	//Scroll Panes
	private JScrollPane scrollPane = new JScrollPane();
	
	//JLabels
	private JLabel lblAddressBook = new JLabel("Address Book");
	private final JLabel lbl_month = new JLabel("Month YYYY");
	
	private JButton btnSearch = new JButton("Search");
	private JPanel topBar = new JPanel();
	
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			//global_calendar = Calendar.getInstance();			
			//global_events = efr.load("EVENTS.csv");//test Load()
			
			//m_manager = manager;
			//m_contact = m_manager.GetContactList().get(0);
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame_Main frame = new JFrame_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		 
	}
	
	/**
	 * Create the frame. 
	 */
	@SuppressWarnings("serial")
	public JFrame_Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame_Main.class.getResource("/resources/application_icon.png")));
		setTitle("Digital Organizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 700);
		
		//Set the toolbar
		System.setProperty("apple.laf.useScreenMenuBar", "true"); //Make it look good on macs
		JMenuBar menuBar = new Toolbar();
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setPreferredSize(getSize());
		setContentPane(contentPane);
		
		
		
		
		topBar.setLocation(0, 0);
		topBar.setPreferredSize(new Dimension(1000,70));
		
		btnAddEvent = new JButton("Add Event");
		btnAddEvent.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_events_48x48.png")));
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame_Events form = new JFrame_Events();
		        form.setVisible(true);
		        System.out.println(monthlyView.tbl_monthly_view.getSelectedColumn() + " " + monthlyView.tbl_monthly_view.getSelectedRow());	        
			}
		});
		
		btnAddTask = new JButton("Add Task");
		btnAddTask.setEnabled(false);
		btnAddTask.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_tasks_48x48.png")));
		
		btnEditDelete = new JButton("Edit/Delete");
		btnEditDelete.setEnabled(false);
		btnEditDelete.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_rename_48x48.png")));
		
		
		btnSearch.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_search_48x48.png")));
		
		topBar.add(btnAddEvent);
		topBar.add(btnAddTask);
		topBar.add(btnEditDelete);
		topBar.add(btnSearch);
		
		contentPane.add(topBar);
				
		JTabbedPane Calendar = new JTabbedPane(JTabbedPane.BOTTOM);
		Calendar.addTab("Monthly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_monthly_16x16.png")), monthlyView, null);
		Calendar.addTab("Weekly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_weekly_16x16.png")), weeklyView, null);
		Calendar.addTab("Daily", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")), dailyView, null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Calendar", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_icon_16x16.png")), Calendar, null);
		tabbedPane.addTab("Address Book", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_address_book_16x16.png")), AddressBook, null);
		tabbedPane.addTab("Task", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_tasks_16x16.png")), null, null);
		
		contentPane.add(tabbedPane);
		
		

		monthlyView.refresh_monthly_view();
		monthlyView.lbl_month.setText(monthlyView.monthToString());

	}
		
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnUseAlternativeAddress){
			try {
				ContactManager manager = new ContactManager();
				manager.Load("CONTACTS.csv");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}

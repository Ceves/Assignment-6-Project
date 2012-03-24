package Classes;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import CalendarViews.MonthView;
import CalendarViews.SearchGUI;
import AddressBookViews.*;

@SuppressWarnings("serial")
public class JFrame_Main extends JFrame {

	/**
	 * THIS IS THE MAIN APPLICATION
	 */
	
	//panels
	private JPanel contentPane = new JPanel();
	private AddressBookView AddressBook = new AddressBookView();
	private JPanel dailyView = new JPanel();
	private JPanel weeklyView = new JPanel();
	public MonthView monthlyView = new MonthView();
	
	//buttons
	private JButton btnUseAlternativeAddress = 
			new JButton("Use Alternative Address Book Manager");
	private JButton btnAddEvent = new JButton("Add Event");;
	private JButton btnEditDelete = new JButton("Edit/Delete");
	private JButton btnAddTask;
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
		setContentPane(contentPane);
		
		btnAddEvent = new JButton("Add Event");
		btnAddEvent.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_events_48x48.png")));
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEventWindow form = new AddEventWindow();
		        form.setVisible(true);
		        System.out.println(MonthView.tbl_monthly_view.getSelectedColumn() + " " + MonthView.tbl_monthly_view.getSelectedRow());	        
			}
		});
		
		btnAddTask = new JButton("Add Task");
		btnAddTask.setEnabled(false);
		btnAddTask.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_tasks_48x48.png")));
		
		btnEditDelete = new JButton("Edit/Delete");
		btnEditDelete.setEnabled(false);
		btnEditDelete.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_rename_48x48.png")));
		
		btnSearch.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_search_48x48.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchGUI();
			}
		});
		
		JTabbedPane Calendar = new JTabbedPane(JTabbedPane.BOTTOM);
		Calendar.addTab("Monthly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_monthly_16x16.png")), monthlyView, null);
		Calendar.addTab("Weekly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_weekly_16x16.png")), weeklyView, null);
		Calendar.addTab("Daily", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")), dailyView, null);
		
		monthlyView.setOpaque(false);
		weeklyView.setOpaque(false);
		dailyView.setOpaque(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Calendar", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_icon_16x16.png")), Calendar, null);
		tabbedPane.addTab("Address Book", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_address_book_16x16.png")), AddressBook, null);
		tabbedPane.addTab("Task", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_tasks_16x16.png")), null, null);
		AddressBook.setOpaque(false);
		Calendar.setOpaque(false);
		
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		contentPane.add(btnAddEvent, c);
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		contentPane.add(btnAddTask,c);
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0;
		contentPane.add(btnEditDelete,c);
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0;
		c.anchor = GridBagConstraints.LINE_END;
		contentPane.add(btnSearch,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 5;
		c.weightx = 1;
		contentPane.add(tabbedPane,c);

		MonthView.refresh_monthly_view();
		monthlyView.lbl_month.setText(MonthView.monthToString());
	}
		
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnUseAlternativeAddress){
			try {
				ContactManager manager = new ContactManager();
				manager.Load();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}

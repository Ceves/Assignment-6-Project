package Classes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.apple.eawt.*;

public class JFrame_Main extends JFrame {

	/**
	 * THIS IS THE MAIN APPLICATION
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbl_address_book;
	private static JTable tbl_monthly_view;
	private static Calendar global_calendar;
	private static ArrayList<Event> global_events = new ArrayList<Event>();
	private static EventFileReader efr = new EventFileReader();
	private static String[][] monthly_view_date_holder = new String[7][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			global_calendar = Calendar.getInstance();			
			global_events = efr.load("EVENTS.csv");//test Load()
			
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
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame_Main.class.getResource("/resources/application_icon.png")));
		setTitle("Digital Organizer - | cs235group9a4 |");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmAddEvent = new JMenuItem("Add Event");
		mnFile.add(mntmAddEvent);
		mntmAddEvent.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")));
		
		JMenuItem mntmAddTask = new JMenuItem("Add Task");
		mntmAddTask.setEnabled(false);
		mnFile.add(mntmAddTask);
		mntmAddTask.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_tasks_16x16.png")));
		
		JMenuItem mntmAddContact = new JMenuItem("Add Contact");
		mnFile.add(mntmAddContact);
		mntmAddContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_contact_16x16.png")));
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmImportAddressBook = new JMenuItem("Import Address Book");
		mntmImportAddressBook.setEnabled(false);
		mnFile.add(mntmImportAddressBook);
		
		JMenuItem mntmImportCalendar = new JMenuItem("Import Calendar");
		mntmImportCalendar.setEnabled(false);
		mnFile.add(mntmImportCalendar);
		
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		
		JMenuItem mntmExportAddressBook = new JMenuItem("Export Address Book");
		mntmExportAddressBook.setEnabled(false);
		mnFile.add(mntmExportAddressBook);
		
		JMenuItem mntmExportCalendar = new JMenuItem("Export Calendar");
		mntmExportCalendar.setEnabled(false);
		mnFile.add(mntmExportCalendar);
		
		JSeparator separator_3 = new JSeparator();
		mnFile.add(separator_3);
		
		JMenuItem mntmPageSetup = new JMenuItem("Page Setup...");
		mntmPageSetup.setEnabled(false);
		mnFile.add(mntmPageSetup);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.setEnabled(false);
		mnFile.add(mntmPrint);
		
		JSeparator separator_4 = new JSeparator();
		mnFile.add(separator_4);
		mntmExit.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_exit_16x16.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setEnabled(false);
		mntmUndo.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_undo_16x16.png")));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setEnabled(false);
		mntmRedo.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_redo_16x16.png")));
		mnEdit.add(mntmRedo);
		
		JSeparator separator_5 = new JSeparator();
		mnEdit.add(separator_5);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setEnabled(false);
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setEnabled(false);
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setEnabled(false);
		mnEdit.add(mntmPaste);
		
		JSeparator separator_6 = new JSeparator();
		mnEdit.add(separator_6);
		
		JMenuItem mntmFindEvents = new JMenuItem("Find Events");
		mntmFindEvents.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")));
		mnEdit.add(mntmFindEvents);
		
		JMenuItem mntmFindTasks = new JMenuItem("Find Tasks");
		mntmFindTasks.setEnabled(false);
		mntmFindTasks.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_tasks_16x16.png")));
		mnEdit.add(mntmFindTasks);
		
		JMenuItem mntmFindContact = new JMenuItem("Find Contact");
		mntmFindContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_find_16x16.png")));
		mnEdit.add(mntmFindContact);
		
		JMenu mnNewMenu = new JMenu("Views");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDailyView = new JMenuItem("Daily View");
		mntmDailyView.setEnabled(false);
		mntmDailyView.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")));
		mnNewMenu.add(mntmDailyView);
		
		JMenuItem mntmWeeklyView = new JMenuItem("Weekly View");
		mntmWeeklyView.setEnabled(false);
		mntmWeeklyView.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_weekly_16x16.png")));
		mnNewMenu.add(mntmWeeklyView);
		
		JMenuItem mntmMonthlyView = new JMenuItem("Monthly View");
		mntmMonthlyView.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_monthly_16x16.png")));
		mnNewMenu.add(mntmMonthlyView);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu.add(separator_7);
		
		JMenuItem mntmAddressBookView = new JMenuItem("Address Book View");
		mntmAddressBookView.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_address_book_16x16.png")));
		mnNewMenu.add(mntmAddressBookView);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpDocumentation = new JMenuItem("Help Contents");
		mntmHelpDocumentation.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_help_16x16.png")));
		mnHelp.add(mntmHelpDocumentation);
		
		JMenuItem mntmAbout = new JMenuItem("About Digital Organizer");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame_Events form = new JFrame_Events();
		        form.setVisible(true);
		        System.out.println(tbl_monthly_view.getSelectedColumn() + " " + tbl_monthly_view.getSelectedRow());	        
			}
		});
		btnAddEvent.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_events_48x48.png")));
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.setEnabled(false);
		btnAddTask.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_tasks_48x48.png")));
		
		JSeparator separator = new JSeparator();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		final JButton btnEditDelete = new JButton("Edit/Delete");
		btnEditDelete.setEnabled(false);
		btnEditDelete.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_rename_48x48.png")));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_search_48x48.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnAddEvent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddTask)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
					.addComponent(btnSearch))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddEvent)
							.addComponent(btnAddTask))
						.addComponent(btnEditDelete)
						.addComponent(btnSearch))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
		);
		
		final JTabbedPane Calendar = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.addTab("Calendar", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_icon_16x16.png")), Calendar, null);
		
		JPanel monthlyView = new JPanel();
		Calendar.addTab("Monthly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_monthly_16x16.png")), monthlyView, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		final JLabel lbl_month = new JLabel("Month YYYY");
		lbl_month.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_month.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_events_monthly_48x48.png")));
		
		JButton btnNextmonth = new JButton("");
		btnNextmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				increment_month();
				lbl_month.setText(monthToString());
			}
		});
		btnNextmonth.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_24x24/application_arrow_right_24x24.png")));
		
		JButton btnPreviousmonth = new JButton("");
		btnPreviousmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decrement_month();
				lbl_month.setText(monthToString());
			}
		});
		btnPreviousmonth.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_24x24/application_arrow_left_24x24.png")));
		GroupLayout gl_monthlyView = new GroupLayout(monthlyView);
		gl_monthlyView.setHorizontalGroup(
			gl_monthlyView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_monthlyView.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_monthlyView.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
						.addGroup(gl_monthlyView.createSequentialGroup()
							.addComponent(lbl_month)
							.addPreferredGap(ComponentPlacement.RELATED, 672, Short.MAX_VALUE)
							.addComponent(btnPreviousmonth)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNextmonth)))
					.addContainerGap())
		);
		gl_monthlyView.setVerticalGroup(
			gl_monthlyView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_monthlyView.createSequentialGroup()
					.addGroup(gl_monthlyView.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_monthlyView.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_month)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
						.addGroup(gl_monthlyView.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_monthlyView.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPreviousmonth)
								.addComponent(btnNextmonth))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tbl_monthly_view = new JTable();
		tbl_monthly_view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditDelete.setEnabled(false);
				for (int d=0;d<7;d++) {
				     for (int x=0;x<6;x++) {
				    	 if ((x == tbl_monthly_view.getSelectedRow()) && (d == tbl_monthly_view.getSelectedColumn()) && (monthly_view_date_holder[d][x] != null)){
				    		 btnEditDelete.setEnabled(true);
				    	 System.out.println(monthly_view_date_holder[d][x]);
				    	 }
				     } 
				}
				
			}
		});
		tbl_monthly_view.setColumnSelectionAllowed(true);
		tbl_monthly_view.setCellSelectionEnabled(true);
		tbl_monthly_view.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_monthly_view.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_monthly_view.getColumnModel().getColumn(0).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(1).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(2).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(3).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(4).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(5).setResizable(false);
		tbl_monthly_view.getColumnModel().getColumn(6).setResizable(false);
		tbl_monthly_view.setRowHeight(59);
		tbl_monthly_view.getTableHeader().setReorderingAllowed(false); 
		scrollPane_1.setViewportView(tbl_monthly_view);
		monthlyView.setLayout(gl_monthlyView);
		
		JPanel weeklyView = new JPanel();
		Calendar.addTab("Weekly", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_weekly_16x16.png")), weeklyView, null);
		
		JPanel dailyView = new JPanel();
		Calendar.addTab("Daily", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_events_16x16.png")), dailyView, null);
		
		JPanel AddressBook = new JPanel();
		tabbedPane.addTab("Address Book", new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_address_book_16x16.png")), AddressBook, null);
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_contact_48x48.png")));
		
		JButton btnUpdatedeleteContact = new JButton("Update/Delete Contact");
		btnUpdatedeleteContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_rename_48x48.png")));
		
		JLabel lblAddressBook = new JLabel("Address Book");
		lblAddressBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddressBook.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_address_book_48x48.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnUseAlternativeAddress = new JButton("Use Alternative Address Book Manager");
		btnUseAlternativeAddress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ContactManager manager = new ContactManager();
					manager.Load("CONTACTS.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		GroupLayout gl_AddressBook = new GroupLayout(AddressBook);
		gl_AddressBook.setHorizontalGroup(
			gl_AddressBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddressBook.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
						.addGroup(gl_AddressBook.createSequentialGroup()
							.addComponent(lblAddressBook)
							.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
							.addComponent(btnUseAlternativeAddress)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAddContact)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdatedeleteContact)))
					.addContainerGap())
		);
		gl_AddressBook.setVerticalGroup(
			gl_AddressBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddressBook.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddressBook.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnUpdatedeleteContact)
							.addComponent(btnAddContact)
							.addComponent(btnUseAlternativeAddress))
						.addComponent(lblAddressBook))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tbl_address_book = new JTable();
		scrollPane.setViewportView(tbl_address_book);
		tbl_address_book.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"First Name", "Surname", "Address", "Postcode", "Mobile No.", "Home No.", "Email", "Fax No.", "Website"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			//New classes?
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbl_address_book.getColumnModel().getColumn(0).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(1).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(2).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(3).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(4).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(5).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(6).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(7).setResizable(false);
		tbl_address_book.getColumnModel().getColumn(8).setResizable(false);
		tbl_address_book.getTableHeader().setReorderingAllowed(false);
		AddressBook.setLayout(gl_AddressBook);
		contentPane.setLayout(gl_contentPane);
		
		refresh_monthly_view();
		lbl_month.setText(monthToString());

	}
		
	//public toString override
	public static String monthToString(){
		String monthlyViewString;
        switch (global_calendar.get(Calendar.MONTH)) {
            case 0:  monthlyViewString = "January";
                     break;
            case 1:  monthlyViewString = "February";
                     break;
            case 2:  monthlyViewString = "March";
                     break;
            case 3:  monthlyViewString = "April";
                     break;
            case 4:  monthlyViewString = "May";
                     break;
            case 5:  monthlyViewString = "June";
                     break;
            case 6:  monthlyViewString = "July";
                     break;
            case 7:  monthlyViewString = "August";
                     break;
            case 8:  monthlyViewString = "September";
                     break;
            case 9: monthlyViewString = "October";
                     break;
            case 10: monthlyViewString = "November";
                     break;
            case 11: monthlyViewString = "December";
                     break;
            default: monthlyViewString = "Invalid month";
                     break;
        }
        
        monthlyViewString = (monthlyViewString + " " + global_calendar.get(Calendar.YEAR));
        
        return monthlyViewString;
	}
	
	//refresh the monthly view
	public static void refresh_monthly_view(){
		global_events = efr.load("EVENTS.csv");//test Load()
		Calendar local_calendar = global_calendar;
		local_calendar.set(Calendar.DAY_OF_MONTH, 1);
		int z = ((local_calendar.get(Calendar.DAY_OF_WEEK) * -1));
		
		for(int d = 0; d < 6; d++){
			for (int i = 0; i < 7; i++){
				tbl_monthly_view.getModel().setValueAt(null,d,i);
			}
		}		
		
		
		for (int i = 0; i < 6; i++){
			for (int d = 0; d < 7; d++){
				z++;
				if ((z >= 0) && (z <= (local_calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - 1))) {
					local_calendar.set(Calendar.DATE, z+1);
					DateFormat df = new SimpleDateFormat("d/M/yy");
					Date currentDate = (local_calendar.getTime());
			        monthly_view_date_holder[d][i] = df.format(currentDate);
		            tbl_monthly_view.getModel().setValueAt(local_calendar.get(Calendar.DAY_OF_MONTH),i,d);
					ListIterator<Event> litr = global_events.listIterator();
				    while (litr.hasNext()) {
				      Event element = litr.next();
				      SimpleDateFormat formatter = new SimpleDateFormat("d/M/yy");
				      
				      if ((formatter.format(element.GetSDate()).compareTo(df.format(currentDate))) == 0) {
				    	  tbl_monthly_view.getModel().setValueAt(local_calendar.get(Calendar.DAY_OF_MONTH) + " - " + element.GetTitle(),i,d);
				      };
				      System.out.println();
				    }				    
				}
			}
		}	
	}
	
	
	//+ month
	public static void increment_month(){
		int month = global_calendar.get(Calendar.MONTH);
		month = month + 1;
		global_calendar.set(Calendar.MONTH, month);
		refresh_monthly_view();
	}
	
	//- month
	public static void decrement_month(){
		int month = global_calendar.get(Calendar.MONTH);
		month = month - 1;
		global_calendar.set(Calendar.MONTH, month);
		refresh_monthly_view();
	}
}
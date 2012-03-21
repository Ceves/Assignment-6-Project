package Classes;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Toolbar extends JMenuBar {

	public Toolbar(){
		super();
		
		JMenu mnFile = new JMenu("File");
		this.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		//mntmExit.addActionListener();
		
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
		this.add(mnEdit);
		
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
		this.add(mnNewMenu);
		
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
		this.add(mnHelp);
		
		JMenuItem mntmHelpDocumentation = new JMenuItem("Help Contents");
		mntmHelpDocumentation.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_16x16/application_help_16x16.png")));
		mnHelp.add(mntmHelpDocumentation);
		
		JMenuItem mntmAbout = new JMenuItem("About Digital Organizer");
		mnHelp.add(mntmAbout);
	}
}

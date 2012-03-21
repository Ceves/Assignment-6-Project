package Classes;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Toolbar extends JMenuBar {

	private JMenu mnFile, mnEdit, mnView, mnHelp;
	private JMenuItem mntmExit, mntmAddEvent, mntmAddTask, mntmAddContact,
						mntmImportAddressBook, mntmImportCalendar,
						mntmExportAddressBook, mntmExportCalendar,
						mntmPageSetup, mntmPrint, mntmUndo, mntmRedo,
						mntmCut, mntmCopy, mntmPaste, mntmFindEvents,
						mntmFindTasks, mntmFindContact, mntmDailyView,
						mntmWeeklyView, mntmMonthlyView, mntmAddressBookView,
						mntmHelpDocumentation, mntmAbout;
	private JSeparator separator = new JSeparator();
	
	public Toolbar(){
		super();
		
		mnFile = new JMenu("File");
		this.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		
		mntmAddEvent = new JMenuItem("Add Event");
		mnFile.add(mntmAddEvent);
		mntmAddEvent.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_events_16x16.png")));
		
		mntmAddTask = new JMenuItem("Add Task");
		mntmAddTask.setEnabled(false);
		mnFile.add(mntmAddTask);
		mntmAddTask.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_tasks_16x16.png")));
		
		mntmAddContact = new JMenuItem("Add Contact");
		mnFile.add(mntmAddContact);
		mntmAddContact.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_contact_16x16.png")));
		
		
		mnFile.add(separator);
		
		mntmImportAddressBook = new JMenuItem("Import Address Book");
		mntmImportAddressBook.setEnabled(false);
		mnFile.add(mntmImportAddressBook);
		
		mntmImportCalendar = new JMenuItem("Import Calendar");
		mntmImportCalendar.setEnabled(false);
		mnFile.add(mntmImportCalendar);
		
		
		mnFile.add(separator);
		
		mntmExportAddressBook = new JMenuItem("Export Address Book");
		mntmExportAddressBook.setEnabled(false);
		mnFile.add(mntmExportAddressBook);
		
		mntmExportCalendar = new JMenuItem("Export Calendar");
		mntmExportCalendar.setEnabled(false);
		mnFile.add(mntmExportCalendar);
		
		mnFile.add(separator);
		
		mntmPageSetup = new JMenuItem("Page Setup...");
		mntmPageSetup.setEnabled(false);
		mnFile.add(mntmPageSetup);
		
		mntmPrint = new JMenuItem("Print");
		mntmPrint.setEnabled(false);
		mnFile.add(mntmPrint);
		
		mnFile.add(separator);
		
		mntmExit.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_exit_16x16.png")));
		mnFile.add(mntmExit);
		
		mnEdit = new JMenu("Edit");
		this.add(mnEdit);
		
		mntmUndo = new JMenuItem("Undo");
		mntmUndo.setEnabled(false);
		mntmUndo.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_undo_16x16.png")));
		mnEdit.add(mntmUndo);
		
		mntmRedo = new JMenuItem("Redo");
		mntmRedo.setEnabled(false);
		mntmRedo.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_redo_16x16.png")));
		mnEdit.add(mntmRedo);
		
		mnEdit.add(separator);
		
		mntmCut = new JMenuItem("Cut");
		mntmCut.setEnabled(false);
		mnEdit.add(mntmCut);
		
		mntmCopy = new JMenuItem("Copy");
		mntmCopy.setEnabled(false);
		mnEdit.add(mntmCopy);
		
		mntmPaste = new JMenuItem("Paste");
		mntmPaste.setEnabled(false);
		mnEdit.add(mntmPaste);
		
		mnEdit.add(separator);
		
		mntmFindEvents = new JMenuItem("Find Events");
		mntmFindEvents.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_events_16x16.png")));
		mnEdit.add(mntmFindEvents);
		
		mntmFindTasks = new JMenuItem("Find Tasks");
		mntmFindTasks.setEnabled(false);
		mntmFindTasks.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_tasks_16x16.png")));
		mnEdit.add(mntmFindTasks);
		
		mntmFindContact = new JMenuItem("Find Contact");
		mntmFindContact.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_find_16x16.png")));
		mnEdit.add(mntmFindContact);
		
		mnView = new JMenu("Views");
		this.add(mnView);
		
		mntmDailyView = new JMenuItem("Daily View");
		mntmDailyView.setEnabled(false);
		mntmDailyView.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_events_16x16.png")));
		mnView.add(mntmDailyView);
		
		mntmWeeklyView = new JMenuItem("Weekly View");
		mntmWeeklyView.setEnabled(false);
		mntmWeeklyView.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_events_weekly_16x16.png")));
		mnView.add(mntmWeeklyView);
		
		mntmMonthlyView = new JMenuItem("Monthly View");
		mntmMonthlyView.setIcon(new ImageIcon(JFrame_Main.class.getResource(
				"/resources/img_16x16/application_events_monthly_16x16.png")));
		mnView.add(mntmMonthlyView);
		
		mnView.add(separator);
		
		mntmAddressBookView = new JMenuItem("Address Book View");
		mntmAddressBookView.setIcon(new ImageIcon(JFrame_Main.class.
				getResource("/resources/img_16x16/application_address_" +
						"book_16x16.png")));
		mnView.add(mntmAddressBookView);
		
		mnHelp = new JMenu("Help");
		this.add(mnHelp);
		
		mntmHelpDocumentation = new JMenuItem("Help Contents");
		mntmHelpDocumentation.setIcon(new ImageIcon(JFrame_Main.class.
				getResource("/resources/img_16x16/application_help_16x16." +
						"png")));
		mnHelp.add(mntmHelpDocumentation);
		
		mntmAbout = new JMenuItem("About Digital Organizer");
		mnHelp.add(mntmAbout);
	}
}

package Classes;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import CalendarViews.MonthView;

/**
 * This class LOOKS like it makes a new JFrame for the events input window
 * @author Alfei
 *
 */
@SuppressWarnings("serial")
public class AddEventWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textLocation;
	private JTextField textTitle;
	private JTextField textStartDate;
	private JTextField textEndDate;
	private JTextField textAddress;
	private JTextField textEndTime;
	private JTextField textStartTime;
	private JTextField textDescription;
	private static ArrayList<Event> global_events = new ArrayList<Event>();
	private static EventFileReader efr = new EventFileReader();

	/**
	 * Launch the application.
	 * 
	 * IS THIS NEEDED?! JFrame_Main is the main app!
	 */
	public static void main(String[] args) {
		try {
			global_events = efr.load("EVENTS.csv");//test Load()
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
	 * 
	 * MASSIVE MASSIVE METHOD
	 * WHAT THE HOLY HELL
	 */
	
	public AddEventWindow() {
		setTitle("Events - Digital Organizer - | cs235group9a4 |");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddEventWindow.
				class.getResource(
						"/resources/img_16x16/application_events_16x16.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 456);
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
		
		JMenuItem mntmPageSetup = new JMenuItem("Page Setup...");
		mnFile.add(mntmPageSetup);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnFile.add(mntmPrint);
		
		JSeparator separator_4 = new JSeparator();
		mnFile.add(separator_4);
		mntmExit.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_exit_16x16.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_undo_16x16.png")));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_redo_16x16.png")));
		mnEdit.add(mntmRedo);
		
		JSeparator separator_5 = new JSeparator();
		mnEdit.add(separator_5);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JSeparator separator_6 = new JSeparator();
		mnEdit.add(separator_6);
		
		JMenuItem mntmFindEvents = new JMenuItem("Find Events");
		mntmFindEvents.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_events_16x16.png")));
		mnEdit.add(mntmFindEvents);
		
		JMenuItem mntmFindTasks = new JMenuItem("Find Tasks");
		mntmFindTasks.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_tasks_16x16.png")));
		mnEdit.add(mntmFindTasks);
		
		JMenuItem mntmFindContact = new JMenuItem("Find Contact");
		mntmFindContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_find_16x16.png")));
		mnEdit.add(mntmFindContact);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpDocumentation = new JMenuItem("Help Contents");
		mntmHelpDocumentation.setIcon(new ImageIcon(JFrame_Main.class.getResource("/javagui/resources/img_16x16/application_help_16x16.png")));
		mnHelp.add(mntmHelpDocumentation);
		
		JMenuItem mntmAbout = new JMenuItem("About Digital Organizer");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Title");
		
		JLabel lblLocation = new JLabel("Location");
		
		textLocation = new JTextField();
		textLocation.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setColumns(10);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setIcon(new ImageIcon(AddEventWindow.class.getResource("/javagui/resources/application_icon.png")));
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblCategory = new JLabel("Category");
		
		final JComboBox comboBoxCategory = new JComboBox();
		comboBoxCategory.setModel(new DefaultComboBoxModel(new String[] {"Social Event", "Birthday", "Work Deadline", "Meeting", "Bill Payment", "Appointment", "Anniversary", "Class/Lecture", "Meal", "Happy Hour", "Concert", "Accident", "Bank Holiday"}));
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblStart = new JLabel("Start");
		
		textStartDate = new JTextField();
		textStartDate.setText("01/01/12");
		textStartDate.setColumns(10);
		
		JLabel lblEnd = new JLabel("End");
		
		textEndDate = new JTextField();
		textEndDate.setText("01/01/12");
		textEndDate.setColumns(10);
		
		JLabel lblRepeat = new JLabel("Repeat");
		
		final JComboBox comboBoxRepeat = new JComboBox();
		comboBoxRepeat.setModel(new DefaultComboBoxModel(new String[] {"Never", "Hourly", "Daily", "Weekly", "Monthly", "Weekly", "Yearly"}));
		
		JSeparator separator_3 = new JSeparator();
		
		JLabel lblDescription = new JLabel("Description");
		
		JButton btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df = new SimpleDateFormat("d/M/yy");

		        try {
		        	global_events = efr.load("EVENTS.csv");
		            Date sDate = df.parse(textStartDate.getText());
		            Date eDate = df.parse(textEndDate.getText());
		            Event myNewEvent = new Event("" + global_events.size() 
		            		+ "", textTitle.getText(), textLocation.getText(), 
		            		textAddress.getText(), sDate, eDate,
		            		textStartTime.getText(),textEndTime.getText(),
		            		comboBoxRepeat.getSelectedIndex(),
		            		textDescription.getText());
					global_events.add(myNewEvent);
		        } catch (ParseException e) {
		        	System.out.println("Invalid Date Format");
		            e.printStackTrace();
		        }

				efr.Save(global_events, "EVENTS.csv");
				
				MonthView.refresh_monthly_view();
				dispose();
				
			}
		});
		btnSaveAndExit.setIcon(new ImageIcon(AddEventWindow.class.getResource("/javagui/resources/img_24x24/application_save_24x24.png")));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(AddEventWindow.class.getResource("/javagui/resources/img_24x24/application_delete_24x24.png")));
		
		JLabel lblAddress = new JLabel("Address");
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		
		JLabel label = new JLabel("@");
		
		JLabel label_1 = new JLabel("@");
		
		textEndTime = new JTextField();
		textEndTime.setText("00:00");
		textEndTime.setColumns(10);
		
		textStartTime = new JTextField();
		textStartTime.setText("00:00");
		textStartTime.setColumns(10);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescription)
					.addContainerGap(251, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textDescription, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addComponent(lblLocation))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblTitle)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textLocation, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(textTitle, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addComponent(lblEvents, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(separator_1, Alignment.LEADING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))))
					.addGap(94))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStart)
					.addGap(10)
					.addComponent(textStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textStartTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnd)
					.addGap(18)
					.addComponent(textEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textEndTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSaveAndExit)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator_3, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblCategory)
							.addGap(18)
							.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblRepeat)
							.addGap(18)
							.addComponent(comboBoxRepeat, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEvents)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocation)
						.addComponent(textLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(textStartTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStart))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd)
						.addComponent(textEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textEndTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRepeat)
						.addComponent(comboBoxRepeat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBoxCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveAndExit)
						.addComponent(btnDelete))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

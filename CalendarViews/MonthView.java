/**
 * 
 */
package CalendarViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.Event;
import Classes.EventFileReader;
import Classes.JFrame_Main;

/**
 * @author cs631989
 *
 */
@SuppressWarnings("serial")
public class MonthView extends JPanel{

	public static JTable tbl_monthly_view;
	public final JLabel lbl_month = new JLabel("Month YYYY");
	private static String[][] monthly_view_date_holder = new String[7][6];
	private static Calendar global_calendar;
	private static ArrayList<Event> global_events = new ArrayList<Event>();
	private static EventFileReader efr = new EventFileReader();


	/**
	 * 
	 */
	public MonthView() {
		global_calendar = Calendar.getInstance();			
		global_events = efr.load("EVENTS.csv");//test Load()
		
		setBorder(new EmptyBorder(0, 7, 0, 7));
		
		JScrollPane scrollPane_1 = new JScrollPane();

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
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 10;
		c.weightx=1;
		this.add(lbl_month, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx=0.15;
		this.add(btnPreviousmonth,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		c.weightx=0.15;
		this.add(btnNextmonth,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 3;
		c.gridwidth = 4;
		c.ipadx = 100;
		c.ipadx = 100;
		c.gridx = 0;
		c.gridy = 1;
		this.add(scrollPane_1,c);
		
		tbl_monthly_view = new JTable();
		tbl_monthly_view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//btnEditDelete.setEnabled(false);
				for (int d=0;d<7;d++) {
					for (int x=0;x<6;x++) {
						if ((x == tbl_monthly_view.getSelectedRow()) && (d == tbl_monthly_view.getSelectedColumn()) && (monthly_view_date_holder[d][x] != null)){
					//		btnEditDelete.setEnabled(true);
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
		tbl_monthly_view.setRowHeight(68);
		tbl_monthly_view.getTableHeader().setReorderingAllowed(false); 
		tbl_monthly_view.setGridColor(Color.lightGray);
		scrollPane_1.setViewportView(tbl_monthly_view);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
}

package CalendarViews;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Classes.Event;
import Classes.EventSearcher;

import javax.swing.*;

@SuppressWarnings("serial")
public class SearchGUI extends JFrame {
	
	private JPanel m_panel;
	private JLabel m_labelTitle;
	private JButton m_buttonSearch;
	private JTextField m_fieldCriteria;
	private JTable m_resultTable;
	private Object[] m_resultArray;
	private GridBagConstraints m_c;
	public static final String[] COLUMN_NAMES =
		{"Event", "City", "Place", "Start Date", "End Date",
		 "Start Time", "End Time", "Description"};

	public SearchGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		pack();
		setVisible(true);
	}
	
	public void initComponents() {
		Handler handler = new Handler();
		
		m_c = new GridBagConstraints();
		m_panel = new JPanel(new GridBagLayout());
		add(m_panel);
		
		m_labelTitle = new JLabel("Event Title");
		m_c.insets = new Insets(15, 15, 15, 15);
		m_c.gridx = 0;
		m_c.gridy = 0;
		m_c.anchor = m_c.WEST;
		m_panel.add(m_labelTitle, m_c);
		
		m_c.insets = new Insets(0, 15, 20, 15);
		m_fieldCriteria = new JTextField(10);
		m_fieldCriteria.setPreferredSize(new Dimension(25,26));
		m_c.gridx = 0;
		m_c.gridy = 1;
		m_panel.add(m_fieldCriteria, m_c);
		
		m_buttonSearch = new JButton("Search");
		m_c.gridx = 1;
		m_c.gridy = 1;
		m_panel.add(m_buttonSearch, m_c);
		m_buttonSearch.addActionListener(handler);
		
	}
	
	public static void main(String[] args) {
		new SearchGUI();
	}
	
	private class Handler implements ActionListener {
		
		ArrayList<Event> events;
		EventSearcher search = new EventSearcher();

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == m_buttonSearch) {
				String criteria = m_fieldCriteria.getText();
				events = new ArrayList<Event>();
				m_resultArray = new Object[events.size()-1];
				
				for(int i=0;i<events.size();i++) {
					m_resultArray[0] = {"1"};
					m_resultArray[0] = "2";
					m_resultArray[0] = "3";
					m_resultArray[0] = "4";
					m_resultArray[0] = "5";
					m_resultArray[0] = "6";
					m_resultArray[0] = "7";
					m_resultArray[0] = "8";
				}
				
				m_resultTable = new JTable(m_resultArray, COLUMN_NAMES);
				m_c.gridx = 0;
				m_c.gridy = 3;
				m_c.gridwidth = 5;
				m_panel.add(m_resultTable, m_c);
				pack();
				
				try {
					events = search.FindByTitle(criteria);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				for(int i=0;i<events.size();i++) {
					System.out.println(events.get(i).GetTitle());
				}
				
			}
		}
		
	}

}

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
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class SearchGUI extends JFrame {

	private JPanel m_panel;
	private JLabel m_labelTitle;
	private JButton m_buttonSearch;
	private JTextField m_fieldCriteria;
	private JTable m_resultTable;
	private GridBagConstraints m_c;
	public static final String[] COLUMN_NAMES = { "Event", "Location",
			"Address", "Start Date", "End Date", "Start Time", "End Time",
			"Description" };

	public SearchGUI() {
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		initComponents();
		pack();
		setVisible(true);
	}

	public void resizeFrame(int x, int y) {
		this.setSize(x, y);
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

		m_c.insets = new Insets(0, 15, 20, 45);
		m_fieldCriteria = new JTextField(10);
		m_fieldCriteria.setPreferredSize(new Dimension(25, 26));
		m_fieldCriteria.setMinimumSize(m_fieldCriteria.getPreferredSize());
		m_c.gridx = 0;
		m_c.gridy = 1;
		m_panel.add(m_fieldCriteria, m_c);

		m_buttonSearch = new JButton("Search");
		m_c.gridx = 1;
		m_c.gridy = 1;
		m_panel.add(m_buttonSearch, m_c);
		m_buttonSearch.addActionListener(handler);

		m_c.insets = new Insets(15, 15, 20, 15);
	}

	public static void main(String[] args) {
		new SearchGUI();
	}

	private class Handler implements ActionListener {

		private ArrayList<Event> m_events;
		private EventSearcher m_search;
		private Object[][] m_tableArray;
		private JScrollPane m_pane;
		private boolean m_tableAdded = false;
		public static final int ROW_HEIGHT = 30;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == m_buttonSearch) {
				if (m_tableAdded == true) {
					m_panel.remove(m_pane);
					m_panel.updateUI();
				}

				m_search = new EventSearcher();

				try {
					m_events = m_search.FindByTitle(m_fieldCriteria.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

				m_tableArray = new Object[m_events.size()][COLUMN_NAMES.length];

				for (int i = 0; i < m_events.size(); i++) {
					String[] data = { m_events.get(i).GetTitle(),
							m_events.get(i).GetLocation(),
							m_events.get(i).GetAddress(),
							String.valueOf(m_events.get(i).GetSDate()),
							String.valueOf(m_events.get(i).GetEDate()),
							m_events.get(i).GetSTime(),
							m_events.get(i).GetETime(),
							m_events.get(i).GetDescription() };

					for (int j = 0; j < COLUMN_NAMES.length; j++) {
						m_tableArray[i][j] = data[j];
					}

				}

				m_resultTable = new JTable(m_tableArray, COLUMN_NAMES);

				m_c.gridx = 0;
				m_c.gridy = 3;
				m_c.fill = m_c.BOTH;
				m_c.gridwidth = 3;
				m_c.weighty = 1;
				m_c.weightx = 1;

				m_pane = new JScrollPane(m_resultTable);
				m_resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				m_panel.add(m_pane, m_c);
				m_tableAdded = true;

				m_panel.updateUI();
				resizeFrame(800, 400);
			}
		}

	}

}

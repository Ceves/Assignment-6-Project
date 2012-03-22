package AddressBookViews;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Classes.JFrame_Main;

public class AddressBookView extends JPanel{
	
	private JTable tbl_address_book;
	private JLabel lblAddressBook = new JLabel("Address Book");
	private JButton btnUpdatedeleteContact = new JButton(
			"Update/Delete Contact");
	private JButton btnAddContact = new JButton("Add Contact");


	public AddressBookView(){
		
		JScrollPane scrollPane = new JScrollPane();

		btnAddContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_contact_48x48.png")));
		
		btnUpdatedeleteContact.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_rename_48x48.png")));
		
		lblAddressBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddressBook.setIcon(new ImageIcon(JFrame_Main.class.getResource("/resources/img_48x48/application_address_book_48x48.png")));
				
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx=1;
		this.add(lblAddressBook, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx=0.15;
		this.add(btnAddContact,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		c.weightx=0.15;
		this.add(btnUpdatedeleteContact,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 3;
		c.gridwidth = 4;
		c.ipadx = 100;
		c.ipadx = 100;
		c.gridx = 0;
		c.gridy = 1;
		this.add(scrollPane,c);

		scrollPane.setViewportView(tbl_address_book);
		tbl_address_book = new JTable();
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
		scrollPane.setViewportView(tbl_address_book);
		//contentPane.setLayout(gl_contentPane);
		
	}
}


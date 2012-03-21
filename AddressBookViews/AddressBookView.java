package AddressBookViews;

import java.awt.Font;

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
				
		GroupLayout gl_AddressBook = new GroupLayout(this);
		gl_AddressBook.setHorizontalGroup(
			gl_AddressBook.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressBook.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddressBook.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
						.addGroup(gl_AddressBook.createSequentialGroup()
							.addComponent(lblAddressBook)
							.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
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
							)
						.addComponent(lblAddressBook))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
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
		this.setLayout(gl_AddressBook);
		//contentPane.setLayout(gl_contentPane);
		
	}
}


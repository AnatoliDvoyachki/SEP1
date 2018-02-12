import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

/**
 * ScreenManageDestinations class, that is the GUI class for the Manage
 * Destinations screen
 */
public class ScreenManageDestinations extends JPanel {

	private JLabel lblTitle;

	private JButton btnBack;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnNew;

	private JScrollPane scrollPane;
	private JTable table;

	public ScreenManageDestinations(BusCompanyController controller) {
		setLayout(null);

		lblTitle = new JLabel("Manage Destinations");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 159, 21);
		add(lblTitle);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 61, 65, 23);
		add(btnBack);
		btnBack.addActionListener(controller);
		btnBack.setActionCommand("manageDestinations-to-main");

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(480, 61, 61, 23);
		add(btnEdit);
		btnEdit.addActionListener(controller);
		btnEdit.setActionCommand("manageDestinations-to-edit");

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(551, 60, 73, 23);
		add(btnDelete);
		btnDelete.addActionListener(controller);
		btnDelete.setActionCommand("manageDestinations-delete");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 614, 346);
		add(scrollPane);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setDragEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(table);

		btnNew = new JButton("New");
		btnNew.setBounds(405, 61, 61, 23);
		add(btnNew);
		btnNew.addActionListener(controller);
		btnNew.setActionCommand("manageDestinations-to-new");
	}

	public Object[] getInput() {
		Object[] data = new Object[1];
		data[0] = table.getSelectedRow();
		return data;
	}

	public void fillInput(Object[] data) {
		table.setModel(new DefaultTableModel((Object[][]) data[0],
				new String[] { "Destination" }));
	}

	public void clear() {

	}
}
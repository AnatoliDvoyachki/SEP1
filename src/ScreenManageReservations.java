import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

/**
 * ScreenManageReservations class, that is the GUI class for the "Manage
 * reservations" screen
 */
public class ScreenManageReservations extends JPanel {

	private JLabel lblTitle;

	private JScrollPane scrollPane;
	private JTable table;

	private JButton btnBack;
	private JButton btnNewTriptour;
	private JButton btnNewBusAndChauffeur;
	private JButton btnEdit;
	private JButton btnDelete;

	public ScreenManageReservations(BusCompanyController controller) {

		setBounds(100, 100, 640, 480);
		setLayout(null);

		lblTitle = new JLabel("Manage Reservations");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 159, 21);
		add(lblTitle);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 61, 65, 23);
		add(btnBack);
		btnBack.addActionListener(controller);
		btnBack.setActionCommand("manageReservation-to-main");

		btnNewBusAndChauffeur = new JButton("New Bus and Chaufeur");
		btnNewBusAndChauffeur.setBounds(176, 61, 163, 23);
		add(btnNewBusAndChauffeur);
		btnNewBusAndChauffeur.addActionListener(controller);
		btnNewBusAndChauffeur
				.setActionCommand("manageReservation-to-newBusAndChauffeur");

		btnNewTriptour = new JButton("New Trip");
		btnNewTriptour.setBounds(349, 61, 121, 23);
		add(btnNewTriptour);
		btnNewTriptour.addActionListener(controller);
		btnNewTriptour.setActionCommand("manageReservation-to-newTripTour");

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(480, 61, 61, 23);
		add(btnEdit);
		btnEdit.addActionListener(controller);
		btnEdit.setActionCommand("manageReservation-to-edit");

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(551, 60, 73, 23);
		add(btnDelete);
		btnDelete.addActionListener(controller);
		btnDelete.setActionCommand("manageReservation-delete");

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
		table.setAutoResizeMode(0);

		scrollPane.setViewportView(table);

	}

	public Object[] getInput() {
		Object[] data = new Object[1];
		data[0] = table.getSelectedRow();
		return data;
	}

	public void fillInput(Object[] data) {
		table.setModel(new DefaultTableModel(
				(Object[][]) data[0],
				new String[] { "Type", "Start", "End", "Chauffeur", "Bus",
						"Destination", "Passengers", "Customer Name",
						"Customer Address", "Customer Phone", "Price", "Notes" }));
	}

	public void clear() {

	}
}

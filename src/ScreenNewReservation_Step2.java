import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

import javax.swing.*;
import javax.swing.border.*;

/**
 * ScreenNewReservation_Step2 class that is the GUI class for the
 * "New Reservation Step 2" screen
 */
public class ScreenNewReservation_Step2 extends JPanel {

	private JTextField textFieldCustomerName;
	private JTextField textFieldCustomerAddress;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldPrice;

	private JLabel lblNewReservation;
	private JLabel lblDriver;
	private JLabel lblBus;
	private JLabel lblPrice;
	private JLabel lblNotes;
	private JLabel lblCustomerName;
	private JLabel lblCustomerAddress;
	private JLabel lblPhoneNumber;
	private JLabel lblReservationInfo;

	private JPanel panelCustomerBorder;

	private JComboBox comboBoxChauffeurs;
	private JComboBox comboBoxBuses;

	private JScrollPane scrollPane;
	private JTextArea textAreaNotes;

	private JButton btnBack;
	private JButton btnSave;

	private JButton btnCancel;

	public ScreenNewReservation_Step2(BusCompanyController controller) {
		setLayout(null);

		lblNewReservation = new JLabel("Reservation | Step 2");
		lblNewReservation.setForeground(Color.GRAY);
		lblNewReservation.setFont(lblNewReservation.getFont().deriveFont(
				lblNewReservation.getFont().getStyle() & ~Font.BOLD, 17f));
		lblNewReservation.setBounds(10, 11, 190, 21);
		add(lblNewReservation);

		lblDriver = new JLabel("Chauffeur");
		lblDriver.setBounds(10, 83, 60, 14);
		add(lblDriver);

		lblBus = new JLabel("Bus");
		lblBus.setBounds(10, 115, 24, 14);
		add(lblBus);

		comboBoxChauffeurs = new JComboBox();
		comboBoxChauffeurs.setBounds(125, 80, 180, 20);
		add(comboBoxChauffeurs);

		comboBoxBuses = new JComboBox();
		comboBoxBuses.setBounds(125, 112, 180, 20);
		add(comboBoxBuses);

		lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 284, 40, 14);
		add(lblPrice);

		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(125, 281, 60, 20);
		add(textFieldPrice);
		textFieldPrice.setColumns(10);

		lblNotes = new JLabel("Notes");
		lblNotes.setBounds(12, 315, 130, 14);
		add(lblNotes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 313, 497, 74);
		add(scrollPane);

		textAreaNotes = new JTextArea();
		scrollPane.setViewportView(textAreaNotes);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 417, 100, 23);
		add(btnBack);
		btnBack.addActionListener(controller);
		btnBack.setActionCommand("newReservationStep2-back");

		btnSave = new JButton("Save");
		btnSave.setBounds(522, 417, 100, 23);
		add(btnSave);
		btnSave.addActionListener(controller);
		btnSave.setActionCommand("newReservationStep2-save");

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(410, 417, 100, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newReservationStep2-to-main");

		panelCustomerBorder = new JPanel();
		panelCustomerBorder.setBorder(new TitledBorder(null, "Customer",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCustomerBorder.setBounds(0, 141, 634, 128);
		add(panelCustomerBorder);
		panelCustomerBorder.setLayout(null);

		lblCustomerName = new JLabel("Name");
		lblCustomerName.setBounds(12, 27, 33, 16);
		panelCustomerBorder.add(lblCustomerName);

		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setBounds(125, 25, 180, 20);
		panelCustomerBorder.add(textFieldCustomerName);
		textFieldCustomerName.setColumns(10);

		lblCustomerAddress = new JLabel("Address");
		lblCustomerAddress.setBounds(12, 60, 130, 14);
		panelCustomerBorder.add(lblCustomerAddress);

		textFieldCustomerAddress = new JTextField();
		textFieldCustomerAddress.setBounds(125, 57, 180, 20);
		panelCustomerBorder.add(textFieldCustomerAddress);
		textFieldCustomerAddress.setColumns(10);

		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(12, 92, 130, 14);
		panelCustomerBorder.add(lblPhoneNumber);

		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(125, 89, 180, 20);
		panelCustomerBorder.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);

		lblReservationInfo = new JLabel(
				"Date: 12 nov 2016 - 17 nov 2016   Destination: Legoland   Number of Passengers: 41");
		lblReservationInfo.setFont(lblReservationInfo.getFont().deriveFont(
				lblReservationInfo.getFont().getStyle() & ~Font.BOLD));
		lblReservationInfo.setForeground(Color.GRAY);
		lblReservationInfo.setBounds(10, 44, 469, 16);
		add(lblReservationInfo);
	}

	public Object[] getInput() {
		Object[] input = new Object[7];
		input[0] = comboBoxChauffeurs.getSelectedItem();
		input[1] = comboBoxBuses.getSelectedItem();
		input[2] = textFieldCustomerName.getText();
		input[3] = textFieldCustomerAddress.getText();
		input[4] = textFieldPhoneNumber.getText();
		input[5] = textFieldPrice.getText();
		input[6] = textAreaNotes.getText();
		return input;
	}

	public void fillInput(Object[] data) {
		comboBoxChauffeurs
				.setModel(new DefaultComboBoxModel((Object[]) data[0]));
		comboBoxBuses.setModel(new DefaultComboBoxModel((Object[]) data[1]));
		textFieldCustomerName.setText((String) data[2]);
		textFieldCustomerAddress.setText((String) data[3]);
		textFieldPhoneNumber.setText((String) data[4]);
		textFieldPrice.setText((String) data[5]);
		textAreaNotes.setText((String) data[6]);

		lblReservationInfo.setText((String) data[7]);

		comboBoxChauffeurs.setSelectedItem((Chauffeur) data[8]); // can possibly
																	// throw
																	// some
																	// error (?)
		comboBoxBuses.setSelectedItem((Bus) data[9]); // same
	}

	public void clear() {
		textFieldCustomerName.setText("");
		textFieldCustomerAddress.setText("");
		textFieldPhoneNumber.setText("");
		textFieldPrice.setText("");
		textAreaNotes.setText("");
	}

}

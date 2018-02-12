import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

import javax.swing.*;

/**
 * ScreenNewBus class that is the GUI class for the "New Bus" screen
 */
public class ScreenNewBus extends JPanel {

	private JTextField textFieldBusType;
	private JTextField textFieldNumberOfSeats;
	private JTextField textFieldId;

	private JLabel lblTitle;
	private JLabel lblBusType;
	private JLabel lblNumberOfSeats;
	private JLabel lblId;

	private JButton btnCancel;
	private JButton btnSave;

	public ScreenNewBus(BusCompanyController controller) {
		setBounds(100, 100, 640, 480);
		setLayout(null);

		lblTitle = new JLabel("Bus");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 99, 21);
		add(lblTitle);

		lblBusType = new JLabel("Bus type");
		lblBusType.setBounds(10, 63, 63, 14);
		add(lblBusType);

		textFieldBusType = new JTextField();
		textFieldBusType.setColumns(10);
		textFieldBusType.setBounds(150, 60, 180, 20);
		add(textFieldBusType);

		lblNumberOfSeats = new JLabel("Number of seats");
		lblNumberOfSeats.setBounds(10, 94, 99, 14);
		add(lblNumberOfSeats);

		textFieldNumberOfSeats = new JTextField();
		textFieldNumberOfSeats.setColumns(10);
		textFieldNumberOfSeats.setBounds(150, 91, 180, 20);
		add(textFieldNumberOfSeats);

		lblId = new JLabel("ID");
		lblId.setBounds(10, 125, 46, 14);
		add(lblId);

		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(150, 122, 180, 20);
		add(textFieldId);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 418, 89, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newBus-to-main");

		btnSave = new JButton("Save");
		btnSave.setBounds(535, 418, 89, 23);
		add(btnSave);
		btnSave.addActionListener(controller);
		btnSave.setActionCommand("newBus-save");
	}

	public Object[] getInput() {
		Object[] input = new Object[3];
		input[0] = textFieldBusType.getText();
		input[1] = textFieldNumberOfSeats.getText();
		input[2] = textFieldId.getText();
		return input;
	}

	public void clear() {
		textFieldBusType.setText("");
		textFieldNumberOfSeats.setText("");
		textFieldId.setText("");
	}

	public void fillInput(Object[] data) {
		textFieldBusType.setText((String) data[0]);
		textFieldNumberOfSeats.setText((String) data[1]);
		textFieldId.setText((String) data[2]);

	}
}

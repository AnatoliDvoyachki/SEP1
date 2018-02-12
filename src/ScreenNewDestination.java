import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
//import java.util.logging.Handler;

import javax.swing.*;

/**
 * ScreenNewDestination class that is the GUI class for the "New Destination"
 * screen
 */
public class ScreenNewDestination extends JPanel {

	private JTextField textFieldDestination;

	private JLabel lblTitle;
	private JLabel lblDestination;

	private JButton btnCancel;
	private JButton btnSave;

	public ScreenNewDestination(BusCompanyController controller) {
		setLayout(null);

		lblTitle = new JLabel("Destination");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 157, 21);
		add(lblTitle);

		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 63, 71, 14);
		add(lblDestination);

		textFieldDestination = new JTextField();
		textFieldDestination.setColumns(10);
		textFieldDestination.setBounds(100, 60, 180, 20);
		add(textFieldDestination);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 418, 89, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newDestination-to-main");

		btnSave = new JButton("Save");
		btnSave.setBounds(535, 418, 89, 23);
		add(btnSave);
		btnSave.addActionListener(controller);
		btnSave.setActionCommand("newDestination-save");
	}

	public Object[] getInput() {
		Object[] input = new Object[1];
		input[0] = textFieldDestination.getText();
		return input;
	}

	public void clear() {
		textFieldDestination.setText("");
	}

	public void fillInput(Object[] data) {
		textFieldDestination.setText((String) data[0]);
	}
}
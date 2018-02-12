import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

import javax.swing.*;

/**
 * ScreenNewChauffeur class that is the GUI class for the "New Chauffeur" screen
 */
public class ScreenNewChauffeur extends JPanel {

	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmail;
	private JTextField textFieldId;

	private JLabel lblTitle;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblPhoneNumber;
	private JLabel lblEmail;
	private JLabel lblId;

	private JButton btnCancel;
	private JButton btnSave;

	public ScreenNewChauffeur(BusCompanyController controller) {
		setBounds(100, 100, 640, 480);
		setLayout(null);

		lblTitle = new JLabel("Chauffeur");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 12, 143, 23);
		add(lblTitle);

		lblName = new JLabel("Name");
		lblName.setBounds(10, 63, 46, 14);
		add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(125, 60, 180, 20);
		add(textFieldName);
		textFieldName.setColumns(10);

		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 95, 58, 14);
		add(lblAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(125, 92, 180, 20);
		add(textFieldAddress);

		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(10, 127, 89, 14);
		add(lblPhoneNumber);

		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(125, 124, 180, 20);
		add(textFieldPhoneNumber);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 418, 89, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newChauffeur-to-main");

		btnSave = new JButton("Save");
		btnSave.setBounds(535, 418, 89, 23);
		add(btnSave);
		btnSave.addActionListener(controller);
		btnSave.setActionCommand("newChauffeur-save");

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 159, 46, 14);
		add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(125, 156, 180, 20);
		add(textFieldEmail);

		lblId = new JLabel("ID");
		lblId.setBounds(10, 191, 46, 14);
		add(lblId);

		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(125, 188, 180, 20);
		add(textFieldId);

	}

	public Object[] getInput() {
		Object[] input = new Object[5];
		input[0] = textFieldName.getText();
		input[1] = textFieldAddress.getText();
		input[2] = textFieldPhoneNumber.getText();
		input[3] = textFieldEmail.getText();
		input[4] = textFieldId.getText();
		return input;
	}

	public void clear() {
		textFieldName.setText("");
		textFieldAddress.setText("");
		textFieldPhoneNumber.setText("");
		textFieldEmail.setText("");
		textFieldId.setText("");
	}

	public void fillInput(Object[] data) {
		textFieldName.setText((String) data[0]);
		textFieldAddress.setText((String) data[1]);
		textFieldPhoneNumber.setText((String) data[2]);
		textFieldEmail.setText((String) data[3]);
		textFieldId.setText((String) data[4]);
	}
}

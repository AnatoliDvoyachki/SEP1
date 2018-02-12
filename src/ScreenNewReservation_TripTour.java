import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

/**
 * ScreenNewReservation_TripTour class that is the GUI class for the
 * "New Trip reservation" screen
 */
public class ScreenNewReservation_TripTour extends JPanel {

	private JLabel lblTitle;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel lblDestination;
	private JLabel lblNumOfPassengers;

	private JDateChooser dateChooserStart;
	private JDateChooser dateChooserEnd;

	private JTextField textFieldNumOfPassengers;

	private JComboBox comboBoxDestinations;
	private JButton btnCancel;
	private JButton btnNext;

	public ScreenNewReservation_TripTour(BusCompanyController controller) {
		setLayout(null);

		lblTitle = new JLabel("Reservation | Trip | Step 1");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 277, 21);
		add(lblTitle);

		lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(10, 66, 60, 14);
		add(lblStartDate);

		dateChooserStart = new JDateChooser();
		dateChooserStart.setBounds(150, 60, 100, 20);
		add(dateChooserStart);

		lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(10, 97, 60, 14);
		add(lblEndDate);

		dateChooserEnd = new JDateChooser();
		dateChooserEnd.setBounds(150, 91, 100, 20);
		add(dateChooserEnd);

		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 125, 70, 14);
		add(lblDestination);

		comboBoxDestinations = new JComboBox();
		comboBoxDestinations.setBounds(150, 122, 180, 20);
		add(comboBoxDestinations);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 418, 100, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newTripTour-to-main");

		btnNext = new JButton("Next");
		btnNext.setBounds(524, 418, 100, 23);
		add(btnNext);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand("newTripTour-to-newReservationStep2");

		lblNumOfPassengers = new JLabel("Num of passengers");
		lblNumOfPassengers.setBounds(10, 155, 111, 16);
		add(lblNumOfPassengers);

		textFieldNumOfPassengers = new JTextField();
		textFieldNumOfPassengers.setColumns(10);
		textFieldNumOfPassengers.setBounds(150, 153, 77, 20);
		add(textFieldNumOfPassengers);
	}

	public Object[] getInput() {
		Object[] input = new Object[4];

		MyDate startDate = new MyDate(dateChooserStart.getCalendar().get(
				Calendar.DAY_OF_MONTH), dateChooserStart.getCalendar().get(
				Calendar.MONTH) + 1, dateChooserStart.getCalendar().get(
				Calendar.YEAR));
		MyDate endDate = new MyDate(dateChooserEnd.getCalendar().get(
				Calendar.DAY_OF_MONTH), dateChooserEnd.getCalendar().get(
				Calendar.MONTH) + 1, dateChooserEnd.getCalendar().get(
				Calendar.YEAR));

		DateInterval dateInterval = new DateInterval(startDate, endDate);

		input[0] = dateInterval;
		input[1] = comboBoxDestinations.getSelectedItem();
		input[2] = textFieldNumOfPassengers.getText();
		input[3] = true;
		return input;
	}

	/**
	 * 
	 * @param data
	 *            data[0] - DateInterval data[1] - Destination list data[2] -
	 *            NumOfPassengers data[3] - (Destination) selected destination
	 */
	public void fillInput(Object[] data) {
		// in case date[0] is just null do not fill date boxes
		// this be needed when we only want to fill comboBox with available
		// destinations,
		// but we don't want to put anything to date fields
		// like when user starts creating new trip reservation.
		if (data[0] != null) {
			// Date interval to date fields
			DateInterval preDateInterval = (DateInterval) data[0];
			MyDate preStartDate = (MyDate) preDateInterval.getStartDate();
			MyDate preEndDate = (MyDate) preDateInterval.getEndDate();

			Calendar startDate = Calendar.getInstance();
			startDate.set(preStartDate.getYear(), preStartDate.getMonth() - 1,
					preStartDate.getDay(), 0, 0);

			Calendar endDate = Calendar.getInstance();
			endDate.set(preEndDate.getYear(), preEndDate.getMonth() - 1,
					preEndDate.getDay(), 0, 0);

			dateChooserStart.setCalendar(startDate);
			dateChooserEnd.setCalendar(endDate);
		}

		// Other fields
		comboBoxDestinations.setModel(new DefaultComboBoxModel(
				(Object[]) data[1]));
		textFieldNumOfPassengers.setText((String) data[2]);
		comboBoxDestinations.setSelectedItem((Destination) data[3]);

	}

	public void clear() {
		dateChooserStart.setCalendar(null);
		dateChooserEnd.setCalendar(null);
		textFieldNumOfPassengers.setText("");
	}

}

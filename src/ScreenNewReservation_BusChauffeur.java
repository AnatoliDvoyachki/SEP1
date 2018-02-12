import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

/**
 * ScreenNewReservation_BusChauffeur class that is the GUI class for the "New
 * Bus and chauffeur reservation" screen
 */
public class ScreenNewReservation_BusChauffeur extends JPanel {

	private JLabel lblTitle;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel lblDestination;
	private JLabel lblNumOfPassengers;

	private JButton btnCancel;
	private JButton btnNext;

	private JTextField textFieldDestination;
	private JTextField textFieldNumOfPassengers;

	private JDateChooser dateChooserStart;
	private JDateChooser dateChooserEnd;

	public ScreenNewReservation_BusChauffeur(BusCompanyController controller) {
		setLayout(null);

		lblTitle = new JLabel("Reservation | Bus and Chauffeur | Step 1");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(10, 11, 342, 21);
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

		textFieldDestination = new JTextField();
		textFieldDestination.setBounds(150, 122, 180, 20);
		add(textFieldDestination);
		textFieldDestination.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 418, 100, 23);
		add(btnCancel);
		btnCancel.addActionListener(controller);
		btnCancel.setActionCommand("newBusAndChauffeur-to-main");

		btnNext = new JButton("Next");
		btnNext.setBounds(524, 418, 100, 23);
		add(btnNext);
		btnNext.addActionListener(controller);
		btnNext.setActionCommand("newBusAndChauffeur-to-newReservationStep2");

		lblNumOfPassengers = new JLabel("Num of passengers");
		lblNumOfPassengers.setBounds(10, 156, 126, 14);
		add(lblNumOfPassengers);

		textFieldNumOfPassengers = new JTextField();
		textFieldNumOfPassengers.setBounds(150, 153, 77, 20);
		add(textFieldNumOfPassengers);
		textFieldNumOfPassengers.setColumns(10);

	}

	/**
	 * Outputs the DateInterval, Destination and passengers for use in a
	 * Reservation constructor
	 * 
	 * @return Object[0] - DateInterval Object[1] - Destination Object[2] -
	 *         NumberOfPassengers Object[3] - Is Predefined?
	 * 
	 */
	public Object[] getInput() {
		Object[] input = new Object[4];
				
		MyDate startDate = new MyDate(
				dateChooserStart.getCalendar().get(Calendar.DAY_OF_MONTH), 
				dateChooserStart.getCalendar().get(Calendar.MONTH) + 1, 
				dateChooserStart.getCalendar().get(Calendar.YEAR)
				);
		MyDate endDate = new MyDate(
				dateChooserEnd.getCalendar().get(Calendar.DAY_OF_MONTH), 
				dateChooserEnd.getCalendar().get(Calendar.MONTH) + 1, 
				dateChooserEnd.getCalendar().get(Calendar.YEAR)
				);
			
		DateInterval dateInterval = new DateInterval(startDate, endDate);

		Destination destination = new Destination(
				textFieldDestination.getText());

		input[0] = dateInterval; // DateInterval
		input[1] = destination; // Destination
		input[2] = textFieldNumOfPassengers.getText(); // Number of passengers
		input[3] = false; // Predefined or not
		return input;
	}

	/**
	 * 
	 * @param data
	 *            data[0] - DateInterval data[1] - Destination data[2] -
	 *            NumOfPassengers
	 */
	public void fillInput(Object[] data) {
		
		// Date interval to date fields
		DateInterval preDateInterval = (DateInterval) data[0];
		MyDate preStartDate = (MyDate) preDateInterval.getStartDate();
		MyDate preEndDate = (MyDate) preDateInterval.getEndDate();

		Calendar startDate = Calendar.getInstance();
		startDate.set(preStartDate.getYear(), preStartDate.getMonth() - 1, preStartDate.getDay(), 0, 0);  
		
		Calendar endDate = Calendar.getInstance();
		endDate.set(preEndDate.getYear(), preEndDate.getMonth() - 1, preEndDate.getDay(), 0, 0);  

		dateChooserStart.setCalendar(startDate);
		dateChooserEnd.setCalendar(endDate);
		
		// Other fields
		textFieldDestination.setText((String) data[1]);
		textFieldNumOfPassengers.setText((String) data[2]);

	}

	public void clear() {
		dateChooserStart.setCalendar(null);
		dateChooserEnd.setCalendar(null);
		textFieldDestination.setText("");
		textFieldNumOfPassengers.setText("");
	}

}

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

/**
 * ScreenMain class, that is the Main GUI screen
 */
public class ScreenMain extends JPanel {

	private JLabel lblTitle;
	private JLabel lblNewReservation;
	private JLabel lblManage;

	private JButton btnNewBusAndChauffeur;
	private JButton btnNewTrip;
	private JButton btnReservations;
	private JButton btnChauffeurs;
	private JButton btnBuses;
	private JButton btnDestinations;

	public ScreenMain(BusCompanyController controller) {

		setLayout(null);

		lblTitle = new JLabel("VIA Bus");
		lblTitle.setForeground(Color.GRAY);
		lblTitle.setFont(lblTitle.getFont().deriveFont(
				lblTitle.getFont().getStyle() & ~Font.BOLD, 17f));
		lblTitle.setBounds(290, 11, 60, 23);
		add(lblTitle);

		lblNewReservation = new JLabel("Create Reservation");
		lblNewReservation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewReservation.setBounds(268, 151, 103, 15);
		add(lblNewReservation);

		btnNewBusAndChauffeur = new JButton("Bus and Chauffeur");
		btnNewBusAndChauffeur.setBounds(175, 177, 140, 23);
		add(btnNewBusAndChauffeur);
		btnNewBusAndChauffeur.addActionListener(controller);
		btnNewBusAndChauffeur.setActionCommand("main-to-newBusAndChauffeur");

		btnNewTrip = new JButton("Trip");
		btnNewTrip.setBounds(325, 177, 140, 23);
		add(btnNewTrip);
		btnNewTrip.addActionListener(controller);
		btnNewTrip.setActionCommand("main-to-newTripTour");

		lblManage = new JLabel("Manage");
		lblManage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManage.setBounds(299, 227, 42, 15);
		add(lblManage);

		btnReservations = new JButton("Reservations");
		btnReservations.setBounds(175, 253, 140, 23);
		add(btnReservations);
		btnReservations.addActionListener(controller);
		btnReservations.setActionCommand("main-to-manageReservation");

		btnChauffeurs = new JButton("Chauffeurs");
		btnChauffeurs.setBounds(325, 253, 140, 23);
		add(btnChauffeurs);
		btnChauffeurs.addActionListener(controller);
		btnChauffeurs.setActionCommand("main-to-manageChauffeurs");

		btnBuses = new JButton("Buses");
		btnBuses.setBounds(325, 287, 140, 23);
		add(btnBuses);
		btnBuses.addActionListener(controller);
		btnBuses.setActionCommand("main-to-manageBuses");

		btnDestinations = new JButton("Destinations");
		btnDestinations.setBounds(175, 287, 140, 23);
		add(btnDestinations);
		btnDestinations.addActionListener(controller);
		btnDestinations.setActionCommand("main-to-manageDestinations");

	}

	public String[] getInput() {
		return null;
	}

	public void clear() {

	}

}

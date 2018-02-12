import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.InputMismatchException;

import javax.swing.*;

/**
 * BusCompanyController class, that serves as a connection between the front end and the
 * back end of the system
 */
public class BusCompanyController implements ActionListener {
	// Fields
	private BusCompanyGUI view;
	private BusCompany model;

	private Object[] tempInput;

	private boolean edit = false;
	private String typeOfReservation;
	private int selectedRowIndex;

	private Reservation editedReservation;
	private Chauffeur editedChauffeur;
	private Bus editedBus;
	private Destination editedDestination;

	/**
	 * Constructor for the BusCompanyController class.
	 * 
	 * @param view
	 *            The view that you want to set
	 * @param model
	 *            The model that you want to set
	 */
	public BusCompanyController(BusCompanyGUI view, BusCompany model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch (cmd) {

		/**
		 * Main window
		 */
		case ("main-to-newBusAndChauffeur"): {
			view.clear(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);
			view.clear(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			view.setMode(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			break;
		}
		case ("main-to-newTripTour"): {
			view.clear(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);
			view.clear(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			view.setMode(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			Object[] dataToFill = { null, model.getDestinations(), null, null };
			view.fillInput(dataToFill);
			break;
		}
		case ("main-to-manageReservation"): {
			executeWriteReservationsToTable();
			break;
		}
		case ("main-to-manageChauffeurs"): {
			executeWriteChauffeursToTable();
			break;
		}
		case ("main-to-manageBuses"): {
			executeWriteBusesToTable();
			break;
		}
		case ("main-to-manageDestinations"): {
			executeWriteDestinationsToTable();
			break;
		}

		/**
		 * New Bus and chauffeur reservation window step 1
		 */
		case ("newBusAndChauffeur-to-main"): {
			typeOfReservation = "";
			view.setMode(BusCompanyGUI.MODE_MAIN);
			if (edit) {
				model.addReservation(editedReservation);
			}
			edit = false;
			break;
		}
		case ("newBusAndChauffeur-to-newReservationStep2"): {
			typeOfReservation = "busAndChauffeur";
			if (edit) {
				executeResEditToNextStep();
			} else {
				executeResNewToNextStep();
			}
			break;
		}

		/**
		 * New Trip and Tour resevation window step 1
		 */
		case ("newTripTour-to-main"): {
			typeOfReservation = "";
			view.setMode(BusCompanyGUI.MODE_MAIN);
			if (edit) {
				model.addReservation(editedReservation);
			}
			edit = false;
			break;
		}
		case ("newTripTour-to-newReservationStep2"): {
			typeOfReservation = "tripAndTour";
			if (edit) {
				executeResEditToNextStep();
			} else {
				executeResNewToNextStep();
			}
			break;
		}

		/**
		 * New reservation step 2
		 */
		case ("newReservationStep2-back"): {
			if (typeOfReservation.equals("busAndChauffeur")) {
				view.setMode(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			} else if (typeOfReservation.equals("tripAndTour")) {
				view.setMode(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			}
			break;
		}
		case ("newReservationStep2-save"): {
			executeCreateReservation(typeOfReservation);
			break;
		}

		case ("newReservationStep2-to-main"): {
			typeOfReservation = "";
			if (edit) {
				model.addReservation(editedReservation);
			}
			edit = false;
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}

		/**
		 * Manage reservations
		 */
		case ("manageReservation-to-main"): {
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}
		case ("manageReservation-to-newBusAndChauffeur"): {
			view.clear(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);
			view.clear(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			view.setMode(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			break;
		}
		case ("manageReservation-to-newTripTour"): {
			view.clear(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);
			view.clear(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			view.setMode(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			Object[] dataToFill = { null, model.getDestinations(), null, null };
			view.fillInput(dataToFill);
			break;
		}
		case ("manageReservation-to-edit"): {
			executeEditReservation();
			break;
		}
		case ("manageReservation-delete"): {
			selectedRowIndex = (int) view.getInput()[0];
			model.removeReservation(model.getReservations().get(
					selectedRowIndex));
			executeWriteReservationsToTable();
			view.setMode(BusCompanyGUI.MODE_MAN_RESERVATIONS);
			break;
		}

		/*
		 * Manage chauffeurs
		 */
		/**
		 * Manage chauffeurs
		 */
		case ("manageChauffeurs-to-main"): {
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}
		case ("manageChauffeurs-to-edit"): {
			executeEditChauffeur();
			break;
		}
		case ("manageChauffeurs-delete"): {
			selectedRowIndex = (int) view.getInput()[0];
			model.removeChauffeur(model.getChauffeurs()[selectedRowIndex]);
			executeWriteChauffeursToTable();
			view.setMode(BusCompanyGUI.MODE_MAN_CHAUFFEURS);
			break;
		}
		case ("manageChauffeurs-to-new"): {
			view.clear(BusCompanyGUI.MODE_NEW_CHAUFFEUR);
			view.setMode(BusCompanyGUI.MODE_NEW_CHAUFFEUR);
			break;
		}
		case ("newChauffeur-save"): {
			executeCreateChauffeur();
			break;
		}
		case ("newChauffeur-to-main"): {
			if (edit) {
				model.addChauffeur(editedChauffeur);
			}
			edit = false;
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}

		/*
		 * Manage buses
		 */
		/**
		 * Manage buses
		 */
		case ("manageBuses-to-screenMain"): {
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}
		case ("manageBuses-to-edit"): {
			executeEditBus();
			break;
		}
		case ("manageBuses-delete"): {
			selectedRowIndex = (int) view.getInput()[0];
			model.removeBus(model.getBuses()[selectedRowIndex]);
			executeWriteBusesToTable();
			view.setMode(BusCompanyGUI.MODE_MAN_BUSES);
			break;
		}
		case ("manageBuses-to-new"): {
			view.clear(BusCompanyGUI.MODE_NEW_BUS);
			view.setMode(BusCompanyGUI.MODE_NEW_BUS);
			break;
		}
		case ("newBus-save"): {
			executeCreateBus();
			break;
		}
		case ("newBus-to-main"): {
			if (edit) {
				model.addBus(editedBus);
			}
			edit = false;
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}

		/*
		 * Manage destinations
		 */
		/**
		 * Manage destinations
		 */
		case ("manageDestinations-to-main"): {
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}
		case ("manageDestinations-to-edit"): {
			executeEditDestination();
			break;
		}
		case ("manageDestinations-delete"): {
			selectedRowIndex = (int) view.getInput()[0];
			model.removeDestination(model.getDestinations()[selectedRowIndex]);
			executeWriteDestinationsToTable();
			view.setMode(BusCompanyGUI.MODE_MAN_DESTINATIONS);
			break;
		}
		case ("manageDestinations-to-new"): {
			view.clear(BusCompanyGUI.MODE_NEW_DESTINATION);
			view.setMode(BusCompanyGUI.MODE_NEW_DESTINATION);
			break;
		}
		case ("newDestination-save"): {
			executeCreateDestination();
			break;
		}
		case ("newDestination-to-main"): {
			if (edit) {
				model.addDestination(editedDestination);
			}
			edit = false;
			view.setMode(BusCompanyGUI.MODE_MAIN);
			break;
		}
		}
	}

	/*
	 * Write to Table methods
	 */

	/**
	 * Method that fills the table in screen "ManageReservations" with the data
	 * from the model
	 */
	private void executeWriteReservationsToTable() {
		view.setMode(BusCompanyGUI.MODE_MAN_RESERVATIONS);

		// create 2 dimensional array representing data in table
		// there are 13 columns and as many rows as there is reservations
		Object[][] reservationsData = new Object[model.getReservations().size()][12];

		// fill that 2 dimensional array with data from model
		for (int i = 0; i < model.getReservations().size(); i++) {
			if (model.getReservations().get(i).isPredefined()) {
				reservationsData[i][0] = "Predetermined";
			} else {
				reservationsData[i][0] = "Custom";
			}
			reservationsData[i][1] = model.getReservations().get(i)
					.getDateInterval().getStartDate();
			reservationsData[i][2] = model.getReservations().get(i)
					.getDateInterval().getEndDate();
			reservationsData[i][3] = model.getReservations().get(i)
					.getChauffeur();
			reservationsData[i][4] = model.getReservations().get(i).getBus();
			reservationsData[i][5] = model.getReservations().get(i)
					.getDestination();
			reservationsData[i][6] = model.getReservations().get(i)
					.getPassengers();
			reservationsData[i][7] = model.getReservations().get(i)
					.getCustomer().getName();
			reservationsData[i][8] = model.getReservations().get(i)
					.getCustomer().getAddress();
			reservationsData[i][9] = model.getReservations().get(i)
					.getCustomer().getPhoneNumber();
			reservationsData[i][10] = model.getReservations().get(i).getPrice();
			reservationsData[i][11] = model.getReservations().get(i).getNote();
		}

		// send this data to be viewed in table
		Object[] dataToFill = { reservationsData };
		view.fillInput(dataToFill);
	}

	/**
	 * Method that writes the bus objects to the table
	 */
	private void executeWriteBusesToTable() {
		view.setMode(BusCompanyGUI.MODE_MAN_BUSES);

		Object[][] busesData = new Object[model.getBuses().length][3];

		for (int i = 0; i < model.getBuses().length; i++) {
			busesData[i][0] = model.getBuses()[i].getId();
			busesData[i][1] = model.getBuses()[i].getType();
			busesData[i][2] = model.getBuses()[i].getNumSeats();
		}

		Object[] dataToFill = { busesData };
		view.fillInput(dataToFill);
	}

	/**
	 * Method that writes the chauffeur objects to the table
	 */
	private void executeWriteChauffeursToTable() {
		view.setMode(BusCompanyGUI.MODE_MAN_CHAUFFEURS);

		Object[][] chauffeursData = new Object[model.getChauffeurs().length][5];

		for (int i = 0; i < model.getChauffeurs().length; i++) {
			chauffeursData[i][0] = model.getChauffeurs()[i].getId();
			chauffeursData[i][1] = model.getChauffeurs()[i].getName();
			chauffeursData[i][2] = model.getChauffeurs()[i].getAddress();
			chauffeursData[i][3] = model.getChauffeurs()[i].getPhoneNumber();
			chauffeursData[i][4] = model.getChauffeurs()[i].getEmail();
		}

		Object[] dataToFill = { chauffeursData };
		view.fillInput(dataToFill);
	}

	/**
	 * Method that writes the destination objects to the table
	 */
	private void executeWriteDestinationsToTable() {
		view.setMode(BusCompanyGUI.MODE_MAN_DESTINATIONS);

		Object[][] destinationsData = new Object[model.getDestinations().length][1];

		for (int i = 0; i < model.getDestinations().length; i++) {
			destinationsData[i][0] = model.getDestinations()[i]
					.getDestination();
		}

		Object[] dataToFill = { destinationsData };
		view.fillInput(dataToFill);
	}

	/**
	 * Method for editing a reservation
	 */
	private void executeEditReservation() {
		edit = true;

		selectedRowIndex = (int) view.getInput()[0];

		// save reservation that is being edited to temporary variable
		// then delete it from model (will be added back when editing is
		// finished/canceled)
		editedReservation = model.getReservations().get(selectedRowIndex);
		model.removeReservation(model.getReservations().get(selectedRowIndex));

		// fill input fields with values of edited reservation
		if (editedReservation.isPredefined()) {
			typeOfReservation = "tripAndTour";
			view.setMode(BusCompanyGUI.MODE_NEW_RES_TRIP_TOUR);
			Object[] dataToFill = { editedReservation.getDateInterval(),
					model.getDestinations(),
					Integer.toString(editedReservation.getPassengers()),
					editedReservation.getDestination() };
			view.fillInput(dataToFill);
		} else {
			typeOfReservation = "busAndChauffeur";
			view.setMode(BusCompanyGUI.MODE_NEW_RES_BUS_CHAUFFEUR);
			Object[] dataToFill = { editedReservation.getDateInterval(),
					editedReservation.getDestination().toString(),
					Integer.toString(editedReservation.getPassengers()), };
			view.fillInput(dataToFill);
		}

	}

	/**
	 * Method for managing a bus
	 */
	private void executeEditBus() {
		edit = true;

		selectedRowIndex = (int) view.getInput()[0];
		editedBus = model.getBuses()[selectedRowIndex];
		model.removeBus(model.getBuses()[selectedRowIndex]);

		view.setMode(BusCompanyGUI.MODE_NEW_BUS);

		Object[] dataToFill = { editedBus.getType(),
				Integer.toString(editedBus.getNumSeats()),
				Integer.toString(editedBus.getId()) };
		view.fillInput(dataToFill);
	}

	/**
	 * Method for managing a chauffeur
	 */
	private void executeEditChauffeur() {
		edit = true;

		selectedRowIndex = (int) view.getInput()[0];
		editedChauffeur = model.getChauffeurs()[selectedRowIndex];
		model.removeChauffeur(model.getChauffeurs()[selectedRowIndex]);

		view.setMode(BusCompanyGUI.MODE_NEW_CHAUFFEUR);

		Object[] dataToFill = { editedChauffeur.getName(),
				editedChauffeur.getAddress(), editedChauffeur.getPhoneNumber(),
				editedChauffeur.getEmail(),
				Integer.toString(editedChauffeur.getId()) };
		view.fillInput(dataToFill);
	}

	/**
	 * Method for editing a destination
	 */
	private void executeEditDestination() {
		edit = true;

		selectedRowIndex = (int) view.getInput()[0];
		editedDestination = model.getDestinations()[selectedRowIndex];
		model.removeDestination(model.getDestinations()[selectedRowIndex]);

		view.setMode(BusCompanyGUI.MODE_NEW_DESTINATION);

		Object[] dataToFill = { editedDestination.getDestination() };
		view.fillInput(dataToFill);
	}

	/**
	 * Method that is used when going to the next step when editing or creating
	 * a new resevation
	 */
	private void executeResEditToNextStep() {
		try {
			tempInput = view.getInput();

			DateInterval dateInterval = (DateInterval) tempInput[0];
			int numOfPassengers = Integer.parseInt((String) tempInput[2]);

			// validation
			if (dateInterval.getEndDate().isBefore(dateInterval.getStartDate())) {
				throw new InputMismatchException();
			} else if (numOfPassengers < 0) {
				throw new InputMismatchException();
			}

			// change viewed screen
			view.setMode(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);

			Object[] dataToFill = {
					model.getAllAvailableChauffeurs((DateInterval) tempInput[0]),
					model.getAllAvailableBuses((DateInterval) tempInput[0],
							Integer.parseInt((String) tempInput[2])),
					editedReservation.getCustomer().getName(),
					editedReservation.getCustomer().getAddress(),
					editedReservation.getCustomer().getPhoneNumber(),
					Double.toString(editedReservation.getPrice()),
					editedReservation.getNote(),
					"Date: " + tempInput[0] + "    Destination: "
							+ tempInput[1] + "   Number of Passengers: "
							+ tempInput[2], editedReservation.getChauffeur(),
					editedReservation.getBus()

			};
			view.fillInput(dataToFill);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}
	}

	/**
	 * Method that saves the input, so that it can be used when saving after the
	 * second step
	 */
	private void executeResNewToNextStep() {
		try {
			// remember the input, so it can be used when saving after second
			// step.
			tempInput = view.getInput();

			if (view.getInput()[1].toString().equals("")) {
				throw new InputMismatchException();
			}

			DateInterval dateInterval = (DateInterval) tempInput[0];
			int numOfPassengers = Integer.parseInt((String) tempInput[2]);

			// validation
			if (dateInterval.getEndDate().isBefore(dateInterval.getStartDate())) {
				throw new InputMismatchException();
			} else if (numOfPassengers < 0) {
				throw new InputMismatchException();
			}

			// change viewed screen
			view.setMode(BusCompanyGUI.MODE_NEW_RES_STEP_TWO);

			Object[] dataToFill = {
					model.getAllAvailableChauffeurs((DateInterval) tempInput[0]),
					model.getAllAvailableBuses((DateInterval) tempInput[0],
							Integer.parseInt((String) tempInput[2])),
					null,
					null,
					null,
					null,
					null,
					"Date: " + tempInput[0] + "    Destination: "
							+ tempInput[1] + "   Number of Passengers: "
							+ tempInput[2], null, null

			};
			view.fillInput(dataToFill);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}

	}

	/**
	 * Method that is used for creating a reservation
	 * 
	 * @param typeOfReservation
	 *            The type of the reservation
	 */
	private void executeCreateReservation(String typeOfReservation) {
		boolean isPredefined;
		if (typeOfReservation.equals("busAndChauffeur")) {
			isPredefined = false;
		} else {
			isPredefined = true;
		}

		try {
			if ((view.getInput()[0]) == null || // chauffeur is not selected
					(view.getInput()[1]) == null || // bus is not selected
					((String) view.getInput()[2]).equals("") || // customer name
																// is empty
					((String) view.getInput()[3]).equals("") || // customer
																// address is
																// empty
					((String) view.getInput()[4]).equals("") || // customer
																// phoneNumber
																// is empty
					Double.parseDouble((String) view.getInput()[5]) < 0 // price
																		// is
																		// bellow
																		// 0
			) {
				throw new InputMismatchException();
			}

			Customer tempCustomer = new Customer((String) view.getInput()[2],
					(String) view.getInput()[3], (String) view.getInput()[4]);
			Reservation tempReservation = new Reservation(isPredefined,
					Integer.parseInt(tempInput[2].toString()),
					Double.parseDouble(view.getInput()[5].toString()),
					tempCustomer, (Chauffeur) view.getInput()[0],
					(Bus) view.getInput()[1], (Destination) tempInput[1],
					(DateInterval) tempInput[0], (String) view.getInput()[6]);

			model.addReservation(tempReservation);
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Reservation Successfully Created");
			view.setMode(BusCompanyGUI.MODE_MAIN);
			edit = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}

	}

	/**
	 * Method that is used for adding a new chauffeur
	 */
	private void executeCreateChauffeur() {
		try {
			// Validation - require all fields
			if (view.getInput()[0].equals("") || view.getInput()[1].equals("")
					|| view.getInput()[2].equals("")
					|| view.getInput()[3].equals("")
					|| view.getInput()[4].equals("")) {
				throw new InputMismatchException();
			}
			Chauffeur tempChauffeur = new Chauffeur(
					Integer.parseInt((String) view.getInput()[4]),
					(String) view.getInput()[0], (String) view.getInput()[1],
					(String) view.getInput()[2], (String) view.getInput()[3]);

			model.addChauffeur(tempChauffeur);
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Chauffeur Successfully Created");
			view.setMode(BusCompanyGUI.MODE_MAIN);
			edit = false;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}
	}

	/**
	 * Method that is used for adding a new bus
	 */
	private void executeCreateBus() {
		try {
			// Validation - require all fields
			if (view.getInput()[0].equals("") || view.getInput()[1].equals("")
					|| view.getInput()[2].equals("")) {
				throw new InputMismatchException();
			}

			Bus tempBus = new Bus(
					Integer.parseInt((String) view.getInput()[2]),
					Integer.parseInt((String) view.getInput()[1]),
					(String) view.getInput()[0]);

			model.addBus(tempBus);
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Bus Successfully Created");
			view.setMode(BusCompanyGUI.MODE_MAIN);
			edit = false;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}

	}

	/**
	 * Method that is used for adding a new destination
	 */
	private void executeCreateDestination() {
		try {

			// Validation - require all fields
			if (view.getInput()[0].equals("")) {
				throw new InputMismatchException();
			}

			Destination tempDestination = new Destination(
					(String) view.getInput()[0]);

			model.addDestination(tempDestination);
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Destination Successfully Created");
			view.setMode(BusCompanyGUI.MODE_MAIN);
			edit = false;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getContentPane(),
					"Invalid information");
			e.printStackTrace();
		}

	}

}
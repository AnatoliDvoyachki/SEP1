import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class that creates the front end of the system
 */
public class BusCompanyGUI extends JFrame {
	// Fields
	private BusCompany model;

	private ScreenMain screenMain;
	private ScreenNewReservation_BusChauffeur screenNewResBusChauffeur;
	private ScreenNewReservation_TripTour screenNewResTripTour;
	private ScreenNewReservation_Step2 screenNewResStepTwo;
	private ScreenManageReservations screenManReservations;
	private ScreenManageChauffeurs screenManChauffeur;
	private ScreenManageDestinations screenManDestinations;
	private ScreenManageBuses screenManBuses;
	private ScreenNewDestination screenNewDestination;
	private ScreenNewBus screenNewBus;
	private ScreenNewChauffeur screenNewChauffeur;

	private JPanel cardPanel;
	private CardLayout cardLayout;

	private String mode;
	public static final String MODE_MAIN = "Add";
	public static final String MODE_NEW_RES_BUS_CHAUFFEUR = "NewResBusChauffeur";
	public static final String MODE_NEW_RES_TRIP_TOUR = "NewResTripTour";
	public static final String MODE_NEW_RES_STEP_TWO = "NewResStepTwo";
	public static final String MODE_MAN_RESERVATIONS = "ManReservations";
	public static final String MODE_MAN_CHAUFFEURS = "ManChauffeurs";
	public static final String MODE_MAN_DESTINATIONS = "screenManDestinations";
	public static final String MODE_MAN_BUSES = "ManBuses";
	public static final String MODE_NEW_DESTINATION = "NewDestination";
	public static final String MODE_NEW_BUS = "NewBus";
	public static final String MODE_NEW_CHAUFFEUR = "NewChauffeur";

	/**
	 * Constructor for the View class.
	 * 
	 * @param model
	 *            The BusCompany class that you want to use
	 */
	public BusCompanyGUI(BusCompany model) {
		super("VIA Bus");
		this.model = model;

		// Window Settings
		setResizable(false);
		setSize(640, 480); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create Handler
		BusCompanyController handler = new BusCompanyController(this, model);

		// Create Screens
		screenMain = new ScreenMain(handler);
		screenNewResBusChauffeur = new ScreenNewReservation_BusChauffeur(
				handler);
		screenNewResTripTour = new ScreenNewReservation_TripTour(handler);
		screenNewResStepTwo = new ScreenNewReservation_Step2(handler);
		screenManReservations = new ScreenManageReservations(handler);
		screenManChauffeur = new ScreenManageChauffeurs(handler);
		screenManDestinations = new ScreenManageDestinations(handler);
		screenManBuses = new ScreenManageBuses(handler);
		screenNewDestination = new ScreenNewDestination(handler);
		screenNewBus = new ScreenNewBus(handler);
		screenNewChauffeur = new ScreenNewChauffeur(handler);

		// create cardPanel and add screens to it
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.add(screenMain, MODE_MAIN);
		cardPanel.add(screenNewResBusChauffeur, MODE_NEW_RES_BUS_CHAUFFEUR);
		cardPanel.add(screenNewResTripTour, MODE_NEW_RES_TRIP_TOUR);
		cardPanel.add(screenNewResStepTwo, MODE_NEW_RES_STEP_TWO);
		cardPanel.add(screenManReservations, MODE_MAN_RESERVATIONS);
		cardPanel.add(screenManChauffeur, MODE_MAN_CHAUFFEURS);
		cardPanel.add(screenManDestinations, MODE_MAN_DESTINATIONS);
		cardPanel.add(screenManBuses, MODE_MAN_BUSES);
		cardPanel.add(screenNewDestination, MODE_NEW_DESTINATION);
		cardPanel.add(screenNewBus, MODE_NEW_BUS);
		cardPanel.add(screenNewChauffeur, MODE_NEW_CHAUFFEUR);

		// Set First Screen
		setContentPane(cardPanel);

		// View the Window
		setVisible(true);
	}

	/**
	 * Method that sets the mode of the view
	 * 
	 * @param mode
	 *            The mode of the view that you want
	 */
	public void setMode(String mode) {
		this.mode = mode;
		cardLayout.show(cardPanel, mode);
	}

	/**
	 * Method that returns the input from the user
	 * 
	 * @return Returns an array with the input from the front end of the system
	 */
	public Object[] getInput() {
		if (mode.equals(MODE_MAIN))
			return screenMain.getInput();
		else if (mode.equals(MODE_NEW_RES_BUS_CHAUFFEUR))
			return screenNewResBusChauffeur.getInput();
		else if (mode.equals(MODE_NEW_RES_TRIP_TOUR))
			return screenNewResTripTour.getInput();
		else if (mode.equals(MODE_NEW_RES_STEP_TWO))
			return screenNewResStepTwo.getInput();
		else if (mode.equals(MODE_MAN_RESERVATIONS))
			return screenManReservations.getInput();
		else if (mode.equals(MODE_MAN_CHAUFFEURS))
			return screenManChauffeur.getInput();
		else if (mode.equals(MODE_MAN_DESTINATIONS))
			return screenManDestinations.getInput();
		else if (mode.equals(MODE_MAN_BUSES))
			return screenManBuses.getInput();
		else if (mode.equals(MODE_NEW_DESTINATION))
			return screenNewDestination.getInput();
		else if (mode.equals(MODE_NEW_BUS))
			return screenNewBus.getInput();
		else if (mode.equals(MODE_NEW_CHAUFFEUR))
			return screenNewChauffeur.getInput();
		return null;
	}

	/**
	 * Method that fills the input fields in the screens in an array
	 * 
	 * @param obj
	 *            The input
	 */
	public void fillInput(Object[] obj) {
		if (mode.equals(MODE_MAIN)) {
		} else if (mode.equals(MODE_NEW_RES_BUS_CHAUFFEUR))
			screenNewResBusChauffeur.fillInput(obj);
		else if (mode.equals(MODE_NEW_RES_TRIP_TOUR))
			screenNewResTripTour.fillInput(obj);
		else if (mode.equals(MODE_NEW_RES_STEP_TWO))
			screenNewResStepTwo.fillInput(obj);
		else if (mode.equals(MODE_MAN_RESERVATIONS))
			screenManReservations.fillInput(obj);
		else if (mode.equals(MODE_MAN_BUSES))
			screenManBuses.fillInput(obj);
		else if (mode.equals(MODE_MAN_CHAUFFEURS))
			screenManChauffeur.fillInput(obj);
		else if (mode.equals(MODE_MAN_DESTINATIONS))
			screenManDestinations.fillInput(obj);
		else if (mode.equals(MODE_NEW_CHAUFFEUR))
			screenNewChauffeur.fillInput(obj);
		else if (mode.equals(MODE_NEW_BUS))
			screenNewBus.fillInput(obj);
		else if (mode.equals(MODE_NEW_DESTINATION))
			screenNewDestination.fillInput(obj);
	}

	/**
	 * Method that clears the screens
	 * 
	 * @param screen
	 *            The screen that you want to clear
	 */
	public void clear(String screen) {
		if (screen.equals(MODE_MAIN))
			screenMain.clear();
		else if (screen.equals(MODE_NEW_RES_BUS_CHAUFFEUR))
			screenNewResBusChauffeur.clear();
		else if (screen.equals(MODE_NEW_RES_TRIP_TOUR))
			screenNewResTripTour.clear();
		else if (screen.equals(MODE_NEW_RES_STEP_TWO))
			screenNewResStepTwo.clear();
		else if (screen.equals(MODE_MAN_RESERVATIONS))
			screenManReservations.clear();
		else if (screen.equals(MODE_MAN_CHAUFFEURS))
			screenManChauffeur.clear();
		else if (screen.equals(MODE_MAN_DESTINATIONS))
			screenManDestinations.clear();
		else if (screen.equals(MODE_MAN_BUSES))
			screenManBuses.clear();
		else if (screen.equals(MODE_NEW_DESTINATION))
			screenNewDestination.clear();
		else if (screen.equals(MODE_NEW_BUS))
			screenNewBus.clear();
		else if (screen.equals(MODE_NEW_CHAUFFEUR))
			screenNewChauffeur.clear();
	}
}

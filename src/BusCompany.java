
import java.io.IOException;
import java.io.Serializable;

import java.util.*;

/**
 * BusCompany class which represents a bus company. This class has an
 * aggregation relationship with Reservation, Bus, Chauffeur and Destination.
 * This class is associated with BusCompanyFile and BusCompanyController
 * classes.
 * */
public class BusCompany implements Serializable {
	// Fields
	private ArrayList<Reservation> reservations;
	private ArrayList<Customer> customers;
	private ArrayList<Chauffeur> chauffeurs;
	private ArrayList<Bus> buses;
	private ArrayList<Destination> destinations;

	/**
	 * Constructor for the BusCompany class
	 */
	public BusCompany() {
		reservations = new ArrayList<>();
		customers = new ArrayList<>();
		chauffeurs = new ArrayList<>();
		buses = new ArrayList<>();
		destinations = new ArrayList<>();
	}

	// Methods

	/**
	 * Returns the list of all reservations in the system
	 * 
	 * @return All the reservations in the system
	 */
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * Returns the list of reservations for a certain chauffeur
	 * 
	 * @param chauffeur
	 *            The chauffeur whose reservations you want
	 * @return The list of reservations of the chauffeur
	 */
	public ArrayList<Reservation> getReservations(Chauffeur chauffeur) {
		ArrayList<Reservation> outputList = new ArrayList<>();
		for (Reservation r : reservations) {
			if (r.getChauffeur().equals(chauffeur)) {
				outputList.add(r);
			}
		}
		return outputList;
	}

	/**
	 * Returns the list of reservations for a certain bus
	 * 
	 * @param bus
	 *            The bus which reservations you want
	 * @return The list of reservations of the bus
	 */
	public ArrayList<Reservation> getReservations(Bus bus) {
		ArrayList<Reservation> outputList = new ArrayList<>();
		for (Reservation r : reservations) {
			if (r.getBus().equals(bus)) {
				outputList.add(r);
			}
		}
		return outputList;
	}

	/**
	 * Returns the list of reservations for a certain customer
	 * 
	 * @param customer
	 *            The customer whose reservations you want
	 * @return The list of reservations of the bus
	 */
	public ArrayList<Reservation> getReservations(Customer customer) {
		ArrayList<Reservation> outputList = new ArrayList<>();
		for (Reservation r : reservations) {
			if (r.getCustomer().equals(customer)) {
				outputList.add(r);
			}
		}
		return outputList;
	}

	/**
	 * Returns the list of all customers in the system
	 * 
	 * @return customers All the customers in the system
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Returns the list of all chauffeurs in the system
	 * 
	 * @return All the chauffeurs in the system
	 */
	public Chauffeur[] getChauffeurs() {
		Chauffeur[] outputList = new Chauffeur[this.chauffeurs.size()];
		outputList = this.chauffeurs.toArray(outputList);
		return outputList;
	}

	/**
	 * Returns the list of all buses in the system
	 * 
	 * @return All the buses in the system
	 */
	public Bus[] getBuses() {
		Bus[] outputList = new Bus[this.buses.size()];
		outputList = this.buses.toArray(outputList);
		return outputList;
	}

	/**
	 * Returns the list of all destinations in the system
	 * 
	 * @return All the destinations in the system
	 */
	public Destination[] getDestinations() {
		Destination[] outputList = new Destination[this.destinations.size()];
		outputList = this.destinations.toArray(outputList);
		return outputList;
	}

	/**
	 * Adds a reservation to the list of reservations
	 * 
	 * @param reservation
	 *            The new reservation to be stored in the system
	 */
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
		saveFile();
	}

	/**
	 * Adds a customer to the list of customers
	 * 
	 * @param customer
	 *            The new customer to be stored in the system
	 */
	public void addCustomer(Customer customer) {
		customers.add(customer);
		saveFile();
	}

	/**
	 * Adds a chauffeur to the list of chauffeurs
	 * 
	 * @param chauffeur
	 *            The new chauffeur to be stored in the system
	 */
	public void addChauffeur(Chauffeur chauffeur) {
		chauffeurs.add(chauffeur);
		saveFile();
	}

	/**
	 * Adds a bus to the list of buses
	 * 
	 * @param bus
	 *            The new bus to be stored in the system
	 */
	public void addBus(Bus bus) {
		buses.add(bus);
		saveFile();
	}

	/**
	 * Adds a destination to the list of destinations
	 * 
	 * @param destination
	 *            The new destination to be stored in the system
	 */
	public void addDestination(Destination destination) {
		destinations.add(destination);
		saveFile();
	}

	/**
	 * Removes a reservations from the list of reservations
	 * 
	 * @param reservation
	 *            The reservation to be removed from the system
	 */
	public void removeReservation(Reservation reservation) {
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).equals(reservation)) {
				reservations.remove(i);
				break;
			}
		}
		saveFile();
	}

	/**
	 * Removes a customer from the list of customers
	 * 
	 * @param customer
	 *            The customer to be removed from the system
	 */
	public void removeCustomer(Customer customer) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).equals(customer)) {
				customers.remove(i);
				break;
			}
		}
		saveFile();
	}

	/**
	 * Removes a chauffeur from the list of chauffeurs
	 * 
	 * @param chauffeur
	 *            The chauffeur to be removed from the system
	 */
	public void removeChauffeur(Chauffeur chauffeur) {
		for (int i = 0; i < chauffeurs.size(); i++) {
			if (chauffeurs.get(i).equals(chauffeur)) {
				chauffeurs.remove(i);
				break;
			}
		}
		saveFile();
	}

	/**
	 * Removes a bus from the list of buses
	 * 
	 * @param bus
	 *            The bus to be removed from the system
	 */
	public void removeBus(Bus bus) {
		for (int i = 0; i < buses.size(); i++) {
			if (buses.get(i).equals(bus)) {
				buses.remove(i);
				break;
			}
		}
		saveFile();
	}

	/**
	 * Removes a destination from the list of destinations
	 * 
	 * @param destination
	 *            The destination to be removed from the system
	 */
	public void removeDestination(Destination destination) {
		for (int i = 0; i < destinations.size(); i++) {
			if (destinations.get(i).equals(destination)) {
				destinations.remove(i);
				break;
			}
		}
		saveFile();
	}

	/**
	 * Returns a list of all available chauffeurs for a given date interval
	 * 
	 * @param newDateInterval
	 *            The date interval for which available chauffeurs are needed
	 * @return The list of available chauffeurs
	 */
	public Chauffeur[] getAllAvailableChauffeurs(DateInterval newDateInterval) {
		ArrayList<Chauffeur> list = new ArrayList<>();
		for (Chauffeur c : chauffeurs) {
			if (c.isAvailable(newDateInterval, getReservations(c))) {
				list.add(c);
			}
		}

		Chauffeur[] outputList = new Chauffeur[list.size()];
		outputList = list.toArray(outputList);
		return outputList;
	}

	/**
	 * Returns a list of all available buses for a given date interval and
	 * number of passengers
	 * 
	 * @param newDateInterval
	 *            The date interval for which available buses are needed
	 * @param numPassengers
	 *            The number of passengers the buses should be able to hold
	 * @return The list of available buses
	 */
	public Bus[] getAllAvailableBuses(DateInterval newDateInterval,
			int numPassengers) {
		ArrayList<Bus> list = new ArrayList<>();
		for (Bus b : buses) {
			if (b.isAvailable(newDateInterval, numPassengers,
					getReservations(b))) {
				list.add(b);
			}
		}

		Bus[] outputList = new Bus[list.size()];
		outputList = list.toArray(outputList);
		return outputList;
	}

	/**
	 * Saves the data to the BusCompanyFile class
	 */
	public void saveFile() {
		try {
			BusCompanyFile.saveBusCompanyData(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

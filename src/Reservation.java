import java.io.Serializable;

/**
 * Reservation class that represents a reservation. This class is composed with
 * the DateInterval class. This class is associated with Customer, Bus,
 * Chauffeur and Destination classes. This class has an aggregation relationship
 * with the BusCompany class.
 */
public class Reservation implements Serializable {
	// Fields
	private int passengers;
	private boolean predefined;
	private double price;
	private Customer customer;
	private Chauffeur chauffeur;
	private Bus bus;
	private Destination destination;
	private DateInterval dateInterval;
	private String note;

	/**
	 * Constructor for the Reservation class
	 * 
	 * @param predefined
	 *            Shows if the reservation is predefined or not
	 * @param passengers
	 *            Represents the number of passengers
	 * @param price
	 *            Represents the price of the reservation
	 * @param customer
	 *            Represents the customer of the reservation
	 * @param chauffeur
	 *            Represents the chauffeur of the reservation
	 * @param bus
	 *            Represents the bus of the reservation
	 * @param destination
	 *            Represents the destination of the reservation
	 * @param dI
	 *            Represents the date interval (start and end dates) of the
	 *            reservation
	 * @param note
	 *            Represents the additional notes of the reservation
	 */
	public Reservation(boolean predefined, int passengers, double price,
			Customer customer, Chauffeur chauffeur, Bus bus,
			Destination destination, DateInterval dI, String note) {

		this.predefined = predefined;
		this.passengers = passengers;
		this.price = price;
		this.chauffeur = chauffeur;
		this.customer = customer;
		this.bus = bus;
		this.destination = destination;
		this.dateInterval = dI;
		this.note = note;
	}

	/**
	 * Method which returns the number of passengers of the reservation
	 * 
	 * @return Returns the number of passengers of the reservation
	 */
	public int getPassengers() {
		return passengers;
	}

	/**
	 * Method which returns the customer of the reservation
	 * 
	 * @return Returns the customer of the reservation
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Method which returns the chauffeur of the reservation
	 * 
	 * @return Returns the chauffeur of the reservation
	 */
	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	/**
	 * Method which returns the destination of the reservation
	 * 
	 * @return Returns the destination of the reservation
	 */
	public Destination getDestination() {
		return destination;
	}

	/**
	 * Method which returns bus of the reservation
	 * 
	 * @return Returns the bus of the reservation
	 */
	public Bus getBus() {
		return bus;
	}

	/**
	 * Method which returns the date interval of the reservation
	 * 
	 * @return Returns the date interval of the reservation
	 */
	public DateInterval getDateInterval() {
		return dateInterval;
	}

	/**
	 * Method which returns true/false according to boolean predefined
	 * 
	 * @return Returns true or false depending on if the reservation is
	 *         predefined or not
	 */
	public boolean isPredefined() {
		return predefined;
	}

	/**
	 * Method which returns the price of the reservation as a double price
	 * 
	 * @return Returns the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Method that returns the note of the reservation as a String note
	 * 
	 * @return Returns the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Method with a passengers parameter, that sets the number of passengers of
	 * the reservation
	 * 
	 * @param passengers
	 *            Sets the number of passengers of the reservation
	 */
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	/**
	 * Method with a Customer parameter, that sets the customer of the
	 * reservation
	 * 
	 * @param customer
	 *            Sets the customer of the reservation
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Method with a Chauffeur parameter, that sets the chauffeur of the
	 * reservation
	 * 
	 * @param chauffeur
	 *            Sets the chauffeur of the reservation
	 */
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	/**
	 * Method with a Destination parameter, that sets the destination of the
	 * reservation
	 * 
	 * @param destination
	 *            Sets the destination of the reservation of the reservation
	 */
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	/**
	 * Method with a Bus parameter of the reservation
	 * 
	 * @param bus
	 *            Sets the bus of the reservation
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	/**
	 * Method with a DateInterval parameter, that sets the date interval of the
	 * reservation
	 * 
	 * @param dateInterval
	 *            Sets the date interval of the reservation
	 */
	public void setDateInterval(DateInterval dateInterval) {
		this.dateInterval = dateInterval;
	}

	/**
	 * Method with a boolean predefined parameter, that sets the boolean value
	 * 
	 * @param predefined
	 *            Sets if the reservation is predefined or not
	 */
	public void setPredefined(boolean predefined) {
		this.predefined = predefined;
	}

	/**
	 * Method that sets price of the reservation
	 * 
	 * @param price
	 *            Set the price of the reservation
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Method that sets the note of the reservation
	 * 
	 * @param note
	 *            Sets notes for the reservation
	 */
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reservation)) {
			return false;
		} else {
			Reservation other = (Reservation) obj;
			return passengers == other.passengers
					&& predefined == other.predefined
					&& customer.equals(other.customer)
					&& chauffeur.equals(other.chauffeur)
					&& bus.equals(other.bus)
					&& destination.equals(other.destination)
					&& dateInterval.equals(other.dateInterval);
		}
	}

	@Override
	public String toString() {
		return customer.toString() + " ; " + chauffeur.toString() + " ; "
				+ bus.toString() + " ; " + dateInterval.toString();
	}
}

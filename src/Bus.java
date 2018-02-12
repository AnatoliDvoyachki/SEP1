import java.io.Serializable;
import java.util.ArrayList;

/**
 * Bus class that represents a bus. This class is associated to the Reservation
 * class, and has an aggregation relationship with the BusCompany class
 */
public class Bus implements Serializable {
	// Fields
	private int id;
	private int numSeats;
	private String type;

	/**
	 * Constructor for the Bus class.
	 * 
	 * @param id
	 *            Represents the id of the bus
	 * @param numSeats
	 *            Represents the number of seats in the bus
	 * @param type
	 *            Represents the type of the bus
	 */
	public Bus(int id, int numSeats, String type) {
		this.id = id;
		this.numSeats = numSeats;
		this.type = type;
	}

	/**
	 * Returns the id of the bus
	 * 
	 * @return Returns the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method with an id parameter which sets the Id of the bus
	 * 
	 * @param id
	 *            The id that you want to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method which returns the number of seats in the bus
	 * 
	 * @return The number of the seats
	 */
	public int getNumSeats() {
		return numSeats;
	}

	/**
	 * Method with a numSeats parameter, which sets the number of seats
	 * 
	 * @param numSeats
	 *            The number of seats that you want to set
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	/**
	 * Returns the type of the bus
	 * 
	 * @return The type of the bus
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method with a type parameter that sets the type of the bus
	 * 
	 * @param type
	 *            The type of the bus that you want to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method with dateInterval, numPassengers and ArrayList<Reservation>
	 * parameters.
	 * 
	 * @param dateInterval
	 *            The date interval that you want to check for
	 * @param numPassengers
	 *            The number of passengers
	 * @param reservations
	 *            The list of reservations
	 * @return Returns true if the bus is available. Else, it returns false.
	 * */
	public boolean isAvailable(DateInterval dateInterval, int numPassengers,
			ArrayList<Reservation> reservations) {
		if (numSeats < numPassengers)
			return false;
		for (Reservation r : reservations) {
			if (r.getDateInterval().overlaps(dateInterval))
				return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus other = (Bus) obj;
		return this.id == other.id && this.type.equals(other.type)
				&& this.numSeats == other.numSeats;
	}

	@Override
	public String toString() {
		return this.id + " " + this.type + " [" + this.numSeats + "]";
	}

}

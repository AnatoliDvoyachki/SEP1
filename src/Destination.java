import java.io.Serializable;

/**
 * Destination class which represents a destination. This class has an
 * aggregation relationship with BusCompany, and is associated with Reservation
 * class
 */
public class Destination implements Serializable {
	// Fields
	private String destination;

	/**
	 * Constructor for the Destination class with 1 parameter
	 * 
	 * @param destination
	 *            Sets the destination
	 */
	public Destination(String destination) {
		this.destination = destination;
	}

	/**
	 * Returns the destination
	 * 
	 * @return The destination that you have set
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Method with a destination parameter that sets the destination
	 * 
	 * @param destination
	 *            The destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Destination))
			return false;
		Destination other = (Destination) obj;
		return this.destination.equals(other.destination);
	}

	@Override
	public String toString() {
		return destination;
	}
}

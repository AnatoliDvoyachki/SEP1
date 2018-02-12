import java.io.Serializable;
import java.util.ArrayList;

/**
 * Chauffeur class that represents a chauffeur. This class has an aggregation
 * relationship with the BusCompany class, and is associated with the
 * reservation class.
 */
public class Chauffeur implements Serializable {
	// Fields
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;

	/**
	 * Constructor for the Chauffeur class.
	 * 
	 * @param id
	 *            The id that you want to set for the chauffeur
	 * @param name
	 *            The name that you want to set for the chauffeur
	 * @param address
	 *            The address that you want to set for the chauffeur
	 * @param phoneNumber
	 *            The phone number that you want to set for the chauffeur
	 * @param email
	 *            The email that you want to set for the chauffeur
	 */
	public Chauffeur(int id, String name, String address, String phoneNumber,
			String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Returns the id
	 * 
	 * @return The id of the chauffeur
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method with an id parameter that sets the id of the chauffeur
	 * 
	 * @param id
	 *            The id that you want to set for the chauffeur
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the chauffeur
	 * 
	 * @return The name of the chauffeur
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method with a name parameter that sets the name of the chauffeur
	 * 
	 * @param name
	 *            The name that you want to set for the chauffeur
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the address of the chauffeur
	 * 
	 * @return The address of the chauffeur
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method with an address parameter, that sets the address of the chauffeur
	 * 
	 * @param address
	 *            The address that you want to set for the chauffeur
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the phone number of the chauffeur
	 * 
	 * @return The phone number of the chauffeur
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Method with a phone number parameter that sets the phone number of the
	 * chauffeur
	 * 
	 * @param phoneNumber
	 *            The phone number that you want to set for the chauffeur
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the email of the chauffeur
	 * 
	 * @return The email of the chauffeur
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method with an email parameter that sets the email of the chauffeur
	 * 
	 * @param email
	 *            The email that you want to set for the chauffeur
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Method with dateInterval, numPassengers and ArrayList<Reservation>
	 * parameters.
	 * 
	 * @param dateInterval
	 *            The date interval that you want to check for
	 * 
	 * @param reservations
	 *            The list of reservations
	 * @return Returns true if the chauffeur is available. Else, it returns
	 *         false.
	 * */
	public boolean isAvailable(DateInterval dateInterval,
			ArrayList<Reservation> reservations) {
		for (Reservation r : reservations) {
			if (r.getDateInterval().overlaps(dateInterval))
				return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Chauffeur))
			return false;
		Chauffeur other = (Chauffeur) obj;
		return this.name.equals(other.name) && this.id == other.id
				&& this.address.equals(other.address)
				&& this.phoneNumber.equals(other.phoneNumber)
				&& this.email.equals(other.email);
	}

	@Override
	public String toString() {
		return this.id + " " + this.name;
	}

}

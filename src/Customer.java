import java.io.Serializable;

/**
 * Customer class that represents a customer. This class has an aggregation
 * relationship with the BusCompany class and is associated with the
 * Reservations class
 */
public class Customer implements Serializable {

	private String name, address, phoneNumber;

	/**
	 * Constructor for the Customer class with 3 parameters.
	 * 
	 * @param name
	 *            Sets the name of the customer
	 * @param address
	 *            Sets the address of the customer
	 * @param phoneNumber
	 *            Sets the phone number of the customer
	 */
	public Customer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the name of the customer
	 * 
	 * @return The name of the customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the address of the customer
	 * 
	 * @return The address of the customer
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns the phone number of the customer
	 * 
	 * @return Returns the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Method with a name parameter that sets the name
	 * 
	 * @param name
	 *            The name that you want to set for the customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method with an address parameter that sets the address
	 * 
	 * @param address
	 *            The address that you want to set for the customer
	 * 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method with a phoneNumber parameter that sets the phone number
	 * 
	 * @param phoneNumber
	 *            The phone number that you want to set for the customer
	 * 
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Customer)) {
			return false;
		} else {
			Customer other = (Customer) obj;
			return name.equals(other.name) && address.equals(other.address)
					&& phoneNumber.equals(other.phoneNumber);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}

import java.io.Serializable;

/**
 * MyDate class that represents a date. This class is associated with the
 * DateInterval class.
 */
public class MyDate implements Serializable {
	// Fields
	private int day;
	private int month;
	private int year;

	/**
	 * Constructor for MyDate class with 3 parameters
	 * 
	 * @param day
	 *            The day that you want to set for the date
	 * @param month
	 *            The month that you want to set for the date
	 * @param year
	 *            The year that you want to set for the date
	 */
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Method that sets the day, month and year
	 * 
	 * @param day
	 *            The day that you want to set for the date
	 * 
	 * @param month
	 *            The month that you want to set for the date
	 * 
	 * @param year
	 *            The year that you want to set for the date
	 */
	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Returns the day of the date
	 * 
	 * @return The day of the date
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns the month of the date
	 * 
	 * @return The month of the date
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Returns the year of the date
	 * 
	 * @return The year of the date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method that copies the MyDate class
	 * 
	 * @return A copy of an instance of the MyDate class
	 */
	public MyDate copy() {
		MyDate other = new MyDate(day, month, year);
		return other;
	}

	/**
	 * Method that checks if an instance of the MyDate class is before or is
	 * equal to another instance of the MyDate class.
	 * 
	 * @param other
	 *            An instance of the MyDate class that you want to compare with
	 * @return True, if the date is before or equals the date that you compare
	 *         with. Otherwise, returns false.
	 */
	public boolean isBeforeOrEquals(MyDate other) {
		if (this.getYear() < other.getYear())
			return true;
		else if ((this.getYear() == other.getYear())
				&& (this.getMonth() < other.getMonth()))
			return true;
		else if ((this.getYear() == other.getYear())
				&& (this.getMonth() == other.getMonth())
				&& (this.getDay() <= other.getDay()))
			return true;
		return false;
	}

	/**
	 * Method that checks if an instance of the MyDate class is before or is
	 * equal to another instance of the MyDate class.
	 * 
	 * @param other
	 *            An instance of the MyDate class that you want to compare with
	 * @return True, if the date is before or equals the date that you compare
	 *         with. Otherwise, returns false.
	 */
	public boolean isBefore(MyDate other) {
		if (this.getYear() < other.getYear())
			return true;
		else if ((this.getYear() == other.getYear())
				&& (this.getMonth() < other.getMonth()))
			return true;
		else if ((this.getYear() == other.getYear())
				&& (this.getMonth() == other.getMonth())
				&& (this.getDay() < other.getDay()))
			return true;
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MyDate))
			return false;
		MyDate other = (MyDate) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

}

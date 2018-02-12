import java.io.Serializable;
import java.util.Date;

/**
 * DateInterval class that represents an interval between two dates. This class
 * is composed with MyDate class and Reservation class.
 */
public class DateInterval implements Serializable {
	// Fields
	private MyDate startDate;
	private MyDate endDate;

	/**
	 * Constructor for the DateInterval class.
	 * 
	 * @param departureDate
	 *            The departure date that you want to set
	 * @param arrivalDate
	 *            The arrival date that you want to set
	 */
	public DateInterval(MyDate departureDate, MyDate arrivalDate) {
		this.startDate = departureDate.copy();
		this.endDate = arrivalDate.copy();

	}

	/**
	 * Method that has 3 parameters and sets the start date.
	 * 
	 * @param day
	 *            The start day that you want to set for the date interval
	 * @param month
	 *            The start month that you want to set for the interval
	 * 
	 * @param year
	 *            The start year that you want to set for the interval
	 */
	public void setStartDate(int day, int month, int year) {
		this.startDate = new MyDate(day, month, year);
	}

	/**
	 * Method that has 3 parameters and sets the end date
	 * 
	 * @param day
	 *            The end day that you want to set for the interval
	 * @param month
	 *            The end month that you want to set for the interval
	 * @param year
	 *            The end year that you want to to set for the interval
	 */
	public void setEndDate(int day, int month, int year) {
		this.endDate = new MyDate(day, month, year);
	}

	/**
	 * Returns the start date
	 * 
	 * @return The start date of the interval
	 */
	public MyDate getStartDate() {
		return startDate;
	}

	/**
	 * Returns the end date
	 * 
	 * @return The end date of the interval
	 */
	public MyDate getEndDate() {
		return endDate;
	}

	/**
	 * Method that has an DateInterval as parameter that returns checks if two
	 * date intervals overlap
	 * 
	 * @param newDateInterval
	 *            The date interval that you compare to
	 * @return Returns true if the intervals overlap, else it returns false
	 */
	public boolean overlaps(DateInterval newDateInterval) {

		if (startDate.isBeforeOrEquals(newDateInterval.getEndDate())
				&& newDateInterval.getStartDate().isBeforeOrEquals(endDate))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return (startDate + "-" + endDate);
	}

}

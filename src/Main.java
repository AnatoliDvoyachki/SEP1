import java.io.IOException;

/**
 * This class runs the system
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BusCompany model = new BusCompany();
		model = BusCompanyFile.readBusCompanyData();
		BusCompanyGUI view = new BusCompanyGUI(model);

	}

	public static void addSampleDate(BusCompany model) {
		Customer cu0 = new Customer("Eric Son", "Trendslane 7", "+4527452312");
		Customer cu1 = new Customer("Mike Litoris", "Tinglestreet 10",
				"+4532301943");

		Chauffeur ch0 = new Chauffeur(3001, "Lane Driver", "Road Avenue 8",
				"+4512158754", "rides@gmail.com");
		Chauffeur ch1 = new Chauffeur(3002, "Wayfarer", "Sweetstreet 5",
				"+4575434412", "boysrus@gmail.com");

		Bus b0 = new Bus(4001, 24, "Partybus");
		Bus b1 = new Bus(4002, 8, "Candyvan");
		Bus b2 = new Bus(4003, 16, "Standard");
		Bus b3 = new Bus(4004, 16, "Standard");

		Destination d0 = new Destination("Kalundborg");
		Destination d1 = new Destination("Next door");

		Reservation r0 = new Reservation(true, 20, 2000, cu0, ch0, b0, d0,
				new DateInterval(new MyDate(2, 11, 2016), new MyDate(5, 11,
						2016)), "");
		Reservation r1 = new Reservation(true, 12, 2000, cu0, ch0, b2, d0,
				new DateInterval(new MyDate(8, 11, 2016), new MyDate(10, 11,
						2016)), "");
		Reservation r2 = new Reservation(true, 12, 2000, cu0, ch0, b3, d1,
				new DateInterval(new MyDate(12, 11, 2016), new MyDate(17, 11,
						2016)), "");
		Reservation r3 = new Reservation(false, 12, 2000, cu0, ch1, b2, d1,
				new DateInterval(new MyDate(6, 11, 2016), new MyDate(15, 11,
						2016)), "");

		model.addCustomer(cu0);
		model.addCustomer(cu1);

		model.addChauffeur(ch0);
		model.addChauffeur(ch1);

		model.addBus(b0);
		model.addBus(b1);
		model.addBus(b2);
		model.addBus(b3);

		model.addDestination(d0);
		model.addDestination(d1);

		model.addReservation(r0);
		model.addReservation(r1);
		model.addReservation(r2);
		model.addReservation(r3);
	}
}

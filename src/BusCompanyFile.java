import java.io.*;

/**
 * BusCompanyFile class, that saves the data from the BusCompany class into a
 * binary file. This class is associated with the BusCompany class.
 */
public class BusCompanyFile implements Serializable {
	// Fields
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static File binary = new File("VIABus.dat");

	/**
	 * Method that writes the data from the BusCompany class into a binary file
	 * 
	 * @param company
	 *            The BusCompany class that is going to be written in the binary
	 *            file
	 */

	public static void saveBusCompanyData(BusCompany company)
			throws IOException {
		fos = new FileOutputStream(binary);
		oos = new ObjectOutputStream(fos);
		try {
			oos.reset();
			oos.writeObject(company);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
			oos.close();
		}
	}

	/**
	 * Method that reads data from a binary file and returns a BusCompany object
	 * 
	 * @return Returns a BusCompany object
	 */

	public static BusCompany readBusCompanyData() throws IOException {
		if (!binary.exists()) {
			binary.createNewFile();
			saveBusCompanyData(new BusCompany());
		}

		fis = new FileInputStream(binary);
		ois = new ObjectInputStream(fis);
		BusCompany temp = null;
		try {
			temp = (BusCompany) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			ois.close();
		}
		return temp;
	}

}

/**
 * 
 */
package Events;

import java.util.Date;

/**
 * @author Alfei
 *
 */
public class Accident extends Classes.Event {

	protected String accidentType;

	/**
	 * 
	 */
	public Accident() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param title
	 * @param location
	 * @param address
	 * @param sDate
	 * @param eDate
	 * @param sTime
	 * @param eTime
	 * @param repeat
	 * @param description
	 */
	public Accident(String id, String title, String location, String address,
			Date sDate, Date eDate, String sTime, String eTime, int repeat,
			String description, String accidentType) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

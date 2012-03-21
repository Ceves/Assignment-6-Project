/**
 * 
 */
package Events;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Alfei
 *
 */
public class Anniversary extends Classes.Event {

	ArrayList<String> anniversees;
	/**
	 * 
	 */
	public Anniversary() {
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
	public Anniversary(String id, String title, String location,
			String address, Date sDate, Date eDate, String sTime, String eTime,
			int repeat, String description, String anniversees) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getAnniversees() {
		return anniversees;
	}

	public void setAnniversees(ArrayList<String> anniversees) {
		this.anniversees = anniversees;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

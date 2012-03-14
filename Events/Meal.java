/**
 * 
 */
package Events;

import java.util.Date;

import javagui.views.Event;

/**
 * @author Alfei
 *
 */
public class Meal extends Event {

	/**
	 * 
	 */
	public Meal() {
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
	public Meal(String id, String title, String location, String address,
			Date sDate, Date eDate, String sTime, String eTime, int repeat,
			String description) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

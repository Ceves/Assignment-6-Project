/**
 * 
 */
package Events;

import java.util.Date;

/**
 * @author Alfei
 *
 */
public class Other extends Classes.Event {

	/**
	 * 
	 */
	public Other() {
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
	public Other(String id, String title, String location, String address,
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

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
public class Concert extends Event {

	public String bandName;
	/**
	 * 
	 */
	public Concert() {
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
	public Concert(String id, String title, String location, String address,
			Date sDate, Date eDate, String sTime, String eTime, int repeat,
			String description, String bandName) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	
	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

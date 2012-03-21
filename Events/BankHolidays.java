/**
 * 
 */
package Events;

import java.util.Date;

/**
 * @author Alfei
 *
 */
public class BankHolidays extends Classes.Event {

	protected String holidayName;
	/**
	 * 
	 */
	public BankHolidays() {
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
	public BankHolidays(String id, String title, String location,
			String address, Date sDate, Date eDate, String sTime, String eTime,
			int repeat, String description, String holidayName) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

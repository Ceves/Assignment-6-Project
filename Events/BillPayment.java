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
public class BillPayment extends Event {

	protected String company;
	/**
	 * 
	 */
	public BillPayment() {
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
	public BillPayment(String id, String title, String location,
			String address, Date sDate, Date eDate, String sTime, String eTime,
			int repeat, String description, String company) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

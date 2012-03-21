/**
 * 
 */
package Events;

import java.util.Date;

/**
 * @author Alfei
 *
 */
public class ClassLecture extends Classes.Event {

	protected String module;
	/**
	 * 
	 */
	public ClassLecture() {
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
	public ClassLecture(String id, String title, String location,
			String address, Date sDate, Date eDate, String sTime, String eTime,
			int repeat, String description, String module) {
		super(id, title, location, address, sDate, eDate, sTime, eTime, repeat,
				description);
		// TODO Auto-generated constructor stub
	}


	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

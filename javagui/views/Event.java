package javagui.views;

/**
* @ file EventManager
* @ author Daniel Lewis
* @ brief makes a event object incapsulating all the need data
* @ this class constructs a object from all of the events data
* 
*  This class defines the attributes that define an Event.
*  This is accomplished by creating accessor and mutator methods
*  to get the data.
*/


import java.text.DateFormat;
import java.util.Date;
 
public class Event {

	// Accessor methords
	/**get event id
	*
	*@\return event id 
	*/
	public String GetId()
	{
	return m_id;
	}
	/**get event Category
	*
	*@\return event Category
	*/
	public int GetCategory()
	{
		return m_category;
	}
	
	/**get event title
	*
	*@\return event title
	*/
	public String GetTitle()
	{
		return m_title;
	}
	
	/**get event Location
	*
	*@\return event Location
	*/
	public String GetLocation()
	{
		return m_location;
	}
	
	/**get event Address
	*
	*@\return event Address
	*/
	public String GetAddress()
	{
		return m_address;
	}
	
	/**get event Start Date
	*
	*@\return event Start Date
	*/
	public Date GetSDate()
	{
		return m_sDate;
	}
	
	/**get event End Date
	*
	*@\return event End Date
	*/
	public Date GetEDate()
	{
		return m_eDate;
	}
	
	/**get event Start Time
	*
	*@\return event Start Time
	*/
	public String GetSTime()
	{
		return m_sTime;
	}
	
	/**get event End Time
	*
	*@\return event End Time
	*/
	public String GetETime()
	{
		return m_eTime;
	}
	
	/**get event Repeat value
	*
	*@\return event Repeat value
	*/
	public int GetRepeat()
	{
		return m_repeat;
	}
	
	/**get event Description
	*
	*@\return event Description
	*/
	public String GetDescription()
	{
		return m_description;
	}
	
	
	/**set event id
	*
	*@\param new event id
	*/
	
	public void SetId(String id)
	{
		m_id = id;
	}
	
	/**set event Category
	*
	*@\param new event Category
	*/
	public void SetCategory(int category)
	{
		if (category <= m_maxCategory)
			{
				m_category = category;
			}
			else
			{
				System.out.println("category error!");
			}
	}
	
	/**set event title
	*
	*@\param new event title
	*/
	public void SetTitle(String title)
	{
		if (title.length() <= m_maxTitle)
			{
				m_title = title;
			}
			else
			{
				System.out.println("Title error!");
			}
	}
	
	/**set event location
	*
	*@\param new event location
	*/
	public void SetLocation(String location)
	{
		if (location.length() <= m_maxLocation)
			{
				m_location = location;
			}
			else
			{
				System.out.println("location error!");
			}
	}
	
	/**set event address
	*
	*@\param new event address
	*/
	public void SetAddress(String address)
	{
		if(address.length() <= m_maxAddress)
		{
			m_address = address;
		}
		else
		{
			System.out.println("Address error!");
		}
		
	}
	
	/**set event start date
	*
	*@\param new event start date
	*/
	public void SetSDate(Date sDate)
	{
		m_sDate = sDate;
	}
	
	/**set event end date
	*
	*@\param new event end date
	*/
	public void SetEDate(Date eDate)
	{
		m_eDate = eDate;
	}
	
	/**set event start Time
	*
	*@\param new event Start Time
	*/
	public void SetSTime(String sTime)
	{
		m_sTime = sTime;
	}
	
	/**set event End Time 
	*
	*@\param new event End Time
	*/
	public void SetETime(String eTime)
	{
		m_eTime = eTime;
	}
	
	/**set event repeat value
	*
	*@\param new event repeat value
	*/
	public void SetRepeat(int repeat)
	{
		if (repeat <= m_maxRepeat)
			{
				m_repeat = repeat;
			}
				else
			{
				System.out.println("Repeat error!");
			}
	}
	
	/**set event descripion 
	*
	*@\param new event description
	*/
	public void SetDescription(String description)
	{
		if (description.length() <= m_maxDescription)
			{
				m_description = description;
			}
				else
			{
				System.out.println("description error!");
			}
	}
	
	
					
	
	/**create event object to hold event data 
	*
	*@\param set event id
	*@\param set event category
	*@\param set event title
	*@\param set event location
	*@\param set event address
	*@\param set event Start date
	*@\param set event End date
	*@\param set event Start time
	*@\param set event End Time
	*@\param set event repeat value
	*@\param set event description 
	*/

	 public Event(String id,int category, String title, String location, 
					String address, Date sDate,Date eDate,String sTime,String eTime,int repeat,String description)
					{
					//Tests
						m_id = id;
						if (category <= m_maxCategory)
							{
							m_category = category;
							}
						else
							{
							System.out.println("category error!");
							}
							
						if (title.length() <= m_maxTitle)
							{
							m_title = title;
							}
						else
							{
							System.out.println("Title error!");
							}
							
						if (location.length() <= m_maxLocation)
							{
							m_location = location;
							}
						else
							{
							System.out.println("location error!");
							}
							
						if(address.length() <= m_maxAddress)
							{
							m_address = address;
							}
						else
							{
							System.out.println("Address error!");
							}
							
						if (repeat <= m_maxRepeat)
							{
							m_repeat = repeat;
							}
						else
							{
							System.out.println("Repeat error!");
							}
							
						if (description.length() <= m_maxDescription)
							{
							m_description = description;
							}
						else
							{
							System.out.println("description error!");
							}
						m_sDate = sDate;
						m_eDate = eDate;
						m_sTime = sTime;
						m_eTime = eTime;
					}
					
	

	
	// varibles 
	private int m_maxCategory = 10;
	private int m_maxTitle = 30;
	private int m_maxLocation = 30;
	private int m_maxAddress = 30;
	private int m_maxRepeat = 3;
	private int m_maxDescription = 100;

	private String m_id;
	private int m_category;
	private String m_title;
	private	String m_location;
	private String m_address;
	private Date m_sDate;
	private Date m_eDate;
	private String m_sTime;
	private String m_eTime;
	private int m_repeat;
	private String m_description;
	
	// Test methord 
	public static void main(String[] args)
	{
		Date sDate = new Date(07/8/12);
		Date eDate = new Date(07/8/12);
		
		//create new event
		Event e = new Event("E1",2,"Tutor Meeting" ,"Farday Room","swansea uni",sDate,eDate
							,"14:00","15:00",0,"Meet with tutor");

		
		//test accessor methords
		
			System.out.println();
			System.out.println("new EVENT");
			System.out.println();
			System.out.println(e.GetId());
			System.out.println(e.GetCategory());
			System.out.println(e.GetTitle());
			System.out.println(e.GetLocation());
			System.out.println(e.GetAddress());
			System.out.println(e.GetSDate());
			System.out.println(e.GetEDate());
			System.out.println(e.GetSTime());
			System.out.println(e.GetETime());
			System.out.println(e.GetRepeat());
			System.out.println(e.GetDescription());
		
		//test Mutator methords
			sDate = new Date(05/2/13);
		
			
			e.SetId("E2");
			e.SetCategory(3);
			e.SetTitle("new title");
			e.SetLocation("new location");
			e.SetAddress("new Address");
			e.SetSDate(sDate);
			e.SetEDate(eDate);
			e.SetSTime("12:00");
			e.SetETime("13:00");
			e.SetRepeat(5);
			e.SetDescription("new description");
			
			System.out.println();
			System.out.println("new EVENT");
			System.out.println();
			System.out.println(e.GetId());
			System.out.println(e.GetCategory());
			System.out.println(e.GetTitle());
			System.out.println(e.GetLocation());
			System.out.println(e.GetAddress());
			System.out.println(e.GetSDate());
			System.out.println(e.GetEDate());
			System.out.println(e.GetSTime());
			System.out.println(e.GetETime());
			System.out.println(e.GetRepeat());
			System.out.println(e.GetDescription());
		
		
	
	}

 }


 
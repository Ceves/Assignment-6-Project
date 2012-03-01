package javagui.views;

/**
* \ file 	EventManager
* \ author	Daniel Lewis
* \ date
* \ see
*
* \ brief preforms function to assist in event creation and event access
*
* \ this class allows for the creation of unique ids for use in the creation of events and allows for events to be located in 
* \ a arraylist based on the events unique id; 
*/


import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class EventManager
{
	

	public EventManager()
	{
	
	}
	
	/**Set unique id for creating a event 
	*
	*@\param ArrayList<Event> dataArray is the EventArray that a new 
	*@\param event is to be added to. it is used to find out the size of the array so
	*@\param that a unique id can be created for a new event.
	*
	*@\return a String containg the unique id is returned to be added to the new events values.
	*
	*/
	
	public String UniqueID(ArrayList<Event> dataArray)
	{
		int m_aLength = dataArray.size() + Incrementval;
		String m_uniqueId = ID.concat(Integer.toString(m_aLength));
		
		
		return m_uniqueId;
	}
	
	/** Find the location of a event in a array list
	*
	*@\param id the unique id of the event you want to find
	*@\param m_dataArray the arraylist you want to find the event in
	*
	*
	*@\return m_eventPosition the location of the event in the array.
	*/
	public int GetEventlocation(String m_Id, ArrayList<Event> m_dataArray)
	{
		for (int i = 0;i<m_dataArray.size();i++)
		{
			if (m_dataArray.get(i).GetId() == m_Id)
			{
				m_eventPosition = i;
				i = m_dataArray.size();
			}
			else 
			{
				i++;
			}
			
		}
		return m_eventPosition;
	}
	
	//test methord
	
	public static void main(String[] args)
	{
	
		ArrayList<Event> a = new ArrayList<Event>();//make new event arraylist
		EventManager m = new EventManager();//Construct new event Manager
		
		//test UniqueID();
		System.out.println(m.UniqueID(a));
		
		
	}
	
	final private String ID = "E";
	final private int Incrementval = 1;
	private int m_eventPosition;
	
	
}
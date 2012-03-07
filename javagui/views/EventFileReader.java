package javagui.views;

/**
* @file EventFileReader
* @author Daniel Lewis
*
* @brief CSV file reader and writer for the events csv file  
*
* This class reads in the events csv file and parses the input 
* to insure the data is in the correct format. It then constructs the 
* infomation in to events and saves the events in a arraylist. the 
* class also used to write the events to file. 
*/


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.text.*;
import java.io.FileWriter; 
import java.io.Writer;


public class EventFileReader {
	

	//Constructor
	public EventFileReader()
	{
	
	}
	
	
	/**
	* Saves the events in a Arraylist and save them to a file.
	*
	* @param ArrayList<Event> SEventArray the array that is to be saved.
	* @param m_SFileLocation the name of the file you want to save to
	*/
	public void Save(ArrayList<Event> SEventArray, String m_SFileLocation)
	{
		this.m_SFileLocation = m_SFileLocation;

		try
		{
			FileWriter writer = new FileWriter(this.m_SFileLocation);
			for(int i = 0; i < SEventArray.size(); i++)
			{
				String id = SEventArray.get(i).GetId();
				String category = Integer.toString(SEventArray.get(i).GetCategory());
				String title = SEventArray.get(i).GetTitle();
				String location = SEventArray.get(i).GetLocation();
				String address = SEventArray.get(i).GetAddress();
				String sDate = formatter.format(SEventArray.get(i).GetSDate());
				String eDate = formatter.format(SEventArray.get(i).GetEDate());
				String sTime = SEventArray.get(i).GetSTime();
				String eTime = SEventArray.get(i).GetETime();
				String repeat = Integer.toString(SEventArray.get(i).GetRepeat());
				String description = SEventArray.get(i).GetDescription();
				
				writer.append(id);
				writer.append(',');
				writer.append(category);
				writer.append(',');
				writer.append(title);
				writer.append(',');
				writer.append(location);
				writer.append(',');
				writer.append(address);
				writer.append(',');
				writer.append(sDate);
				writer.append(',');
				writer.append(eDate);
				writer.append(',');
				writer.append(sTime);
				writer.append(',');
				writer.append(eTime);
				writer.append(',');
				writer.append(repeat);
				writer.append(',');
				writer.append(description);
				writer.append('\r');
				writer.append('\n');
				writer.flush();
				
			}
			writer.close();
	}
	
catch(IOException e)
{
 e.printStackTrace();
} 

	}
	
	/**
	* loadS data from csv file.
	*
	* @param m_fileLocation the path to the file that is to be loaded.
	* @return a ArrayList<Event> with all the data from the file converted into the correct formats.
	*/
	public ArrayList<Event> load(String m_fileLocation)
	{
	
	this.m_fileLocation = m_fileLocation;
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(m_fileLocation));
			String line = "";
			StringTokenizer st = null;

			int lineNumber = 0; 
			int tokenNumber = 0;

			//read comma separated file line by line
			
			while ((line = br.readLine()) != null) 
			{
				lineNumber++;
				//use comma as token separator
				st = new StringTokenizer(line,",");

				while (st.hasMoreTokens()) {
					
					m_dataArray.add(st.nextToken());
					//display csv values
					//System.out.print(st + "  ");
					//System.out.println(tokenNumber);
					tokenNumber++;
				}

			tokenNumber = 0;
       }
			formatData();
			
		} catch (Exception e) {
		System.err.println("CSV file cannot be read : " + e);
		}
	 return m_eventArray;
	}
	
	/**format the data from the csv file from strings in to the correct data formats.
	*
	*/
	private void formatData()
	{
	
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date sDate = new Date();
	Date eDate = new Date();
	
	int index = 0;
	
	for(int i=0;i < m_dataArray.size();i++)
	{
		//System.out.println("id = "+m_dataArray.get(i));
		
		String id = m_dataArray.get(i);
		
		i++;
		//System.out.println("cat = "+m_dataArray.get(i));
		
		int category = Integer.parseInt(m_dataArray.get(i));
		
		i++;
		//System.out.println("title = "+m_dataArray.get(i));
		
		String title = m_dataArray.get(i);
		
		i++;
		//System.out.println("location = "+m_dataArray.get(i));
		
		String location = m_dataArray.get(i);
		
		i++;
		//System.out.println("address = "+m_dataArray.get(i));
		
		String address = m_dataArray.get(i);
		
		i++;
	//System.out.println("sdate = "+m_dataArray.get(i));
		
		try { 
		sDate = (Date)formatter.parse(m_dataArray.get(i)); 
		} catch (ParseException e)
		{System.out.println("Exception :"+e);  } 
		
		i++;
		//System.out.println("eDate = "+m_dataArray.get(i));
		
		try { 
		eDate = (Date)formatter.parse(m_dataArray.get(i)); 
		}catch (ParseException e)
		{System.out.println("Exception :"+e);  } 
		
		i++;
		//System.out.println("sTime = "+m_dataArray.get(i));
		
		String sTime =  m_dataArray.get(i);
		
		i++;
		//System.out.println("eTime = "+m_dataArray.get(i));
		
		String eTime = m_dataArray.get(i);
		
		i++;
		//System.out.println("repeat = "+m_dataArray.get(i));
		
		int repeat = Integer.parseInt(m_dataArray.get(i));
		
		i++;
		//System.out.println("description = "+m_dataArray.get(i));
		
		String description = m_dataArray.get(i);
	
		Event event = new Event(id,category,title,location,address,sDate,eDate,sTime,eTime,repeat,description);
		
		m_eventArray.add(event);
	
		}
		
	
	
	}
	
	//varables
	private ArrayList <String> m_dataArray = new ArrayList<String>();
	private ArrayList <Event> m_eventArray = new ArrayList<Event>();
	private String m_fileLocation = "EVENTS.csv";
	private String m_SFileLocation = "EVENTS.csv";
	private String m_fileName = "EVENTS.csv";
	private DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	
	
	// Test methord 
	public static void main(String[] args)
	{
		ArrayList<Event> a = new ArrayList<Event>();
		EventFileReader r = new EventFileReader();
	
		a = r.load("EVENTS.csv");//test Load()
	
		for(int i =0; i < a.size(); i ++)
		{
		
			System.out.println();
			System.out.println("EVENT "+ i);
			System.out.println();
			System.out.println(a.get(i).GetId());
			System.out.println(a.get(i).GetCategory());
			System.out.println(a.get(i).GetTitle());
			System.out.println(a.get(i).GetLocation());
			System.out.println(a.get(i).GetAddress());
			System.out.println(a.get(i).GetSDate());
			System.out.println(a.get(i).GetEDate());
			System.out.println(a.get(i).GetSTime());
			System.out.println(a.get(i).GetETime());
			System.out.println(a.get(i).GetRepeat());
			System.out.println(a.get(i).GetDescription());
		
		}
		
		System.out.println("");
		System.out.println("Saving");
		r.Save(a,"TESTEVENTS.csv");
		System.out.println("File saved to TESTEVENTS.csv");
	
	}

}
package javagui.views;

/**
* \ file  TaskFileReader
* \ author Daniel Lewis
* \ date
* \ see
*
* \ brief CSV file reader and writer for the tasks csv file  
*
* This class reads in the tasks csv file and parses the input to insure the data is in the correct format
* then constructs the infomation in to tasks and saves the tasks in a arraylist. the class also used to write the tasks to file. 
*/







import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.text.*;
import java.io.FileWriter;


public class TaskFileReader {
 

 //Constructor
 
 public TaskFileReader()
 {
 
 }
 
 /**Saves the tasks in a Arraylist and save them to a file.
 *
 *@\param ArrayList<Task> STaskArray the array that is to be saved.
 *@\param m_SFileLocation the name of the file you want to save too
 *
 *
 */
 
 public void Save(ArrayList<Task> STaskArray, String m_SFileLocation)
 {
  this.m_SFileLocation = m_SFileLocation;

  try
  {
   FileWriter writer = new FileWriter(this.m_SFileLocation);
   for(int i = 0; i < STaskArray.size(); i++)
   {
    String id = STaskArray.get(i).GetId();
    String category = Integer.toString(STaskArray.get(i).GetCategory());
    String title = STaskArray.get(i).GetTitle();
    String location = STaskArray.get(i).GetLocation();
    String sDate = formatter.format(STaskArray.get(i).GetSDate());
    String eDate = formatter.format(STaskArray.get(i).GetDDate());
    String sTime = STaskArray.get(i).GetSTime();
    String eTime = STaskArray.get(i).GetDTime();
    String repeat = Integer.toString(STaskArray.get(i).GetRepeat());
    String description = STaskArray.get(i).GetDescription();
    
    writer.append(id);
    writer.append(',');
    writer.append(category);
    writer.append(',');
    writer.append(title);
    writer.append(',');
    writer.append(location);
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
    writer.append('\n');
    
   }
   writer.close();
 }
 
catch(IOException e)
{
 e.printStackTrace();
} 

 }
 
 /**load data from csv file.
 *
 *@\param m_fileLocation the path to the file that is to be loaded.
 *
 *@\return a ArrayList<Task> with all the data from the file converted into the correct formats.
 *
 */
 public ArrayList<Task> load(String m_fileLocation)
 {
 
 try 
  {
   BufferedReader br = new BufferedReader(new FileReader(m_fileLocation));
   String line = "";
   StringTokenizer st = null;

   

   //read comma separated file line by line
   
   while ((line = br.readLine()) != null) 
   {
    //use comma as token separator
    st = new StringTokenizer(line,",");

    while (st.hasMoreTokens()) {
     
     m_dataArray.add(st.nextToken());
    }
       }
   formatData();
   
  } catch (Exception e) {
  System.err.println("CSV file cannot be read : " + e);
  }
  return m_taskArray;
 }
 
 /**format the data from the csv file from strings in to the correct data formats.
 *
 */
 private void formatData()
 {
 
 DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
 Date sDate = new Date();
 Date eDate = new Date();
 
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
  
  m_dataArray.get(i);
  
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
 
  Task task = new Task(id,category,title,location,sDate,eDate,sTime,eTime,repeat,description);
  
  m_taskArray.add(task);
 
  }
  
 
 
 }
 
 //varables
 private ArrayList <String> m_dataArray = new ArrayList<String>();
 private ArrayList <Task> m_taskArray = new ArrayList<Task>();
 private String m_SFileLocation = "TASKS.csv";
 private DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
 
 
 // Test methord 
 public static void main(String[] args)
 {
  ArrayList<Task> a = new ArrayList<Task>();
  TaskFileReader r = new TaskFileReader();
 
  a = r.load("TASKS.csv");//test Load()
 
  for(int i =0; i < a.size(); i ++)
  {
  
   System.out.println();
   System.out.println("TASK "+ i);
   System.out.println();
   System.out.println(a.get(i).GetId());
   System.out.println(a.get(i).GetCategory());
   System.out.println(a.get(i).GetTitle());
   System.out.println(a.get(i).GetLocation());
   System.out.println(a.get(i).GetSDate());
   System.out.println(a.get(i).GetDDate());
   System.out.println(a.get(i).GetSTime());
   System.out.println(a.get(i).GetDTime());
   System.out.println(a.get(i).GetRepeat());
   System.out.println(a.get(i).GetDescription());
  
  }
  
  System.out.println("");
  System.out.println("Saving");
  r.Save(a,"TESTTASKS.csv");
  System.out.println("File saved to TESTTASKS.csv");
 
 }

}
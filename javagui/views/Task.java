package javagui.views;

/**
 * The Task class is designed for folding Tasks.  It is accessible through constructors and mutator
 * it facilitates the creation, alteration and deletion of Tasks.
 * 
 * @author Devin Taylor
 * @date 27/02/12
 * 
 */


import java.util.Date;
 
public class Task {
 
 /**
  * Initiate the variables associated with Tasks. 
  */
   private int m_maxCategory = 10;
   private int m_maxTitle = 30;
   private int m_maxLocation = 30;
   private int m_maxRepeat = 3;
   private int m_maxDescription = 100;
  
  private String m_id;
  private String m_title;
  private String m_location;
  private int m_category;
  private Date m_start_date;
  private Date m_due_date;
  private String m_start_time;
  private String m_due_time;
  private int m_repeat;
  private String m_description;

 // Setup Accessors
 /**get task id
 *
 *@\return task id 
 */
 public String GetId()
 {
 return m_id;
 }
 /**get task Category
 *
 *@\return task Category
 */
 public int GetCategory()
 {
  return m_category;
 }
 
 /**get task title
 *
 *@\return task title
 */
 public String GetTitle()
 {
  return m_title;
 }
 
 /**get task Location
 *
 *@\return task Location
 */
 public String GetLocation()
 {
  return m_location;
 }
 
 /**get task Start Date
 *
 *@\return task Start Date
 */
 public Date GetSDate()
 {
  return m_start_date;
 }
 
 /**get task End Date
 *
 *@\return task End Date
 */
 public Date GetDDate()
 {
  return m_due_date;
 }
 
 /**get task Start Time
 *
 *@\return task Start Time
 */
 public String GetSTime()
 {
  return m_start_time;
 }
 
 /**get task End Time
 *
 *@\return task End Time
 */
 public String GetDTime()
 {
  return m_due_time;
 }
 
 /**get task Repeat value
 *
 *@\return task Repeat value
 */
 public int GetRepeat()
 {
  return m_repeat;
 }
 
 /**get task Description
 *
 *@\return task Description
 */
 public String GetDescription()
 {
  return m_description;
 }
 
 
 // Setup Mutators
 
 /**set task id
 *
 *@\param new task id
 */
 
 public void SetId(String id)
 {
  m_id = id;
 }
 
 /**set task Category
 *
 *@\param new task Category
 */
 public void SetCategory(int category)
 {
  if (category <= m_maxCategory)
   {
    m_category = category;
   }
   else
   {
    System.out.println("category out of range");
   }
 }
 
 /**set task title
 *
 *@\param new task title
 */
 public void SetTitle(String title)
 {
  if (title.length() <= m_maxTitle)
   {
    m_title = title;
   }
   else
   {
    System.out.println("title out of range");
   }
 }
 
 /**set task location
 *
 *@\param new task location
 */
 public void SetLocation(String location)
 {
  if (location.length() <= m_maxLocation)
   {
    m_location = location;
   }
   else
   {
    System.out.println("location out of range");
   }
 }
 
 /**set task start date
 *
 *@\param new task start date
 */
 public void SetSDate(Date sDate)
 {
  m_start_date = sDate;
 }
 
 /**set task end date
 *
 *@\param new task end date
 */
 public void SetEDate(Date eDate)
 {
  m_due_date = eDate;
 }
 
 /**set task start Time
 *
 *@\param new task Start Time
 */
 public void SetSTime(String sTime)
 {
  m_start_time = sTime;
 }
 
 /**set task End Time 
 *
 *@\param new task End Time
 */
 public void SetDTime(String eTime)
 {
  m_due_time = eTime;
 }
 
 /**set task repeat value
 *
 *@\param new task repeat value
 */
 public void SetRepeat(int repeat)
 {
  if (repeat <= m_maxRepeat)
   {
    m_repeat = repeat;
   }
    else
   {
    System.out.println("reeat our of range");
   }
 }
 
 /**set task descripion 
 *
 *@\param new task description
 */
 public void SetDescription(String description)
 {
  if (description.length() <= m_maxDescription)
   {
    m_description = description;
   }
    else
   {
    System.out.println("description out of range");
   }
 }
 
 
     
 
 /**create task object to hold task data 
 *
 *@\param set task id
 *@\param set task category
 *@\param set task title
 *@\param set task location
 *@\param set task Start date
 *@\param set task Due date
 *@\param set task Start time
 *@\param set task Due Time
 *@\param set task repeat value
 *@\param set task description 
 */

  public Task(String id,int category, String title, String location, Date sDate,Date dDate,String sTime,String dTime,int repeat,String description)
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
      m_start_date = sDate;
      m_due_date = dDate;
      m_start_time = sTime;
      m_due_time = dTime;
     } 
 // Test method 
 public static void main(String[] args)
 {
  Date sDate = new Date(07/8/12);
  Date dDate = new Date(07/8/12);
  
  //create new task
  Task e = new Task("E1",2,"CS235 A4" ,"Farday Room",sDate,dDate,"14:00","15:00",0,"Hand in Assignment");

  
  //test accessor methods
  
   System.out.println();
   System.out.println("New Task");
   System.out.println();
   System.out.println(e.GetId());
   System.out.println(e.GetCategory());
   System.out.println(e.GetTitle());
   System.out.println(e.GetLocation());
   System.out.println(e.GetSDate());
   System.out.println(e.GetDDate());
   System.out.println(e.GetSTime());
   System.out.println(e.GetDTime());
   System.out.println(e.GetRepeat());
   System.out.println(e.GetDescription());
  
  //test Mutator methods
   sDate = new Date(05/2/13);
  
   
   e.SetId("E2");
   e.SetCategory(3);
   e.SetTitle("new title");
   e.SetLocation("new location");
   e.SetSDate(sDate);
   e.SetEDate(dDate);
   e.SetSTime("12:00");
   e.SetDTime("13:00");
   e.SetRepeat(5);
   e.SetDescription("new description");
   
   System.out.println();
   System.out.println("New Task");
   System.out.println();
   System.out.println(e.GetId());
   System.out.println(e.GetCategory());
   System.out.println(e.GetTitle());
   System.out.println(e.GetLocation());
   System.out.println(e.GetSDate());
   System.out.println(e.GetDDate());
   System.out.println(e.GetSTime());
   System.out.println(e.GetDTime());
   System.out.println(e.GetRepeat());
   System.out.println(e.GetDescription());
  
  
 
 }

 }


 
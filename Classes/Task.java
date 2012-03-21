package Classes;

/**
 * The Task class is designed for folding Tasks.  It is accessible through constructors and mutator
 * it facilitates the creation, alteration and deletion of Tasks.
 * 
 * @author Devin Taylor
 * @date 27/02/12
 * 
 */


import java.util.Calendar;
import java.util.Date;
 
public class Task {
 
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
 
 /**
 *This gets the ID for the contact
 *@return ID
 */
   public String GetId() {
 
   return m_id;
 
   }
 
 /**
 *This gets the Category of the task
 *@return task Category
 */
  public int GetCategory() {
  
  return m_category;
 
  }
 
 /**
 *This gets the Title of the Task
 *@return task Title
 */
  public String GetTitle() {
  
  return m_title;
 
  } 
 
 /**
  * This gets the Location of the task
  *@return task Location
 */
  public String GetLocation() {
  
  return m_location;
 
  }
 
 /**
  * gets the Start Date of task
  *@return task Start Date
 */
  public Date GetSDate() {
  
  return m_start_date;
 
 
  }
 
 /**
 *gets task End Date
 *@return task End Date
 */
  public Date GetDDate() {
  
  return m_due_date;
 
 
  }
 
 /**
 * get task Start Time
 *@return task Start Time
 */
  public String GetSTime() {
  
  return m_start_time;
 
  }
 
 /**get task End Time
 *
 *@\return task End Time
 */
  public String GetDTime() {
  
  return m_due_time;
 
  }
 
 /**
 *task Repeat value
 *@return task Repeat value
 */
  public int GetRepeat() {
  
  return m_repeat;
 
 
  }
 
 /**
 *get task Description
 *@return task Description
 */
  public String GetDescription() {
  
  return m_description;
 
 
  }
 
 
 // Setup Mutators
 
 /**
 *set task id
 *@param id
 */
 
  public void SetId(String id) {
  
  m_id = id;
 
 
  }
 
 /**
 *set task Category
 *@param category
 */
  public void SetCategory(int category) {
    
  m_category = category;
   
   
  }
 
 /**
 * set task title
 *@\param new task title
 */
  public void SetTitle(String title) {
 
  m_title = title;
   
   
  }
   
 
 /**
 * set task location
 *@\param new task location
 */
  public void SetLocation(String location) { 
  
  m_location = location;
  
  }
 
 /**
 * set task start date
 *@\param new task start date
 */
  public void SetSDate(Date sDate) {
  
  m_start_date = sDate;
 
 
  }
 
 /**
 * set task end date
 *@param new task end date
 */
  public void SetEDate(Date eDate) {
  
  m_due_date = eDate;
 
 
  }
 
 /**set task start Time
 *
 *@param new task Start Time
 */
  public void SetSTime(String sTime) {
  
  m_start_time = sTime;
 
 
  }
 
 /**set task End Time 
 *
 *@param new task End Time
 */
  public void SetDTime(String eTime) {
  
  m_due_time = eTime;
 
 
  }
 
 /**
 * set task repeat value
 *@param new task repeat value
 */
  public void SetRepeat(int repeat) {

  m_repeat = repeat;
   
   
  }
  
 
 /**
 *set task descripion 
 *@param new task description
 */
  public void SetDescription(String description) {
 
  m_description = description;
 
 
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

/**
* Check valid Location
* @param dob location
* @return True if valid
*/

 public boolean ValidLocation(String m_location2){
  if (m_location2.equals("")){
   System.out.println("Please enter a valid location " +
                           "(1 or more characters)");
    return false;
   }
  return true;
 }
 
 /**
* Check valid Category
* @param m_category2
* @return True if valid
*/
 public boolean ValidCategory(int m_category2){
   if (m_category2==0){
    System.out.println("Please enter a valid category " +
                             "(1 or more characters)");
    return false;
   }
  return true;
  }
  
  /**
* Check valid Title
* @param dob title
* @return True if valid
*/
  public boolean ValidTitle(String title){
    if (title.equals("")){
     System.out.println("Please enter a valid dob title" +
                "(1 or more characters)");
     return false;
   }
  return true;
 }
 
 
  /**
* Check valid Start Time
* @param start_time
* @return True if valid
*/
  public boolean ValidStartTime(String start_time){
    if (start_time.equals("")){
     System.out.println("Please enter a valid start time " +
                 "(1 or more characters)");
          return false;
     }
   return true;
  }
  
  /**
* Check valid Due Time
* @param due_time Due Time
* @return True if valid
*/
  public boolean ValidDueTime(String due_time){
    if (due_time.equals("")){
       System.out.println("Please enter a valid due time " +
                "(1 or more characters)");
           return false;
        }
    return true;
   }
   
   /**
* Check valid Description
* @param description
* @return True if valid
*/
   public boolean ValidDescription(String description){
       if (description.equals("")){
             System.out.println("Please enter a valid description " +
                       "(1 or more characters)");
               return false;
         }
       return true;
   }
  
  /**
* Check valid Repeat
* @param m_repeat2
* @return True if valid
*/
   public boolean ValidRepeat(int m_repeat2){
      if (m_repeat2== 0){
       System.out.println("Please enter a valid repeat " +
                "(1 or more characters)");
         return false;
     }
   return true;
  }
  public Task(String m_id,int m_category, String m_title, 
		 Date m_start_date, Date m_due_date, String m_start_time, String m_due_time,
		  String m_location, int m_repeat, String m_description,)
     {
     //Tests
       this.m_id = m_id;
       this.m_start_date = m_start_date;
       this.m_due_date = m_due_date;
       this.m_start_time = m_start_time;
       this.m_due_time = m_due_time;
      
       try {
       if(ValidTitle(m_title)==true)
       this.m_title = m_title;
       else
       throw new Exception();
       if (ValidLocation(m_location) == true)
       this.m_location = m_location;
       else
       throw new Exception();
       if (ValidRepeat(m_repeat)==true)
       this.m_repeat = m_repeat;
       else
       throw new Exception();
       if (ValidDescription(m_description)==true)
       this.m_description = m_description;
       else
       throw new Exception();
       if (ValidCategory(m_category)==true)
       this.m_category = m_category;
       } catch (Exception e) {
       e.printStackTrace();
         
         
       }
     }
       
       
     


 // Test method 
 public static void main(String[] args)
 {
  Date sDate = new Date(07/8/12);
  Date dDate = new Date(07/8/12);
  
  //create new task
  Task e = new Task("E1",2,"CS235 A4" ,"Farday Room",sDate,dDate,"14:00",
		  "15:00",0,"Hand in Assignment", m_description, m_category);

  
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
   
   System.out.println(e.GetId() + " " + e.GetCategory() + " " + e.GetTitle() + " " +
                      e.GetLocation + " " + e.GetSDate() + " " + e.GetDDate() + " " +
                      e.GetSTime() + " " + e.GetDTime() + " " + e.GetRepeat() + " " + e.GetDescription());
   
  
  
 
 }

 }
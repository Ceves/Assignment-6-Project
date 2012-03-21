package javagui.views;

/**
* \ file  TaskManager
* \ author Daniel Lewis
* \ date
* \ see
*
* \ brief preforms function to assist in task creation and task access
*
* \ this class allows for the creation of unique ids for use in the creation of tasks and allows for tasks to be located in 
* \ a arraylist based on the tasks unique id; 
*/


import java.util.ArrayList;

public class TaskManager
{
 

 public TaskManager()
 {
 
 }
 
 /**Set unique id for creating a task 
 *
 *@\param ArrayList<Task> dataArray is the TaskArray that a new 
 *@\param task is to be added to. it is used to find out the size of the array so
 *@\param that a unique id can be created for a new task.
 *
 *@\return a String containg the unique id is returned to be added to the new tasks values.
 *
 */
 
 public String UniqueID(ArrayList<Task> dataArray)
 {
  int m_aLength = dataArray.size() + Incrementval;
  String m_uniqueId = ID.concat(Integer.toString(m_aLength));
  
  
  return m_uniqueId;
 }
 
 /** Find the location of a task in a array list
 *
 *@\param id the unique id of the task you want to find
 *@\param m_dataArray the arraylist you want to find the task in
 *
 *
 *@\return m_taskPosition the location of the task in the array.
 */
 public int GetTasklocation(String m_Id, ArrayList<Task> m_dataArray)
 {
  for (int i = 0;i<m_dataArray.size();i++)
  {
   if (m_dataArray.get(i).GetId() == m_Id)
   {
    m_taskPosition = i;
    i = m_dataArray.size();
   }
   else 
   {
    i++;
   }
   
  }
  return m_taskPosition;
 }
 
 //test method
 
 public static void main(String[] args)
 {
 
  ArrayList<Task> a = new ArrayList<Task>();//make new task arraylist
  TaskManager m = new TaskManager();//Construct new task Manager
  
  //test UniqueID();
  System.out.println(m.UniqueID(a));
  
  
 }
 
 final private String ID = "E";
 final private int Incrementval = 1;
 private int m_taskPosition;
 
 
}
package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import javax.naming.directory.InvalidAttributesException;

/**
* @author Hammed Abiola
* @date 21/03/2012
*
* @brief
* This class stores a collection of Task. Operations such as
* getting and setting multiple Tasks can be performed by this class.
*/
public class TaskCollection extends Collection<Task> {

/**
* Default constructor creates a new ArrayList to hold only events.
*/
    public TaskCollection() {
        m_data = new ArrayList<Task>();
    }
    
    /**
* This method returns a collection of events which meet the
* criteria of a specific calendar day.
* @param date A valid calendar date
* @return Returns an ArrayList holding objects of type event.
*/
    public ArrayList<Task> GetTaskByDay(Calendar date) {
        ArrayList<Task> task = new ArrayList<Task>();
        for(int i = 0; i < m_data.size(); i++) {
            Task e = m_data.get(i);
            Calendar edate = e.GetStart_date();
            if(edate.get(Calendar.DAY_OF_MONTH) ==
             date.get(Calendar.DAY_OF_MONTH)
                    && edate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && edate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    )
                task.add(e);
            //check if it repeats
            else if(date.compareTo(edate) >= 0) {
                if(e.GetRepetition() == Task.REPEATING_DAILY) {//daily
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_WORKING_DAYS &&
                 date.get(Calendar.DAY_OF_WEEK) >= Calendar.MONDAY &&
                 date.get(Calendar.DAY_OF_WEEK) <= Calendar.FRIDAY) {
                 //working days
                   task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_WEEKENDS &&
                 (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                 date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                 //weekends
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_WEEKLY &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK)) {//weekly
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_TWO_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%2 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%2) {//two weeks
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_FOUR_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%4 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%4) {//four weeks
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_MONTHLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH)) {//monthly
                    task.add(e);
                }
                else if(e.GetRepetition() == Task.REPEATING_YEARLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH) &&
                 date.get(Calendar.MONTH) ==
                 edate.get(Calendar.MONTH)) {//yearly
                   task.add(e);
                }
            }
                    
        }
        return task;
    }
    
    /**
* This method returns the index at which an event is held in an ArrayList
* using the ID of the event.
* @param id The ID of a particular event.
* @return Returns an integer representing the index position the event is
* stored
* at in the ArrayList.
* @throws InvalidAttributesException Throws exception if the EventID does
* not exist.
*/
    public int GetTaskIndexById(int id) throws InvalidAttributesException {
        for(int i = 0; i < m_data.size(); i++) {
            if(m_data.get(i).GetId() == id) {
                return i;
            }
        }
        throw new InvalidAttributesException(
         "The requested EventID does not exists");
    }
    
    /**
* This method returns an event which matches an event
* object's ID held in the EventCollection array
* @param id The ID of the event to be returned
* @return The event object which matches specified ID
* @throws InvalidAttributesException If no ID is matched to any event
*/
    public Event GetTaskById(int id) throws InvalidAttributesException {
     for(int i = 0; i < m_data.size(); i++) {
            if(m_data.get(i).GetId() == id) {
                return m_data.get(i);
            }
     }
     throw new InvalidAttributesException("Task not found");
    }
    
    public static void main(String args[]) {
    
     TaskCollection collection = new TaskCollection();
     TaskCollection emptyCollection = new TaskCollection();
    
     Calendar calStart = Calendar.getInstance();
     Calendar calEnd = Calendar.getInstance();
     Calendar calNoTask = Calendar.getInstance();
    
     calStart.set(2012, 12, 10, 12, 00);
     calEnd.set(2012, 12, 11, 12, 00);
     calNoTask.set(2012, 12, 12, 12, 00);
    
     /* Test GetTaskByDay(date) */
     try {
collection.Add(new Task(1, "Start Project", calStart, calEnd,
"Project Deadline", 0));
} catch (Exception e) {
System.out.println(e.getMessage());
}
    
     // Test day populated with one task
     ArrayList<Task> taskArray = collection.GetTaskByDay(calStart);
     if (taskArray.size()==1) {
     System.out.println("Pass: Task successfully returned " +
     "for set date");
     } else {
     System.out.println("Fail: Task could not be returned " +
     "for set date");
     }
    
     // Test day with no task
     ArrayList<Task> noTaskArray = emptyCollection.GetTaskByDay
     (calNoTask);
     if (noTaskArray.size()==0) {
     System.out.println("Pass: No task found for set day");
     } else {
     System.out.println("Fail: Some task were found when no " +
     "task were set");
     }
    
     /* Test GetTaskIndexByID(id) */
    
     // Test with valid ID of existing task
     try {
     collection.GetTaskIndexById(1);
     System.out.println("Pass: Task returned with matching ID '1'");
     } catch (InvalidAttributesException e) {
     System.out.println("Failed: The task ID '1' does exist but " +
     "has not been returned");
     }
    
     // Test with an invalid ID of an task which does not exist
     try {
     collection.GetTaskIndexById(2);
     System.out.println("Fail: No task has the ID '2' but an task " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    
     /* Test GetTaskByID(id) */
    
     // Test with a valid ID of existing Task
     try {
     collection.GetTaskById(1);
     System.out.println("Pass: Task with valid ID found");
     } catch (InvalidAttributesException e) {
     System.out.println("Fail: "+e.getMessage());
     }
    
     // Test with an invalid ID of an task which does not exist
     try {
     collection.GetTaskById(2);
     System.out.println("Fail: No task has the ID '2' but an task " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    }   
}
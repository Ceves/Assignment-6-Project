bash: M-F: command not found

}ckage calendar;

import java.util.ArrayList;
import java.util.Calendar;
import javax.naming.directory.InvalidAttributesException;

/**
* @author Adam Barrell
* @date 22/02/2012
*
* @brief
* This class stores a collection of Events. Operations such as
* getting and setting multiple events can be performed by this class.
*/
public class EventsCollection extends Collection<Event> {

/**
* Default constructor creates a new ArrayList to hold only events.
*/
    public EventsCollection() {
        m_data = new ArrayList<Event>();
    }
    
    /**
* This method returns a collection of events which meet the
* criteria of a specific calendar day.
* @param date A valid calendar date
* @return Returns an ArrayList holding objects of type event.
*/
    public ArrayList<Event> GetEventsByDay(Calendar date) {
        ArrayList<Event> events = new ArrayList<Event>();
        for(int i = 0; i < m_data.size(); i++) {
            Event e = m_data.get(i);
            Calendar edate = e.GetStart_date();
            if(edate.get(Calendar.DAY_OF_MONTH) ==
             date.get(Calendar.DAY_OF_MONTH)
                    && edate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && edate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    )
                events.add(e);
            //check if it repeats
            else if(date.compareTo(edate) >= 0) {
                if(e.GetRepetition() == Event.REPEATING_DAILY) {//daily
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WORKING_DAYS &&
                 date.get(Calendar.DAY_OF_WEEK) >= Calendar.MONDAY &&
                 date.get(Calendar.DAY_OF_WEEK) <= Calendar.FRIDAY) {
                 //working days
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WEEKENDS &&
                 (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                 date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                 //weekends
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WEEKLY &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK)) {//weekly
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_TWO_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%2 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%2) {//two weeks
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_FOUR_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%4 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%4) {//four weeks
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_MONTHLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH)) {//monthly
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_YEARLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH) &&
                 date.get(Calendar.MONTH) ==
                 edate.get(Calendar.MONTH)) {//yearly
                    events.add(e);
                }
            }
                    
        }
        return events;
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
    public int GetEventIndexById(int id) throws InvalidAttributesException {
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
    public Event GetEventById(int id) throws InvalidAttributesException {
     for(int i = 0; i < m_data.size(); i++) {
            if(m_data.get(i).GetId() == id) {
                return m_data.get(i);
            }
     }
     throw new InvalidAttributesException("Event not found");
    }
    
    public static void main(String args[]) {
    
     EventsCollection collection = new EventsCollection();
     EventsCollection emptyCollection = new EventsCollection();
    
     Calendar calStart = Calendar.getInstance();
     Calendar calEnd = Calendar.getInstance();
     Calendar calNoEvents = Calendar.getInstance();
    
     calStart.set(2012, 12, 10, 12, 00);
     calEnd.set(2012, 12, 11, 12, 00);
     calNoEvents.set(2012, 12, 12, 12, 00);
    
     /* Test GetEventsByDay(date) */
     try {
collection.Add(new Event(1, "My Birthday", calStart, calEnd,
"The day of my birthday", 0));
} catch (Exception e) {
System.out.println(e.getMessage());
}
    
     // Test day populated with one event
     ArrayList<Event> eventArray = collection.GetEventsByDay(calStart);
     if (eventArray.size()==1) {
     System.out.println("Pass: Event successfully returned " +
     "for set date");
     } else {
     System.out.println("Fail: Event could not be returned " +
     "for set date");
     }
    
     // Test day with no events
     ArrayList<Event> noEventArray = emptyCollection.GetEventsByDay
     (calNoEvents);
     if (noEventArray.size()==0) {
     System.out.println("Pass: No events found for set day");
     } else {
     System.out.println("Fail: Some events were found when no " +
     "events were set");
     }
    
     /* Test GetEventIndexByID(id) */
    
     // Test with valid ID of existing event
     try {
     collection.GetEventIndexById(1);
     System.out.println("Pass: Event returned with matching ID '1'");
     } catch (InvalidAttributesException e) {
     System.out.println("Failed: The event ID '1' does exist but " +
     "has not been returned");
     }
    
     // Test with an invalid ID of an event which does not exist
     try {
     collection.GetEventIndexById(2);
     System.out.println("Fail: No event has the ID '2' but an event " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    
     /* Test GetEventByID(id) */
    
     // Test with a valid ID of existing event
     try {
     collection.GetEventById(1);
     System.out.println("Pass: Event with valid ID found");
     } catch (InvalidAttributesException e) {
     System.out.println("Fail: "+e.getMessage());
     }
    
     // Test with an invalid ID of an event which does not exist
     try {
     collection.GetEventById(2);
     System.out.println("Fail: No event has the ID '2' but an event " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    }
    
}
package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import javax.naming.directory.InvalidAttributesException;

/**
* @author Adam Barrell
* @date 22/02/2012
*
* @brief
* This class stores a collection of Events. Operations such as
* getting and setting multiple events can be performed by this class.
*/
public class EventsCollection extends Collection<Event> {

/**
* Default constructor creates a new ArrayList to hold only events.
*/
    public EventsCollection() {
        m_data = new ArrayList<Event>();
    }
    
    /**
* This method returns a collection of events which meet the
* criteria of a specific calendar day.
* @param date A valid calendar date
* @return Returns an ArrayList holding objects of type event.
*/
    public ArrayList<Event> GetEventsByDay(Calendar date) {
        ArrayList<Event> events = new ArrayList<Event>();
        for(int i = 0; i < m_data.size(); i++) {
            Event e = m_data.get(i);
            Calendar edate = e.GetStart_date();
            if(edate.get(Calendar.DAY_OF_MONTH) ==
             date.get(Calendar.DAY_OF_MONTH)
                    && edate.get(Calendar.MONTH) == date.get(Calendar.MONTH)
                    && edate.get(Calendar.YEAR) == date.get(Calendar.YEAR)
                    )
                events.add(e);
            //check if it repeats
            else if(date.compareTo(edate) >= 0) {
                if(e.GetRepetition() == Event.REPEATING_DAILY) {//daily
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WORKING_DAYS &&
                 date.get(Calendar.DAY_OF_WEEK) >= Calendar.MONDAY &&
                 date.get(Calendar.DAY_OF_WEEK) <= Calendar.FRIDAY) {
                 //working days
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WEEKENDS &&
                 (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                 date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                 //weekends
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_WEEKLY &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK)) {//weekly
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_TWO_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%2 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%2) {//two weeks
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_FOUR_WEEKS &&
                 date.get(Calendar.DAY_OF_WEEK) ==
                 edate.get(Calendar.DAY_OF_WEEK) &&
                 date.get(Calendar.WEEK_OF_YEAR)%4 ==
                 edate.get(Calendar.WEEK_OF_YEAR)%4) {//four weeks
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_MONTHLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH)) {//monthly
                    events.add(e);
                }
                else if(e.GetRepetition() == Event.REPEATING_YEARLY &&
                 date.get(Calendar.DAY_OF_MONTH) ==
                 edate.get(Calendar.DAY_OF_MONTH) &&
                 date.get(Calendar.MONTH) ==
                 edate.get(Calendar.MONTH)) {//yearly
                    events.add(e);
                }
            }
                    
        }
        return events;
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
    public int GetEventIndexById(int id) throws InvalidAttributesException {
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
    public Event GetEventById(int id) throws InvalidAttributesException {
     for(int i = 0; i < m_data.size(); i++) {
            if(m_data.get(i).GetId() == id) {
                return m_data.get(i);
            }
     }
     throw new InvalidAttributesException("Event not found");
    }
    
    public static void main(String args[]) {
    
     EventsCollection collection = new EventsCollection();
     EventsCollection emptyCollection = new EventsCollection();
    
     Calendar calStart = Calendar.getInstance();
     Calendar calEnd = Calendar.getInstance();
     Calendar calNoEvents = Calendar.getInstance();
    
     calStart.set(2012, 12, 10, 12, 00);
     calEnd.set(2012, 12, 11, 12, 00);
     calNoEvents.set(2012, 12, 12, 12, 00);
    
     /* Test GetEventsByDay(date) */
     try {
collection.Add(new Event(1, "My Birthday", calStart, calEnd,
"The day of my birthday", 0));
} catch (Exception e) {
System.out.println(e.getMessage());
}
    
     // Test day populated with one event
     ArrayList<Event> eventArray = collection.GetEventsByDay(calStart);
     if (eventArray.size()==1) {
     System.out.println("Pass: Event successfully returned " +
     "for set date");
     } else {
     System.out.println("Fail: Event could not be returned " +
     "for set date");
     }
    
     // Test day with no events
     ArrayList<Event> noEventArray = emptyCollection.GetEventsByDay
     (calNoEvents);
     if (noEventArray.size()==0) {
     System.out.println("Pass: No events found for set day");
     } else {
     System.out.println("Fail: Some events were found when no " +
     "events were set");
     }
    
     /* Test GetEventIndexByID(id) */
    
     // Test with valid ID of existing event
     try {
     collection.GetEventIndexById(1);
     System.out.println("Pass: Event returned with matching ID '1'");
     } catch (InvalidAttributesException e) {
     System.out.println("Failed: The event ID '1' does exist but " +
     "has not been returned");
     }
    
     // Test with an invalid ID of an event which does not exist
     try {
     collection.GetEventIndexById(2);
     System.out.println("Fail: No event has the ID '2' but an event " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    
     /* Test GetEventByID(id) */
    
     // Test with a valid ID of existing event
     try {
     collection.GetEventById(1);
     System.out.println("Pass: Event with valid ID found");
     } catch (InvalidAttributesException e) {
     System.out.println("Fail: "+e.getMessage());
     }
    
     // Test with an invalid ID of an event which does not exist
     try {
     collection.GetEventById(2);
     System.out.println("Fail: No event has the ID '2' but an event " +
     "has been returned");
     } catch (InvalidAttributesException e) {
     System.out.println("Pass: "+e.getMessage());
     }
    }
    
}

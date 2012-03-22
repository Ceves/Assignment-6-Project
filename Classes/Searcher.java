package Classes;

import java.util.ArrayList;

/**
 * @file Searcher.java
 * @author Adam
 * 
 * @brief This class serves as a super class which searches for objects in a
 *        collection.
 * 
 *        Searcher defines static constants which it's sub classes use when
 *        defining search methods. This class works with a generic array list
 *        which should be defined by the sub classes.
 * 
 * @param <T>
 *            The generic data type of the array, must be defined by sub
 *            classes.
 */
public class Searcher<T> {

	public static final int MAX_LENGTH = 30;
	public static final int MATCH_ANYWHERE = 0;
	protected ArrayList<T> m_dataArray;

	/**
	 * Initialises the array list data structure to hold an collection of
	 * arbitrary object types.
	 */
	public Searcher() {
		m_dataArray = new ArrayList<T>();
	}

}

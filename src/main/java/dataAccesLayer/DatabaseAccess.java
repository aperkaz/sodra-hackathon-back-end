package dataAccesLayer;

import businessClasses.Property;

/**
 * Interface defining the methods to interact with the database.
 *
 * Each of the logic blocks has a helper class
 *
 * @author alain
 *
 */
public interface DatabaseAccess {

	/* Property related methods */
	public Property getProperty(int id_property);	
	
}

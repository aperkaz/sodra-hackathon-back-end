package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import businessClasses.Property;

/**
 * Class to fetch the data related to de Properties from the DB.
 * 
 * @author alain
 *
 */

public class PropertyService {
		
	public static ArrayList<Integer> getAvailablePropertyIds(Connection connection){
		ArrayList<Integer> ids = new ArrayList<>();
						
		try {
			String sql = "SELECT id_property FROM PROPERTY;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ids.add(result.getInt("id_property"));			
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
		
		return ids;		
	}
	
	public static Property getProperty(Connection connection, int id_property) {
		Property property = new Property();
		
		try {
			String sql = "SELECT * FROM PROPERTY WHERE id_property = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id_property);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				property.setId(id_property);
				property.setAvg_tree_height(result.getInt("avg_tree_height"));
				property.setArea(result.getInt("area"));
				property.setName(result.getString("name"));
				property.setVisit_count(result.getInt("visit_count"));
				property.setLast_drone_inspection(result.getString("last_drone_inspection"));
				property.setSoil_quality(result.getString("soil_quality"));
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return property;
	}

}

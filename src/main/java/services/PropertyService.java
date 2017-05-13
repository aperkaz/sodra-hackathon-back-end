package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessClasses.Property;

public class PropertyService {
	
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

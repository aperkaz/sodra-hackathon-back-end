package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import businessClasses.Property;

public class PropertyService {
	
	public Property getProperty(Connection connection, int id_property) {

		Property property = new Property();
		try {
			String sql = "SELECT * FROM property WHERE id_property = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id_property);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				property.setName(result.getString("name"));
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return property;

	}

}

package businessClasses;

import org.json.JSONObject;

public class Property {

	private int id_property;
	private int avg_tree_height;
	private int area;
	private String name;
	private int visit_count;
	private String last_drone_inspection;
	private String soil_quality;

	public Property() {

	}

	public Property(int id_property, int avg_tree_height, int area, String name, int visit_count,
			String last_drone_inspection, String soil_quality) {
		this.id_property = id_property;
		this.avg_tree_height = avg_tree_height;
		this.area = area;
		this.name = name;
		this.visit_count = visit_count;
		this.last_drone_inspection = last_drone_inspection;
		this.soil_quality = soil_quality;
	}
	
	public JSONObject toJson(){
		JSONObject json = new JSONObject();
		json.put("id_property", id_property);
		json.put("avg_tree_height", avg_tree_height);
		json.put("area", area);
		json.put("name", name);
		json.put("visit_count", visit_count);
		json.put("last_drone_inspection", last_drone_inspection);
		json.put("soil_quality", soil_quality);		
		return json;
	}
	
	@Override
	public String toString() {
		return "PROPERTY \n " +
		"Id_property: " + id_property + " \n " +
    	"Avg_Tree_Height: "+ avg_tree_height + " \n " +
    	"Area: " + area + " \n " +
    	"Name: " + name + " \n " +
    	"Visit_count: " + visit_count + " \n " +
    	"Last_drone_inspection: " + last_drone_inspection + " \n " +
    	"Soil_quality :" + soil_quality + " \n ";		
	}

	public int getId() {
		return id_property;
	}

	public void setId(int id_property) {
		this.id_property = id_property;
	}

	public int getAvg_tree_height() {
		return avg_tree_height;
	}

	public void setAvg_tree_height(int avg_tree_height) {
		this.avg_tree_height = avg_tree_height;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVisit_count() {
		return visit_count;
	}

	public void setVisit_count(int visit_count) {
		this.visit_count = visit_count;
	}

	public String getLast_drone_inspection() {
		return last_drone_inspection;
	}

	public void setLast_drone_inspection(String last_drone_inspection) {
		this.last_drone_inspection = last_drone_inspection;
	}

	public int getId_property() {
		return id_property;
	}

	public void setId_property(int id_property) {
		this.id_property = id_property;
	}

	public String getSoil_quality() {
		return soil_quality;
	}

	public void setSoil_quality(String soil_quality) {
		this.soil_quality = soil_quality;
	}

}

package businessClasses;

public class Property {

	private int id_property;
	private int avg_tree_height;
	private int area;
	private String name;
	private int visit_count;
	private String last_drone_inspection;
	
	public Property(){
		
	}
	
	public Property(int id_property, int avg_tree_height, int area, String name, int visit_count, String last_drone_inspection){
		this.id_property = id_property;
		this.avg_tree_height = avg_tree_height;
		this.area = area;
		this.name = name;
		this.visit_count = visit_count;
		this.last_drone_inspection = last_drone_inspection;
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
	
	
	
}

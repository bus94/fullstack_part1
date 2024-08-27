package SelectTest;

public class Department {
	private String dept_ID;
	private String dept_Title;
	private String location_ID;
	
	public Department() {
	}
	
	public Department(String dept_ID, String dept_Title, String location_ID) {
		this.dept_ID = dept_ID;
		this.dept_Title = dept_Title;
		this.location_ID = location_ID;
	}

	public String getDept_ID() {
		return dept_ID;
	}

	public void setDept_ID(String dept_ID) {
		this.dept_ID = dept_ID;
	}

	public String getDept_Title() {
		return dept_Title;
	}

	public void setDept_Title(String dept_Title) {
		this.dept_Title = dept_Title;
	}

	public String getLocation_ID() {
		return location_ID;
	}

	public void setLocation_ID(String location_ID) {
		this.location_ID = location_ID;
	}

	@Override
	public String toString() {
		return "[dept_ID=" + dept_ID + ", dept_Title=" + dept_Title + ", location_ID=" + location_ID + "]";
	}
	
	
}

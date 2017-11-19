package Company;

public class Task {

	private String name;
	private double workingHours;
	
	Task(String name, double time){
		if(name != null){
			setName(name);
		}
		
		if(time > 0){
			setWorkingHours(time);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	
}

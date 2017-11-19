package Company;

public class Task {

	private String name;
	private int workingHours;
	
	public Task(String name, int time){
		if(name != null){
			this.name = name;
		}
		
		if(time > 0){
			setWorkingHours(time);
		}
	}

	public String getName() {
		return name;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	
}

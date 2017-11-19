package Company;

public class Employee {

	private String name;
	private Task currentTask = null;
	private double workingHours = 8;
	
	Employee (String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	public void work(){
		if(getWorkingHours() > this.currentTask.getWorkingHours()){
			this.workingHours = this.workingHours - this.currentTask.getWorkingHours();
			this.getCurrentTask().setWorkingHours(0);
		}else{
			this.currentTask.setWorkingHours(this.currentTask.getWorkingHours() - this.workingHours);
			this.workingHours = 0;
		}
	}
	
	public void showReport(){
		System.out.println("Employee name: "+this.getName());
		System.out.println("Current task: "+this.getCurrentTask().getName());
		System.out.println("Working hours left: "+this.getWorkingHours());
		System.out.println("Task's remaining work time: "+this.getCurrentTask().getWorkingHours());
	}
	
}

package Company;

public class Employee {

	private final String NAME;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork allWork;

	public Employee (String name){
		this.NAME = name;
		this.hoursLeft = 8;
	}
	
	public void work(){
		if(this.currentTask == null){
			this.currentTask = allWork.getNextTask();
			if(this.currentTask == null){
				System.out.println("Nothing to do...");
				return;
			}
		}
		if(this.getHoursLeft() > this.currentTask.getWorkingHours()){
			this.hoursLeft = this.hoursLeft - this.currentTask.getWorkingHours();
			this.getCurrentTask().setWorkingHours(0);
			System.out.println(this.getName() + " just finished working on " + this.getCurrentTask().getName());
			this.currentTask = allWork.getNextTask();
			if(this.currentTask != null){
				System.out.println("Now starting work on " + this.currentTask.getName());
				this.work();
			}else{
				System.out.println("Nothing to do...");
				return;
			}
		}else{
			this.currentTask.setWorkingHours(this.currentTask.getWorkingHours() - this.hoursLeft);
			System.out.println(this.getName() + " has been working on " + this.currentTask.getName() + " for " + this.hoursLeft + " hours today and he stil has " + this.currentTask.getWorkingHours() + " hours of work to do!");
			this.hoursLeft = 0;
		}
		
	}
	
	public void startWorkingDay(){
		System.out.println(this.getName() + " is starting the day!");
		this.hoursLeft = 8;
	}

	public String getName() {
		return NAME;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	public int getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(int workingHours) {
		this.hoursLeft = workingHours;
	}
	
	public void showReport(){
		System.out.println("Employee name: "+this.getName());
		System.out.println("Current task: " + (this.currentTask == null ? "Currently not working on anything." : this.currentTask.getName()));
		System.out.println("Working hours left: "+this.getHoursLeft());
		System.out.println("Task's remaining work time: " + (this.currentTask == null ? "Currently not working on anything." : this.getCurrentTask().getWorkingHours()));
	}
	
	public static AllWork getAllWork() {
		return allWork;
	}

	public static void setAllWork(AllWork allWork) {
		Employee.allWork = allWork;
	}
	
}
